/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.MovieDAO;
import DAO.UserDAO;
import Model.Movie;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MovieOrder {
    private JFrame jFrame;
    private JPanel ListPanelFilm;
    private final int sizex = 100;
    private final int sizey = 200;
    private List<Movie> listMovie;
    private static int userID;
    private List<User> listEmployee;
    private List<User> listUser;
    
    public MovieOrder(int userID) {
        this.userID = userID;
        listMovie = MovieDAO.getListMovie();
        listEmployee = UserDAO.getListEmployee();
        listUser = UserDAO.getListUser();
        create();
    }
    
    public void create() {
         jFrame = createJFrame();
         GridLayout grid = new GridLayout(2,5,8,10);
         ListPanelFilm = new JPanel();
         ListPanelFilm.setLayout(grid);
         ListPanelFilm.setBorder(new EmptyBorder(30, 10, 10, 10));
         ListPanelFilm.setBackground(new Color(0,0,0));
         
         for(int i = 0; i< listMovie.size(); i++) { 
             Movie movie = listMovie.get(i);
             //age
             JPanel jpnFilm = new JPanel(new BorderLayout());
             
             Label lblAge = new Label(movie.getAge());
             lblAge.setAlignment(Label.RIGHT);
             lblAge.setForeground(Color.decode("0xf9ca24"));
             lblAge.setFont(new Font("Tahoma", 1, 12));
             lblAge.setBackground(Color.decode("0xeb4d4b"));
             jpnFilm.add(lblAge, BorderLayout.NORTH);
             
             //button
             ImageIcon img = new ImageIcon(getClass().getResource("/img/"+movie.getImg()));
             Image imgScale = img.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
             JButton button = new JButton(new ImageIcon(imgScale));
             button.setForeground(Color.decode("0xffffff"));
             button.setPreferredSize(new Dimension(sizex,sizey));
             button.setBackground(Color.decode("0x30336b"));
             button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     //To change body of generated methods, choose Tools | Templates.
                     MovieInformation movieInformation = new MovieInformation(userID, movie);
                     movieInformation.setVisible(true);
                     movieInformation.setExtendedState(MAXIMIZED_BOTH);
                     jFrame.setVisible(false);
                     
                 }
             });
             jpnFilm.add(button, BorderLayout.CENTER);
             
             //name
             Label movieNameLabel = new Label(movie.getName());
             movieNameLabel.setAlignment(Label.LEFT);
             movieNameLabel.setForeground(Color.WHITE);
             movieNameLabel.setFont(new Font("Tahoma", 1, 14));
             movieNameLabel.setBackground(Color.decode("0x22a6b3"));
             jpnFilm.add(movieNameLabel,BorderLayout.SOUTH);
             ListPanelFilm.add(jpnFilm);            
         }
         jFrame.add(ListPanelFilm, BorderLayout.NORTH);
         JPanel bottomPanel = new JPanel(new BorderLayout());
         bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));        
         bottomPanel.setBackground(new Color(0,0,0));
         JButton prev = new JButton("Back");
         prev.setIcon(new ImageIcon(getClass().getResource("/logo/backburger.png")));
         prev.setPreferredSize(new Dimension(150, 50));
         prev.setFocusPainted(false);
         prev.setBackground(new java.awt.Color(0, 102, 153));
         prev.setFont(new java.awt.Font("Tahoma", 1, 14));
         prev.setForeground(new java.awt.Color(255, 255, 255));
         prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (User user : listEmployee) {
                    if(user.getId() == userID) {
                        EmployeeHome emHome = new EmployeeHome(userID);
                        emHome.setVisible(true);
                        jFrame.setVisible(false);
                    }
                }
                for (User user1 : listUser) {
                    if(user1.getId() == userID) {
                        Home home = new Home(userID);
                        home.setVisible(true);
                        jFrame.setVisible(false);
                    }
                }
                if(userID == 1) {
                    AdminHome adHome = new AdminHome(userID);
                    adHome.setVisible(true);
                    jFrame.setVisible(false);
                }
            }
        });
         bottomPanel.add(prev, BorderLayout.WEST);
         jFrame.add(bottomPanel, BorderLayout.SOUTH);
         jFrame.setLocationRelativeTo(null);
         jFrame.setVisible(true);
             
    }
    
    private static JFrame createJFrame() {
        JFrame frame = new JFrame("Chọn phim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(900,500);
        frame.getContentPane().setBackground(new Color(0,0,0));
        return frame;
    }
    
    public static void main(String[] args) {
        MovieOrder movieOrder = new MovieOrder(userID);
    }
    
}
