import java.awt.EventQueue;


import java.sql.*;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class logintrail {

	JFrame frame;
	private JTextField txtstudid;
	private JPasswordField txtstudpass;
	private JButton loginbtn;
	private JButton backbutton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logintrail window = new logintrail();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	/**
	 * Create the application.
	 */
	public logintrail() {
		initialize();
		
	}
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(251, 59, 214, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(143, 150, 141, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(143, 210, 100, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtstudid = new JTextField();
		txtstudid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtstudid.setBounds(294, 142, 203, 35);
		frame.getContentPane().add(txtstudid);
		txtstudid.setColumns(10);
		
		txtstudpass = new JPasswordField();
		txtstudpass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtstudpass.setBounds(294, 201, 203, 32);
		frame.getContentPane().add(txtstudpass);
		
		loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== loginbtn) {
		        
		        
		        try{ 
		        	Class.forName("com.mysql.jdbc.Driver");
		        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");
//		        Statement st=con.createStatement();
//		        String sql="select * from studlogin";
		        PreparedStatement pst = con.prepareStatement("SELECT `stu_id`,`stu_pass` FROM `studregister` WHERE `stu_id`=? AND `stu_pass` = ?");
		        pst.setString(1, txtstudid.getText());
		        pst.setString(2, String.valueOf(txtstudpass.getPassword()));

		        ResultSet rs= pst.executeQuery();
		        if(rs.next()) {
		        	JOptionPane.showMessageDialog(null, "Login Successfully");
		        	studentdashboard window = new studentdashboard();
					window.frame.setVisible(true);
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "Wrong Username or Password");
		        	txtstudid.setText("");
		        	txtstudpass.setText("");
		        }
		           
		               
		            }
		        
		        catch(Exception evt) {
		        	Logger.getLogger(logintrail.class.getName()).log(java.util.logging.Level.SEVERE, null, evt);
		        }
			}

						
		}
			});
		loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbtn.setBounds(218, 306, 120, 40);
		frame.getContentPane().add(loginbtn);
		
		backbutton = new JButton("Back");
		backbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backbutton.setBounds(377, 306, 120, 40);
		frame.getContentPane().add(backbutton);
		
//		JButton resetbtn = new JButton("Reset");
//		resetbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		resetbtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				txtstudid.setText("");
//				txtstudpass.setText("");
//				
//			}
//		});
//		resetbtn.setBounds(476, 306, 100, 40);
//		frame.getContentPane().add(resetbtn);
		
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				studentdashboard obj=new studentdashboard();								
        		obj.setVisible(true);
//        		dispose();
        		 		
        		
			}
		});
		
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				home window = new home();
				window.frame.setVisible(true);
//        		dispose();
        		 		
        		
			}
		});
	}


	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}




	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
