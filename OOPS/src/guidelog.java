import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class guidelog {

	JFrame frame;
	private JTextField guideun;
	private JPasswordField guidepass;
//	public Object frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guidelog window = new guidelog();
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
	public guidelog() {  
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guide login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(258, 55, 157, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(146, 171, 98, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(146, 221, 98, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		guideun = new JTextField();
		guideun.setFont(new Font("Tahoma", Font.PLAIN, 12));
		guideun.setBounds(308, 173, 170, 26);
		frame.getContentPane().add(guideun);
		guideun.setColumns(10);
		
		guidepass = new JPasswordField();
		guidepass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		guidepass.setBounds(308, 221, 170, 26);
		frame.getContentPane().add(guidepass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				dispose();
				
//		        String un =guideun.getText();
//		        String p= guidepass.getText();
		        
		        try{ Class.forName("com.mysql.jdbc.Driver");
		        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");
		        PreparedStatement pst = con.prepareStatement("SELECT `guide_un`,`guide_pass` FROM guidelogin WHERE guide_un=? AND guide_pass=?");
		        pst.setString(1, guideun.getText());
		        pst.setString(2, String.valueOf(guidepass.getPassword()));

		        ResultSet rs= pst.executeQuery();
		           
		               if(rs.next()) {
		            	   dispose();
		            	   JOptionPane.showMessageDialog(null, "Login Successfully");
		            	   
		            	   gpage obj=new gpage();								
		           		   obj.setVisible(true);
		           		   
		            	   
		               }
		               else {
				        	JOptionPane.showMessageDialog(null, "Invalid Username OR Password");
				        	guideun.setText("");
				        	guidepass.setText("");
				        }
		            
		        }
		catch(Exception evt){
			Logger.getLogger(guidelog.class.getName()).log(java.util.logging.Level.SEVERE, null, evt);
		}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(205, 314, 110, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(359, 315, 110, 36);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				home window = new home();
				window.frame.setVisible(true);
//        		dispose();
        		 		
        		
			}
		});
		
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false);
//				gpage obj=new gpage();								
//        		obj.setVisible(true);
////        		dispose();
//        		 		
//        		
//			}
//		});
	}

	protected void dispose() {
		
		
	}

}
