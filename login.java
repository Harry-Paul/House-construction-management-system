import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import java.lang.String;

class LoginPage extends JFrame implements ActionListener {

    private JLabel signinasLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JComboBox<String> siginasComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    final String jdbcURL = "jdbc:postgresql://localhost:5432/HCMS";
    final String username = "postgres";
    final String password = "1234"; 

    public LoginPage() {
        super("Login Page");
        this.setSize(800, 800);
        this.

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        signinasLabel = new JLabel("Sign in as");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        
        siginasComboBox = new JComboBox<>(new String[] { "Admin", "Customer", "Retailer" });
        siginasComboBox.setBackground(Color.orange) ;
        siginasComboBox.setBorder (new EmptyBorder(2, 2, 2, 2));
        siginasComboBox.setEditable(true);

        usernameField = new JTextField(20);
        
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(signinasLabel, constraints);

        constraints.gridx = 1;
        add(siginasComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(passwordLabel, constraints);

        constraints.gridx = 1;
        add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        add(loginButton, constraints);

        loginButton.addActionListener(this); }

            public void actionPerformed(ActionEvent e) {
                try{
                String text = (String)siginasComboBox.getSelectedItem();
                String us = (String) usernameField.getText();
                String pa = new String(passwordField.getPassword());

                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                if(text.equals("Customer")){
                    String sql= "select * from customers where customer_id= ? and password=?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1,us);
                    stmt.setString(2,pa);
                    ResultSet st = stmt.executeQuery();
                    if(st.next()){
                        CustomerPage cp = new CustomerPage();
                        cp.setVisible(true);
                        cp.setSize(1540,800);
                    }
                }
                else if(text.equals("Retailer")){
                    String sql= "select * from retailers where retailer_id=? and password=?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1,us);
                    stmt.setString(2,pa);
                    ResultSet st = stmt.executeQuery();
                    if(st.next()){
                        RetailerPage rp = new RetailerPage();
                        rp.setVisible(true);
                        rp.setSize(1540,800);
                        }
                }
                else if(text.equals("Admin")){
                    if(us.equals("Admin") && pa.equals("1234")){
                        AdminPage ap  = new AdminPage();
                        ap.setVisible(true);
                        ap.setSize(1540,800);
                    }
                }}

                
                catch(SQLException ae){
                    System.out.println("Exception");
                    ae.printStackTrace();
                }
           
        
}}

public class login{
    public static void main(String[] args) {
        LoginPage lp =new LoginPage();
        lp.setVisible(true);
        lp.setSize(800,800);
    }
}
