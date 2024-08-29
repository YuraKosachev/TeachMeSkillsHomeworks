package Homework_calculator;

import javax.swing.*;
import java.beans.ConstructorProperties;

public class CustomJButton extends JButton {

    private final String val;

    public CustomJButton(String text, Icon icon, String val) {
        super(text, icon);
        this.val = val;
    }

    public CustomJButton(String val) {
        super();
        this.val = val;
    }

    public CustomJButton(Icon icon, String val) {
        super(icon);
        this.val = val;
    }

    public CustomJButton(String text, String val) {
        super(text);
        this.val = val;
    }

    public CustomJButton(Action a, String val) {
        super(a);
        this.val = val;
    }

}
