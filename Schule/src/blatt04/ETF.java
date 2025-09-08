package blatt04;

public class ETF {
    public static void main(String[] args) {
        double sparbetrag = 50;
        int monat = 12;
        double wert = 3578.89;
        double anteil = sparbetrag / wert;
        while (monat > 0) {
            sparbetrag += 50;
            monat -= 1;
            anteil = sparbetrag / wert;
            System.out.printf("Gesamtbetrag: %.2f€", sparbetrag);
            System.out.println("Monat: " + monat);
            System.out.printf("Anteil:");
        }
    }
}
