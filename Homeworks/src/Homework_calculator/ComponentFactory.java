package Homework_calculator;

import javax.swing.*;

public class ComponentFactory {

    public DisplayJPanel getDisplay(InputRule rule,
                                    int x, int y,
                                    int width, int height) {
        return new DisplayJPanel(rule, x, y, width, height);
    }

    public NumberButtonJPanel getNumberButtons(DisplayJPanel displayJPanel,
                                               int x, int y,
                                               int width, int height) {
        return new NumberButtonJPanel(displayJPanel, x, y, width, height);
    }

    public OperationJPanel getOperationPanel(DisplayJPanel displayJPanel, CalcOperations operations,
                                             int x, int y,
                                             int width, int height) {
        return new OperationJPanel(displayJPanel, operations, x, y, width, height);
    }
}
