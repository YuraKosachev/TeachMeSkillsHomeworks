package Homework_lesson13;

import javax.swing.*;
import java.util.Scanner;

public class HomeWorkLesson13Task1 {
    public static void main(String[] args) {

        //Task 1
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AuthenticationForm();
            }

        });
    }

}
