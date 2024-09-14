package Homework_lesson13;

import javax.swing.*;
import java.awt.*;

public class PasswordPanel extends JPanel {
    private final JPasswordField password;
    private final JLabel label;
    public PasswordPanel(String labelText){
        label = new JLabel(labelText);
        password = new JPasswordField();
        setLayout(new GridLayout(2,1,10,0));
        password.setFont( new Font("Serif",0,15));
        setVisible(true);
        add(label);
        add(password);

    }
    public String getText(){
        return password.getText();
    }
}
