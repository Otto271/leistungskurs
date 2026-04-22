package blatt26.aufgabe03;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[3];
        players[0] = new Player();
        players[1] = new Player();
        players[2] = new Player();
        Simulation sim = new Simulation();
        sim.kampf(players, 0,1);
        System.out.println(players[0].kartenMenge(Karten.SCHERE));
    }
}
