import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.sql.SQLException;
class MO extends JFrame implements ActionListener  
{   
    JButton b1;   
    private JLabel u1;
    private JLabel u2;
    private JLabel u3;
    private JLabel u4;
    private JLabel u5;
    final String jdbcURL = "jdbc:postgresql://localhost:5432/HCMS";
    final String username = "postgres";
    final String password = "1234";  
    final JTextField  t1, t2,t3,t4,t5;  
    String id1;
    String id2;
    String id3;
    String id4;
    String id5;  
    MO()  
    {     
        this.setSize(800,800);
        this.setLayout(new GridBagLayout());      
        GridBagConstraints constraints = new GridBagConstraints();
        u1 = new JLabel("Order_ID");
        u2 = new JLabel("Commodity ID");
        u3 = new JLabel("REtailer ID");
        u4 = new JLabel("Project ID");
        u5 = new JLabel("Rate");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        b1 = new JButton("SUBMIT"); 
        System.out.println(id1);
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(u1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(t1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;

        add(u2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(t2 , constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;

        add(u3, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        add(t3, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;

        add(u4, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        add(t4, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;

        add(u5, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        add(t5, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        add(b1, constraints);
        b1.addActionListener(this);       
        setTitle("New Order");          
    }
    public void actionPerformed(ActionEvent e){
        try{
            id1 = t1.getText();
            id2 = t2.getText();
            id3 = t3.getText();
            id4 = t4.getText();
            id5 = t5.getText();
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            if(id1!=""){
                System.out.println("Connected");
                String sql = "insert into orders values (?, ?, ?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1,id1);
                stmt.setString(2,id2);
                stmt.setString(3,id3);
                stmt.setString(4,id4);
                stmt.setString(5,id5);
                stmt.executeUpdate();
                connection.close();
                }
            }
            catch(SQLException ae){
                System.out.println("Exception");
                ae.printStackTrace();
            }
            
    }
        
}

public class makeorder {
    public static void main(String args[]){
        MO mk = new MO();
        mk.setVisible(true);
        mk.setSize(800,800);

    }
}
