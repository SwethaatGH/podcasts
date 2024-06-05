import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class home implements ActionListener {
    private JFrame frame=new JFrame();
    private JPanel panel,pl1,pl2,pl3;
    private JButton notif,history,trending,logout,title1,title2,title3;
    private JLabel psgpod,wcuser,psglogo,notification,notiflogo,arrow,theme,recom,logo1,logo2,logo3,dept1,dept2,dept3,desc1,desc2,desc3;
    private static final String url = "jdbc:mysql://localhost:3306/cpapp";
    private static final String username = "root";
    private static final String password = "";
    public home()
    {
        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);
        panel=new JPanel();
        panel.setLayout(null);
        c.add(panel);
        panel.setBounds(0,0,800,800);
        panel.setBackground(new Color(255, 255, 255));

        psglogo=new JLabel();
        ImageIcon icon=new ImageIcon("psglogo.png");
        psglogo.setIcon(icon);
        psglogo.setBounds(10,10,50,50);

        psgpod=new JLabel("PSG PODCASTS");
        Font psgpodfont = new Font("Proxima Nova", Font.BOLD, 30); // Font name, style, size
        psgpod.setFont(psgpodfont);
        psgpod.setBounds(70,15,300,40);
        psgpod.setForeground(new Color(255, 255, 255));

        wcuser=new JLabel("Welcome User!");
        wcuser.setForeground(new Color(255, 255, 255));
        Font wcuserfont = new Font("Proxima Nova", Font.BOLD, 19); // Font name, style, size
        wcuser.setFont(wcuserfont);
        wcuser.setBounds(662,20,250,30);

        theme=new JLabel();
        ImageIcon themeimg=new ImageIcon(getimage("home","theme"));
        theme.setIcon(themeimg);
        theme.setBounds(0,70,800,250);

        notif=new JButton("Notifications");
        notif.setBounds(630,330,160,60);
        notif.setForeground(new Color(0, 0, 0));
        Font notifbtnfont = new Font("Proxima Nova", Font.PLAIN, 17); // Font name, style, size
        notif.setFont(notifbtnfont);
        ImageIcon bell=new ImageIcon("bellicon.png");
        notif.setIcon(bell);
        notif.addActionListener(this);

        trending=new JButton("Trending");
        trending.setBounds(520,330,100,60);
        trending.setForeground(new Color(1, 1, 21));
        Font trendbtnfont = new Font("Proxima Nova", Font.PLAIN, 17); // Font name, style, size
        trending.setFont(trendbtnfont);
        trending.addActionListener(this);

        logout=new JButton("Logout");
        logout.setBounds(715,730,80,33);
        logout.setForeground(new Color(0, 0, 0));
        Font logoutbtnfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
        logout.setFont(logoutbtnfont);
        logout.addActionListener(this);

        pl1=new JPanel();
        pl1.setLayout(null);
        pl1.setBounds(15,405,770,100);

        pl2=new JPanel();
        pl2.setLayout(null);
        pl2.setBounds(15,515,770,100);

        pl3=new JPanel();
        pl3.setLayout(null);
        pl3.setBounds(15,625,770,100);

        recom=new JLabel("Recommendations");
        recom.setForeground(new Color(255, 255, 255));
        Font recmfont = new Font("Proxima Nova", Font.BOLD, 25); // Font name, style, size
        recom.setFont(recmfont);
        recom.setBounds(20,335,210,40);

        logo1=new JLabel();
        ImageIcon logo1i=new ImageIcon(getimage("cse","playlist"));
        logo1.setIcon(logo1i);
        logo2=new JLabel();
        ImageIcon logo2i=new ImageIcon(getimage("ece","playlist"));
        logo2.setIcon(logo2i);
        logo3=new JLabel();
        ImageIcon logo3i=new ImageIcon(getimage("it","playlist"));
        logo3.setIcon(logo3i);
        logo1.setBounds(10,10,140,80);
        logo2.setBounds(10,10,140,80);
        logo3.setBounds(10,10,140,80);

        title1=new JButton();
        title1.setText(gettitle("cse","playlist"));
        //title1.setForeground(new Color(255, 255, 255));
        Font tit1font = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
        title1.setFont(tit1font);
        title1.setBounds(150,14,240,30);
        title1.setBackground(new Color(0,0,0));
        title1.addActionListener(this);
        pl1.add(title1);

        title2=new JButton();
        title2.setText(gettitle("ece","playlist"));
        //title2.setForeground(new Color(255, 255, 255));
        Font tit2font = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
        title2.setFont(tit2font);
        title2.setBounds(150,14,230,30);
        title2.setBackground(new Color(0,0,0));
        title2.addActionListener(this);
        pl2.add(title2);

        title3=new JButton();
        title3.setText(gettitle("it","playlist"));
        //title3.setForeground(new Color(255, 255, 255));
        Font tit3font = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
        title3.setFont(tit3font);
        title3.setBounds(150,14,230,30);
        title3.setBackground(new Color(0,0,0));
        title3.addActionListener(this);
        pl3.add(title3);

        history=new JButton("Go To History");
        //history.setForeground(new Color(255, 255, 255));
        Font histfont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        history.setFont(histfont);
        history.setBounds(20,730,120,30);
        title3.setBackground(new Color(0,0,0));
        title3.addActionListener(this);
        history.addActionListener(this);
        panel.add(history);

        dept1=new JLabel(getdesc("cse","playlist"));
        dept1.setForeground(new Color(255, 255, 255));
        Font dept1font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        dept1.setFont(dept1font);
        dept1.setBounds(155,50,250,30);
        pl1.add(dept1);

        dept2=new JLabel(getdesc("ece","playlist"));
        dept2.setForeground(new Color(255, 255, 255));
        Font dept2font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        dept2.setFont(dept2font);
        dept2.setBounds(155,50,250,30);
        pl2.add(dept2);

        dept3=new JLabel(getdesc("it","playlist"));
        dept3.setForeground(new Color(255, 255, 255));
        Font dept3font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        dept3.setFont(dept3font);
        dept3.setBounds(155,50,250,30);
        pl3.add(dept3);

        arrow=new JLabel();
        ImageIcon arrowicon=new ImageIcon("arrowicon.png");
        arrow.setIcon(arrowicon);
        arrow.setBounds(140,730,30,30);
        panel.add(arrow);

        pl1.setBackground(new Color(0, 0, 0));
        pl2.setBackground(new Color(0, 0, 0));
        pl3.setBackground(new Color(0, 0, 0));
        pl1.add(logo1);
        pl2.add(logo2);
        pl3.add(logo3);
        panel.setBackground(new Color(0, 0, 0));
        panel.add(psglogo);
        panel.add(theme);
        panel.add(psgpod);
        panel.add(wcuser);
        panel.add(notif);
        panel.add(logout);
        panel.add(recom);
        panel.add(trending);
        panel.add(pl1);
        panel.add(pl2);
        panel.add(pl3);
        frame.setVisible(true);
    }
    @Before
    public void setUp() {
        home homeframe = new home();
    }
    public String getimage(String dept, String topic) {
        String imagename = null;
        String query = "SELECT image FROM images WHERE dept = ? AND topic = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept);   // Set the value for the "dept" parameter
            statement.setString(2, topic);  // Set the value for the "topic" parameter
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    imagename = resultSet.getString("image");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagename;
    }

    public String gettitle(String dept, String topic) {
        String title = null;
        String query = "SELECT d1 FROM texts WHERE dept = ? AND topic = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept);   // Set the value for the "dept" parameter
            statement.setString(2, topic);  // Set the value for the "topic" parameter
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    title = resultSet.getString("d1");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }

    public String getdesc(String dept, String topic) {
        String desc = null;
        String query = "SELECT d2 FROM texts WHERE dept = ? AND topic = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept);   // Set the value for the "dept" parameter
            statement.setString(2, topic);  // Set the value for the "topic" parameter
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    desc = resultSet.getString("d2");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return desc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==title1)
        {
            //frame.dispose();
            podcastfromhome podcastfromhomeframe=new podcastfromhome("csea");
        }
        if(e.getSource()==title2)
        {
            //frame.dispose();
            podcastfromhome podcastfromhomeframe=new podcastfromhome("ecea");
        }
        if(e.getSource()==title3)
        {
            //frame.dispose();
            podcastfromhome podcastfromhomeframe=new podcastfromhome("ita");
        }
        if(e.getSource()==logout)
        {
            frame.dispose();
            login loginframe=new login();
        }
        if(e.getSource()==trending)
        {
            //frame.dispose();
            TrendingPage trendingframe=new TrendingPage();
        }
        if(e.getSource()==notif)
        {
            //frame.dispose();
            PodcastNotificationApp notifframe=new PodcastNotificationApp();
        }
        if(e.getSource()==history)
        {
            //frame.dispose();
            PodcastHistoryPage historyframe=new PodcastHistoryPage();
        }
    }
    @Test
    public void testGetImage() {
        home home = new home();

        String result = home.getimage("cse", "playlist");

        String expected = "pl1icon.png";

        assertEquals(expected, result);
    }
}


