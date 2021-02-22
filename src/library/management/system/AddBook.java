package library.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddBook extends JFrame implements ActionListener
{
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2;
        
    public static void main(String[] args) 
    {
	new AddBook().setVisible(true);
    }

    public void random() 
    {
        Random rd = new Random();
	t1.setText("" + rd.nextInt(2000));
    }

    public AddBook() 
    {
        super("Add Book");
        setBounds(350, 150, 450, 450);
	setLayout(null);

        //Book ID Label
        JLabel l1 = new JLabel("Book ID: ");
	l1.setBounds(80, 70, 100, 25);
	add(l1);
        
        //Book name label
	JLabel l2 = new JLabel("Book Name");
	l2.setBounds(80, 110, 100, 25);
	add(l2);

        //ISBN label
	JLabel l3 = new JLabel("ISBN");
	l3.setBounds(80, 150, 100, 25);
	add(l3);

        //Author label
	JLabel l4 = new JLabel("Author");
	l4.setBounds(80, 190, 100, 25);
	add(l4);

        //Price Label
	JLabel l5 = new JLabel("Price");
	l5.setBounds(80, 230, 100, 25);
	add(l5);

        //Book ID Textfield
	t1 = new JTextField();
	t1.setBounds(190, 70, 157, 25);
	add(t1);

        //Book name Textfield
        t2 = new JTextField();
	t2.setBounds(190, 110, 157, 25);
	add(t2);
	
        //ISBN Textfield
        t3 = new JTextField();
	t3.setBounds(190, 150, 157, 25);
	add(t3);
        
        //Author Textfield
        t4 = new JTextField();
	t4.setBounds(190, 190, 157, 25);
	add(t4);
	
	//Price Textfield
        t5 = new JTextField();
	t5.setBounds(190, 230, 157, 25);
	add(t5);
        
        //Add Button
        b1 = new JButton("Add");
	b1.setBounds(80, 290, 100, 40);
        b1.addActionListener(this);
	add(b1);

        //Back Button
	b2 = new JButton("Back");
        b2.setBounds(247, 290, 100, 40);
	b2.addActionListener(this);
	add(b2);

	random();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            if(ae.getSource() == b1)
            {
                if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Error");
                }
                else
                {
                    String sql = "insert into book values(?, ?, ?, ?, ?)";
                    PreparedStatement ps = con.c.prepareStatement(sql);

                    ps.setString(1, t1.getText());
                    ps.setString(2, t2.getText());
                    ps.setString(3, t3.getText());
                    ps.setString(4, t4.getText());
                    ps.setString(5, t5.getText());

                    int rs = ps.executeUpdate();
                    if (rs > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                    }
                    ps.close();
                }
            }
            if(ae.getSource() == b2)
            {
                this.setVisible(false);
		new Home().setVisible(true);

            }
            con.c.close();
        }
        catch(Exception e)
        {
            
        }
    }
}
