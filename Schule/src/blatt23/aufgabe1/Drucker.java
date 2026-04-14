package blatt23.aufgabe1;

public class Drucker {
    private Verbindungsmodus verbindungsmodi;
    private int papierfach;
    private Modus modi;
    private boolean scanner;
    private double fuells;
    private double fuellf;
    private int seitenzahl;
    private Abonnement abonnement;

    public Drucker(Abonnement abonnement) {
        this.abonnement = abonnement;
        this.seitenzahl = abonnement.Kontingent;
        this.fuells = 100;
        this.fuellf = 100;
        this.papierfach = 0;
        this.scanner = false;
        this.verbindungsmodi = Verbindungsmodus.OFFLINE;
        this.modi = Modus.STANDBY;
    }

    public void zuOnline() {
        this.verbindungsmodi = Verbindungsmodus.ONLINE;
    }

    public void zuOffline() {
        this.verbindungsmodi = Verbindungsmodus.OFFLINE;
    }

    public void zuLokal() {
        this.verbindungsmodi = Verbindungsmodus.LOKAL;
    }

    public void papierAuffuellen(int papier) {
        if (this.papierfach + papier <= 250 || this.papierfach + papier > 0) {
            this.papierfach += papier;
        } else {
            System.out.println("Zu viel oder zu wenig Papier!");
        }
    }

    public void legeAufGlas() {
        if (!this.scanner) {
            this.scanner = true;
        }
    }

    public void entferneVonGlas() {
        if (this.scanner) {
            this.scanner = false;
        }
    }

    public boolean scannen() {
        if (this.scanner && this.verbindungsmodi != Verbindungsmodus.OFFLINE) {
            return true;
        }
        return false;
    }

    private void tinteAuffuellen(Patronenart patronenart) {
        if (patronenart == Patronenart.SCHWARZ) {
            this.fuells = 100;
        } else {
            this.fuellf = 100;
        }
    }

    public void aboWechsel(int abo) {
        switch (abo) {
            case 1:
                this.abonnement = Abonnement.XS;
            case 2:
                this.abonnement = Abonnement.S;
            case 3:
                this.abonnement = Abonnement.M;
            case 4:
                this.abonnement = Abonnement.L;
            case 5:
                this.abonnement = Abonnement.XL;
        }
        neuesKontigent(this.abonnement);
    }

    private void neuesKontigent(Abonnement abonnement) {
        this.seitenzahl += abonnement.Kontingent;
    }

    public void drucken(Druckart druckart, Druckmodus farbe, int menge, int nummer) {
        switch (druckart) {
            case Druckart.SPAREN -> {
                if (this.seitenzahl > 0) {
                    if (menge > 0) {
                        if (menge < papierfach) {
                            if (farbe == Druckmodus.SCHWARZWEISS) {
                                if (this.fuells < 0.3) {
                                    tinteAuffuellen(Patronenart.SCHWARZ);
                                }
                                this.fuells -= 0.3;
                            } else {
                                if (this.fuells < 0.1) {
                                    tinteAuffuellen(Patronenart.SCHWARZ);
                                }
                                if (this.fuellf < 0.3) {
                                    tinteAuffuellen(Patronenart.FARBE);
                                }
                                this.fuellf -= 0.3;
                                this.fuells -= 0.1;
                            }
                            this.seitenzahl -= menge;
                            this.papierfach -= menge;
                        } else {
                            System.out.println("Zu viel Papier!");
                        }
                    }
                } else {
                    System.out.println("Upgrade Broke Boy!");
                }
            }
            case Druckart.NORMAL -> {
                if  (this.seitenzahl > 0) {
                    if (menge > 0) {
                        if (menge < papierfach) {
                            if (farbe ==  Druckmodus.SCHWARZWEISS) {
                                if (this.fuells < 0.5) {
                                    tinteAuffuellen(Patronenart.SCHWARZ);
                                }
                                this.fuells -= 0.5;
                            } else {
                                if (this.fuells < 0.2) {
                                    tinteAuffuellen(Patronenart.SCHWARZ);
                                }
                                if (this.fuellf < 0.6) {
                                    tinteAuffuellen(Patronenart.FARBE);
                                }
                                this.fuellf -= 0.6;
                                this.fuells -= 0.2;
                            }
                            this.seitenzahl -= menge;
                            this.papierfach -= menge;
                        } else {
                            System.out.println("Zu viel Papier!");
                        }
                    }
                } else {
                    System.out.println("Upgrade Broke Boy!");
                }
            }
            case Druckart.QUALITAET -> {
                if (this.seitenzahl > 0) {
                    if (menge > 0) {
                        if (menge < papierfach) {
                            if (farbe == Druckmodus.SCHWARZWEISS) {
                                if (this.fuells < 0.8) {
                                    tinteAuffuellen(Patronenart.SCHWARZ);
                                }
                                this.fuells -= 0.8;
                            } else {
                                if (this.fuells < 0.3) {
                                    tinteAuffuellen(Patronenart.SCHWARZ);
                                }
                                if (this.fuellf < 1.1) {
                                    tinteAuffuellen(Patronenart.FARBE);
                                }
                                this.fuellf -= 1.1;
                                this.fuells -= 0.3;
                            }
                        } else {
                            System.out.println("Zu viel Papier!");
                        }
                    }
                } else {
                    System.out.println("Upgrade Broke Boy!");
                }
            }
        }
        Druckauftrag druckauftrag = new Druckauftrag(nummer, menge, farbe, druckart, fuells, fuellf);
    }
}
