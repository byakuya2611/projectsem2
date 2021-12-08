/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.UserDAO;
import Model.User;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class UserManage extends javax.swing.JFrame {

    //Khai bao bien
    DefaultTableModel tableModel;
    List<User> listUsers = new ArrayList<>();
    private static int userId;

    private JFrame frame;

    /**
     * Creates new form UserManage
     */
    public UserManage(int userId) {
        initComponents();
        this.userId = userId;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tableModel = (DefaultTableModel) UserTable.getModel();
        listUsers = UserDAO.getListUser();
        showUser();
        UserTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = UserTable.getSelectedRow();
                User user = listUsers.get(index);
                FullNameTxt.setText(user.getFullName());
                EmailTxt.setText(user.getEmail());

                PhoneTxt.setText(user.getPhoneNumber());
                AddressTxt.setText(user.getAddress());
                GenderBox.setSelectedItem(user.getGender());

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    //show table
    private void showUser() {
        tableModel.setRowCount(0);
        listUsers.forEach(user -> {
            tableModel.addRow(new Object[]{
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getGender(),
                user.getCreateAccountDate(),
                user.getUpdateAccoutDate()
            });
        });

    }

    /**
     *
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        toppanel = new javax.swing.JPanel();
        TitleTxt = new javax.swing.JLabel();
        bottompanel = new javax.swing.JPanel();
        BackBtn = new javax.swing.JButton();
        bodypanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FullNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PasswordTxt = new javax.swing.JPasswordField();
        AddBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        EmailTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PhoneTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        AddressTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        GenderBox = new javax.swing.JComboBox<>();
        SearchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(153, 0, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());

        toppanel.setBackground(new java.awt.Color(0, 102, 204));
        toppanel.setPreferredSize(new java.awt.Dimension(1278, 64));
        toppanel.setLayout(new java.awt.BorderLayout());

        TitleTxt.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TitleTxt.setForeground(new java.awt.Color(255, 255, 255));
        TitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleTxt.setText("User Manager");
        toppanel.add(TitleTxt, java.awt.BorderLayout.CENTER);

        jPanel2.add(toppanel, java.awt.BorderLayout.PAGE_START);

        bottompanel.setBackground(new java.awt.Color(19, 15, 64));
        bottompanel.setPreferredSize(new java.awt.Dimension(1278, 70));
        bottompanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackBtn.setBackground(new java.awt.Color(0, 102, 153));
        BackBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(255, 255, 255));
        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/backburger.png"))); // NOI18N
        BackBtn.setText("Back");
        BackBtn.setPreferredSize(new java.awt.Dimension(150, 50));
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        bottompanel.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(bottompanel, java.awt.BorderLayout.PAGE_END);

        UserTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fuill Name", "Email", "Phone", "Address", "Gender", "Create Account", "Update Account"
            }
        ));
        jScrollPane1.setViewportView(UserTable);

        jPanel1.setPreferredSize(new java.awt.Dimension(1278, 500));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1278, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Full Name:");

        FullNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullNameTxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password:");

        AddBtn.setBackground(new java.awt.Color(54, 33, 88));
        AddBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add");
        AddBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(54, 33, 88));
        ResetBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn.setText("Reset");
        ResetBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FullNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(462, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FullNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PasswordTxt)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        EmailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Email:");

        PhoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTxtActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Phone:");

        UpdateBtn.setBackground(new java.awt.Color(54, 33, 88));
        UpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        UpdateBtn.setText("Update");
        UpdateBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(54, 33, 88));
        DeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBtn.setText("Delete");
        DeleteBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(PhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(460, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel9, java.awt.BorderLayout.CENTER);

        AddressTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTxtActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Address:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Gender:");

        GenderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Male", "Female", "Other" }));
        GenderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderBoxActionPerformed(evt);
            }
        });

        SearchBtn.setBackground(new java.awt.Color(54, 33, 88));
        SearchBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        SearchBtn.setText("Search");
        SearchBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenderBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(305, 305, 305)
                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(627, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(GenderBox)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout bodypanelLayout = new javax.swing.GroupLayout(bodypanel);
        bodypanel.setLayout(bodypanelLayout);
        bodypanelLayout.setHorizontalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodypanelLayout.setVerticalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodypanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(bodypanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FullNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullNameTxtActionPerformed

    private void EmailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTxtActionPerformed

    private void PhoneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTxtActionPerformed

    private void AddressTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTxtActionPerformed

    private void GenderBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderBoxActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        String fullName = FullNameTxt.getText();
        String password = new String(PasswordTxt.getPassword());
        String phone = PhoneTxt.getText();
        String email = EmailTxt.getText();
        String address = AddressTxt.getText();
        String gender = GenderBox.getSelectedItem().toString();
        Integer role_id = 3;
        java.util.Date dateCreateDateAccount = new java.util.Date();
        java.util.Date dateUpdatDateAccount = new java.util.Date();
        User user = new User(fullName, email, phone, password, role_id, gender, dateCreateDateAccount, dateUpdatDateAccount, address);
        if (Validation(fullName, password, email, phone, gender).length() > 0) {
            JOptionPane.showMessageDialog(this, Validation(fullName, password, email, phone, gender).toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            UserDAO.Insert(user);
            JOptionPane.showMessageDialog(this, "DONE!!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            Reset();
        }

        listUsers = UserDAO.getListUser();
        showUser();
    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
        int selectedIndex = UserTable.getSelectedRow();
        if (selectedIndex >= 0) {
            User user = listUsers.get(selectedIndex);
            String fullName = FullNameTxt.getText();
            String password = user.getPassWord();
            String phone = PhoneTxt.getText();
            String email = EmailTxt.getText();
            String address = AddressTxt.getText();
            String gender = GenderBox.getSelectedItem().toString();
            Integer role_id = 3;
            java.util.Date dateCreateDateAccount = user.getCreateAccountDate();
            java.util.Date dateUpdatDateAccount = new java.util.Date();
            if (Validation(fullName, password, email, phone, gender).length() > 0) {
                    JOptionPane.showMessageDialog(this, Validation(fullName, password, email, phone, gender).toString(), "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int option = JOptionPane.showConfirmDialog(this, "Do you want upadate this user?");
                    if (option == 0) {
                        user.setFullName(fullName);
                        user.setAddress(address);
                        user.setPassWord(password);
                        user.setPhoneNumber(phone);
                        user.setEmail(email);
                        user.setGender(gender);
                        user.setRoleId(role_id);
                        user.setCreateAccountDate(dateCreateDateAccount);
                        user.setUpdateAccoutDate(dateUpdatDateAccount);
                        UserDAO.Update(user, user.getId());
                        Reset();
                    }

                }
                listUsers = UserDAO.getListUser();
                showUser();
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here
        List<User> users = new ArrayList<>();
        String input = JOptionPane.showInputDialog(this,"Enter your full name:");
        if(input != null && input.length() > 0) {
            users = UserDAO.Find(input);
            tableModel.setRowCount(0);
            users.forEach(user -> {
            tableModel.addRow(new Object[]{
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getRoleId(),
                user.getGender(),
                user.getCreateAccountDate(),
                user.getUpdateAccoutDate()
            });
        });
        } else {
            showUser();
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedIndex = UserTable.getSelectedRow();
        if (selectedIndex >= 0) {
            User user = listUsers.get(selectedIndex);
            int option = JOptionPane.showConfirmDialog(this, "Do you want delete this user?");
            if (option == 0) {
                UserDAO.Delete(user.getId());
                Reset();
            }
            listUsers = UserDAO.getListUser();
            showUser();
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        if(userId == 1) {
            AdminHome adHome = new AdminHome(userId);
            adHome.setExtendedState(MAXIMIZED_BOTH);
            adHome.setVisible(true);
            this.setVisible(false);
        } else {
            EmployeeHome emHome = new EmployeeHome(userId);
            emHome.setExtendedState(MAXIMIZED_BOTH);
            emHome.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BackBtnActionPerformed

    private void Reset() {
        FullNameTxt.setText("");
        PasswordTxt.setText("");
        PhoneTxt.setText("");
        EmailTxt.setText("");
        AddressTxt.setText("");
        PhoneTxt.setText("");
        GenderBox.setSelectedIndex(0);
    }

    private StringBuilder Validation(String fullname, String password, String email, String phone, String gender) {
        StringBuilder sb = new StringBuilder();
        if (fullname.equals("")) {
            sb.append("Full name is empty\n");
        }
        Pattern emailPattern = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher emailMatcher = emailPattern.matcher(email);
        if (email.equals("")) {
            sb.append("Email is empty \n");
        } else if (!emailMatcher.find()) {
            sb.append("Email must be abc@gmail.com \n");
        }
        Pattern phonePattern = Pattern.compile("[0-9]{10}");
        Matcher phoneMatcher = phonePattern.matcher(phone);
        if (phone.equals("")) {
            sb.append("phone is empty \n");
        } else if (!phoneMatcher.find()) {
            sb.append("Phone must be 0-9 at least 10 \n");
        }
        if (gender.equals("Choose")) {
            sb.append("Gender is empty\n");
        }
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (password.equals("")) {
            sb.append("password is empty \n");
        } else if (!passwordMatcher.find()) {
            sb.append("Password must be at least once a digit, a lower case, an upper case, no whitespace,  at least eight character\n");
        }
        return sb;
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
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManage(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField AddressTxt;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTextField EmailTxt;
    private javax.swing.JTextField FullNameTxt;
    private javax.swing.JComboBox<String> GenderBox;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JTextField PhoneTxt;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JTable UserTable;
    private javax.swing.JPanel bodypanel;
    private javax.swing.JPanel bottompanel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel toppanel;
    // End of variables declaration//GEN-END:variables
}
