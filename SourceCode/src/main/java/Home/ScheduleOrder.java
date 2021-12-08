/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.ScheduleDAO;
import Model.Schedule;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ScheduleOrder {
    private JFrame frame;
    private JPanel ScheduleListPanel;
    private final int sizex = 100;
    private final int sizey = 50;
    private List<Schedule> schedules;
    private static int movie_id;
    private static int idUser;
    
    public ScheduleOrder(int movie_id, int idUser) {
        this.movie_id = movie_id;
        this.idUser = idUser;
        schedules = ScheduleDAO.getScheduleList(movie_id);
        create();
        
    }
    public void create() {
        frame = createFrame();
        GridLayout layout = new GridLayout(2,3,8,10);
        ScheduleListPanel = new JPanel();
        ScheduleListPanel.setLayout(layout);
        ScheduleListPanel.setBorder(new EmptyBorder(30,10,10,10));
        ScheduleListPanel.setBackground(Color.decode("0x130f40"));
        
        for(int i = 0; i<schedules.size();i++) {
            Schedule schedule = schedules.get(i);
            JPanel panel = new JPanel(new BorderLayout());
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setText( schedule.getRoom_name() + " Date: " + schedule.getDate() + " Time: " + schedule.getTime());
            button.setForeground(new Color(0, 0, 0));
            button.setFont(new Font("Tahoma", 4, 16));
            button.setPreferredSize(new Dimension(sizex,sizey));
            button.setBackground(new Color(66, 245, 135));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ChairOrder chairOrder = new ChairOrder(idUser, schedule.getMovie_id(),schedule.getRoom_id(),schedule.getId(), schedule.getPrice());
                    frame.setVisible(false);
                }
            });
            panel.add(button,BorderLayout.CENTER);
            ScheduleListPanel.add(panel);
        }
        frame.add(ScheduleListPanel, BorderLayout.NORTH);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10,10,10,10));
        bottomPanel.setBackground(Color.decode("0x130f40"));
        JButton prev = new JButton("Back");
        prev.setPreferredSize(new Dimension(150, 50));
        prev.setBackground(new Color(0,102,153));
        prev.setFocusPainted(false);
        prev.setFont(new Font("Tahoma", 3,16));
        prev.setIcon(new ImageIcon(getClass().getResource("/logo/backburger.png")));
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovieOrder movieOrder = new MovieOrder(idUser);
                frame.setVisible(false);
            }
        });
        bottomPanel.add(prev, BorderLayout.WEST);   
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static JFrame createFrame() {
        JFrame frame = new JFrame("Chọn lịch xem phim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(900,500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
    
    public static void main(String[] args) {
        ScheduleOrder scheduleOrder = new ScheduleOrder(movie_id,idUser);
    }
    
}
