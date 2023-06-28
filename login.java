import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;

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
    JPanel Head;
    public LoginPage() {
        FlatArcDarkIJTheme.setup();
        Head = new JPanel();
        Head.setBounds(0,0,400,400);
        Head.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        GridBagConstraints constraints = new GridBagConstraints();

        signinasLabel = new JLabel("Sign in as");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        
        siginasComboBox = new JComboBox<>(new String[] { "Admin", "Customer", "Retailer" });
        siginasComboBox.setBorder (new EmptyBorder(2, 2, 2, 2));

        usernameField = new JTextField("username",20);
        
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        Head.add(signinasLabel, constraints);

        constraints.gridx = 1;
        Head.add(siginasComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        Head.add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        Head.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        Head.add(passwordLabel, constraints);

        constraints.gridx = 1;
        Head.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        Head.add(loginButton, constraints);
        this.add(Head);
        this.setVisible(true);
        this.setSize(400,400);
        this.setLocationRelativeTo(null); 
        loginButton.addActionListener(this); }
        public void dialogbox(){
            JFrame frame = new JFrame("Main Window");
          
           JOptionPane.showMessageDialog(frame, "Enter Valid Data","Error", JOptionPane.ERROR_MESSAGE);
        }
        public void usernotfound(){
            JFrame frame = new JFrame("Main Window");
          
           JOptionPane.showMessageDialog(frame, "User not found or Wrong password","Error", JOptionPane.ERROR_MESSAGE);
        }

            public void actionPerformed(ActionEvent e) {
                try{
                String text = (String)siginasComboBox.getSelectedItem();
                String us = (String) usernameField.getText();
                String pa = new String(passwordField.getPassword());

                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                if(text.equals("Customer")){
                    String sql= "select * from customer_auth where username= ? and password=?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1,us);
                    stmt.setString(2,pa);
                    ResultSet st = stmt.executeQuery();
                    if(st.next()){
                        CustomerPage cp = new CustomerPage(us);
                        cp.setVisible(true);
                        cp.setSize(800,600);
                        dispose();
                    }
                    else{
                        usernotfound();
                    }
                }
                else if(text.equals("Retailer")){
                    String sql= "select * from retailer_auth where username=? and password=?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1,us);
                    stmt.setString(2,pa);
                    ResultSet st = stmt.executeQuery();
                    if(st.next()){
                        RetailerPage rp = new RetailerPage(us);
                        rp.setVisible(true);
                        rp.setSize(800,600);
                        dispose();
                        }
                    else{
                        usernotfound();
                    }
                }
                else if(text.equals("Admin")){
                    if(us.equals("Admin") && pa.equals("1234")){
                        AdminPage ap  = new AdminPage();
                        ap.setVisible(true);
                        ap.setSize(800,600);
                        dispose();
                    }
                    else{
                        usernotfound();
                    }
                }}

                
                catch(Exception ae){
                    dialogbox();
                    System.out.println("Exception");
                    ae.printStackTrace();
                }    
        }
}

public class login{
    public static void main(String[] args) {
        LoginPage lp = new LoginPage();
    }
}

