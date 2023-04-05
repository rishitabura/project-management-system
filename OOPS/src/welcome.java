import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcome extends javax.swing.JFrame {

    public welcome() {
        initComponents();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButton4 = new javax.swing.JButton();
        jButton4.setFont(new Font("Tahoma", Font.BOLD, 14));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 22)); // NOI18N
        jLabel1.setText("Project Management System");

        jButton1.setText("Student Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Guide Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
//        JButton jButton4 = new JButton("Student Login");
//        jButton4.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		StudentLogin window = new StudentLogin();
//				window.frame3.setVisible(true);
//        	}
//        });
//        jButton4.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        jButton4.setText("Student Login");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGap(181)
        			.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(jButton3)
        			.addGap(18)
        			.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        			.addGap(216))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(301)
        			.addComponent(jLabel1)
        			.addContainerGap(312, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(29)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(31)
        					.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(262, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    /*private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        studentregistration obj = new studentregistration();
        obj.setVisible(true);
        dispose();
    }*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	studentregistration window = new studentregistration();
		window.frame.setVisible(true);
        dispose();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {        
    	guidelog window = new guidelog();
		window.frame.setVisible(true);
        dispose();
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {        
    	studlogin window = new studlogin();
		window.frame.setVisible(true);
        dispose();
    }
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
}
