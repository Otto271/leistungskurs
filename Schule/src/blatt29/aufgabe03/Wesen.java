package blatt29.aufgabe03;

import blatt13.Zufall;

import java.util.ArrayList;

public abstract class Wesen {
    private int maxHP;
    private int curHP;
    private int staerke;
    private int verteidigung;
    private int speed;
    private int glueck;
    private ArrayList <Item> items;

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

    public boolean treffer(Wesen w) {
        double a = (double) (this.getSpeed()/w.getSpeed());
        if (Math.random() < a) {
            return true;
        }
        return false;
    }

    public Wesen angriff(Wesen w) {
        if (treffer(w)) {
            if (Math.random() < (double) this.getGlueck() / 100) {
                w.setCurHP(w.getCurHP() - 4*this.getStaerke());
            } else {
                w.setCurHP(w.getCurHP() - 4*this.getStaerke() - 2*w.getVerteidigung());
            }
        }
        return w;
    }

    public void sammeln() {
        int rdm = Zufall.zufallGanz(6);
        switch (rdm) {
            case 0: items.add(Item.PILZ); break;
            case 1: items.add(Item.BANDAGE); break;
            case 2: items.add(Item.APPLE); break;
            case 3: items.add(Item.SANDWICH); break;
            case 4: items.add(Item.BIER); break;
            case 5: items.add(Item.TOTEMOFUNDYING); break;
        }
    }

    public void useItem(Item item) {
        if (items.contains(item)) {
            if (item.equals(Item.TOTEMOFUNDYING)) {
                this.curHP = this.maxHP;
            }
            this.curHP += item.heal;
            items.remove(item);
        }
    }
}
