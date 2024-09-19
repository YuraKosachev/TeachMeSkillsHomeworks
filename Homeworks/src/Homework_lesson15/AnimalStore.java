package Homework_lesson15;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class AnimalStore<T> {
    private final Deque<T> store;

    public AnimalStore(){
        store = new ArrayDeque<>();
    }

    public void add(T item){
        store.addFirst(item);
    }

    public boolean isEmpty(){
        return store.isEmpty();
    }

    public T getLast(){
        return store.removeLast();
    }
}
