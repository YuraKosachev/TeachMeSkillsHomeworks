package Homework_calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private final DisplayJPanel displayJPanel;
    private final CalcOperations calcOperations;
    private final NumberButtonJPanel numberButtonJPanel;
    private final OperationJPanel operationJPanel;

    public CalculatorFrame(String title,
                           CalcOperations operations,
                           ComponentFactory factory,
                           InputRule rule,
                           int width,
                           int height) {
        super(title);
        this.calcOperations = operations;
        this.displayJPanel = factory.getDisplay(rule, 0, 0, width, 50);

        int numberPanelWidth = 160;
        int operationPanelWith = 100;
        this.numberButtonJPanel = factory.getNumberButtons(this.displayJPanel, 10, 60,
                numberPanelWidth, height - 110);
        this.operationJPanel = factory.getOperationPanel(this.displayJPanel, this.calcOperations,
                170, 60, operationPanelWith, height - 110);

        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.componentInit();
    }

    private void componentInit() {
        setResizable(false);
        setVisible(true);
        setLayout(null);
        add(this.displayJPanel);

        add(this.numberButtonJPanel);
        add(this.operationJPanel);
    }


}
