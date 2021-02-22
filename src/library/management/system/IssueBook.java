package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener{

    
    JDateChooser dateChooser;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private JButton b1,b2,b3,b4;

    public static void main(String[] args) {
	new IssueBook().setVisible(true);
			
    }

    public IssueBook() 
    {
        super("Issue Book");
        setBounds(350, 150, 600, 410);
	setLayout(null);

	JLabel l1 = new JLabel("Book ID: ");
	
	l1.setBounds(80, 70, 100, 25);
	add(l1);

	JLabel l2 = new JLabel("Book Name: ");
	
	l2.setBounds(80, 110, 100, 25);
	add(l2);
        
        JLabel l8 = new JLabel("Student ID");
	
	l8.setBounds(80, 150, 100, 25);
	add(l8);

	JLabel l9 = new JLabel("Student Name");
	
	l9.setBounds(80, 190, 100, 25);
	add(l9);

	
        
	t1 = new JTextField();
	t1.setBounds(190, 70, 157, 25);
	add(t1);
        /*book name*/
        t2 = new JTextField();
	t2.setBounds(190, 110, 157, 25);
	add(t2);
        /*student name*/
        t8 = new JTextField();
	t8.setBounds(190, 190, 157, 25);
	add(t8);
        /*student id*/
        t9 = new JTextField();
	t9.setBounds(190, 150, 157, 25);
	add(t9);
	
	b1 = new JButton("Search");
	b1.addActionListener(this);
	
	b1.setBounds(357, 70, 75, 25);
        
	add(b1);

	
	

	
        
        

	b2 = new JButton("Search");
	b2.addActionListener(this);
	
	b2.setBounds(357, 150, 75, 25);
        
	add(b2);

	

	
        
	JLabel l15 = new JLabel(" Date of Issue :");
	
	l15.setBounds(80, 230, 100, 25);
	add(l15);

	dateChooser = new JDateChooser();
	
	dateChooser.setBounds(190, 230, 157, 25);
	add(dateChooser);

	b3 = new JButton("Issue");
	b3.addActionListener(this);
	
	b3.setBounds(80, 290, 100, 40);
	
        add(b3);

	b4 = new JButton("Back");
	b4.addActionListener(this);
	
	b4.setBounds(247, 290, 100, 40);
	
        add(b4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from book where book_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                   
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b2){
                String sql = "select * from student where student_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t9.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    t8.setText(rs.getString("name"));
                   
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b3)
            {
                try
                {
                    String sql = "insert into issueBook(book_id, student_id, bname, sname, dateOfIssue) values(?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t9.getText());
                    st.setString(3, t2.getText());
                    st.setString(4, t8.getText());
                    st.setString(5, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());

                    if(t1.getText().isEmpty()||t9.getText().isEmpty()||t2.getText().isEmpty()||t8.getText().isEmpty())  
                    {
                        JOptionPane.showMessageDialog(null, "error");
                    }
                    else
                    {
                        int i = st.executeUpdate();
                        if (i > 0)
                        {
                            JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
                            t1.setText("");
                            t9.setText("");
                            t2.setText("");
                            t8.setText("");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "error");
                    }
                    
                    
                }
                catch(Exception e){
                        e.printStackTrace();
                                }
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
		new Home().setVisible(true);
			
            }
            
            con.c.close();
        }catch(Exception e){
            
        }
    }
}
