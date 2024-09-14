package Homework_lesson13;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticationForm extends JFrame implements ActionListener {
//   // private final JTextField login;
//    private final JPasswordField password;
//    private final JPasswordField confirm;
    private final TextPanel login;
    private final PasswordPanel password;
    private final PasswordPanel confirm;
    private final JButton submit;

    public AuthenticationForm(){
        login = new TextPanel("Login");
        password = new PasswordPanel("Password");
        confirm = new PasswordPanel("Confirm password");
        submit = new JButton("Send");
        submit.addActionListener(this);
        JPanel main = new JPanel(new GridLayout(4,1,0,10));
        main.setBorder(new EmptyBorder(10, 10, 10, 10));
        setSize(new Dimension(300,300));
        setLayout(new BorderLayout(0,10));
        setResizable(false);
        setVisible(true);

        main.add(login);
        main.add(password);
        main.add(confirm);
        main.add(submit);
        add(main, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(Authentication.isValid(login.getText(), password.getText(), confirm.getText())){
          JOptionPane.showMessageDialog(null,"Authentication successfully pass!","info", JOptionPane.INFORMATION_MESSAGE);
      }else{
          JOptionPane.showMessageDialog(null,"Authentication failed!\nCheck console message","info", JOptionPane.ERROR_MESSAGE);
      }
    }
}
