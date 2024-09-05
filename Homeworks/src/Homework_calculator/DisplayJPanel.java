package Homework_calculator;

import javax.swing.*;
import java.awt.*;

public class DisplayJPanel extends JPanel {
    private final JTextField textField;
    private final InputRule inputRule;
    private boolean isResultSet;

    {
        this.isResultSet = false;
    }

    public DisplayJPanel(InputRule inputRule,
                         int x, int y,
                         int width, int height) {
        this.textField = new JTextField();
        this.inputRule = inputRule;
        this.textField.setEditable(false);
        this.textField.setFont(new Font("Serif", Font.PLAIN, 20));

        this.setBounds(x, y, width, height);
        this.setLayout(new BorderLayout());
        this.add(textField, BorderLayout.CENTER);
    }

    public String getText() {
        return this.textField.getText();
    }

    public void setTextField(String text, boolean isResult) {
        if (text == null)
            return;

        if (isResultSet) {
            resetText();
        }

        if (!this.inputRule.isCorrect(this.textField.getText(), text))
            return;
        String val = this.getText() + text;
        this.textField.setText(val);
        this.isResultSet = isResult;
    }

    public void resetText() {
        this.textField.setText("");
        this.isResultSet = false;
    }

    public void removeLast() {
        if (isResultSet) {
            resetText();
        }

        if (getText().isEmpty())
            return;

        String current = this.getText();
        String val = current.substring(0, current.length() - 1);
        this.textField.setText(val);
    }
}
