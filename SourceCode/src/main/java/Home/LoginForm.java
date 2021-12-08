/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.UserDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author ngomi
 */
public class LoginForm extends javax.swing.JFrame {

    public Preferences pref  = Preferences.userRoot().node("rememberme");
    
    private JFrame frame;
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        String email = null;
        email = pref.get("Email", email);
        emailTxt.setText(email);
        String pass = null;
        pass = pref.get("Password", pass);
        passwordTxt.setText(pass);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        forgotPassword = new javax.swing.JLabel();
        signInBtn = new javax.swing.JButton();
        signUpBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        remember = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Movie Ticket", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/movie-roll.png"))); // NOI18N
        jLabel3.setText("Login");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 210, -1));

        emailTxt.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(102, 102, 102));
        emailTxt.setText("Enter Email");
        emailTxt.setBorder(null);
        emailTxt.setOpaque(false);
        emailTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTxtFocusLost(evt);
            }
        });
        jPanel2.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 380, 40));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 380, 10));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel1.setText("Email:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 104, 80, 30));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel4.setText("Password:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        passwordTxt.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        passwordTxt.setForeground(new java.awt.Color(102, 102, 102));
        passwordTxt.setText("Password");
        passwordTxt.setBorder(null);
        passwordTxt.setPreferredSize(new java.awt.Dimension(120, 30));
        passwordTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTxtFocusGained(evt);
            }
        });
        jPanel2.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 380, 40));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 380, -1));

        forgotPassword.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        forgotPassword.setForeground(new java.awt.Color(204, 0, 0));
        forgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPassword.setText("Forgot Password?");
        forgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPasswordMouseExited(evt);
            }
        });
        jPanel2.add(forgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 334, 140, 20));

        signInBtn.setBackground(new java.awt.Color(255, 255, 255));
        signInBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signInBtn.setText("Sign In");
        signInBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        signInBtn.setBorderPainted(false);
        signInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signInBtn.setFocusPainted(false);
        signInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signInBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signInBtnMouseExited(evt);
            }
        });
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
            }
        });
        jPanel2.add(signInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 150, 40));

        signUpBtn.setBackground(new java.awt.Color(255, 255, 255));
        signUpBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signUpBtn.setText("Sign Up");
        signUpBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        signUpBtn.setBorderPainted(false);
        signUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpBtn.setFocusPainted(false);
        signUpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUpBtnMouseExited(evt);
            }
        });
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        jPanel2.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 150, 40));

        closeBtn.setBackground(new java.awt.Color(255, 255, 255));
        closeBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitBtn.setBackground(new java.awt.Color(255, 255, 255));
        ExitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/close.png"))); // NOI18N
        ExitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExitBtn.setPreferredSize(new java.awt.Dimension(50, 50));
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitBtnMouseExited(evt);
            }
        });
        closeBtn.add(ExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 50, 50));

        remember.setBackground(new java.awt.Color(255, 255, 255));
        remember.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        remember.setText("Remeber Me");
        jPanel2.add(remember, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 540));

        setSize(new java.awt.Dimension(481, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void saveEmailPass(String email, String pass) {
        if(email != null && pass != null) {
            String user = email;
            pref.put("Email", user);
            String password = pass;
            pref.put("Password", password);
        }
    }
    
    public final void check(boolean remeber) {
        String pass = new String(passwordTxt.getPassword());
        if(remeber == true) {
            saveEmailPass(emailTxt.getText(), pass);
        }
    }
    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        // TODO add your handling code here:
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Comfirm if you want to exit", "Movie Ticket",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_ExitBtnMouseClicked
    
    private void ExitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseEntered
        // TODO add your handling code here:
        changeColor(closeBtn, new Color(255,0,0));
    }//GEN-LAST:event_ExitBtnMouseEntered

    private void ExitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseExited
        // TODO add your handling code here:
        changeColor(closeBtn, new Color(255,255,255));
    }//GEN-LAST:event_ExitBtnMouseExited

    private void emailTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTxtFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_emailTxtFocusGained

    private void passwordTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTxtFocusGained
        // TODO add your handling code here:
        passwordTxt.setText("");
    }//GEN-LAST:event_passwordTxtFocusGained

    private void forgotPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordMouseExited
        // TODO add your handling code here:
        forgotPassword.setBorder(null);
    }//GEN-LAST:event_forgotPasswordMouseExited

    private void forgotPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordMouseEntered
        // TODO add your handling code here:
        Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204,0,0));
        forgotPassword.setBorder(label_border);
    }//GEN-LAST:event_forgotPasswordMouseEntered

    private void signInBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_signInBtnMouseClicked

    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        // TODO add your handling code here:
        String email = emailTxt.getText();
        String password = new String(passwordTxt.getPassword());
        Pattern emailPattern = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
        Matcher emailMatcher = emailPattern.matcher(email);
        StringBuilder sb = new StringBuilder();
        
        if(email.equals("")) {
            sb.append("Email is empty\n");
        } else if(!emailMatcher.find()) {
            sb.append("Email must be abc@gmail.com\n");
        }
        if(password.equals("")) {
            sb.append("Password is empty\n");
        }
        if(sb.length() >0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if(UserDAO.getLogin(email, password)) {
                if(UserDAO.getRoleAccount(email, password) == 2 || UserDAO.getRoleAccount(email, password) == 1) {
                    dispose();
                    if(remember.isSelected()) {
                        check(true);
                    } else {
                        check(false);
                    }
                    new MainManage().setVisible(true);
                } else {
                    if(remember.isSelected()) {
                        check(true);
                    } else {
                        check(false);
                    }
                            
                    dispose();
                    //bang order cua kh
                    new Home(UserDAO.getUser(email, password).getId()).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Email or Password dose not exits!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }    

    }//GEN-LAST:event_signInBtnActionPerformed

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new RegisterForm().setVisible(true);
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void signInBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInBtnMouseEntered
        // TODO add your handling code here:
        signInBtn.setBackground(Color.BLACK);
        signInBtn.setForeground(Color.WHITE);
    }//GEN-LAST:event_signInBtnMouseEntered

    private void signInBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInBtnMouseExited
        // TODO add your handling code here:
        signInBtn.setBackground(Color.WHITE);
        signInBtn.setForeground(Color.BLACK);
    }//GEN-LAST:event_signInBtnMouseExited

    private void signUpBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpBtnMouseEntered
        // TODO add your handling code here:
        signUpBtn.setBackground(Color.BLACK);
        signUpBtn.setForeground(Color.WHITE);
    }//GEN-LAST:event_signUpBtnMouseEntered

    private void signUpBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpBtnMouseExited
        // TODO add your handling code here:
        signUpBtn.setBackground(Color.WHITE);
        signUpBtn.setForeground(Color.BLACK);
    }//GEN-LAST:event_signUpBtnMouseExited

    private void emailTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtFocusLost
    
    public void changeColor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JPanel closeBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel forgotPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JCheckBox remember;
    private javax.swing.JButton signInBtn;
    private javax.swing.JButton signUpBtn;
    // End of variables declaration//GEN-END:variables
}
