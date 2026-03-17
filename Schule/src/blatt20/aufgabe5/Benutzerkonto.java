package blatt20.aufgabe5;

import java.util.Objects;

public class Benutzerkonto {
    private String benutzername;
    private String email;
    private String geburtsdatum;
    private String passwort;
    private double guthaben;
    private String datum;
    private boolean angemeldet;

    public Benutzerkonto(String benutzername, String datum, double guthaben, String passwort, String geburtsdatum, String email) {
        this.benutzername = benutzername;
        this.datum = datum;
        this.guthaben = guthaben;
        this.passwort = passwort;
        this.geburtsdatum = geburtsdatum;
        this.email = email;
    }

    public void anmelden(String benutzername, String passwort) {
        if (!benutzername.equals(this.benutzername)) {
            System.out.println("Falscher Benutzername!");
        } else if (!passwort.equals(this.passwort)) {
            System.out.println("Falsches Passwort!");
        } else {
            this.angemeldet = true;
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


}
