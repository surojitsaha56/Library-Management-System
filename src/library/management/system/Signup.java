package library.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener
{
    private JTextField t1, t2;
    private JPasswordField p1;
    private JButton b1, b2;
    private JLabel l1, l2, l3;

    public static void main(String[] args) 
    {
        new Signup().setVisible(true);
    }

    public Signup() 
    {
        setBounds(350, 150, 500, 350);
	setLayout(null);
        
        //Username Label
	l1=new JLabel("Username : ");
	l1.setBounds(100, 50, 100, 25);
	add(l1);
        
        //Name Label
	l2= new JLabel("Name :");
	l2.setBounds(100, 100, 100, 25);
	add(l2);

        //Password Label
	l3= new JLabel("Password :");
	l3.setBounds(100, 150, 100, 25);
	add(l3);

        //Username TextField
        t1= new JTextField();
	t1.setBounds(210, 50, 157, 25);
	add(t1);
        
        //Name TextField
	t2= new JTextField();
	t2.setBounds(210, 100, 157, 25);
	add(t2);
        
        //Password Field
        p1= new JPasswordField();
	p1.setBounds(210, 150, 157, 25);
	add(p1);
        
        //Create Button
	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setBounds(100, 220, 100, 40);
        add(b1);

        //Back Button
	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(265, 220, 100, 40);
	add(b2);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            
            if(ae.getSource() == b1)
            {
               if(t1.getText().isEmpty()||t2.getText().isEmpty()||p1.getText().isEmpty())
               {
                   JOptionPane.showMessageDialog(null, "Error");
               }      
               else
               {
                    String sql = "insert into account(username, name, password) values(?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, p1.getText());
                    
                    int i = st.executeUpdate();
                    if (i > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Created");
                        t1.setText("");
                        t2.setText("");
                        p1.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                    st.close();
               }
                
            }
            if(ae.getSource() == b2)
            {
                this.setVisible(false);
		new Login_user().setVisible(true);
            }
        }
        catch(Exception e)
        {
            
        }
    }
}

