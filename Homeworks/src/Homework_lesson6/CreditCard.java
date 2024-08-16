package Homework_lesson6;

public class CreditCard {
    private long number;
    private double balance;

    public CreditCard(long number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public void addMoney(double money) {
        balance += money;
    }

    public void getMoney(double money) {
        if ((balance - money) < 0) {
            balance = 0;
        } else {
            balance -= money;
        }
    }

    public String getCardInfo() {
        return String.format("Card number %d\nBalance - %.2f", this.number, this.balance);
    }
}
