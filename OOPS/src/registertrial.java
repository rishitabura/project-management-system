import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class registertrial {

	JFrame frame;
	private JTextField txtstudid;
	private JTextField txtstudyear;
	private JTextField txtstudbranch;
	private JTextField txtstuddiv;
	
	private JPasswordField txtstudpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registertrial window = new registertrial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registertrial() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	private JTextField txtroll;
	
	public void Connect() 
	{
		try 
	    {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");
	    }
		catch (ClassNotFoundException ex) 

		{
			ex.printStackTrace();
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(243, 28, 229, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(113, 110, 108, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(113, 146, 108, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Branch");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(113, 179, 108, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Division & Batch ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(113, 215, 108, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(113, 295, 108, 23);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtstudid = new JTextField();
		txtstudid.setBounds(260, 113, 177, 26);
		frame.getContentPane().add(txtstudid);
		txtstudid.setColumns(10);
		
		txtstudyear = new JTextField();
		txtstudyear.setBounds(260, 147, 177, 26);
		frame.getContentPane().add(txtstudyear);
		txtstudyear.setColumns(10);
		
		txtstudbranch = new JTextField();
		txtstudbranch.setBounds(260, 179, 177, 26);
		frame.getContentPane().add(txtstudbranch);
		txtstudbranch.setColumns(10);
		
		txtstuddiv = new JTextField();
		txtstuddiv.setBounds(260, 215, 177, 26);
		frame.getContentPane().add(txtstuddiv);
		txtstuddiv.setColumns(10);
		
		txtstudpass = new JPasswordField();
		txtstudpass.setBounds(260, 292, 177, 26);
		frame.getContentPane().add(txtstudpass);
		
		JButton btnNewButton = 
				new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studid,studyear,studbranch,studdiv,studroll,studpass;
				
				studid = txtstudid.getText();
				studyear = txtstudyear.getText();
				studbranch = txtstudbranch.getText();
				studdiv = txtstuddiv.getText();
				studroll= txtroll.getText();
				studpass = txtstudpass.getText();
				
				try {
					pst = con.prepareStatement("insert into studregister(stu_id,year,branch,division,rollno,stu_pass)values(?,?,?,?,?,?)");          
					pst.setString(1,studid);
					pst.setString(2,studyear);
					pst.setString(3,studbranch);
					pst.setString(4,studdiv);
					pst.setString(5, studroll);
					pst.setString(6,studpass);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!!");
					//table_load();
					txtstudid.setText("");
					txtstudyear.setText("");
					txtstudbranch.setText("");
					txtstuddiv.setText("");
					txtroll.setText("");
					txtstudpass.setText("");
					txtstudid.requestFocus();
				
				}
				
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			
//				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(124, 371, 108, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(436, 371, 98, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Roll number ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(113, 255, 108, 23);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtroll = new JTextField();
		txtroll.setBounds(260, 256, 177, 26);
		frame.getContentPane().add(txtroll);
		txtroll.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtstudid.setText("");
				txtstudyear.setText("");
				txtstudbranch.setText("");
				txtstuddiv.setText("");
				txtroll.setText("");
				txtstudpass.setText("");
				txtstudid.requestFocus();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(287, 371, 85, 37);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				home window=new home();								
        		window.frame.setVisible(true);
//        		dispose();
        		 		
        		
			}
		});
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
