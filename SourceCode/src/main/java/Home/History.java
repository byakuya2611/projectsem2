/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.TicketDAO;
import Model.Ticket;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class History {
    private static int user_id;
    private JFrame frame;
    private JPanel panel;
    private List<Ticket> list;
    private static int movie_id;
    
    public History(int user_id) {
        this.user_id = user_id;
        list = TicketDAO.GetTicketList(user_id);
        create();
    }
    
    public void create() {
        frame = createFrame();
        
        GridLayout layout = new GridLayout(3,4,8,10);
        
        panel = new JPanel();
        panel.setLayout(layout);
        panel.setBorder(new EmptyBorder(30,10,10,10));
        panel.setBackground(new Color(0,0,0));
        
        for(int i = 0; i< list.size(); i++) {
            Ticket ticket = list.get(i);
            JPanel panel_ticket = new JPanel(new BorderLayout());
            panel_ticket.setBackground(new Color(0,102,153));
            
            
            
            Label dateTime = new Label(ticket.getDate() + " - " + ticket.getTime() + " - " + ticket.getCode());
            dateTime.setFont(new Font("Tahoma", 1, 12));
            dateTime.setForeground(Color.WHITE);
            dateTime.setAlignment(Label.CENTER);
            panel_ticket.add(dateTime, BorderLayout.NORTH);
            
            Label movieName = new Label(ticket.getMovie_name());
            movieName.setFont(new Font("Tahoma", 1, 15));
            movieName.setForeground(Color.WHITE);
            movieName.setAlignment(Label.CENTER);
            panel_ticket.add(movieName,BorderLayout.CENTER);
            
            
            Label room = new Label(ticket.getRoom_name() + " - " + ticket.getChair_name());
            room.setFont(new Font("Tahoma", 1, 12));
            room.setForeground(Color.WHITE);
            room.setAlignment(Label.CENTER);
            panel_ticket.add(room,BorderLayout.SOUTH);
            
            panel.add(panel_ticket);
        }
        frame.add(panel,BorderLayout.NORTH);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10,10,10,10));
        bottomPanel.setBackground(new Color(0,0,0));
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
                Home home = new Home(user_id);
                home.setVisible(true);
                frame.setVisible(false);
            }
        });
        bottomPanel.add(prev, BorderLayout.WEST); 
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static JFrame createFrame() {
        JFrame frame = new JFrame("History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(900,500);
        frame.getContentPane().setBackground(new Color(0,0,0));
        return frame;
    }

    public static void main(String[] args) {
        History history = new History(user_id);
    }
}
