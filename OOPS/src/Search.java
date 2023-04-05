import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() {
		initialize();
		table_load();
		appointment();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void table_load()
    {
     try
     {
//    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","2205");
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");
//        pst = con.prepareStatement("select * from appointment");
//        rs = pst.executeQuery();

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    
                    
                },
                new String [] {
                    "stu_usern", "stu_userp"
                }
            ));
//      table1.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch (SQLException e)
     {
     e.printStackTrace();
     }
    }
	
	public void appointment() {
		   try
		     {
//		    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","2205");
		    	con = DriverManager.getConnection("jdbc:mysql://localhost:3307/pms","root","");
		        pst = con.prepareStatement("select * from studlogin");
		        rs = pst.executeQuery();

		      table.setModel(DbUtils.resultSetToTableModel(rs));
		     }
		     catch (SQLException e)
		     {
		     e.printStackTrace();
		     }
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.getModel();
				String search=textField.getText();
				DefaultTableModel t1=(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(t1);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
				
				
			
			}
		});
		textField.setBounds(236, 72, 162, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 139, 514, 347);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        }
		};
		
		scrollPane.setViewportView(table);
	}
}