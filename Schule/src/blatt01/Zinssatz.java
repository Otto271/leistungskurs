package blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        double altes_kapital = 1220;
        double zinsatz = 2.25;
        double zinsen = altes_kapital * zinsatz / 100;
        double neues_kapital = altes_kapital + zinsen;

        System.out.println("Altes kapital: " + altes_kapital + "€");
        System.out.println("Zinsatz: " + zinsatz + "%");
        System.out.println();
        System.out.println("Zinsen: " + zinsen + "€");
        System.out.println("Neues kapital: " + neues_kapital + "€");
    }
}
