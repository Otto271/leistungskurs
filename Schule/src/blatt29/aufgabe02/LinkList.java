package blatt29.aufgabe02;

public class LinkList <T>{
    Node <T> head;

    public void print() {
        head.print();
    }

    public boolean isEmpty() {
        return head == null;
    }

}
