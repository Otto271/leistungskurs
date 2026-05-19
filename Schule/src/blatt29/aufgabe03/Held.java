package blatt29.aufgabe03;

public class Held extends Wesen {
    private int maxMP;
    private int curMP;
    private int mStaerke;
    private int mVerteidigung;

    public Held(int maxHP, int curHP, int staerke, int verteidigung, int speed, int glueck, int maxMP, int curMP, int mStaerke, int mVerteidigung) {
        super(maxHP, curHP, staerke, verteidigung, speed, glueck);
        this.maxMP = maxMP;
        this.curMP = curMP;
        this.mStaerke = mStaerke;
        this.mVerteidigung = mVerteidigung;
    }
}
