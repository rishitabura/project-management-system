import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class project_info {

	JFrame frame;
	private JTextField txttitle;
	private JTextField txtdomain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					project_info window = new project_info();
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
	public project_info() {
		initialize();
		Connect();
	}
	Connection con1;
	PreparedStatement pst;
	private JTextField txttype;
	private JTextField txtdivroll;
	
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 709, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Project details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(271, 10, 158, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Project title : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(70, 129, 109, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		txttitle = new JTextField();
		txttitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttitle.setBounds(243, 130, 356, 30);
		frame.getContentPane().add(txttitle);
		txttitle.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Domain : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(70, 180, 82, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtdomain = new JTextField();
		txtdomain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdomain.setBounds(243, 176, 204, 30);
		frame.getContentPane().add(txtdomain);
		txtdomain.setColumns(10);
		
//		JButton btnNewButton = new JButton("Upload");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser chooser = new JFileChooser();
//				chooser.showOpenDialog(null);
//				File f =chooser.getSelectedFile();
//				String filename = f.getAbsolutePath();
//				txtdomain.setText(filename);
//			}
//		});
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		btnNewButton.setBounds(490, 175, 109, 30);
//		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Date of submission : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(70, 269, 163, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		final JDateChooser txttdate = new JDateChooser();
		txttdate.setBounds(243, 269, 232, 30);
		frame.getContentPane().add(txttdate);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			private JDateChooser txtdate;

			public void actionPerformed(ActionEvent e) {
				String divroll,title,domain,type;
				
				divroll = txtdivroll.getText();
				title = txttitle.getText();
				domain = txtdomain.getText();
				type = txttype.getText();
				try {
					pst = con1.prepareStatement("insert into project_info(div_roll,title,domain,type,date)values(?,?,?,?,?)");          
					pst.setString(1,divroll);
					pst.setString(2,title);
					pst.setString(3,domain);
					pst.setString(4, type);
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
					String date =sdf.format(txttdate.getDate());
					pst.setString(5,date);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!!");
					//table_load();
//					txtdivroll.setText("");
//					txttitle.setText("");
//					txtdomain.setText("");
//					txttype.setText("");
//					txttdate.setCalendar(null);
//
//				
//					txttitle.requestFocus();
				
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(165, 337, 118, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtdivroll.setText("");
				txttitle.setText("");
				txtdomain.setText("");
				txttype.setText("");
				txttdate.setCalendar(null);
				txtdivroll.requestFocus();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(320, 337, 109, 38);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				studlogin window = new studlogin();
				window.frame.setVisible(true);
		        
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(465, 337, 89, 38);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type of project :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(70, 223, 143, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Capstone project", "EDI project", "Course project", "SDP ", "Major project "}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = comboBox.getSelectedItem().toString();
				
				txttype.setText(selectedValue);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(457, 223, 135, 30);
		frame.getContentPane().add(comboBox);
		
		txttype = new JTextField();
		txttype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttype.setBounds(243, 224, 204, 30);
		frame.getContentPane().add(txttype);
		txttype.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Division and roll number (eg. A22) : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(70, 81, 316, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtdivroll = new JTextField();
		txtdivroll.setForeground(new Color(0, 0, 0));
		txtdivroll.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdivroll.setBounds(395, 82, 204, 30);
		frame.getContentPane().add(txtdivroll);
		txtdivroll.setColumns(10);
		
		JButton btnNewButton = new JButton("See previous project details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				gpage obj=new gpage();								
        		   obj.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(228, 398, 234, 38);
		frame.getContentPane().add(btnNewButton);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
