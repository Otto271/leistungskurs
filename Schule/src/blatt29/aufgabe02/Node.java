package blatt29.aufgabe02;

public class Node <T>{
    private T value;
    private Node <T> next;

    public Node(T value, T next) {
        this.value = value;
    }

    public void setNext(Node <T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public Node <T> next() {
        return this.next;
    }

    public void print() {
        System.out.println(this.value + " -> " + this.next);
    }
}
