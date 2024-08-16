package Homework_lesson6;

import java.util.Random;

public class HomeworkLesson6 {
    public static void main(String[] args) {
        //runCreditCardTask();
        runAtmTask();
    }

    //Task1
    private static void runCreditCardTask(){
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
    private static void runAtmTask(){
        Atm atm = new Atm(new Logger(),
                new MoneyPackage(100,20),
                new MoneyPackage(20,50),
                new MoneyPackage(20,100));

        atm.addMoney(new MoneyPackage(200,100));
        atm.addMoney(new MoneyPackage(100,5));

        atm.extractMoney(150);

    }

    private static long cardNumberGeneration() {
        Random random = new Random();
        final int MAX_NUMBER_LENGHT = 16;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < MAX_NUMBER_LENGHT; i++) {
            int first = i == 0 ? 1 : 0;
            builder.append(random.nextInt(first,9));
        }
        return Long.parseLong(builder.toString());
    }

    private static void println(String message){
        System.out.println(message);
    }
}
