import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class project_details {

	public JFrame frame;
	private JTextField txttitle;
	protected Object set;
	private JTextField txtreport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					project_details window = new project_details();
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
	public project_details() {
		initialize();
		Connect();
	}
	Connection con1;
	PreparedStatement pst;
	
	public void Connect() 
	{
		try 
	    {
			Class.forName("com.mysql.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");
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
		frame.setBounds(100, 100, 700, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Project details ");
		lblNewLabel_3.setBounds(268, 65, 167, 20);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Project title");
		lblNewLabel_2.setBounds(35, 162, 99, 31);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_5 = new JLabel("Report ");
		lblNewLabel_5.setBounds(35, 210, 99, 31);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txttitle = new JTextField();
		txttitle.setBounds(213, 163, 404, 31);
		frame.getContentPane().add(txttitle);
		txttitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttitle.setColumns(10);
		
		txtreport = new JTextField();
		txtreport.setBounds(213, 210, 404, 31);
		frame.getContentPane().add(txtreport);
		txtreport.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Date of submission");
		lblNewLabel_8.setBounds(35, 270, 153, 26);
		frame.getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		final JDateChooser txtdate = new JDateChooser();
		txtdate.setBounds(213, 270, 226, 26);
		frame.getContentPane().add(txtdate);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setBounds(166, 343, 110, 37);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title,report;
				
				
				title = txttitle.getText();
				report = txtreport.getText();
				try {
					pst = con1.prepareStatement("insert into project_details(title,report,date)values(?,?,?)");          
					pst.setString(1,title);
					pst.setString(2,report);
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
					String date =sdf.format(txtdate.getDate());
					pst.setString(3,date);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!!");
					//table_load();
					txttitle.setText("");
					txtreport.setText("");
//					txtdate.setDate("");
				
					txttitle.requestFocus();
				
				}
				
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
			}

			private StringBuffer getDate() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(323, 343, 99, 37);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				studentdashboard obj=new studentdashboard();								
        		obj.setVisible(true);
//        		dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.setBounds(462, 343, 99, 37);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txttitle.setText("");
				
				txtreport.setText("");
				
				
			}
			
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
