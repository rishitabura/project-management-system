import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class studentdashboard implements ActionListener   {
	

	JFrame frame;
	private JTextField txtsem;
	private JTextField txtsub;
	private JTextField txtguide;
	private JTextField txtroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentdashboard window = new studentdashboard();
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
	public studentdashboard() {
		initialize();
		Connect();
//		gro_no();
		
	}
	Connection con1;
	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	
	protected Object grpno;
	protected JLabel divbatch;
	protected JLabel grpno1;
	
//	public void gro_no() {
//		  try
//		     {
//		    	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/pms", "root","");
//		        pst = con.prepareStatement("select rollno from studregister where stu_id='12110244'");
//		        rs = pst.executeQuery();
//		        rs.next();
//		        JLabel lblNewLabel_4 = new JLabel();
//		        lblNewLabel_4.setBounds(150, 25, 90, 80);
//		        lblNewLabel_4.setText(rs.getString(1));
//		        lblNewLabel_4.setEnabled(true);
//		        lblNewLabel_4.setFont(new Font("Tahoma",Font.BOLD, 15));
//				frame.getContentPane().add(lblNewLabel_4);
//				
//				JButton btnNewButton_1 = new JButton("Back");
//				btnNewButton_1.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						frame.setVisible(false);
//						studlogin window = new studlogin();
//						window.frame.setVisible(true);
//						
//					}
//				});
//				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//				btnNewButton_1.setBounds(444, 317, 90, 32);
//				frame.getContentPane().add(btnNewButton_1);
//				
//				
//		     }
//		     catch (SQLException e)
//		     {
//		     e.printStackTrace();
//		     }
//	}
	public void Connect() 
	{
		try 
	    {
			Class.forName("com.mysql.jdbc.Driver");
			con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");
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
		frame.setBounds(100, 100, 700, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Dashboard");
		lblNewLabel.setBounds(24, 28, 206, 32);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
//		JLabel lblNewLabel_5 = new JLabel("Roll number :  ");
//		lblNewLabel_5.setBounds(30, 49, 110, 32);
//		frame.getContentPane().add(lblNewLabel_5);
//		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel_1 = new JLabel("Enter subject name ");
		lblNewLabel_1.setBounds(159, 197, 149, 32);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Semester");
		lblNewLabel_2.setBounds(159, 145, 113, 37);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel_2);
		
		txtsem = new JTextField();
		txtsem.setBounds(351, 152, 141, 28);
		frame.getContentPane().add(txtsem);
		txtsem.setColumns(10);
		
		txtsub = new JTextField();
		txtsub.setBounds(351, 202, 141, 28);
		frame.getContentPane().add(txtsub);
		txtsub.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Guide name ");
		lblNewLabel_3.setBounds(159, 252, 102, 28);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel_3);
		
		txtguide = new JTextField();
		txtguide.setBounds(351, 255, 141, 28);
		frame.getContentPane().add(txtguide);
		txtguide.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setBounds(159, 317, 113, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String grpno,sem,sub,guidename ;
				
				grpno = txtroll.getText();
				sem = txtsem.getText();
				sub = txtsub.getText();
				guidename = txtguide.getText();
				
				try {
					pst = con1.prepareStatement("insert into studdashboard(grp_no,semester,subjects,guidename)values(?,?,?,?)");          
					pst.setString(1,grpno);
					pst.setString(2,sem);
					pst.setString(3,sub);
					pst.setString(4,guidename);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!!");
					project_info window = new project_info();
					window.frame.setVisible(true);
					
					
					
//					frame.setVisible(false);
//					project_details frame =new project_details();								
//	        		frame.setVisible(true);
	        		//dispose();
					//table_load();
//					txtroll.setText("");
//					txtsem.setText("");
//					txtsub.setText("");
//					txtguide.setText("");
//					txtroll.requestFocus();
				
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
//			
//				
			}

		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnNewButton);
		
		txtroll = new JTextField();
		txtroll.setBounds(351, 109, 141, 28);
		frame.getContentPane().add(txtroll);
		txtroll.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter group number ");
		lblNewLabel_4.setBounds(159, 105, 158, 30);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setBounds(316, 317, 85, 32);
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false);
//				project_details obj=new project_details();								
//        		obj.setVisible(true);
//			}
//		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				home window =new home();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(441, 317, 85, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtroll.setText("");
				txtsem.setText("");
				txtsub.setText("");
				txtguide.setText("");
				txtroll.requestFocus();
        		
        		
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}}
				);
		

		
		
	}

	


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		frame.setVisible(false);
//		project_details obj = new project_details();
//		obj.setVisible(true);
		
	}
}
