package blatt20.aufgabe3;

public class Ofen {
    int beheizungsmodus;
    int temp;
    public Ofen(int beheizungsmodus, int temp) {
        this.beheizungsmodus = beheizungsmodus;
        this.temp = temp;
    }
    void tempchange(int temp) {
        this.temp = temp;
    }
    void modushoch() {
        this.beheizungsmodus++;
    }
    void modusrunter() {
        this.beheizungsmodus--;
    }
}
