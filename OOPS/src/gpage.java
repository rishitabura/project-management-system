import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
public class gpage extends JFrame implements ActionListener {  
//Initializing Components  
    JLabel lb, lb1, lb2, lb3, lb4, lb5;  
    JTextField tf1, tf2, tf3, tf4, tf5;  
    JButton btn;  
    JFrame frame;
    private JTextField tf6;
	protected Object frame1;
	private JButton btnNewButton;
    //Creating Constructor for initializing JFrame components  
    gpage() {  
        //Providing Title  
//        super("Fetching Student Information");  
        lb5 = new JLabel("Enter Division and roll number:");  
        lb5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb5.setBounds(50, 30, 230, 30);  
        tf5 = new JTextField(20);  
        tf5.setBounds(290, 30, 193, 30);  
        btn = new JButton("Get details ");  
        btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btn.setBounds(502, 30, 118, 30);  
        btn.addActionListener(this);  
        lb = new JLabel("Project Information ");  
        lb.setBounds(259, 70, 174, 30);  
        lb.setForeground(new Color(0, 0, 0));  
        lb.setFont(new Font("Serif", Font.BOLD, 20));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(702, 503);  
        lb1 = new JLabel("Title of project : ");  
        lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1.setBounds(92, 166, 134, 30);  
        tf1 = new JTextField(50);  
        tf1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tf1.setBounds(255, 124, 266, 30);  
        lb2 = new JLabel("Domain :");  
        lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb2.setBounds(92, 206, 118, 33);  
        tf2 = new JTextField(100);  
        tf2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tf2.setBounds(255, 169, 266, 30);  
        lb3 = new JLabel("Type of project : ");  
        lb3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb3.setBounds(92, 249, 141, 30);  
        tf3 = new JTextField(50);  
        tf3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tf3.setBounds(255, 210, 266, 30);  
        lb4 = new JLabel("Date of submission : ");  
        lb4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb4.setBounds(92, 289, 157, 30);  
        tf4 = new JTextField(50);  
        tf4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tf4.setBounds(255, 252, 266, 30);  
        getContentPane().setLayout(null);  
        //Add components to the JFrame  
        getContentPane().add(lb5);  
        getContentPane().add(tf5);  
        getContentPane().add(btn);  
        getContentPane().add(lb);  
        getContentPane().add(lb1);  
        getContentPane().add(tf1);  
        getContentPane().add(lb2);  
        getContentPane().add(tf2);  
        getContentPane().add(lb3);  
        getContentPane().add(tf3);  
        getContentPane().add(lb4);  
        getContentPane().add(tf4);  
        //Set TextField Editable False  
        tf1.setEditable(false);  
        tf2.setEditable(false);  
        tf3.setEditable(false);  
        tf4.setEditable(false);  
        
        JLabel lb6 = new JLabel("Div & roll no : ");
        lb6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb6.setBounds(92, 126, 157, 20);
        getContentPane().add(lb6);
        
        tf6 = new JTextField();
        tf6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tf6.setBounds(255, 293, 266, 27);
        getContentPane().add(tf6);
        tf6.setColumns(10);
        
        btnNewButton = new JButton("Clear");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf5.requestFocus();
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(290, 365, 125, 30);
        getContentPane().add(btnNewButton);
    }  
    public void actionPerformed(ActionEvent e) {  
        //Create DataBase Coonection and Fetching Records  
        try {  
            String str = tf5.getText();  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");  
            PreparedStatement st = con.prepareStatement("select * from project_info where div_roll=?");  
            st.setString(1, str);  
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
            if (rs.next()) {  
                String s = rs.getString(1);  
                String s1 = rs.getString(2);  
                String s2 = rs.getString(3);  
                String s3 = rs.getString(4);
                String s4 = rs.getString(5);
                //Sets Records in TextFields.  
                tf1.setText(s);  
                tf2.setText(s1);  
                tf3.setText(s2);  
                tf4.setText(s3); 
                tf6.setText(s4);
            } else {  
                JOptionPane.showMessageDialog(null, "Student not Found");  
            }  
            //Create Exception Handler  
        } catch (Exception ex) {  
            System.out.println(ex);  
        }  
    }  
    //Running Constructor  
    public static void main(String args[]) { 
    	
        new gpage();  
    }  
}  