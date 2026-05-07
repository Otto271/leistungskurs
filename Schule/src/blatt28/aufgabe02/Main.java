package blatt28.aufgabe02;

public class Main {
    public static void main(String[] args) {
        Warteschlange <Integer> stapel = new Warteschlange <Integer>();
        stapel.add(4);
        stapel.add(5);
        stapel.add(6);
        Warteschlange <Integer> stapel2 = new Warteschlange <Integer>();
        stapel2.add(4);
        stapel2.add(5);
        stapel2.add(6);
        stapel.print();
        stapel2.print();
        stapel.poll();
        stapel2.poll();
        stapel.print();
        stapel2.print();
        stapel.duplicate();
        stapel2.duplicate();
        stapel.print();
        stapel2.print();
    }
}
