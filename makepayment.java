import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import java.lang.String;
import javax.swing.table.DefaultTableModel;

class makepaymentPage extends JFrame {
    final String jdbcURL = "jdbc:postgresql://localhost:5432/HCMS";
    final String username = "postgres";
    final String password = "1234";
    JPanel Body;
    DefaultTableModel defaultTableModel;
    JTable table;
  

    makepaymentPage(){
        Body = new JPanel();
        Body.setBounds(0,100,500,600);
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        Body.add(new JScrollPane(table));
        defaultTableModel.addColumn("Order ID");
        defaultTableModel.addColumn("Roll No");
        defaultTableModel.addColumn("Department");
        defaultTableModel.addColumn("");
        this.add(Body);
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql= "select * from orders";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet st = stmt.executeQuery();
            int i=0;
            while(st.next()){
                String oid = st.getString("order_id");
                String rid = st.getString("Retailer_id");
                String cid = st.getString("Comm_id");
                i++;
                defaultTableModel.addRow(new Object[]{oid,rid,cid});
                System.out.println("a");
                

            }
        }
        catch(SQLException ae){
            System.out.println("Exception");
            ae.printStackTrace();
        } 
        this.setVisible(true);
        this.setSize(600,600);
        this.setLocationRelativeTo(null); 
    }
}
public class makepayment {
    public static void main(String args[]){
        makepaymentPage mp = new makepaymentPage();
    }
}
