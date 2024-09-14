package Homework_lesson13;

import javax.swing.*;
        import java.awt.*;

public class TextPanel extends JPanel {
    private final JTextField textField;
    private final JLabel label;
    public TextPanel(String labelText){
        label = new JLabel(labelText);
        textField = new JTextField();
        setLayout(new GridLayout(2,1,10,0));
        textField.setFont( new Font("Serif",0,15));
        setVisible(true);
        add(label);
        add(textField);

    }
    public String getText(){
        return textField.getText();
    }
}