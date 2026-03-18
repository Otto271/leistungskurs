package blatt20.aufgabe5;

import java.util.Date;
import java.util.Objects;

public class Benutzerkonto {
    private String benutzername;
    private String email;
    private java.util.Date geburtsdatum;
    private String passwort;
    private double guthaben;
    private java.util.Date datum;
    private boolean angemeldet;

    public Benutzerkonto(String benutzername, Date datum, double guthaben, String passwort, Date geburtsdatum, String email) {
        this.benutzername = benutzername;
        this.datum = datum;
        this.guthaben = guthaben;
        this.passwort = passwort;
        this.geburtsdatum = geburtsdatum;
        this.email = email;
        this.angemeldet = false;
    }

    public String getBenutzername() {
        if (this.angemeldet) {
            return benutzername;
        } else  {
            System.out.println("Erst anmelden!");
            return "";
        }
    }

    public String getEmail() {
        if (this.angemeldet) {
            return email;
        } else   {
            System.out.println("Erst anmelden!");
            return "";
        }
    }

    public Date getGeburtsdatum() {
        if (this.angemeldet) {
            return geburtsdatum;
        } else  {
            System.out.println("Erst anmelden!");
            return null;
        }
    }

    public Date getDatum() {
        if (this.angemeldet) {
            return datum;
        } else {
            System.out.println("Erst anmelden!");
            return null;
        }
    }

    public boolean isAngemeldet() {
        return angemeldet;
    }

    public void anmelden(String benutzername, String passwort) {
        if (!this.angemeldet) {
            if (!benutzername.equals(this.benutzername)) {
                System.out.println("Falscher Benutzername!");
            } else if (!passwort.equals(this.passwort)) {
                System.out.println("Falsches Passwort!");
            } else {
                this.angemeldet = true;
            }
        }
    }

    public void abmelden() {
        if (this.angemeldet) {
            this.angemeldet = false;
        }
    }

    public void passwortAendern(String passwort, String neuPasswort) {
        if (!passwort.equals(this.passwort)) {
            System.out.println("Falsches Passwort!");
        } else if (neuPasswort.equals(this.passwort)) {
            System.out.println("Gleiches Passwort!");
        } else {
            this.passwort = neuPasswort;
        }
    }

    public void gutschein(String gutschein, double wert) {
        if (!this.angemeldet) {
            System.out.println("Erst Anmelden!");
        } else if (gutschein.equals("0162T--8")) {
            if (wert > 0) {
                this.guthaben = wert;
            } else  {
                System.out.println("Gutschein leer!");
            }
        } else {
            System.out.println("Falscher Code!");
        }
    }

    public void guthaben() {
        System.out.println("Guthaben: " + this.guthaben + "€");
    }
}
