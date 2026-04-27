package blatt26.aufgabe03;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[3];
        players[0] = new Player();
        players[1] = new Player();
        players[2] = new Player();
        players[0].kampf(players, 2);
        System.out.println(players[0].kartenMenge(Karten.SCHERE));
        System.out.println(players[0].kartenMenge(Karten.STEIN));
        System.out.println(players[0].kartenMenge(Karten.PAPIER));
        System.out.println(players[2].kartenMenge(Karten.SCHERE));
        System.out.println(players[2].kartenMenge(Karten.STEIN));
        System.out.println(players[2].kartenMenge(Karten.PAPIER));
    }
}
