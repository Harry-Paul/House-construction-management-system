import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

class viewcustomerqueriesPage extends JFrame {
    final String jdbcURL = "jdbc:postgresql://localhost:5432/HCMS";
    final String username = "postgres";
    final String password = "1234";  
    viewcustomerqueriesPage(){
        try{
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql= "select comm_id, comm_name from commodities";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int i=0;
            while(rs.next()){
                loaddata(rs.getString("comm_id"),rs.getString("comm_name"),i);
                i++;
            }
        }
        catch(SQLException ae){
            System.out.println("Exception");
            ae.printStackTrace();
        }
        this.setVisible(true);
        this.setSize(500,400);
        this.setLocationRelativeTo(null); 
    }
    public void loaddata(String a, String b, int n){
        JPanel p = new JPanel();
        p.setBounds(0,n*100,500,100);
        JLabel c = new JLabel(a);
        JLabel q = new JLabel(b);
        p.add(c);
        p.add(new JScrollPane(q));
        
        this.add(p);
    }
}


public class veiwcustomerqueries {
    public static void main(String args[]){
        viewcustomerqueriesPage vp = new viewcustomerqueriesPage();
    }
    
}
