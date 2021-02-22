//student details
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{

   // private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1,b2;
    private String t1, t2, t3, t4;
    
    public static void main(String[] args) {
	new StudentDetails().setVisible(true);
    }

    public void student() {
        try {
            conn con = new conn();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public StudentDetails() {
        setBounds(200, 100, 890, 475);
        /*contentPane = new JPanel();
	contentPane.setBackground(new Color(220, 220, 220));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);*/
	setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(80, 100, 725, 250);
	add(scrollPane);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 1).toString());
            }
	});
	//table.setBackground(new Color(240, 248, 255));
	//table.setForeground(Color.DARK_GRAY);
	//table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);

	

	b2 = new JButton("Back");
	b2.addActionListener(this);
	
	//b2.setForeground(new Color(199, 21, 133));
	//b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	//b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
	b2.setBounds(705, 375, 100, 40);
	add(b2);

	JLabel l1 = new JLabel("Student Details");
	//l1.setForeground(new Color(102, 205, 170));
	l1.setFont(new Font("Times New Roman", Font.BOLD , 30));
	l1.setBounds(350, 20, 400, 47);
	add(l1);


	//search = new JTextField();
	//search.setBackground(new Color(255, 240, 245));
	//search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
	//search.setForeground(new Color(47, 79, 79));
	//search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	//search.setBounds(189, 89, 357, 33);
	//add(search);
	//search.setColumns(10);

	/*JLabel l2 = new JLabel("Back");
	l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Home home = new Home();
		home.setVisible(true);
            }
	});*/
	//l2.setForeground(Color.GRAY);
	//l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	
	//l2.setBounds(97, 89, 72, 33);
	//add(l2);

	/*JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Student-Deatails",
		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
	panel.setBounds(68, 59, 790, 370);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);*/
        
	student();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            conn con = new conn();
            
            if(ae.getSource()==b2)
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
