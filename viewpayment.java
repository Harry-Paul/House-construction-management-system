import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

class veiwpaymentPage extends JFrame{
    final String jdbcURL = "jdbc:postgresql://localhost:5432/HCMS";
    final String username = "postgres";
    final String password = "1234";  
    DefaultTableModel defaultTableModel;
    JTable table;
    veiwpaymentPage(){
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        table.setFillsViewportHeight(true);

        defaultTableModel.addColumn("Payment ID");
        defaultTableModel.addColumn("Retailer ID");
        defaultTableModel.addColumn("Order ID");
        defaultTableModel.addColumn("Amount");
        this.add(new JScrollPane(table));
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql= "select * from payment_retailer";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet st = stmt.executeQuery();
            int i=0;
            while(st.next()){
                String prid = st.getString("payment_retailer_id");
                String rid = st.getString("retailer_id");
                String oid = st.getString("order_id");
                int amount = st.getInt("to_recieve");
                i++;
                defaultTableModel.addRow(new Object[]{prid,rid,oid,amount});
                System.out.println("a");
            }
        }
        catch(Exception ae){
            dialogbox();
            System.out.println("Exception");
            ae.printStackTrace();
        } 
    }
}
public class viewpayment {
    public static void mani(String args[]){
        viewpaymentPage vp = new viewpaymentPage();
    }
}
