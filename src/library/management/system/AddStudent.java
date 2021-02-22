package library.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener
{
    private JTextField t1,t2;
    private JComboBox c1, c2;
    private JButton b1,b2;
    private JLabel l1, l2, l3, l4;

    public static void main(String[] args) 
    {
        new AddStudent().setVisible(true);
    }

    public void random() 
    {
        Random rd = new Random();
	t1.setText("" + rd.nextInt(2000));
    }
    
    public AddStudent() 
    {
        super("Add Student");
	setBounds(350, 150, 450, 410);
        setLayout(null);
	
        //Student ID Label
	l1 = new JLabel("Student ID: ");
	l1.setBounds(80, 70, 100, 25);
	add(l1);

        //Student Name Label
	l2 = new JLabel("Student Name: ");
	l2.setBounds(80, 110, 100, 25);
	add(l2);

	//Branch Label
        l3 = new JLabel("Branch: ");
	l3.setBounds(80, 150, 100, 25);
	add(l3);

        //Year Label
        l4 = new JLabel("Year: ");
	l4.setBounds(80, 190, 100, 25);
	add(l4);

	//Student ID Textfield
	t1 = new JTextField();
	t1.setBounds(190, 70, 157, 25);
	add(t1);
        
	//Student name Textfield
        t2 = new JTextField();
	t2.setBounds(190, 110, 157, 25);
	add(t2);

	//Branch Combobox
        c1 = new JComboBox();
        String options1[]={"CS", "IT", "EXTC", "Chemical", "BioTech"};
	c1.setModel(new DefaultComboBoxModel(options1));
	c1.setBounds(190, 150, 157, 25);
	add(c1);

        //Year Combobox
	c2= new JComboBox();
        String options2[]={"FE", "SE", "TE", "BE"};
	c2.setModel(new DefaultComboBoxModel(options2));
	c2.setBounds(190, 190, 157, 25);
	add(c2);

	//Add Button
        b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(80, 250, 100, 40);
        add(b1);

        //Back Button
	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(247, 250, 100, 40);
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
                    if(t1.getText().isEmpty()||t2.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Error");
                    }
                    else
                    {
                        String sql = "insert into student(student_id, name, branch, year) values(?, ?, ?, ?)";
                        PreparedStatement st = con.c.prepareStatement(sql);
                        st.setString(1, t1.getText());
                        st.setString(2, t2.getText());
                        st.setString(3, (String) c1.getSelectedItem());
                        st.setString(4, (String) c2.getSelectedItem());

                        int i = st.executeUpdate();
                        if (i > 0)
                        {
                            JOptionPane.showMessageDialog(null, "Successfully Added");
                            t1.setText("");
                            t2.setText("");
                            random();
                        }
                        
                         st.close();
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

