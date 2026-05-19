package blatt29.aufgabe03;

import blatt13.Zufall;

import java.util.ArrayList;

public abstract class Wesen {
    private int maxHP;
    private int curHP;
    private int level;
    private int exp;

    private int staerke;
    private int verteidigung;
    private int speed;
    private int glueck;

    private Waffe waffe;
    private Kopf kopf;
    private Ruestung ruest;

    private ArrayList <Status> status;
    private ArrayList <Item> items;

    public Wesen(int maxHP, int level, int staerke, int verteidigung, int speed, int glueck) {
        this.maxHP = maxHP;
        this.curHP = this.maxHP;
        this.level = level;
        this.exp = 0;

        this.staerke = staerke;
        this.verteidigung = verteidigung;
        this.speed = speed;
        this.glueck = glueck;

        this.waffe = null;
        this.kopf = null;
        this.ruest = null;

        this.status = new ArrayList<Status>();
        this.items = new ArrayList<Item>();
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
        if (w.status.contains(Status.SCHLAF)) {
            //hit
            return true;
        }

        double a = (double) (this.speed / w.getSpeed());
        double b = 0;
        if (a < 1) {
            b = 0.1;
            if (a < 0.9) {
                b = 0.2;
            }
            if (a < 0.8) {
                b = 0.3;
            }
            if (a < 0.7) {
                b = 0.4;
            }
        } else if (a > 1) {
            b = 0.1;
            if (a > 1.1) {
                b = 0.07;
            }
            if (a > 1.2) {
                b = 0.05;
            }
            if (a > 1.3) {
                b = 0.03;
            }
        }
        if (Math.random() < b) {
            //hit
            return true;
        } else {
            //dodge
            return false;
        }
    }

    public void schaden(int schaden) {
        if (schaden <= 0) {
            System.out.println("WEAK!");
        } else {
            if (schaden >= this.curHP) {
                this.curHP = 0;
                System.out.println("DEFEAT!");
            } else {
                this.curHP -= schaden;
            }
        }
    }

    public void angriff(Wesen w) {
        if (treffer(w)) {
            if (Math.random() < (double) (this.glueck / 5)) {
                w.schaden(4*this.staerke);
                System.out.println("Krit!");
            } else {
                w.schaden(2*this.staerke - 2*w.verteidigung);
                System.out.println("Hit!");
            }
        }
    }

    public void updateStats(Ausruestung a, boolean add) {
        if (add) {
            this.staerke += a.getStr();
            this.verteidigung += a.getVit();
            this.speed += a.getDex();
            this.glueck += a.getLck();
        } else {
            this.staerke -= a.getStr();
            this.verteidigung -= a.getVit();
            this.speed -= a.getDex();
            this.glueck -= a.getLck();
        }
    }

    public boolean setWaffe(Waffe w) {
        if (this.waffe == null) {
            this.waffe = w;
            updateStats(w, true);
            return true;
        } else {
            return false;
        }
    }

    public boolean setKopf(Kopf k) {
        if (this.kopf == null) {
            this.kopf = k;
            updateStats(k, true);
            return true;
        } else {
            return false;
        }
    }

    public boolean setRuest(Ruestung r) {
        if (this.ruest == null) {
            this.ruest = r;
            updateStats(r, true);
            return true;
        } else {
            return false;
        }
    }

    public boolean ausruesten(Ausruestung a) {
        if (this.getClass() == a.getKlasse()) {
            if (a.getClass() == Waffe.class) {
                return setWaffe((Waffe) a);
            } else if (a.getClass() == Kopf.class) {
                return setKopf((Kopf) a);
            } else if (a.getClass() == Ruestung.class) {
                return setRuest((Ruestung) a);
            }
        }
        return false;
    }

    public void ablegen(int i) {
        if (i == 0) {
            this.updateStats(this.waffe, false);
            this.waffe = null;
        }else if (i == 1) {
            this.updateStats(this.kopf, false);
            this.kopf = null;
        } else if (i == 2) {
            this.updateStats(this.ruest, false);
            this.ruest = null;
        }
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
