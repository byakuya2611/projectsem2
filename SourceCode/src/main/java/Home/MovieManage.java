/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DAO.MovieDAO;
import DAO.ScheduleDAO;
import Model.Movie;
import Model.Schedule;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField.*;


/**
 *
 * @author Admin
 */
public class MovieManage extends javax.swing.JFrame {

    //Khai bao bien
    private JFrame frame;
    DefaultTableModel tableModel;
    DefaultTableModel tableModel1;
    List<Movie> ListMovies = new ArrayList<>();
    List<Schedule> listSchedules = new ArrayList<>();
    private static int userId;
    
    /**
     * Creates new form UserManage
     */
    public MovieManage(int userId) {
        initComponents();
        this.userId = userId;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tableModel = (DefaultTableModel) MovieTable.getModel();
        tableModel1 = (DefaultTableModel) ScheduleTable.getModel();
        ListMovies = MovieDAO.getListMovie();
        showMovie();
        MovieTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                int index = MovieTable.getSelectedRow();
                Movie movie = ListMovies.get(index);
                MovieNameTxt.setText(movie.getName());
                TypeBox.setSelectedItem(movie.getType());
                AgeTxt.setText(movie.getAge());
                DirectorTxt.setText(movie.getDirector());
                ActorTxt.setText(movie.getCast());
                try {
                    Date releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)tableModel.getValueAt(index, 2));
                    ReleaseDatePicker.setDate(releaseDate);
                } catch (ParseException ex) {
                    Logger.getLogger(MovieManage.class.getName()).log(Level.SEVERE, null, ex);
                }
                DescTxt.setText(movie.getDescription());
                ImgTxt.setText(movie.getImg());
                ImageIcon img = new ImageIcon(getClass().getResource("/img/" + movie.getImg()));
                Image imgScale = img.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                ImgLabel.setIcon(new ImageIcon(imgScale));
                Integer movieId = movie.getId();
                listSchedules = ScheduleDAO.getScheduleList(movie.getId());
                showSchedule();
                ScheduleTable.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //To change body of generated methods, choose Tools | Templates.
                        int index1 = ScheduleTable.getSelectedRow();
                        Schedule schedule = listSchedules.get(index1);
                        RoomBox.setSelectedItem(schedule.getRoom_name());
                        try {
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tableModel1.getValueAt(index1, 1));
                            DatePicker.setDate(date);
                        } catch (ParseException ex) {
                            Logger.getLogger(MovieManage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        TimeTxt.setText(schedule.getTime());
                        PriceTxt.setText(String.valueOf(schedule.getPrice()));
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
    private void showMovie() {
        tableModel.setRowCount(0);
        ListMovies.forEach(movie -> {
            tableModel.addRow(new Object[] {
                movie.getName(),
                movie.getType(),
                movie.getStart_at(),
                movie.getDirector(),
                movie.getCast(),
                movie.getAge(),
                movie.getImg(),
                movie.getDescription()
            });
        }) ;
    }
    
    private void showSchedule() {
        tableModel1.setRowCount(0);
        listSchedules.forEach(schedule -> {
            tableModel1.addRow(new Object[] {
                schedule.getRoom_name(),
                schedule.getDate(),
                schedule.getTime(),
                schedule.getPrice()
            });
        });
    }
    
    public int nameToId(String name) {
        int movieId = 0;
        for (Movie movie : ListMovies) {
            if(movie.getName() == name) {
                movieId = movie.getId();
            }
        }
        return movieId;
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

        timePicker1 = new com.raven.swing.TimePicker();
        jPanel2 = new javax.swing.JPanel();
        toppanel = new javax.swing.JPanel();
        TitleTxt = new javax.swing.JLabel();
        bodypanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MovieTable = new javax.swing.JTable();
        MoviePanel = new javax.swing.JPanel();
        ImgLabel = new javax.swing.JLabel();
        MovieName = new javax.swing.JLabel();
        Type = new javax.swing.JLabel();
        Age = new javax.swing.JLabel();
        Director = new javax.swing.JLabel();
        Actor = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Desc = new javax.swing.JLabel();
        MovieNameTxt = new javax.swing.JTextField();
        AgeTxt = new javax.swing.JTextField();
        DirectorTxt = new javax.swing.JTextField();
        ActorTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        DescTxt = new javax.swing.JTextArea();
        TypeBox = new javax.swing.JComboBox<>();
        ImgTxt = new javax.swing.JTextField();
        UploadBtn = new javax.swing.JButton();
        ReleaseDatePicker = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        ScheduleTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        AddScheBtn = new javax.swing.JButton();
        UpdateScheBtn = new javax.swing.JButton();
        ResetScheBtn = new javax.swing.JButton();
        DeleteScheBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TimeTxt = new javax.swing.JTextField();
        PriceTxt = new javax.swing.JTextField();
        DatePicker = new com.toedter.calendar.JDateChooser();
        RoomBox = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        SearchBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();

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
        TitleTxt.setText("Movie Manage");
        toppanel.add(TitleTxt, java.awt.BorderLayout.CENTER);

        jPanel2.add(toppanel, java.awt.BorderLayout.PAGE_START);

        MovieTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MovieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Release Date", "Director", "Cast", "Age", "Thumbnail", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MovieTable);
        if (MovieTable.getColumnModel().getColumnCount() > 0) {
            MovieTable.getColumnModel().getColumn(5).setResizable(false);
        }

        MoviePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movie", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        MovieName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MovieName.setText("Name:");

        Type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Type.setText("Type:");

        Age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Age.setText("Age:");

        Director.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Director.setText("Director:");

        Actor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Actor.setText("Cast:");

        Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Date.setText("Release Date:");

        Desc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Desc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Desc.setText("Description:");
        Desc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        DescTxt.setColumns(20);
        DescTxt.setRows(5);
        jScrollPane2.setViewportView(DescTxt);

        TypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Horror", "Action", "Cartoon", "Family", "Drama", "Comedy" }));

        UploadBtn.setText("Upload");
        UploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadBtnActionPerformed(evt);
            }
        });

        ReleaseDatePicker.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout MoviePanelLayout = new javax.swing.GroupLayout(MoviePanel);
        MoviePanel.setLayout(MoviePanelLayout);
        MoviePanelLayout.setHorizontalGroup(
            MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MoviePanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MoviePanelLayout.createSequentialGroup()
                        .addComponent(ImgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UploadBtn)))
                .addGap(18, 18, 18)
                .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Actor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Director, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Age, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MovieName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ActorTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DirectorTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgeTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TypeBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MovieNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(ReleaseDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        MoviePanelLayout.setVerticalGroup(
            MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MoviePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MoviePanelLayout.createSequentialGroup()
                        .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImgTxt)
                            .addComponent(UploadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                    .addGroup(MoviePanelLayout.createSequentialGroup()
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MovieName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MovieNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Type, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(TypeBox))
                        .addGap(18, 18, 18)
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Director, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DirectorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Actor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Date, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(ReleaseDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(MoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Desc)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room", "Date", "Time", "Price"
            }
        ));
        jScrollPane3.setViewportView(ScheduleTable);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schedule", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        AddScheBtn.setBackground(new java.awt.Color(54, 33, 88));
        AddScheBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddScheBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddScheBtn.setText("Add");
        AddScheBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        AddScheBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddScheBtnActionPerformed(evt);
            }
        });

        UpdateScheBtn.setBackground(new java.awt.Color(54, 33, 88));
        UpdateScheBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateScheBtn.setForeground(new java.awt.Color(255, 255, 255));
        UpdateScheBtn.setText("Update");
        UpdateScheBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        UpdateScheBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateScheBtnActionPerformed(evt);
            }
        });

        ResetScheBtn.setBackground(new java.awt.Color(54, 33, 88));
        ResetScheBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResetScheBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetScheBtn.setText("Reset");
        ResetScheBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        ResetScheBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetScheBtnActionPerformed(evt);
            }
        });

        DeleteScheBtn.setBackground(new java.awt.Color(54, 33, 88));
        DeleteScheBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteScheBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteScheBtn.setText("Delete");
        DeleteScheBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        DeleteScheBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteScheBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Room :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Date :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Time:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Price:");

        DatePicker.setDateFormatString("yyyy-MM-dd");
        DatePicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatePickerMouseClicked(evt);
            }
        });
        DatePicker.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                DatePickerInputMethodTextChanged(evt);
            }
        });

        RoomBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Room 1", "Room 2", "Room 3", "Room 4", "Room 5", "Room 6" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RoomBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteScheBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddScheBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateScheBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetScheBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddScheBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RoomBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateScheBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeTxt)
                    .addComponent(ResetScheBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PriceTxt))
                    .addComponent(DeleteScheBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

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

        javax.swing.GroupLayout bodypanelLayout = new javax.swing.GroupLayout(bodypanel);
        bodypanel.setLayout(bodypanelLayout);
        bodypanelLayout.setHorizontalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1578, Short.MAX_VALUE)
            .addGroup(bodypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodypanelLayout.createSequentialGroup()
                        .addComponent(MoviePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodypanelLayout.setVerticalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MoviePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodypanelLayout.createSequentialGroup()
                        .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodypanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bodypanelLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bodypanelLayout.createSequentialGroup()
                                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel2.add(bodypanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        String movieName = MovieNameTxt.getText();
        String age = AgeTxt.getText();
        String director = DirectorTxt.getText();
        String cast = ActorTxt.getText();
        String releaseDate = Utilities.Utility.ConvertDateToString(ReleaseDatePicker.getDate());
        String desc = DescTxt.getText();
        String img = ImgTxt.getText();
        String type = TypeBox.getSelectedItem().toString();
        Integer typeId = null;
        switch (type) {
            case "Horror":
                typeId = 1;
                break;
            case "Action":
                typeId = 2;
                break;
            case "Cartoon":
                typeId = 3;
                break;
            case "Family":
                typeId = 4;
                break;
            case "Drama":
                typeId = 5;
                break;
            default:
                typeId = 6;
                break;
        }
        Movie movie = new Movie(movieName, desc, img, cast, typeId, director, age, releaseDate, type);
        if(Validation(movieName, type, age, director, cast, releaseDate, desc, img).length() > 0) {
            JOptionPane.showMessageDialog(this, Validation(movieName, type, age, director, cast, releaseDate, desc, img).toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            MovieDAO.Insert(movie);
            JOptionPane.showMessageDialog(this, "DONE!!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            Reset();
        }
        
        ListMovies = MovieDAO.getListMovie();
        showMovie();
        
    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
        int selectIndex = MovieTable.getSelectedRow();
        if(selectIndex >= 0) {
            Movie movie = ListMovies.get(selectIndex);
            String movieName = MovieNameTxt.getText();
            String age = AgeTxt.getText();
            String director = DirectorTxt.getText();
            String cast = ActorTxt.getText();
            String releaseDate = Utilities.Utility.ConvertDateToString(ReleaseDatePicker.getDate());
            String desc = DescTxt.getText();
            String img = ImgTxt.getText();
            String type = TypeBox.getSelectedItem().toString();
            Integer typeId = null;
            switch (type) {
                case "Horror":
                    typeId = 1;
                    break;
                case "Action":
                    typeId = 2;
                    break;
                case "Cartoon":
                    typeId = 3;
                    break;
                case "Family":
                    typeId = 4;
                    break;
                case "Drama":
                    typeId = 5;
                    break;
                default:
                    typeId = 6;
                    break;
            }
            if(Validation(movieName, type, age, director, cast, releaseDate, desc, img).length() > 0) {
            JOptionPane.showMessageDialog(this, Validation(movieName, type, age, director, cast, releaseDate, desc, img).toString(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Do you want update this movie?");
                if(option == 0) {
                    movie.setName(movieName);
                    movie.setAge(age);
                    movie.setDirector(director);
                    movie.setCast(cast);
                    movie.setImg(img);
                    movie.setType_id(typeId);
                    movie.setType(type);
                    movie.setStart_at(releaseDate);
                    movie.setDescription(desc);
                    MovieDAO.Update(movie, movie.getId());
                    Reset();
                }
            }
            
            ListMovies = MovieDAO.getListMovie();
            showMovie();
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here
        List<Movie> movies = new ArrayList<>();
        String input = JOptionPane.showInputDialog(this, "Enter movie name:");
        if(input != null && input.length() > 0) {
            movies = MovieDAO.Find(input);
            tableModel.setRowCount(0);
            movies.forEach(movie -> {
            tableModel.addRow(new Object[] {
                movie.getName(),
                movie.getType(),
                movie.getStart_at(),
                movie.getDirector(),
                movie.getCast(),
                movie.getAge(),
                movie.getImg(),
                movie.getDescription()
            });
        });   
        } else {
            showMovie();
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int selectIndex = MovieTable.getSelectedRow();
        if(selectIndex >= 0) {
            Movie movie = ListMovies.get(selectIndex);
            int option = JOptionPane.showConfirmDialog(this, "Do you want delete this movie?");
            if(option == 0) {
                MovieDAO.Delete(movie.getId());
                Reset();
            }
            ListMovies = MovieDAO.getListMovie();
            showMovie();
        }
            
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void AddScheBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddScheBtnActionPerformed
        // TODO add your handling code here:
        int selectedIndex = MovieTable.getSelectedRow();
        if(selectedIndex >= 0) {
            Movie movie = ListMovies.get(selectedIndex);
            String room = RoomBox.getSelectedItem().toString();
            String scheDate = Utilities.Utility.ConvertDateToString(DatePicker.getDate());
            String time = TimeTxt.getText();
            Integer price = Integer.parseInt(PriceTxt.getText());
            Integer roomId = null;
            switch (room) {
                case "Room 1":
                    roomId = 1;
                    break;
                case "Room 2":
                    roomId = 2;
                    break;
                case "Room 3":
                    roomId = 3;
                    break;
                case "Room 4":
                    roomId = 4;
                    break;
                case "Room 5":
                    roomId = 5;
                    break;
                default:
                    roomId = 6;
                    break;
            }
            Schedule schedule = new Schedule(movie.getId(),roomId,scheDate,time,room,price);
            if(Validation(room, scheDate, time, price).length() > 0) {
                JOptionPane.showMessageDialog(this, Validation(room, scheDate, time, price), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ScheduleDAO.Insert(schedule);
                JOptionPane.showMessageDialog(this, "DONE!!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                RoomBox.setSelectedIndex(0);
                DatePicker.setDate(null);
                TimeTxt.setText("");
                PriceTxt.setText("");
            }

            listSchedules = ScheduleDAO.getScheduleList(movie.getId());
            showSchedule();
        }
    }//GEN-LAST:event_AddScheBtnActionPerformed

    private void UpdateScheBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateScheBtnActionPerformed
        // TODO add your handling code here:
        int selectedIndex = MovieTable.getSelectedRow();
        if(selectedIndex >= 0) {
            Movie movie = ListMovies.get(selectedIndex);
            int selectedIndex1 = ScheduleTable.getSelectedRow();
            if(selectedIndex1 >= 0) {
                Schedule schedule = listSchedules.get(selectedIndex1);
                String room = RoomBox.getSelectedItem().toString();
                String scheDate = Utilities.Utility.ConvertDateToString(DatePicker.getDate());
                String time = TimeTxt.getText();
                Integer price = Integer.parseInt(PriceTxt.getText());
                Integer roomId = null;
                switch (room) {
                    case "Room 1":
                        roomId = 1;
                        break;
                    case "Room 2":
                        roomId = 2;
                        break;
                    case "Room 3":
                        roomId = 3;
                        break;
                    case "Room 4":
                        roomId = 4;
                        break;
                    case "Room 5":
                        roomId = 5;
                        break;
                    default:
                        roomId = 6;
                        break;
                }
                if(Validation(room, scheDate, time, price).length() > 0) {
                    JOptionPane.showMessageDialog(this, Validation(room, scheDate, time, price), "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int option = JOptionPane.showConfirmDialog(this, "Do you want update this schedule?");
                    if(option == 0) {
                        schedule.setRoom_name(room);
                        schedule.setDate(scheDate);
                        schedule.setMovie_id(movie.getId());
                        schedule.setPrice(price);
                        schedule.setRoom_id(roomId);
                        schedule.setTime(time);
                        ScheduleDAO.Update(schedule, schedule.getId());
                        RoomBox.setSelectedIndex(0);
                        DatePicker.setDate(null);
                        TimeTxt.setText("");
                        PriceTxt.setText("");
                    }
                }

                listSchedules = ScheduleDAO.getScheduleList(movie.getId());
                showSchedule();
            }
        }
    }//GEN-LAST:event_UpdateScheBtnActionPerformed

    private void ResetScheBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetScheBtnActionPerformed
        // TODO add your handling code here:
        RoomBox.setSelectedIndex(0);
        DatePicker.setDate(null);
        TimeTxt.setText("");
        PriceTxt.setText("");
    }//GEN-LAST:event_ResetScheBtnActionPerformed

    private void DeleteScheBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteScheBtnActionPerformed
        // TODO add your handling code here:
        int selectedIndex = MovieTable.getSelectedRow();
        if(selectedIndex >= 0) {
            Movie movie = ListMovies.get(selectedIndex);
            int selectedIndex1 = ScheduleTable.getSelectedRow();
            if(selectedIndex1 >= 0) {
                Schedule schedule = listSchedules.get(selectedIndex1);
                int option = JOptionPane.showConfirmDialog(this, "Do you want delete this schedule?");
                if(option == 0) {
                ScheduleDAO.Delete(schedule.getId());
                RoomBox.setSelectedIndex(0);
                DatePicker.setDate(null);
                TimeTxt.setText("");
                PriceTxt.setText("");
                }
                listSchedules = ScheduleDAO.getScheduleList(movie.getId());
                showSchedule();
            }
        }
    }//GEN-LAST:event_DeleteScheBtnActionPerformed

    private void UploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();
        ImageIcon img = new ImageIcon(f.toString());
        Image imgScale = img.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImgLabel.setIcon(new ImageIcon(imgScale));
        ImgTxt.setText(f.getName());
    }//GEN-LAST:event_UploadBtnActionPerformed

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

    private void DatePickerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatePickerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DatePickerMouseClicked

    private void DatePickerInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_DatePickerInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_DatePickerInputMethodTextChanged

    private void Reset() {
        MovieNameTxt.setText("");
        TypeBox.setSelectedIndex(0);
        AgeTxt.setText("");
        DirectorTxt.setText("");
        ActorTxt.setText("");
        ReleaseDatePicker.setDate(null);
        DescTxt.setText("");
        ImgTxt.setText("");
        ImgLabel.setIcon(null);
        RoomBox.setSelectedIndex(0);
        DatePicker.setDate(null);
        TimeTxt.setText("");
        PriceTxt.setText("");
        tableModel1.setNumRows(0);
    }
    
    private StringBuilder Validation(String name, String type, String age, String director, String cast, String releaseDate, String desc, String img) {
        StringBuilder sb = new StringBuilder();
        if(name.equals("")) {
            sb.append("Movie name is empty!!!\n");
        }
        if(type.equals("")) {
            sb.append("Type is empty!!!\n");
        }
        if(age.equals("")) {
            sb.append("Age is empty!!!\n");
        }
        if(director.equals("")) {
            sb.append("Director is empty!!!\n");
        }
        if(cast.equals("")) {
            sb.append("Cast is empty!!!\n");
        }
        if(releaseDate.equals("")) {
            sb.append("Release date is empty!!!\n");
        }
        if(desc.equals("")) {
            sb.append("Description is empty!!!\n");
        }if(img.equals("")) {
            sb.append("Image is empty!!!\n");
        }
        return sb;
    }
    
    private StringBuilder Validation(String room, String date, String time, Integer price) {
        StringBuilder sb = new StringBuilder();
        if(room.equals("")) {
            sb.append("Room is empty!!!\n");
        }
        if(date.equals("")) {
            sb.append("Date is empty!!!\n");
        }
        if(time.equals("")) {
            sb.append("Time is empty!!!\n");
        }
        if(price.equals("")) {
            sb.append("Price is empty!!!\n");
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
            java.util.logging.Logger.getLogger(MovieManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieManage(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Actor;
    private javax.swing.JTextField ActorTxt;
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AddScheBtn;
    private javax.swing.JLabel Age;
    private javax.swing.JTextField AgeTxt;
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel Date;
    private com.toedter.calendar.JDateChooser DatePicker;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeleteScheBtn;
    private javax.swing.JLabel Desc;
    private javax.swing.JTextArea DescTxt;
    private javax.swing.JLabel Director;
    private javax.swing.JTextField DirectorTxt;
    private javax.swing.JLabel ImgLabel;
    private javax.swing.JTextField ImgTxt;
    private javax.swing.JLabel MovieName;
    private javax.swing.JTextField MovieNameTxt;
    private javax.swing.JPanel MoviePanel;
    private javax.swing.JTable MovieTable;
    private javax.swing.JTextField PriceTxt;
    private com.toedter.calendar.JDateChooser ReleaseDatePicker;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton ResetScheBtn;
    private javax.swing.JComboBox<String> RoomBox;
    private javax.swing.JTable ScheduleTable;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField TimeTxt;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JLabel Type;
    private javax.swing.JComboBox<String> TypeBox;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton UpdateScheBtn;
    private javax.swing.JButton UploadBtn;
    private javax.swing.JPanel bodypanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.raven.swing.TimePicker timePicker1;
    private javax.swing.JPanel toppanel;
    // End of variables declaration//GEN-END:variables
}
