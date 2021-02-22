package library.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;



public class ReturnTable extends JFrame implements ActionListener
{
    private JTable table_1;
    private JButton b1;
    
    public static void main(String[] args) 
    {
        new ReturnTable().setVisible(true);
    }
    
    public void returnBook() 
    {
        try 
        {
            conn con = new conn();
            String sql = "select * from returnBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
	}
        catch (Exception e) 
        {
			
	}
    }
    public ReturnTable()
    {
        super("Return Table");
        setBounds(250, 100, 810, 450);
        setLayout(null);
        
        JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(40, 70, 708, 217);
	add(scrollPane_1);
        
        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);
        
        
        
        
        b1=new JButton("Back");
        b1.setBounds(675, 320, 70, 30);
        b1.addActionListener(this);
        add(b1);
        returnBook();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b1)
        {
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    
}
