package blatt28.aufgabe02;

import java.util.ArrayList;

public class Stapel <T>{
    ArrayList<T> arr;

    public Stapel() {
        this.arr = new ArrayList<T>();
    }

    public boolean empty() {
        return this.arr == null;
    }

    public T peek() {
        return this.arr.getLast();
    }

    public T pop() {
        return this.arr.removeLast();
    }

    public void push(T t) {
        this.arr.add(t);
    }

    public void print(){
        System.out.println(this.arr.toString());
    }

    public void duplicate() {
        this.push(peek());
    }


}
