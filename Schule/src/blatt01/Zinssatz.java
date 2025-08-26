package blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        double altes_kapital = 1220.0;
        double zinssatz = 2.25;
        double zinsen = altes_kapital * zinssatz / 100;
        double neues_kapital = altes_kapital + zinsen;
        System.out.println("Altes Kapital: " + altes_kapital + "€");
        System.out.println("Zinssatz: " + zinssatz + "%");
        System.out.println();
        System.out.println("Zinsen: " + zinsen + "€");
        System.out.println("Neues Kapital: " + neues_kapital + "€");
    }
}
