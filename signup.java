import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class signup implements ActionListener{
    private JFrame frame=new JFrame();
    private JLabel signuplogo,newuser,rollno,password,confirmpassword;
    private JButton register;
    private JTextField roll;
    private JPasswordField pw,confirmpw;
    private signup signupframe;
    private Robot robot;
    private static final String url = "jdbc:mysql://localhost:3306/cpapp";
    private static final String usernamesql = "root";
    private static final String passwordsql = "";
    public signup()
    {
        frame.setTitle("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 460);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);
        JPanel signuppanel=new JPanel();
        signuppanel.setLayout(null);
        signuppanel.setBounds(0,0,700,460);
        signuppanel.setBackground(new Color(79, 204, 252));
        c.add(signuppanel);
        newuser=new JLabel("Register!");
        newuser.setBounds(140,100,260,30);
        newuser.setForeground(new Color(3, 37, 68));
        Font newuserfont = new Font("Proxima Nova", Font.BOLD, 30); // Font name, style, size
        newuser.setFont(newuserfont);
        ImageIcon signupicon=new ImageIcon("signupicon.png");
        signuplogo=new JLabel();
        signuplogo.setIcon(signupicon);
        signuplogo.setBounds(400,105,200,200);

        rollno = new JLabel("Roll No:");
        Font rollnofont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        rollno.setFont(rollnofont);
        rollno.setBounds(55, 160, 100, 20);
        password = new JLabel("Password:");
        Font passwordfont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        password.setFont(passwordfont);
        password.setBounds(55, 200, 100, 20);
        confirmpassword = new JLabel("Confirm Password:");
        Font cnfmrollnofont = new Font("Proxima Nova", Font.PLAIN, 16); // Font name, style, size
        confirmpassword.setFont(cnfmrollnofont);
        confirmpassword.setBounds(55, 240, 200, 20);

        roll = new JTextField();
        roll.setBounds(195, 160, 120, 20);
        roll.setForeground(new Color(3, 37, 68));
        signuppanel.add(roll);
        pw = new JPasswordField();
        pw.setBounds(195, 200, 120, 20);
        pw.setForeground(new Color(3, 37, 68));
        signuppanel.add(pw);
        confirmpw = new JPasswordField();
        confirmpw.setBounds(195, 240, 120, 20);
        confirmpw.setForeground(new Color(3, 37, 68));
        register = new JButton("REGISTER !");
        register.setBounds(140, 280, 70, 20);
        Font registerbtnfont = new Font("Proxima Nova", Font.PLAIN, 12); // Font name, style, size
        register.setFont(registerbtnfont);
        register.setForeground(new Color(3, 37, 68));
        register.addActionListener(this);
        signuppanel.add(register);
        signuppanel.add(confirmpw);
        signuppanel.add(rollno);
        signuppanel.add(password);
        signuppanel.add(signuplogo);
        signuppanel.add(newuser);
        signuppanel.add(confirmpassword);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register)
        {
            String username = roll.getText();
            String password = String.valueOf(pw.getPassword());
            String confirmpassword = String.valueOf(confirmpw.getPassword());

            if (password.equals(confirmpassword)) {
                if (registeruser(username, password)) {
                    frame.dispose();
                    login loginframe = new login();
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Passwords do not match");
            }
        }
    }
    private static boolean registeruser(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(url,usernamesql,passwordsql);
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int inserted = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return inserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Before
    public void setUp() throws Exception {
        signup signupframe= new signup();
        robot = new Robot();
    }
    @Test
    public void testPasswordMismatch() {
        robot.delay(1000);
        String username = roll.getText();
        String password = String.valueOf(pw.getPassword());

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        boolean registrationResult = signup.registeruser(username,password);
        assertFalse(registrationResult);
    }
}
