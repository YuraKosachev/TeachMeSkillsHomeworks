package Homework_lesson6;

import java.util.Comparator;

public class MoneyPackageComparator implements Comparator<MoneyPackage> {
    @Override
    public int compare(MoneyPackage o1, MoneyPackage o2) {
        return  o2.nominal - o1.nominal;
    }
}
