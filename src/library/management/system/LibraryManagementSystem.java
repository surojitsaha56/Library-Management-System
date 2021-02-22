package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener
{

        JLabel l1;
        JButton b1;
        
        public LibraryManagementSystem() 
        {
		
                setBounds(300,100,600,500);
                setLayout(null);
                //setLocation(300,300);

		//l1 = new JLabel("");
                b1 = new JButton("Next");
                
                //b1.setBackground(Color.WHITE);
                //b1.setForeground(Color.BLACK);
		l1=new JLabel("Library");
                l1.setBounds(200, 50, 200, 100);
                l1.setFont(new Font("Times New Roman", Font.BOLD, 50));
                add(l1);
                
                l1=new JLabel("Management");
                l1.setBounds(150, 125, 300, 100);
                l1.setFont(new Font("Times New Roman", Font.BOLD, 50));
                add(l1);
                
                l1=new JLabel("System");
                l1.setBounds(220, 200, 400, 100);
                l1.setFont(new Font("Times New Roman", Font.BOLD, 50));
                add(l1);
                
                
                //ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/first.jpg"));
                //Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
                //ImageIcon i2 = new ImageIcon(i3);
               // l1 = new JLabel(i2);
                
                b1.setBounds(250,350,90,50);
		//l1.setBounds(0, 0, 1366, 390);
                
                add(b1);
		
                
                b1.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent ae)
        {
                new Login_user().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) 
        {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);			
	}
}
