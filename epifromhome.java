import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class epifromhome implements ActionListener {
    private JFrame frame = new JFrame();
    private JPanel panel, pl1;
    private JButton title1, playcse, pausecse, resetcse, playece, pauseece, resetece, playit, pauseit, resetit;
    private JLabel wcuser, logo1, psgpod, psglogo, theme, epititle, epidesc1, epidesc21;
    public Clip clipcse=AudioSystem.getClip();
    public Clip clipece=AudioSystem.getClip();
    public Clip clipit=AudioSystem.getClip();
    public String desc;
    private static final String url = "jdbc:mysql://localhost:3306/cpapp";
    private static final String username = "root";
    private static final String password = "";

    public epifromhome(String x) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.desc=x;
        frame.setTitle("Episodes");
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

        psglogo = new JLabel();
        ImageIcon icon = new ImageIcon("psglogo.png");
        psglogo.setIcon(icon);
        psglogo.setBounds(10, 10, 50, 50);
        panel.add(psglogo);

        psgpod = new JLabel("PSG PODCASTS");
        Font psgpodfont = new Font("Proxima Nova", Font.BOLD, 30); // Font name, style, size
        psgpod.setFont(psgpodfont);
        psgpod.setBounds(70, 15, 300, 40);
        psgpod.setForeground(new Color(1, 1, 21));
        panel.add(psgpod);

        epititle = new JLabel("Technical Talks");
        epititle.setForeground(new Color(0, 0, 0));
        Font recmfont = new Font("Proxima Nova", Font.BOLD, 21); // Font name, style, size
        epititle.setFont(recmfont);
        epititle.setBounds(15, 70, 230, 20);
        panel.add(epititle);

        panel.setBackground(new Color(255, 255, 255));
        frame.setVisible(true);

        wcuser = new JLabel("Welcome User!");
        wcuser.setForeground(new Color(0, 0, 0));
        Font wcuserfont = new Font("Proxima Nova", Font.BOLD, 19); // Font name, style, size
        wcuser.setFont(wcuserfont);
        wcuser.setBounds(662, 20, 250, 30);
        panel.add(wcuser);

        switch (x) {
            case ("techcse"): {
                theme = new JLabel();
                ImageIcon themeimg = new ImageIcon(getimage("cse","epitheme"));
                theme.setIcon(themeimg);
                theme.setBounds(0, 100, 800, 250);
                panel.add(theme);

                pl1 = new JPanel();
                pl1.setLayout(null);
                pl1.setBounds(15, 355, 770, 140);
                pl1.setBackground(new Color(255, 255, 255));
                title1 = new JButton();
                title1.setText(gettitle("cse","epi"));
                //title1.setForeground(new Color(255, 255, 255));
                Font tit1font = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
                title1.setFont(tit1font);
                title1.setBounds(155, 14, 300, 30);
                title1.setBackground(new Color(0, 0, 0));
                //title1.addActionListener(this);
                pl1.add(title1);

                epidesc1 = new JLabel(getdesc("cse","epi"));
                epidesc1.setForeground(new Color(0, 0, 0));
                Font epid1font = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                epidesc1.setFont(epid1font);
                epidesc1.setBounds(160, 50, 300, 30);
                pl1.add(epidesc1);
                epidesc21 = new JLabel(getsubdesc("cse","epi"));
                epidesc21.setForeground(new Color(0, 0, 0));
                Font epid21font = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                epidesc21.setFont(epid21font);
                epidesc21.setBounds(160, 75, 520, 30);
                pl1.add(epidesc21);

                logo1 = new JLabel();
                ImageIcon logo1i = new ImageIcon(getimage("cse","epi"));
                logo1.setIcon(logo1i);
                logo1.setBounds(10, 10, 120, 120);
                pl1.add(logo1);

                playcse = new JButton("PLAY");
                playcse.setBounds(540, 60, 50, 50);
                playcse.setForeground(new Color(1, 1, 21));
                Font playbtnfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                playcse.setFont(playbtnfont);
                pl1.add(playcse);

                pausecse = new JButton("PAUSE");
                pausecse.setBounds(600, 60, 70, 50);
                pausecse.setForeground(new Color(1, 1, 21));
                Font pausebtnfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                pausecse.setFont(pausebtnfont);
                pl1.add(pausecse);

                resetcse = new JButton("RESET");
                resetcse.setBounds(680, 60, 60, 50);
                resetcse.setForeground(new Color(1, 1, 21));
                Font resetbtnfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                resetcse.setFont(resetbtnfont);
                pl1.add(resetcse);

                File filecse = new File(getaudiofile("cse","epi"));
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(filecse);
                this.clipcse.open(audioStream);
                pausecse.addActionListener(this);
                playcse.addActionListener(this);
                resetcse.addActionListener(this);
                panel.add(pl1);
                break;
            }
            case ("techece"): {
                theme = new JLabel();
                ImageIcon themeimgece = new ImageIcon(getimage("ece","epitheme"));
                theme.setIcon(themeimgece);
                theme.setBounds(0, 100, 800, 250);
                panel.add(theme);

                pl1 = new JPanel();
                pl1.setLayout(null);
                pl1.setBounds(15, 355, 770, 140);
                pl1.setBackground(new Color(255, 255, 255));
                title1 = new JButton();
                title1.setText(gettitle("ece","epi"));
                //title1.setForeground(new Color(255, 255, 255));
                Font tit1ecfont = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
                title1.setFont(tit1ecfont);
                title1.setBounds(155, 14, 300, 30);
                title1.setBackground(new Color(0, 0, 0));
                //title1.addActionListener(this);
                pl1.add(title1);

                epidesc1 = new JLabel(getdesc("ece","epi"));
                epidesc1.setForeground(new Color(0, 0, 0));
                Font epid1ecefont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                epidesc1.setFont(epid1ecefont);
                epidesc1.setBounds(160, 50, 300, 30);
                pl1.add(epidesc1);
                epidesc21 = new JLabel(getsubdesc("ece","epi"));
                epidesc21.setForeground(new Color(0, 0, 0));
                Font epid21ecefont = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                epidesc21.setFont(epid21ecefont);
                epidesc21.setBounds(160, 75, 600, 30);
                pl1.add(epidesc21);

                logo1 = new JLabel();
                ImageIcon logo1iece = new ImageIcon(getimage("ece","epi"));
                logo1.setIcon(logo1iece);
                logo1.setBounds(10, 10, 120, 120);
                pl1.add(logo1);

                playece = new JButton("PLAY");
                playece.setBounds(560, 50, 50, 50);
                playece.setForeground(new Color(1, 1, 21));
                Font playbtncsfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                playece.setFont(playbtncsfont);
                pl1.add(playece);

                pauseece = new JButton("PAUSE");
                pauseece.setBounds(620, 50, 70, 50);
                pauseece.setForeground(new Color(1, 1, 21));
                Font pausebtncsfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                pauseece.setFont(pausebtncsfont);
                pl1.add(pauseece);

                resetece = new JButton("RESET");
                resetece.setBounds(700, 50, 60, 50);
                resetece.setForeground(new Color(1, 1, 21));
                Font resetbtnecefont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                resetece.setFont(resetbtnecefont);
                pl1.add(resetece);

                File filecse = new File(getaudiofile("ece","epi"));
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(filecse);
                this.clipece.open(audioStream);
                pauseece.addActionListener(this);
                playece.addActionListener(this);
                resetece.addActionListener( this);
                panel.add(pl1);
                break;
            }
            case ("techit"): {
                theme = new JLabel();
                ImageIcon themeimgit = new ImageIcon(getimage("it","epitheme"));
                theme.setIcon(themeimgit);
                theme.setBounds(0, 100, 800, 250);
                panel.add(theme);

                pl1 = new JPanel();
                pl1.setLayout(null);
                pl1.setBounds(15, 355, 770, 140);
                pl1.setBackground(new Color(255, 255, 255));
                title1 = new JButton();
                title1.setText(gettitle("it","epi"));
                //title1.setForeground(new Color(255, 255, 255));
                Font tit1itfont = new Font("Proxima Nova", Font.PLAIN, 18); // Font name, style, size
                title1.setFont(tit1itfont);
                title1.setBounds(155, 14, 300, 30);
                title1.setBackground(new Color(0, 0, 0));
                //title1.addActionListener(this);
                pl1.add(title1);

                epidesc1 = new JLabel(getdesc("it","epi"));
                epidesc1.setForeground(new Color(0, 0, 0));
                Font epid1itfont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
                epidesc1.setFont(epid1itfont);
                epidesc1.setBounds(160, 50, 300, 30);
                pl1.add(epidesc1);
                epidesc21 = new JLabel(getsubdesc("it","epi"));
                epidesc21.setForeground(new Color(0, 0, 0));
                Font epid21itfont = new Font("Proxima Nova", Font.PLAIN, 14); // Font name, style, size
                epidesc21.setFont(epid21itfont);
                epidesc21.setBounds(160, 75, 600, 30);
                pl1.add(epidesc21);

                logo1 = new JLabel();
                ImageIcon logo1iit = new ImageIcon(getimage("it","epi"));
                logo1.setIcon(logo1iit);
                logo1.setBounds(10, 10, 120, 120);
                pl1.add(logo1);

                playit = new JButton("PLAY");
                playit.setBounds(560, 50, 50, 50);
                playit.setForeground(new Color(1, 1, 21));
                Font playbtnitfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                playit.setFont(playbtnitfont);
                pl1.add(playit);

                pauseit = new JButton("PAUSE");
                pauseit.setBounds(620, 50, 70, 50);
                pauseit.setForeground(new Color(1, 1, 21));
                Font pausebtnitfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                pauseit.setFont(pausebtnitfont);
                pl1.add(pauseit);

                resetit = new JButton("RESET");
                resetit.setBounds(700, 50, 60, 50);
                resetit.setForeground(new Color(1, 1, 21));
                Font resetbtnitfont = new Font("Proxima Nova", Font.PLAIN, 15); // Font name, style, size
                resetit.setFont(resetbtnitfont);
                pl1.add(resetit);

                File fileit = new File(getaudiofile("it","epi"));
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileit);
                this.clipit.open(audioStream);
                pauseit.addActionListener(this);
                playit.addActionListener( this);
                resetit.addActionListener( this);
                panel.add(pl1);
                break;
            }
        }
    }
    public String getaudiofile(String dept, String epi) {
        String audiofilepath = null;
        String query = "SELECT audiofile FROM audiofiles WHERE dept = ? AND epi = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept);
            statement.setString(2, epi);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    audiofilepath = resultSet.getString("audiofile");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return audiofilepath;
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
        if(e.getSource()==playcse){
            this.clipcse.start();
        }
        if(e.getSource()==playece){
            this.clipece.start();
        }
        if(e.getSource()==playit){
            this.clipit.start();
        }
        if(e.getSource()==pausecse){
            this.clipcse.stop();
        }
        if(e.getSource()==pauseece){
            this.clipece.stop();
        }
        if(e.getSource()==pauseit){
            this.clipit.stop();
        }
        if(e.getSource()==resetcse){
            this.clipcse.setMicrosecondPosition(0);
        }
        if(e.getSource()==resetece){
            this.clipece.setMicrosecondPosition(0);
        }
        if(e.getSource()==resetit){
            this.clipit.setMicrosecondPosition(0);
        }
    }
    @Before
    public void setUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        epifromhome epiframe = new epifromhome(this.desc);
    }
    @Test
    public void testGetImage() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        epifromhome epiframe = new epifromhome(this.desc);
        if(this.desc=="csea")
        {
            String result = epifromhome.getimage("cse", "epi");
            String expected = "csespeaker.png";
            assertEquals(expected, result);
        }
        else if(this.desc=="ecea")
        {
            String result = epifromhome.getimage("ece", "epi");
            String expected = "ecespeaker.png";
            assertEquals(expected, result);
        }
        else if(this.desc=="ita"){
            String result = epifromhome.getimage("it", "epi");
            String expected = "itspeaker.png";
            assertEquals(expected, result);
        }
    }
    public static String getimage(String dept, String topic) {
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

