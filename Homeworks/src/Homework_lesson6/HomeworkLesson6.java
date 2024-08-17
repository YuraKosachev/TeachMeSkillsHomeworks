package Homework_lesson6;

import java.util.Random;
import java.util.Scanner;

public class HomeworkLesson6 {
    public static void main(String[] args) {
        //runCreditCardTask();
        runAtmTask();
    }

    //Task1
    private static void runCreditCardTask() {
        CreditCard cardVisa = new CreditCard(cardNumberGeneration(), 120);
        CreditCard cardMaster = new CreditCard(cardNumberGeneration(), 150.12);
        CreditCard cardWorld = new CreditCard(cardNumberGeneration(), 145.5);

        println("Card info before:");
        println("---------------------");
        println(cardVisa.getCardInfo());
        println(cardMaster.getCardInfo());
        println(cardWorld.getCardInfo());

        cardVisa.addMoney(100.34);
        cardMaster.addMoney(22.45);
        cardWorld.getMoney(23);

        println("Card info after:");
        println("---------------------");
        println(cardVisa.getCardInfo());
        println(cardMaster.getCardInfo());
        println(cardWorld.getCardInfo());

    }

    //Task2
    private static void runAtmTask() {
        //create atm with default money packages
        Logger logger = new Logger();
        Atm atm = new Atm(logger,
                new MoneyPackage(2, 20),
                new MoneyPackage(20, 50),
                new MoneyPackage(20, 100));
        //run atm menu
        while (true) {
            int choose = input("Please enter atm action:\n[1] - extract money\n[2] - print atm available money nominal\n[3] - add money package\n[4] - exit\nYour choose: ");
            switch (choose) {
                case 1 -> extractMoneyAction(atm);
                case 2 -> logger.info(atm.getAvailableNominals());
                case 3 -> addMoneyAction(atm);

                case 4 -> {
                    logger.info("Bye");
                    return;
                }
                default -> logger.error("Enter correct menu value");
            }
        }
    }

    private static void extractMoneyAction(Atm atm) {
        int money = input("Enter money count to extract: ");
        atm.extractMoney(money);
    }

    private static void addMoneyAction(Atm atm) {
        int nominal = input("Enter money nominal: ");
        int count = input("Enter money count: ");

        atm.addMoney(new MoneyPackage(count, nominal));
    }

    private static int input(String message) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            if (!scanner.hasNextInt()) {
                println("Enter correct value");
                continue;
            }
            return scanner.nextInt();
        }
    }

    private static long cardNumberGeneration() {
        Random random = new Random();
        final int MAX_NUMBER_LENGHT = 16;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < MAX_NUMBER_LENGHT; i++) {
            int first = i == 0 ? 1 : 0;
            builder.append(random.nextInt(first, 9));
        }
        return Long.parseLong(builder.toString());
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
