package Homework_lesson20;

import java.util.List;
import java.util.function.Consumer;

public class SortThread extends Thread {
    private final Sortable sorter;
    private final List<Integer> list;
    private final Printer printer;

    public SortThread(Sortable sorter,
                      List<Integer> list,
                      Printer printer) {
        this.sorter = sorter;
        this.list = list;
        this.printer = printer;
    }

    @Override
    public void run() {
        sorter.sort(list);
        printer.print(list, sorter.getClass().getName());
    }
}
