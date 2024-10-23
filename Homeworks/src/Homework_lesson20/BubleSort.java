package Homework_lesson20;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Collections.swap;

public class BubleSort implements Sortable {
    @Override
    public void sort(List<Integer> integerList) {
        long count = integerList.stream().count();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (integerList.get(i) < integerList.get(j)) {
                    swap(integerList, i, j);
                }
            }
        }
    }
}
