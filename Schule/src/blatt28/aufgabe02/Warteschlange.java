package blatt28.aufgabe02;

import java.util.ArrayList;

public class Warteschlange <T>{
    ArrayList <T> arr;

    public Warteschlange() {
        this.arr = new ArrayList<>();
    }

    public boolean empty() {
        return this.arr == null;
    }

    public boolean add (T t) {
        this.arr.add(t);
        return true;
    }

    public T peek() {
        return this.arr.getFirst();
    }

    public T poll() {
        return this.arr.removeFirst();
    }

    public void print(){
        System.out.println(this.arr.toString());
    }

    public void duplicate() {
        ArrayList <T> newArr = new ArrayList<>();
        newArr.add(this.arr.getFirst());
        newArr.addAll(this.arr);
        this.arr = newArr;
    }
}
