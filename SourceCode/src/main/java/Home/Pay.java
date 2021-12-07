/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.TicketDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ngomi
 */
public class Pay {
    private JFrame frame;
    private static int user_id;
    private static int movie_id;
    private static int room_id;
    private static int price;
    private static int schedule_id;
    private JPanel panel_pay;
    private static List<Integer> listChair = new ArrayList<>();
    
    public Pay(int user_id, int movie_id, int room_id, int price, int schedule_id, List<Integer> listChair) {
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.schedule_id = schedule_id;
        this.price = price;
        this.listChair = listChair;
        create();
    }
    
    public void create(){
        frame = createFrame();
        
        panel_pay = new JPanel(new BorderLayout());
        panel_pay.setBorder(new EmptyBorder(30,10,10,10));
        panel_pay.setBackground(Color.decode("0x130f40"));
        Label lbl1 = new Label("Price \t * \t Number of chairs \t = \t Total: ");
        lbl1.setForeground(Color.WHITE);
        lbl1.setBackground(new Color(66, 245, 135));
        lbl1.setAlignment(Label.CENTER);
        lbl1.setFont(new Font("Tahoma", 4, 18));
        panel_pay.add(lbl1, BorderLayout.NORTH);
        
        
        Label lbl2 = new Label(price + "\t * \t" + listChair.size() + "\t = \t " + (price*listChair.size()) + "VND");
        lbl2.setForeground(Color.WHITE);
        lbl2.setBackground(new Color(66, 245, 135));
        lbl2.setAlignment(Label.CENTER);
        lbl2.setFont(new Font("Tahoma", 4, 18));
        panel_pay.add(lbl2,BorderLayout.SOUTH);
        
        frame.add(panel_pay,BorderLayout.NORTH);
        
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
                ChairOrder chairOrder = new ChairOrder(user_id, movie_id, room_id, schedule_id,price );
                frame.setVisible(false);
            }
        });
        JButton next = new JButton("Pay");
        next.setPreferredSize(new Dimension(150, 50));
        next.setBackground(new Color(0,102,153));
        next.setFocusPainted(false);
        next.setFont(new Font("Tahoma", 3,16));
        next.setIcon(new ImageIcon(getClass().getResource("/logo/cash-100.png")));
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i< listChair.size(); i++) {
                    TicketDAO.Order(user_id, listChair.get(i), schedule_id);
                }
                Home home = new Home(user_id);
                home.setVisible(true);
                frame.setVisible(false);
            }
        });
        bottomPanel.add(next,BorderLayout.EAST);
        bottomPanel.add(prev, BorderLayout.WEST);
        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    public static JFrame createFrame() {
        JFrame frame = new JFrame("Pay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(900,500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
    
    public static void main(String[] args) {
        Pay pay = new Pay(user_id, movie_id, room_id, price, schedule_id, listChair);
    }
    
}
