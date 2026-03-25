package blatt20.aufgabe6;

public class Team {
    private int teamID;
    private int platz;
    private int aktuelleRunde;

    private Charakter charakter;

    public Team(int teamID, int platz, int aktuelleRunde) {
        this.teamID = teamID;
        this.platz = platz;
        this.aktuelleRunde = aktuelleRunde;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getPlatz() {
        return platz;
    }

    public int getAktuelleRunde() {
        return aktuelleRunde;
    }

    public void setAktuelleRunde(int aktuelleRunde) {
        this.aktuelleRunde = aktuelleRunde;
    }

    public void wechsleZuFahrer(Charakter charakter) {

    }

    public void aktualiesierePlatzierung() {

    }
}
