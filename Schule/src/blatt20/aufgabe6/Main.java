package blatt20.aufgabe6;

public class Main {
    public static void main(String[] args) {
        Charakter charakter = new Charakter("Mario", Gewichtsklasse.Mittel, "Roter feuerball");
        Item item = new Item("Grüner Panzer", false, "Fliegt immer geradeaus, prallt von Wänden ab, wird aber nach kurzer Zeit zerstört. Der Getroffene schlägt einen Salto und wird abgebremst.");
        Kart kart = new Kart("Dudu-Buggy", 0.1, 1);
        Charakter charakter2 = new Charakter("Koopa", Gewichtsklasse.Leicht, "3x Grüne Panzer");
        Item item2 = new Item("Schwindel-Box", false, "Sieht fast so aus wie eine normale Item-Box, bei Berührung erhaltet ihr kein Item, sondern werdet stattdessen wie durch einen Grünen Panzer durch die Luft geschleudert.");
        Kart kart2 = new Kart("Toad-Kart", 0.4, 0.8);
        System.out.println(charakter.getGewichtsklasse());
        System.out.println(charakter2.getGewichtsklasse());
    }
}
