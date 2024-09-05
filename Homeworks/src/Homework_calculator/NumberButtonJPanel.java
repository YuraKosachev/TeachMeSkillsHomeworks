package Homework_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButtonJPanel extends JPanel {
    private final DisplayJPanel displayJPanel;

    public NumberButtonJPanel(DisplayJPanel displayJPanel,
                              int x, int y,
                              int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(new GridLayout(4, 3));
        this.displayJPanel = displayJPanel;
        this.componentInit();
    }

    private void componentInit() {
        for (int counter = 9; counter >= 0; counter--) {
            if(counter == 0)
            {
                add(new JPanel());
            }
            JButton btn = new JButton(String.valueOf(counter));
            btn.setFont(new Font("Serif", Font.PLAIN, 15));
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayJPanel.setTextField(((JButton) e.getSource()).getText(), false);
                }
            });
            add(btn);

            if(counter == 0)
            {
                add(new JPanel());
            }
        }
    }
}
