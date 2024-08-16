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
        MoneyPackage existingPackage = getPackageByNominal(moneyPackage.nominal);

        if (existingPackage == null) {
            extendMoneyPackages(moneyPackage);
            return;
        }
        existingPackage.count += moneyPackage.count;
    }

    public boolean extractMoney(int money) {

        if (!canExtract(money)) {
            this.logger.error("Enter a multiple of the available amount nominal value: " + this.getAvailableNominals());
            return false;
        }

        MoneyPackage[] moneyPackagesTemp = Arrays.copyOf(this.moneyPackages, this.moneyPackages.length);
        Arrays.sort(moneyPackagesTemp, new MoneyPackageComparator());

        while (money > 0) {
            if (!canExtract(money)) {
                this.logger.error("There are not enough money nominal's count  to extract");
                return false;
            }
            for (MoneyPackage moneyPackage : this.moneyPackages) {
                if (moneyPackage.count != ZERO && money - moneyPackage.nominal > ZERO) {
                    money = money - moneyPackage.nominal;
                    moneyPackage.count--;
                }
            }
        }


        return true;
    }

    private String getAvailableNominals() {
        StringBuilder builder = new StringBuilder();
        for (MoneyPackage moneyPackage : this.moneyPackages) {
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

    private MoneyPackage getPackageByNominal(int nominal) {

        for (MoneyPackage moneyPackage : this.moneyPackages) {
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
