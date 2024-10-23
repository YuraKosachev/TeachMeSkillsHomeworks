package Homework_lesson20;

import java.util.List;
import java.util.function.Consumer;

public class InsertSort implements Sortable{
    @Override
    public void sort(List<Integer> integerList) {
        long count = integerList.stream().count();
        for (int i = 1; i < count; i++) {
            int current = integerList.get(i);
            int j = i - 1;
            while (j >= 0 && current < integerList.get(j)) {
                integerList.set(j + 1, integerList.get(j));
                j--;
            }
            integerList.set(j + 1, current);
        }
    }
}
