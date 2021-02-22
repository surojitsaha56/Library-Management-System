package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
    private JLabel l1;
    private JButton b1, b2, b3, b4, b5, b7, b8, b9, b10;

	public static void main(String[] args) 
        {
            new Home().setVisible(true);
	}
        
        public Home() 
        {
            
            super("Menu Page");
            setLayout(null);
            setBounds(220, 40, 760, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            l1 = new JLabel("Library Management System");
            l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
            l1.setBounds(180, 30, 700, 80);
            add(l1);

            b3 = new JButton("Add Student");
            b3.addActionListener(this);
            b3.setBounds(100, 135, 120, 90);
            add(b3);
            
            b1 = new JButton("Add Books");
            b1.addActionListener(this);
            b1.setBounds(300, 135, 120, 90);
            add(b1);

            b2 = new JButton("Issue Table");
            b2.addActionListener(this);
            b2.setBounds(500, 135, 120, 90);
            add(b2);

            b4 = new JButton("Issue Book");
            b4.addActionListener(this);
            b4.setBounds(100, 265, 120, 90);
            add(b4);

            b5 = new JButton("Return Book");
            b5.addActionListener(this);
            b5.setBounds(300, 265, 120, 90);
            add(b5);
            
           
            b7= new JButton("Student Data");
            b7.addActionListener(this);
            add(b7) ;
            b7.setBounds(100, 400, 120, 90);
            
            b8= new JButton("Books Data");
            b8.addActionListener(this);
            add(b8) ;
            b8.setBounds(300, 400, 120, 90);
            
            b9= new JButton("Logout");
            b9.addActionListener(this);
            add(b9) ;
            b9.setBounds(500, 400, 120, 90);
            
            b10= new JButton("Return Table");
            b10.addActionListener(this);
            add(b10) ;
            b10.setBounds(500, 265, 120, 90);
            
            
            
        }
        
        
        public void actionPerformed(ActionEvent ae){
           
            
            if(ae.getSource() == b1){
                this.setVisible(false);
                new AddBook().setVisible(true);
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new IssueTable().setVisible(true);
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new AddStudent().setVisible(true);
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new IssueBook().setVisible(true);
            }
            if(ae.getSource() == b5){
                this.setVisible(false);
                new ReturnBook().setVisible(true);
            }
            if(ae.getSource()==b7){
                this.setVisible(false);
                new StudentDetails().setVisible(true);
            }
            if(ae.getSource()==b8){
                this.setVisible(false);
                new BookDetails().setVisible(true);
            }
            if(ae.getSource()==b9){
                this.setVisible(false);
                new Login_user().setVisible(true);
            }
            if(ae.getSource() == b10){
                this.setVisible(false);
                new ReturnTable().setVisible(true);
            }
        }
}
