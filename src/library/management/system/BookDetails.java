package library.management.system;

import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class BookDetails extends JFrame implements ActionListener
{
    private JTable t1;
    private JButton b1;
    private JLabel l1;

    public static void main(String[] args) 
    {
	new BookDetails().setVisible(true);
    }
    
    public void Book() 
    {
	try 
        {
            conn con = new conn();
            String sql = "select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            t1.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
	} 
        catch (Exception e) 
        {
	
	}
    }

    public BookDetails() 
    {
        setBounds(200, 75, 890, 475);
        setLayout(null);

	JScrollPane s1 = new JScrollPane();
	s1.setBounds(50, 100, 771, 250);
	add(s1);

	t1 = new JTable();
	t1.setBackground(new Color(240, 248, 255));
	s1.setViewportView(t1);

	/*Back Button*/
        b1= new JButton("Back");
        b1.setBounds(720, 370, 100, 40);
        b1.addActionListener(this);
        add(b1);
        
	l1 = new JLabel("Book Details");
	l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
	l1.setBounds(330, 15, 400, 47);
	add(l1);

        Book();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            if(ae.getSource()==b1)
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
