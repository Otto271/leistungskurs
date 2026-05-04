package blatt28.aufgabe02;

public class Main {
    public static void main(String[] args) {
        Stapel <Integer> stapel = new Stapel <Integer>();
        stapel.push(4);
        stapel.push(5);
        stapel.push(6);
        Stapel <Integer> stapel2 = new Stapel<Integer>();
        stapel2.push(4);
        stapel2.push(5);
        stapel2.push(6);
        stapel.print();
        stapel2.print();
        stapel.pop();
        stapel2.pop();
        stapel.print();
        stapel2.print();
    }
}
