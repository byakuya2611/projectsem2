/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.ChairDAO;
import Model.Chair;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ngomi
 */
public class ChairOrder {

    private JFrame frame;
    private List<Integer> Total = new ArrayList<>();
    private List<Integer> ListChairOrdered = new ArrayList<>();
    private List<Chair> listChairs;
    private static int user_id;
    private static int movie_id;
    private static int room_id;
    private static int schedule_id;
    private static int price;
    private final int sizex = 70;
    private final int sizey = 35;
    private int row = 0;
    private int column = 0;
    private JPanel btnPanel;

    public ChairOrder(int user_id, int movie_id, int room_id, int schedule_id, int price) {
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.schedule_id = schedule_id;
        this.price = price;
        row = ChairDAO.getNumberOfRow(room_id);
        column = ChairDAO.getNumberofColumn(room_id);
        listChairs = ChairDAO.getChairList(room_id);
        ListChairOrdered = ChairDAO.getChairOrdered(room_id);
        create();
    }

    public void create() {
        frame = createJFrame();
        
        Label Title = new Label("Select chair", 1);
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Tahoma", 3, 18));
        Title.setBackground(new Color(34, 166, 179));
        frame.add(Title, BorderLayout.NORTH);
        UIManager.put("ToggleButton.select", new Color(34, 166, 179));
        GridLayout layout = new GridLayout(column + 1, row + 1, 8, 4);
        btnPanel = new JPanel();
        btnPanel.setLayout(layout);
        btnPanel.setBorder(new EmptyBorder(30, 10, 10, 10));
        btnPanel.setBackground(Color.decode("0x130f40"));
        if (row > 0 && column > 0) {
            int c = column + 1;
            for (int i = 0; i <= row; i++) {
                for (int j = 1; j <= c; j++) {
                    Chair chair = listChairs.get(i * c + j - 1);
                    JToggleButton btn = new JToggleButton();
                    btn.setForeground(Color.decode("0xffffff"));
                    btn.setFocusPainted(false);
                    btn.setPreferredSize(new Dimension(sizex, sizey));
                    if (!chair.getChair_name().isEmpty()) {
                        btn.setText(chair.getChair_name());
                        
                        btn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //To change body of generated methods, choose Tools | Templates.
                                if (Total.contains(chair.getId())) {
                                    Total.remove(new Integer(chair.getId()));
                                } else {
                                    Total.add(chair.getId());
                                }
                            }
                        });
                        btn.setBackground(new Color(66, 245, 135));
                        if (check(chair.getId(), ListChairOrdered)) {
                            btn.setBackground(Color.DARK_GRAY);
                            btn.setEnabled(false);
                        }
                    } else {
                        btn.setBackground(new Color(66, 245, 135));
                        btn.setBorder(new EmptyBorder(0, 0, 0, 0));
                        btn.setEnabled(false);
                    }
                    btnPanel.add(btn);
                }
            }
        }
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10,10,10,10));
        bottomPanel.setBackground(Color.decode("0x130f40"));
        JButton prev = new JButton("Back");
        prev.setFocusPainted(false);
        prev.setPreferredSize(new Dimension(150, 50));
        prev.setBackground(new Color(0,102,153));
        prev.setFont(new Font("Tahoma", 3,16));
        prev.setIcon(new ImageIcon(getClass().getResource("/logo/backburger.png")));
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScheduleOrder scheduleOrder = new ScheduleOrder(movie_id,user_id);
                frame.setVisible(false);
            }
        });
        JButton next = new JButton("Buy");
        next.setPreferredSize(new Dimension(150, 50));
        next.setBackground(new Color(0,102,153));
        next.setFocusPainted(false);
        next.setFont(new Font("Tahoma", 3,16));
        next.setIcon(new ImageIcon(getClass().getResource("/logo/cash-register.png")));
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pay pay = new Pay(user_id, movie_id,room_id,price,schedule_id,Total );
                frame.setVisible(false);
            }
        });
        bottomPanel.add(next,BorderLayout.EAST);
        bottomPanel.add(prev, BorderLayout.WEST);
        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.add(btnPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JFrame createJFrame() {
        JFrame frame = new JFrame("Chair Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }

    private static boolean check(int s, List<Integer> Chair) {
        for (int i = 0; i < Chair.size(); i++) {
            if (s == Chair.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ChairOrder chairOrder = new ChairOrder(user_id, movie_id, room_id, schedule_id,price);
    }

}
