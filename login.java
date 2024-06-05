import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class login extends JFrame implements ActionListener {
    private JTextField usernamefield;
    private JPasswordField passwordfield;
    private JLabel username, password, appname, applogo,newuser;
    private JButton login, reset,signup;
    private String usernameip,passwordip;
    private static final String url = "jdbc:mysql://localhost:3306/cpapp";
    private static final String usernamesql = "root";
    private static final String passwordsql = "";
    private login loginframe;
    private Robot robot;


    public login() {
        this.setTitle("College Podcasts Application Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 460);
        this.setResizable(false);
        JPanel loginpanel=new JPanel();
        loginpanel.setLayout(null);
        Container c = getContentPane();
        c.setLayout(null);
        loginpanel.setBounds(0,0,640,460);
        loginpanel.setBackground(new Color(250, 130, 117));
        ImageIcon appicon=new ImageIcon("appicon.png");
        applogo=new JLabel();
        applogo.setIcon(appicon);
        applogo.setBounds(50,100,200,200);
        appname=new JLabel("PSG Podcasts");
        appname.setBounds(340,100,260,30);
        appname.setForeground(new Color(3, 37, 68));
        Font appnamefont = new Font("Proxima Nova", Font.BOLD, 28); // Font name, style, size
        appname.setFont(appnamefont);
        username = new JLabel("Username:");
        password = new JLabel("Password:");
        Font usernamefont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        username.setFont(usernamefont);
        Font passwordfont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        password.setFont(passwordfont);
        username.setBounds(315, 150, 100, 20);
        password.setBounds(315, 190, 100, 20);
        c.add(loginpanel);
        loginpanel.add(username);
        loginpanel.add(password);
        loginpanel.add(applogo);
        loginpanel.add(appname);
        usernamefield = new JTextField();
        usernamefield.setBounds(425, 150, 120, 20);
        usernamefield.setForeground(new Color(3, 37, 68));
        loginpanel.add(usernamefield);
        passwordfield = new JPasswordField();
        passwordfield.setBounds(425, 190, 120, 20);
        passwordfield.setForeground(new Color(3, 37, 68));
        loginpanel.add(passwordfield);
        login = new JButton("LOGIN");
        login.setBounds(430, 230, 70, 20);
        Font loginbtnfont = new Font("Proxima Nova", Font.PLAIN, 12); // Font name, style, size
        login.setFont(loginbtnfont);
        login.setForeground(new Color(3, 37, 68));
        login.addActionListener(this);
        loginpanel.add(login);
        reset = new JButton("RESET");
        Font resetbtnfont = new Font("Proxima Nova", Font.PLAIN, 12); // Font name, style, size
        reset.setFont(resetbtnfont);
        reset.setBounds(515, 230, 70, 20);
        reset.setForeground(new Color(3, 37, 68));
        reset.addActionListener(this);
        loginpanel.add(reset);
        newuser=new JLabel("New User ?");
        newuser.setForeground(new Color(3, 37, 68));
        Font newuserfont = new Font("Proxima Nova", Font.PLAIN, 12); // Font name, style, size
        newuser.setFont(newuserfont);
        newuser.setBounds(360,270,100,20);
        loginpanel.add(newuser);
        signup=new JButton("SIGN UP!");
        Font signupbtnfont = new Font("Proxima Nova", Font.PLAIN, 12); // Font name, style, size
        signup.setFont(signupbtnfont);
        signup.setBounds(430,270,70,20);
        signup.addActionListener(this);
        loginpanel.add(signup);
        this.setVisible(true);
    }
    public boolean checklogin(String un, String pw) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(url, usernamesql, passwordsql);
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, un);
            statement.setString(2, pw);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signup)
        {
            //this.dispose();
            signup signupframe=new signup();
        }
        if (e.getSource() == reset) {
            this.usernamefield.setText("");
            this.passwordfield.setText("");
        }
        if (e.getSource() == login) {
            this.usernameip = usernamefield.getText();
            this.passwordip = String.valueOf(passwordfield.getPassword());

            if (checklogin(this.usernameip, this.passwordip)) {
                //this.dispose();
                home homeframe = new home();
            } else {
                JOptionPane.showMessageDialog(this, "Password is incorrect");
            }
        }
    }
    @Before
    public void setUp() throws Exception {
        loginframe = new login();
        loginframe.setVisible(true);
        robot = new Robot();
    }

    @Test
    public void testValidLogin() {
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        assertTrue(loginframe.checklogin(this.usernamefield.getText(),
                String.valueOf(this.passwordfield.getPassword())));
    }

}

