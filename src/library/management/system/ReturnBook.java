//return book
package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener{

    //private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton b1,b2,b3;
    private JDateChooser dateChooser;
    private String v;

    public static void main(String[] args) {
	new ReturnBook().setVisible(true);
    }

    public void delete() {
        try {
            conn con = new conn();
            String sql = "delete from issueBook where book_id=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, textField_1.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
	}
    }

    
    public ReturnBook() {
        setBounds(350, 75, 600, 500);
	/*contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);*/
	setLayout(null);

	

	JLabel lblStudentid = new JLabel("Student ID");
	//lblStudentid.setForeground(Color.BLACK);
	//lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblStudentid.setBounds(100, 60, 100, 25);
	add(lblStudentid);

	JLabel lblNewLabel = new JLabel("Book ID");
	//lblNewLabel.setForeground(new Color(0, 0, 0));
	//lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel.setBounds(100, 110, 100, 25);
	add(lblNewLabel);
        
        JLabel lblDateOfIssue = new JLabel("Date of Issue");
	//lblDateOfIssue.setForeground(Color.BLACK);
	//lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfIssue.setBounds(100, 160, 100, 25);
	add(lblDateOfIssue);
        
        JLabel lblBook = new JLabel("Book");
	//lblBook.setForeground(Color.BLACK);
	//lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblBook.setBounds(100, 210, 100, 25);
	add(lblBook);

	JLabel lblName = new JLabel("Name");
	//lblName.setForeground(Color.BLACK);
	//lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(100, 260, 100, 25);
	add(lblName);

        

	

	JLabel lblDateOfReturn = new JLabel("Date of Return");
	//lblDateOfReturn.setForeground(Color.BLACK);
	//lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfReturn.setBounds(100, 310, 100, 25);
	add(lblDateOfReturn);

        textField = new JTextField();
	//textField.setForeground(new Color(105, 105, 105));
	//textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	textField.setBounds(210, 60, 157, 25);
	add(textField);
	//textField.setColumns(10);

	textField_1 = new JTextField();
	//textField_1.setForeground(new Color(105, 105, 105));
	//textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	textField_1.setBounds(210, 110, 157, 25);
	add(textField_1);
	//textField_1.setColumns(10);

	

	textField_2 = new JTextField();
	//textField_2.setEditable(false);
	//textField_2.setForeground(new Color(0, 100, 0));
	//textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_2.setBounds(210, 160, 157, 25);
	add(textField_2);
	//textField_2.setColumns(10);

	textField_3 = new JTextField();
	//textField_3.setEditable(false);
	//textField_3.setForeground(new Color(0, 100, 0));
	//textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	//textField_3.setColumns(10);
	textField_3.setBounds(210, 210, 157, 25);
	add(textField_3);

        textField_4 = new JTextField();
	//textField_4.setEditable(false);
	//textField_4.setForeground(new Color(0, 100, 0));
	//textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	//textField_4.setColumns(10);
	textField_4.setBounds(210, 260, 157, 25);
	add(textField_4);


	dateChooser = new JDateChooser();
	//dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	dateChooser.setBounds(210, 310, 157, 25);
	add(dateChooser);

        b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBounds(387, 60, 75, 25);
        //b1.setBackground(Color.BLACK);
        //b1.setForeground(Color.WHITE);
	add(b1);
        
	b2 = new JButton("Return");
	b2.addActionListener(this);
	//b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	//b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	b2.setBounds(100, 370, 100, 30);
       // b2.setBackground(Color.BLACK);
        //b2.setForeground(Color.WHITE);

	add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	//b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	//b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	b3.setBounds(359, 370, 100, 30);
        //b3.setBackground(Color.BLACK);
        //b3.setForeground(Color.WHITE);
	add(b3);

	
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        v=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        try{
            conn con = new conn();
            if(ae.getSource() == b1)
            {
                String sql = "select * from issueBook where student_id = ? and book_id =?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, textField.getText());
		st.setString(2, textField_1.getText());
                
                
                
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    textField_3.setText(rs.getString("bname"));
                    textField_4.setText(rs.getString("sname"));
                    textField_2.setText(rs.getString("dateOfIssue"));
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b2)
            {
                String sql = "insert into returnBook(book_id, student_id, bname, sname,dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(2, textField.getText());
		st.setString(1, textField_1.getText());
		st.setString(3, textField_3.getText());
		st.setString(4, textField_4.getText());
		
		st.setString(5, textField_2.getText());
                               
                
		st.setString(6, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                
                if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||v.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "error");
                }
                else
                {
                    int i = st.executeUpdate();
                    if (i > 0) 
                    {
                        delete();
                        textField.setText("");
                        textField_1.setText("");
                    } else
                            JOptionPane.showMessageDialog(null, "error");
                        
                }
                
		
		
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Home().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }
}
