package blatt20.aufgabe6;

public class Kart {
    private String modellName;
    private double maxGeschwindigkeit;
    private double beschleunigung;

    public Kart(String modellName, double maxGeschwindigkeit, double beschleunigung) {
        this.modellName = modellName;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.beschleunigung = beschleunigung;
    }

    public String getModellName() {
        return modellName;
    }

    public double getMaxGeschwindigkeit() {
        return maxGeschwindigkeit;
    }

    public double getBeschleunigung() {
        return beschleunigung;
    }

    public void setBeschleunigung(double beschleunigung) {
        this.beschleunigung = beschleunigung;
    }

    public void beschleunigen() {

    }

    public void bremse() {

    }

    public void drifte() {

    }
}
