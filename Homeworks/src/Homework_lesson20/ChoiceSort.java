package Homework_lesson20;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Collections.swap;

public class ChoiceSort implements Sortable {
    @Override
    public void sort(List<Integer> integerList) {
        long count = integerList.stream().count();
        for (int left = 0; left < count; left++) {
            int minInd = left;
            for (int i = left; i < count; i++) {
                if (integerList.get(i) < integerList.get(minInd)) {
                    minInd = i;
                }
            }
            swap(integerList, left, minInd);
        }
    }
}
