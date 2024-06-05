import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class podcastfromhome implements ActionListener {
    private JFrame frame = new JFrame();
    private JPanel panel,pl1,pl2,pl3;
    private JButton title1,title2,title3;
    String dept;
    private JLabel wcuser,psgpod,psglogo,theme,playtitle,pdesc1,pdesc2,pdesc3,logo1,logo2,logo3,pdesc21,pdesc22,pdesc23;

    private static final String url = "jdbc:mysql://localhost:3306/cpapp";
    private static final String username = "root";
    private static final String password = "";
    public podcastfromhome(String x) {
        this.dept=x;
        frame.setTitle("Podcasts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);
        panel = new JPanel();
        panel.setLayout(null);
        c.add(panel);
        panel.setBounds(0, 0, 800, 800);
        panel.setBackground(new Color(255, 255, 255));

        psglogo=new JLabel();
        ImageIcon icon=new ImageIcon("psglogo.png");
        psglogo.setIcon(icon);
        psglogo.setBounds(10,10,50,50);
        panel.add(psglogo);

        psgpod=new JLabel("PSG PODCASTS");
        Font psgpodfont = new Font("Proxima Nova", Font.BOLD, 30); // Font name, style, size
        psgpod.setFont(psgpodfont);
        psgpod.setBounds(70,15,300,40);
        psgpod.setForeground(new Color(1, 1, 21));
        panel.add(psgpod);

        wcuser=new JLabel("Welcome User!");
        wcuser.setForeground(new Color(0, 0, 0));
        Font wcuserfont = new Font("Proxima Nova", Font.BOLD, 19); // Font name, style, size
        wcuser.setFont(wcuserfont);
        wcuser.setBounds(662,20,250,30);
        panel.add(wcuser);

        pl1=new JPanel();
        pl1.setLayout(null);
        pl1.setBounds(15,355,770,140);

        pl2=new JPanel();
        pl2.setLayout(null);
        pl2.setBounds(15,490,770,140);

        pl3=new JPanel();
        pl3.setLayout(null);
        pl3.setBounds(15,635,770,140);
        pl1.setBackground(new Color(255, 255, 255));
        pl2.setBackground(new Color(255, 255, 255));
        pl3.setBackground(new Color(255, 255, 255));

        theme=new JLabel();

        switch(x)
        {
            case("csea"):
            {
                playtitle=new JLabel(gettitle("cse","playlist"));
                playtitle.setForeground(new Color(0, 0, 0));
                Font recmfont = new Font("Proxima Nova", Font.BOLD, 21); // Font name, style, size
                playtitle.setFont(recmfont);
                playtitle.setBounds(20,327,230,20);
                panel.add(playtitle);

                ImageIcon themeimg=new ImageIcon(getimage("cse","theme"));
                theme.setIcon(themeimg);
                theme.setBounds(0,70,800,250);
                panel.add(theme);

                pdesc1=new JLabel(getdesc("cse","tech"));
                pdesc1.setForeground(new Color(0, 0, 0));
                Font pd1font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc1.setFont(pd1font);
                pdesc1.setBounds(160,50,300,30);
                pl1.add(pdesc1);
                pdesc21=new JLabel(getsubdesc("cse","tech"));
                pdesc21.setForeground(new Color(0, 0, 0));
                Font pd21font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc21.setFont(pd21font);
                pdesc21.setBounds(160,72,600,30);
                pl1.add(pdesc21);

                pdesc2=new JLabel(getdesc("cse","alum"));
                pdesc2.setForeground(new Color(0, 0, 0));
                Font pd2font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc2.setFont(pd2font);
                pdesc2.setBounds(160,50,260,30);
                pl2.add(pdesc2);
                pdesc22=new JLabel(getsubdesc("cse","alum"));
                pdesc22.setForeground(new Color(0, 0, 0));
                Font pd22font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc22.setFont(pd22font);
                pdesc22.setBounds(160,72,600,30);
                pl2.add(pdesc22);

                pdesc3=new JLabel(getdesc("cse","hod"));
                pdesc3.setForeground(new Color(0, 0, 0));
                Font pd3font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc3.setFont(pd3font);
                pdesc3.setBounds(160,50,600,20);
                pl3.add(pdesc3);
                pdesc23=new JLabel(getsubdesc("cse","hod"));
                pdesc23.setForeground(new Color(0, 0, 0));
                Font pd23font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc23.setFont(pd23font);
                pdesc23.setBounds(160,72,600,30);
                pl3.add(pdesc23);

                logo1=new JLabel();
                ImageIcon logo1i=new ImageIcon(getimage("cse","tech"));
                logo1.setIcon(logo1i);
                logo2=new JLabel();
                ImageIcon logo2i=new ImageIcon(getimage("cse","alum"));
                logo2.setIcon(logo2i);
                logo3=new JLabel();
                ImageIcon logo3i=new ImageIcon(getimage("cse","hod"));
                logo3.setIcon(logo3i);

                break;
            }
            case("ecea"):
            {
                playtitle=new JLabel(gettitle("ece","playlist"));
                playtitle.setForeground(new Color(0, 0, 0));
                Font recmfont = new Font("Proxima Nova", Font.BOLD, 21); // Font name, style, size
                playtitle.setFont(recmfont);
                playtitle.setBounds(20,327,230,20);
                panel.add(playtitle);

                ImageIcon themeimg=new ImageIcon(getimage("ece","theme"));
                theme.setIcon(themeimg);
                theme.setBounds(5,70,820,250);
                panel.add(theme);

                pdesc1=new JLabel(getdesc("ece","tech"));
                pdesc1.setForeground(new Color(0, 0, 0));
                Font pd1font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc1.setFont(pd1font);
                pdesc1.setBounds(160,50,300,30);
                pl1.add(pdesc1);
                pdesc21=new JLabel(getsubdesc("ece","tech"));
                pdesc21.setForeground(new Color(0, 0, 0));
                Font pd21font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc21.setFont(pd21font);
                pdesc21.setBounds(160,72,600,30);
                pl1.add(pdesc21);

                pdesc2=new JLabel(getdesc("ece","alum"));
                pdesc2.setForeground(new Color(0, 0, 0));
                Font pd2font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc2.setFont(pd2font);
                pdesc2.setBounds(160,50,400,30);
                pl2.add(pdesc2);
                pdesc22=new JLabel(getsubdesc("ece","alum"));
                pdesc22.setForeground(new Color(0, 0, 0));
                Font pd22font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc22.setFont(pd22font);
                pdesc22.setBounds(160,72,600,30);
                pl2.add(pdesc22);

                pdesc3=new JLabel(getdesc("ece","hod"));
                pdesc3.setForeground(new Color(0, 0, 0));
                Font pd3font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc3.setFont(pd3font);
                pdesc3.setBounds(160,50,400,20);
                pl3.add(pdesc3);
                pdesc23=new JLabel(getsubdesc("ece","hod"));
                pdesc23.setForeground(new Color(0, 0, 0));
                Font pd23font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc23.setFont(pd23font);
                pdesc23.setBounds(160,72,600,30);
                pl3.add(pdesc23);

                logo1=new JLabel();
                ImageIcon logo1i=new ImageIcon(getimage("ece","tech"));
                logo1.setIcon(logo1i);
                logo2=new JLabel();
                ImageIcon logo2i=new ImageIcon(getimage("ece","alum"));
                logo2.setIcon(logo2i);
                logo3=new JLabel();
                ImageIcon logo3i=new ImageIcon(getimage("ece","hod"));
                logo3.setIcon(logo3i);

                break;
            }
            case("ita"):
            {
                playtitle=new JLabel(gettitle("it","playlist"));
                playtitle.setForeground(new Color(0, 0, 0));
                Font recmfont = new Font("Proxima Nova", Font.BOLD, 21); // Font name, style, size
                playtitle.setFont(recmfont);
                playtitle.setBounds(20,327,230,20);
                panel.add(playtitle);

                ImageIcon themeimg=new ImageIcon(getimage("it","theme"));
                theme.setIcon(themeimg);
                theme.setBounds(0,70,800,250);
                panel.add(theme);

                pdesc1=new JLabel(getdesc("it","tech"));
                pdesc1.setForeground(new Color(0, 0, 0));
                Font pd1font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc1.setFont(pd1font);
                pdesc1.setBounds(160,50,300,30);
                pl1.add(pdesc1);
                pdesc21=new JLabel(getsubdesc("it","tech"));
                pdesc21.setForeground(new Color(0, 0, 0));
                Font pd21font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc21.setFont(pd21font);
                pdesc21.setBounds(160,72,600,30);
                pl1.add(pdesc21);

                pdesc2=new JLabel(getdesc("it","alum"));
                pdesc2.setForeground(new Color(0, 0, 0));
                Font pd2font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc2.setFont(pd2font);
                pdesc2.setBounds(160,50,260,30);
                pl2.add(pdesc2);
                pdesc22=new JLabel(getsubdesc("it","alum"));
                pdesc22.setForeground(new Color(0, 0, 0));
                Font pd22font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc22.setFont(pd22font);
                pdesc22.setBounds(160,72,600,30);
                pl2.add(pdesc22);

                pdesc3=new JLabel(getdesc("it","hod"));
                pdesc3.setForeground(new Color(0, 0, 0));
                Font pd3font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                pdesc3.setFont(pd3font);
                pdesc3.setBounds(160,50,400,20);
                pl3.add(pdesc3);
                pdesc23=new JLabel(getsubdesc("it","hod"));
                pdesc23.setForeground(new Color(0, 0, 0));
                Font pd23font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                pdesc23.setFont(pd23font);
                pdesc23.setBounds(160,72,600,30);
                pl3.add(pdesc23);

                logo1=new JLabel();
                ImageIcon logo1i=new ImageIcon(getimage("it","tech"));
                logo1.setIcon(logo1i);
                logo2=new JLabel();
                ImageIcon logo2i=new ImageIcon(getimage("it","alum"));
                logo2.setIcon(logo2i);
                logo3=new JLabel();
                ImageIcon logo3i=new ImageIcon(getimage("it","hod"));
                logo3.setIcon(logo3i);

                break;
            }
        }

        title1=new JButton();
        title1.setText(gettitle("cse","tech"));
        //title1.setForeground(new Color(255, 255, 255));
        Font tit1font = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
        title1.setFont(tit1font);
        title1.setBounds(155,14,250,30);
        title1.setBackground(new Color(0,0,0));
        title1.addActionListener(this);
        pl1.add(title1);

        title2=new JButton();
        title2.setText(gettitle("cse","alum"));
        //title2.setForeground(new Color(255, 255, 255));
        Font tit2font = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
        title2.setFont(tit2font);
        title2.setBounds(155,14,250,30);
        title2.setBackground(new Color(0,0,0));
        title2.addActionListener(this);
        pl2.add(title2);

        title3=new JButton();
        title3.setText(gettitle("cse","hod"));
        //title3.setForeground(new Color(255, 255, 255));
        Font tit3font = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
        title3.setFont(tit3font);
        title3.setBounds(155,14,250,30);
        title3.setBackground(new Color(0,0,0));
        title3.addActionListener(this);
        pl3.add(title3);


        logo1.setBounds(10,0,120,120);
        logo2.setBounds(10,0,120,120);
        logo3.setBounds(10,0,120,120);
        pl1.add(logo1);
        pl2.add(logo2);
        pl3.add(logo3);
        panel.add(pl1);
        panel.add(pl2);
        panel.add(pl3);
        panel.setBackground(new Color(255, 255, 255));
        frame.setVisible(true);
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
    public String getsubdesc(String dept, String topic) {
        String subdesc = null;
        String query = "SELECT d3 FROM texts WHERE dept = ? AND topic = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept);   // Set the value for the "dept" parameter
            statement.setString(2, topic);  // Set the value for the "topic" parameter
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    subdesc = resultSet.getString("d3");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subdesc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource()==title1)&&(this.dept=="csea"))
        {
            try {
                //frame.dispose();
                epifromhome epifromhomeframe=new epifromhome("techcse");
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
        if((e.getSource()==title1)&&(this.dept=="ecea"))
        {
            try {
                //frame.dispose();
                epifromhome epifromhomeframe=new epifromhome("techece");
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
        if((e.getSource()==title1)&&(this.dept=="ita"))
        {
            frame.dispose();
            try {
                //frame.dispose();
                epifromhome epifromhomeframe=new epifromhome("techit");
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    @Before
    public void setUp(){
        podcastfromhome podcastframe = new podcastfromhome(this.dept);
    }
    @Test
    public void testGetImage() {
        podcastfromhome podcastframe = new podcastfromhome(this.dept);
    if(this.dept=="csea")
    {
        String result = podcastframe.getimage("cse", "tech");
        String expected = "cselogo2pl.png";
        assertEquals(expected, result);
    }
    else if(this.dept=="ecea")
    {
        String result = podcastframe.getimage("ece", "tech");
        String expected = "ecelogo1pl.png";
        assertEquals(expected, result);
    }
    else if(this.dept=="ita"){
        String result = podcastframe.getimage("it", "tech");
        String expected = "cselogo1pl.png";
        assertEquals(expected, result);
    }
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
}
