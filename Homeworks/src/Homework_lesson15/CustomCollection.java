package Homework_lesson15;

import java.util.Arrays;

public class CustomCollection<T> {

    private T[] collection;
    private final int DEFAULT_CAPACITY_EXTENDS = 10;
    private int currentIndex;

    {
        currentIndex = 0;
    }

    public CustomCollection(int capacity) {
        this.collection = (T[]) (new Object[capacity]);
    }

    public CustomCollection() {
        this.collection = (T[]) (new Object[0]);
    }

    private void extend(int extendCapacity) {
        this.collection = Arrays.copyOf(this.collection, this.collection.length + extendCapacity);
    }

    public int size() {
        return currentIndex;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int actualSize() {
        int count = 0;
        for (int i = 0; i < this.collection.length; i++) {
            if (this.collection[i] != null) {
                count++;
            }
        }
        return count;
    }

    private void fragmetation() {
        for (int i = 0; i < this.collection.length; i++) {
            if (this.collection[i] == null) {
                for (int j = i + 1; j < this.collection.length; j++) {
                    if (this.collection[j] != null) {
                        this.collection[i] = this.collection[j];
                        this.collection[j] = null;
                        break;
                    }
                }
            }
        }
    }

    public boolean add(T o) {
        if (currentIndex >= this.collection.length)
            extend(DEFAULT_CAPACITY_EXTENDS);
        try {
            this.collection[currentIndex] = o;
            currentIndex++;
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //public T
    public boolean remove(T o) {
        int index = find(o);
        if (index == -1)
            return false;

        this.collection[index] = null;

        fragmetation();
        currentIndex--;
        return true;
    }

    public boolean remove(int index) {
        try {
            if(index >= currentIndex)
                return false;
            this.collection[index] = null;
            fragmetation();
            currentIndex--;
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public int find(T o) {
        for (int i = 0; i < this.collection.length; i++) {
            if (this.collection[i] == null)
                continue;

            if (o.equals(this.collection[i]))
                return i;
        }

        return -1;
    }

    public boolean removeAll() {
        try {
            this.collection = (T[]) (new Object[0]);
            currentIndex = 0;
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public T get(int index) {
        try {
            if (index > currentIndex)
                return null;
            return this.collection[index];
        } catch (Exception ex) {
            return null;
        }
    }

}
