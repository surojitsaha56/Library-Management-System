package library.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener
{
    private JTextField t1;
    private JPasswordField p1;
    private JButton b1, b2, b3;
    
    public static void main(String[] args) 
    {
        new Login_user().setVisible(true);
    }

    public Login_user() 
    {
        super("Login");
        setBounds(350, 150, 500, 350);
        setLayout(null);
		
        //Username Label
        JLabel l1 = new JLabel("Username : ");
	l1.setBounds(100, 80, 100, 25);
	add(l1);
        
        //Password Label
	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(100, 130, 100, 25);
	add(l2);
        
        //Username TextField
	t1 = new JTextField();
	t1.setBounds(210, 80, 157, 25);
	add(t1);
	
        //Password PasswordField
	p1 = new JPasswordField();
	p1.setBounds(210, 130, 157, 25);
	add(p1);

        //Login Button
	b1 = new JButton("Login");
	b1.addActionListener(this);
	b1.setBounds(100, 200, 100, 40);
	add(b1);
		
        //Sign Up Button
        b2 = new JButton("Sign Up");
	b2.addActionListener(this);
	b2.setBounds(265, 200, 100, 40);
	add(b2);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try 
            {
                conn con = new conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, p1.getText());
                
                ResultSet rs = st.executeQuery();
                
                if (rs.next()) 
                {
                    this.setVisible(false);
                    new Home().setVisible(true);
                } 
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login !");
                }
			
            } 
            catch (Exception e2) 
            {
                e2.printStackTrace();
            }
        }
        else if(ae.getSource() == b2)
        {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }   
    }
}
