package blatt26.aufgabe01;

public class Main {
    public static void main(String[] args) {
        Punkt punkt = new Punkt(1,3);
        Kreis kreis = new Kreis(punkt, 0.5);
        System.out.println(kreis.distanz(kreis));
    }
}
