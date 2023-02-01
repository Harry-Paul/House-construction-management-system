import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

class viewprojectsPage extends JFrame{

    final String jdbcURL = "jdbc:postgresql://localhost:5432/HCMS";
    final String username = "postgres";
    final String password = "1234";  
    String cid;
    String Amount;
    DefaultTableModel defaultTableModel;
    JTable table;
    viewprojectsPage(String a){
        this.cid = a;
            defaultTableModel = new DefaultTableModel();
            table = new JTable(defaultTableModel);
            table.setPreferredScrollableViewportSize(new Dimension(300, 200));
            table.setFillsViewportHeight(true);

            defaultTableModel.addColumn("Commodity ID");
            defaultTableModel.addColumn("Commodity");
            defaultTableModel.addColumn("Quantity");
            defaultTableModel.addColumn("Price");
            this.add(new JScrollPane(table));
            try{
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                String sql= "select * from projects where customer_id=?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1,cid);
                ResultSet st = stmt.executeQuery();
                int i=0;
                while(st.next()){
                    String coid = st.getString("comm_id");
                    String coname = st.getString("comm_name");
                    int qua = st.getInt("quantity");
                    int price = st.getInt("quantity");
                    i++;
                    defaultTableModel.addRow(new Object[]{coid,coname,qua,price});
                    System.out.println("a");
                    }
            }
            catch(SQLException ae){
                System.out.println("Exception");
                ae.printStackTrace();
            } 

        this.setVisible(true);
        this.setSize(500,600);
        this.setLocationRelativeTo(null);      
        setTitle("New Order"); 
}         
}

public class viewprojects {
    public static void main(String args[]){
        viewprojectsPage vp = new viewprojectsPage("abcd");
    }
}
