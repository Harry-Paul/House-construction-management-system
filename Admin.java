import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;

import java.awt.*;
import java.awt.event.*;
class AdminPage extends JFrame implements ActionListener{
    JLabel title;
    JLabel h1;
    JLabel h2;
    JLabel h3;
    GridBagConstraints c;
    JPanel head;
    JPanel Body;
    JButton b1;
    JButton b2;
    JButton b3;
    ImageIcon i1;
    ImageIcon i2;
    ImageIcon i3;
    Image img1;
    Image img2;
    Image img3;
    AdminPage(){
        FlatArcDarkIJTheme.setup();
        head= new JPanel();
        head.setBackground(Color.DARK_GRAY);
        head.setBounds(0,0,800,100);
        JLabel title = new JLabel("<html><span style='color: teal;'>Admin</span></html>");
        title.setFont (title.getFont().deriveFont(64.0f));
        h1 = new JLabel("<html><span style='color: teal;'>Make Order</span></html>");
        h1.setFont (title.getFont().deriveFont(20.0f));
        h1.setBounds(100,475,200,20);
        h2 = new JLabel("<html><span style='color: teal;'>Make Payment</span></html>");
        h2.setFont (title.getFont().deriveFont(20.0f));
        h2.setBounds(330,475,200,20);
        h3 = new JLabel("<html><span style='color: teal;'></span></html>");
        h3.setFont (title.getFont().deriveFont(20.0f));
        h3.setBounds(580,475,200,20);
        i1 = new ImageIcon("makeorder4.jpg");
        i2 = new ImageIcon("makepayment2.png");
        i3 = new ImageIcon("viewprojects.jpg");
        img1 =  i1.getImage();
        img2 = i2.getImage();
        img3 = i3.getImage();
        Image r1 = img1.getScaledInstance(200, 250,java.awt.Image.SCALE_SMOOTH);
        Image r2 = img2.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH);
        Image r3 = img3.getScaledInstance(350, 250,  java.awt.Image.SCALE_SMOOTH);
        title.setFont (title.getFont().deriveFont(64.0f));
        head.add(title);
        this.add(head);
        Body = new JPanel();
        Body.setBounds(0,100,1540,800);
        Body.setBackground(Color.BLACK);
        Body.setLayout(null);
        b1=new JButton(new ImageIcon(r1));
        b2=new JButton(new ImageIcon(r2));
        b3=new JButton(new ImageIcon(r3));
        b1.setBounds(50,200,200,250);
        b2.setBounds(300,200,200,250);
        b3.setBounds(550,200,200,250);
        Body.add(b1);
        Body.add(b2);
        Body.add(b3);
        Body.add(h1);
        Body.add(h2);
        Body.add(h3);
        this.add(Body);
        this.setVisible(true);
        this.setSize(800,600);
        this.setLocationRelativeTo(null); 
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this); }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
                MO m = new MO();}
            else if(e.getSource()==b2){
                makepaymentPage mp = new makepaymentPage();
            }
            else if(e.getSource()==b3){
            }
        }        
}

public class Admin {
    public static void main(String args[]){
        AdminPage cus = new AdminPage();
    }
} 
