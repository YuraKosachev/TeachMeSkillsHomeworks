package Homework_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationJPanel extends JPanel {
    private final DisplayJPanel displayJPanel;
    private final CalcOperations operations;

    public OperationJPanel(DisplayJPanel displayJPanel,
                           CalcOperations operations,
                           int x, int y,
                           int width, int height) {
        this.displayJPanel = displayJPanel;
        this.operations = operations;
        this.setBounds(x, y, width, height);
        this.setLayout(new GridLayout(4, 2));
        this.componentInit();
    }

    private void componentInit() {
        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayJPanel.resetText();
            }
        });

        clear.setFont(new Font("Serif", Font.PLAIN, 15));

        JButton backspace = new JButton("<");
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayJPanel.removeLast();
            }
        });

        backspace.setFont(new Font("Serif", Font.PLAIN, 15));

        JButton point = new JButton(".");
        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayJPanel.setTextField(((JButton) e.getSource()).getText(), false);
            }
        });

        point.setFont(new Font("Serif", Font.PLAIN, 15));

        add(clear);
        add(backspace);
        add(point);

        // operations
        String[] operators = {"-", "+", "/", "*"};
        for (String operator : operators) {
            JButton operatorButton = new JButton(operator);
            operatorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayJPanel.setTextField(((JButton) e.getSource()).getText(), false);
                }
            });
            operatorButton.setFont(new Font("Serif", Font.PLAIN, 15));
            add(operatorButton);
        }

        JButton equals = new JButton("=");
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String result = operations.getEquationResult(displayJPanel.getText());
                    displayJPanel.resetText();
                    displayJPanel.setTextField(result, true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    displayJPanel.resetText();
                }
            }
        });
        equals.setFont(new Font("Serif", Font.PLAIN, 15));
        add(equals);
    }
}
