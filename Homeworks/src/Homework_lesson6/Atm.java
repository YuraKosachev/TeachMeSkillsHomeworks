package Homework_lesson6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Spliterator;

public class Atm {
    private MoneyPackage[] moneyPackages;
    private Logger logger;
    private final int ZERO = 0;

    public Atm(Logger logger, MoneyPackage... packages) {
        this.moneyPackages = packages;
        this.logger = logger;
    }

    public void addMoney(MoneyPackage moneyPackage) {
        MoneyPackage existingPackage = getPackageByNominal(moneyPackage.nominal, this.moneyPackages);

        if (existingPackage == null) {
            extendMoneyPackages(moneyPackage);
            return;
        }
        existingPackage.count += moneyPackage.count;
    }

    private MoneyPackage[] deepCopyOf(MoneyPackage[] source) {
        MoneyPackage[] copy = new MoneyPackage[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = new MoneyPackage(source[i].count, source[i].nominal);
        }
        return copy;
    }

    public boolean extractMoney(int money) {
        MoneyPackage[] moneyPackagesTemp = this.deepCopyOf(this.moneyPackages);

        if (!canExtract(money, moneyPackagesTemp)) {
            this.logger.error("Enter a multiple of the available amount nominal value: " + this.getAvailableNominals());
            return false;
        }

        Arrays.sort(moneyPackagesTemp, new MoneyPackageComparator());

        while (money > 0) {
            if (!canExtract(money, moneyPackagesTemp)) {
                this.logger.error("There are not enough money nominal's count  to extract");
                return false;
            }
            for (MoneyPackage moneyPackage : moneyPackagesTemp) {
                if (moneyPackage.count != ZERO && money - moneyPackage.nominal >= ZERO) {
                    money = money - moneyPackage.nominal;
                    moneyPackage.count--;
                    break;
                }
            }
        }

        this.logger.info(getPackagesDifferent(this.moneyPackages, moneyPackagesTemp));
        this.moneyPackages = moneyPackagesTemp;
        return true;
    }

    private String getPackagesDifferent(MoneyPackage[] previous, MoneyPackage[] next) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < next.length; i++) {
            MoneyPackage previousPackage = getPackageByNominal(next[i].nominal, previous);
            if (previousPackage == null || previousPackage.count - next[i].count == 0)
                continue;

            builder.append(String.format("Nominal: %d count: %d\n", next[i].nominal, previousPackage.count - next[i].count));

        }
        return builder.toString();
    }

     public String getAvailableNominals() {
        StringBuilder builder = new StringBuilder();
        for (MoneyPackage moneyPackage : this.moneyPackages) {
            if (moneyPackage.count > ZERO)
                builder.append(String.format(" [%d] ", moneyPackage.nominal));
        }
        return builder.toString();
    }

    private boolean canExtract(int money, MoneyPackage[] packages) {
        for (MoneyPackage moneyPackage : packages) {
            if (moneyPackage.count != ZERO && money % moneyPackage.nominal == ZERO)
                return true;
        }
        return false;
    }

    private MoneyPackage getPackageByNominal(int nominal, MoneyPackage[] packages) {

        for (MoneyPackage moneyPackage : packages) {
            if (moneyPackage.nominal == nominal) {
                return moneyPackage;
            }
        }
        return null;
    }

    private void extendMoneyPackages(MoneyPackage moneyPackage) {
        MoneyPackage[] result = new MoneyPackage[this.moneyPackages.length + 1];
        result[this.moneyPackages.length] = moneyPackage;
        for (int i = 0; i < result.length - 1; i++) {
            result[i] = this.moneyPackages[i];
        }
        this.moneyPackages = result;
    }


}
