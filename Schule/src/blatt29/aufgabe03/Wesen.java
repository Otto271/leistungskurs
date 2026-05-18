package blatt29.aufgabe03;

public abstract class Wesen {
    private int maxHP;
    private int curHP;
    private int staerke;
    private int verteidigung;
    private int speed;
    private int glueck;

    public Wesen(int maxHP, int curHP, int staerke, int verteidigung, int speed, int glueck) {
        this.maxHP = maxHP;
        this.curHP = curHP;
        this.staerke = staerke;
        this.verteidigung = verteidigung;
        this.speed = speed;
        this.glueck = glueck;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurHP() {
        return curHP;
    }

    public int getStaerke() {
        return staerke;
    }

    public int getVerteidigung() {
        return verteidigung;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGlueck() {
        return glueck;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurHP(int curHP) {
        this.curHP = curHP;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public void setVerteidigung(int verteidigung) {
        this.verteidigung = verteidigung;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setGlueck(int glueck) {
        this.glueck = glueck;
    }

    public int schaden(Held h, Gegner g) {
        return 4*h.getStaerke() - 2*g.getVerteidigung();
    }
}
