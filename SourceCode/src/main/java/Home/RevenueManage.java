/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.MovieDAO;
import DAO.ScheduleDAO;
import DAO.TicketDAO;
import Model.Movie;
import Model.Schedule;
import Model.Ticket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class RevenueManage extends javax.swing.JFrame {

    private JFrame frame;
    DefaultTableModel tableModel;
    List<Ticket> listTickets = new ArrayList<>();
    List<Movie> listMovies = new ArrayList<>();
    List<Schedule> listSchedule = new ArrayList<>();
    List<Ticket> listTicketChoose = new ArrayList<>();
    private static int userId;
    
    /**
     * Creates new form RevenueManage
     */
    public RevenueManage(int userId) {
        initComponents();
        this.userId = userId;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tableModel = (DefaultTableModel) MovieRevenueTable.getModel();
        listTickets = TicketDAO.GetListTicket();
        listMovies = MovieDAO.getListMovie();
        showRevenue();
    }
    
    public Integer countTickets(Integer movieId) {
        Integer count = 0;
        for (Movie movie : listMovies) {
            if(movie.getId() == movieId) {
                listSchedule = ScheduleDAO.getScheduleList(movieId);
                for (Schedule schedule : listSchedule) {
                    for (Ticket ticket : listTickets) {
                        if(ticket.getSchedule_id() == schedule.getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    public Integer totalMovieRevenue(Integer movieId) {
        Integer total = 0;
        for (Movie movie : listMovies) {
            if(movie.getId() == movieId) {
                listSchedule = ScheduleDAO.getScheduleList(movieId);
                for (Schedule schedule : listSchedule) {
                    for (Ticket ticket : listTickets) {
                        if(ticket.getSchedule_id() == schedule.getId()) {
                            total += schedule.getPrice();
                        }
                    }
                }
            }
        }
        return total;
    }
    
    public void showRevenue() {
        int total = 0;
        tableModel.setRowCount(0);
        listMovies.forEach(movie -> {
            tableModel.addRow(new Object[] {
                movie.getName(),
                countTickets(movie.getId()),
                totalMovieRevenue(movie.getId())
            });
        });
        for (Movie movie : listMovies) {
            total += totalMovieRevenue(movie.getId());
        }
        TotalRevenueText.setText("Total Revenue: " + total);
    }
    
    public Integer countTicketsByTime(Integer movieId) {
        Integer count = 0;
        for (Movie movie : listMovies) {
            if(movie.getId() == movieId) {
                listSchedule = ScheduleDAO.getScheduleList(movieId);
                for (Schedule schedule : listSchedule) {
                    for (Ticket ticket : listTicketChoose) {
                        if(ticket.getSchedule_id() == schedule.getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    public Integer totalMovieRevenueByTime(Integer movieId) {
        Integer total = 0;
        for (Movie movie : listMovies) {
            if(movie.getId() == movieId) {
                listSchedule = ScheduleDAO.getScheduleList(movieId);
                for (Schedule schedule : listSchedule) {
                    for (Ticket ticket : listTicketChoose) {
                        if(ticket.getSchedule_id() == schedule.getId()) {
                            total += schedule.getPrice();
                        }
                    }
                }
            }
        }
        return total;
    }
    
    public void findRevenueByTime(String dateFrom, String dateTo) {
        Integer total = 0;
        listTicketChoose = TicketDAO.GetListTicket(dateFrom, dateTo);
        tableModel.setRowCount(0);
        listMovies.forEach(movie -> {
            tableModel.addRow(new Object[] {
                movie.getName(),
                countTicketsByTime(movie.getId()),
                totalMovieRevenueByTime(movie.getId())
            });
        });
        for (Movie movie : listMovies) {
            total += totalMovieRevenueByTime(movie.getId());
        }
        TotalRevenueText.setText("Total Revenue: " + total);
    }

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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        DateFromPicker = new com.toedter.calendar.JDateChooser();
        DateToPicker = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        FindBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        TotalRevenueText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MovieRevenueTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(825, 74));

        jPanel2.setBackground(new java.awt.Color(153, 0, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());

        toppanel.setBackground(new java.awt.Color(0, 102, 204));
        toppanel.setPreferredSize(new java.awt.Dimension(1278, 64));
        toppanel.setLayout(new java.awt.BorderLayout());

        TitleTxt.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TitleTxt.setForeground(new java.awt.Color(255, 255, 255));
        TitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleTxt.setText("Revenue Manager");
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

        jPanel1.setPreferredSize(new java.awt.Dimension(1278, 500));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1278, 100));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("From:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("To:");

        FindBtn.setBackground(new java.awt.Color(54, 33, 88));
        FindBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FindBtn.setForeground(new java.awt.Color(255, 255, 255));
        FindBtn.setText("Find");
        FindBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        FindBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindBtnActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DateFromPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DateToPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(FindBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FindBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(DateFromPicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateToPicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        TotalRevenueText.setText("Total Revenue: ");
        TotalRevenueText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MovieRevenueTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MovieRevenueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Movie Name", "Tickets sold", "Revenue"
            }
        ));
        jScrollPane1.setViewportView(MovieRevenueTable);

        javax.swing.GroupLayout bodypanelLayout = new javax.swing.GroupLayout(bodypanel);
        bodypanel.setLayout(bodypanelLayout);
        bodypanelLayout.setHorizontalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1480, Short.MAX_VALUE)
            .addGroup(bodypanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalRevenueText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bodypanelLayout.setVerticalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodypanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(TotalRevenueText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jPanel2.add(bodypanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FindBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindBtnActionPerformed
        // TODO add your handling code here
        String dateFrom = Utilities.Utility.ConvertDateToString(DateFromPicker.getDate());
        String dateTo = Utilities.Utility.ConvertDateToString(DateToPicker.getDate());
        findRevenueByTime(dateFrom, dateTo); 
    }//GEN-LAST:event_FindBtnActionPerformed

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

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        showRevenue();
    }//GEN-LAST:event_ResetBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RevenueManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RevenueManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RevenueManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RevenueManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevenueManage(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private com.toedter.calendar.JDateChooser DateFromPicker;
    private com.toedter.calendar.JDateChooser DateToPicker;
    private javax.swing.JButton FindBtn;
    private javax.swing.JTable MovieRevenueTable;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JLabel TotalRevenueText;
    private javax.swing.JPanel bodypanel;
    private javax.swing.JPanel bottompanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel toppanel;
    // End of variables declaration//GEN-END:variables
}
