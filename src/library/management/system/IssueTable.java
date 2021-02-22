
package library.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class IssueTable extends JFrame implements ActionListener
{

    //private JPanel contentPane;
    private JTable table;
    //private JTable table_1;
    private JButton b1;

    public static void main(String[] args) {
        new IssueTable().setVisible(true);
    }

    public void issueBook() 
    {
	try 
        {
            conn con =  new conn();
            String sql = "select * from issueBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception e) 
        {
			// TODO: handle exception
	}
    }

    

    public IssueTable() {
        setBounds(200, 100, 810, 450);
	/*contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);*/
	setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(40, 70, 708, 217);
	add(scrollPane);

        table = new JTable();
	//table.setBackground(new Color(224, 255, 255));
	//table.setForeground(new Color(128, 128, 0));
	//table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	scrollPane.setViewportView(table);

	/*JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
	panel.setForeground(new Color(0, 128, 128));
	panel.setBounds(26, 36, 737, 240);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);*/

	
	//l1.setForeground(new Color(204, 0, 102));
	//l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	
        JLabel l2=new JLabel("Issue Table");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l2.setBounds(320, 5, 175, 75);
        add(l2);
        
        //Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2);
        //l1.setIcon(i3);
	//l1.setBounds(690, 13, 96, 27);
	//contentPane.add(l1);

	

	/*JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2, true), "Return-Book-Details",
		TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 102, 51)));
	panel_1.setBounds(22, 299, 741, 240);
        panel_1.setBackground(Color.WHITE);
	contentPane.add(panel_1);*/
        b1= new JButton("Back");
        b1.setBounds(648, 300, 100, 40);
        b1.addActionListener(this);
        add(b1);
        

	issueBook();
	
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
