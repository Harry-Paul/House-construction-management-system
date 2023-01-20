import javax.swing.*;
import java.awt.*;
class RetailerPage extends JFrame{
    JLabel title;
    JLabel h1;
    GridBagConstraints c;
    JPanel head;
    JPanel Body;
    JButton b1;
    JButton b2;
    JButton b3;
    RetailerPage(){
        head= new JPanel();
        head.setBackground(Color.gray);
        head.setBounds(0,0,1540,100);
        title = new JLabel("Retailer");
        head.add(title);
        this.add(head);
        Body = new JPanel();
        Body.setBounds(0,100,1920,980);
        Body.setBackground(Color.BLUE);
        Body.setLayout(null);
        b1=new JButton("Button1");
        b2=new JButton("Button2");
        b3=new JButton("Button2");
        b1.setBounds(122,250,350,350);
        b2.setBounds(594,250,350,350);
        b3.setBounds(1066,250,350,350);
        Body.add(b1);
        Body.add(b2);
        Body.add(b3);
        this.add(Body);
    };
}

public class Retailer {
    public static void main(String args[]){
        RetailerPage cus = new RetailerPage();
        cus.setVisible(true);
        cus.setSize(1540,1080);
    }
}