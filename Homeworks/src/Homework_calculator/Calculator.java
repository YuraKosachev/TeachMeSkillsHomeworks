package Homework_calculator;

import javax.swing.*;

public class Calculator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorFrame calc = new CalculatorFrame("I'm calculator",
                        new CalcOperations(),
                        new ComponentFactory(),
                        new InputRule(),
                        300, 500);
            }
        });
    }
}