package Homework_calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import static java.awt.SystemColor.window;
//import issrg.utils.gui;

public class Calculator {

    public static void main(String[] args) {
        //WindowUtilities.setNativeLookAndFeel();
        JFrame f = new JFrame("I'm simple calculator");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        f.setSize(400, 150);
        Container content = f.getContentPane();
        content.setBackground(Color.white) ;
        content.setLayout (new FlowLayout()) ;

        for(int i = 0; i < 10; i++){
            CustomJButton button = new CustomJButton(String.valueOf(i), String.valueOf(i));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    System.out.println(e);
//                    window.setVisible(true);
//                    statusLabel.setText("A Window shown to the user.");
                }
            });

            content.add(button, i);
            //content.applyComponentOrientation();
        }

        f.setVisible (true);}
}