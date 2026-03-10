package blatt20.aufgabe1;

public class Main {
    public static void main(String[] args) {
        Kaffeemaschine kaffeemaschine = new Kaffeemaschine();
        System.out.println(kaffeemaschine.bohnen + " " + kaffeemaschine.wasser);
        kaffeemaschine.bohnenAuffuellen();
        kaffeemaschine.wasserAuffuellen();
        System.out.println(kaffeemaschine.bohnen + " " + kaffeemaschine.wasser);
        kaffeemaschine.wasserLeeren();
        kaffeemaschine.bohnenLeeren();
        System.out.println(kaffeemaschine.bohnen + " " + kaffeemaschine.wasser);
        kaffeemaschine.bohnenAuffuellen();
        kaffeemaschine.wasserAuffuellen();
        kaffeemaschine.kaffeeziehen(10, 10);
        System.out.println(kaffeemaschine.bohnen + " " + kaffeemaschine.wasser + " " + kaffeemaschine.dreck + " " + kaffeemaschine.kaffeesatz);
        kaffeemaschine.wasserLeeren();
        kaffeemaschine.kaffeesatzLeeren();
        kaffeemaschine.wasserReinigen();
        System.out.println(kaffeemaschine.bohnen + " " + kaffeemaschine.wasser + " " + kaffeemaschine.dreck + " " + kaffeemaschine.kaffeesatz);
        kaffeemaschine.wasserAuffuellen();
        kaffeemaschine.bohnenAuffuellen();
        kaffeemaschine.kaffeeziehen(200, 10);
        kaffeemaschine.kaffeeziehen(200, 10);
        kaffeemaschine.kaffeeziehen(200, 10);
        kaffeemaschine.bohnenAuffuellen();
        kaffeemaschine.kaffeeziehen(200, 10);
        kaffeemaschine.wasserAuffuellen();
        kaffeemaschine.bohnenAuffuellen();
        kaffeemaschine.kaffeeziehen(200, 10);
        kaffeemaschine.kaffeeziehen(200, 10);
        System.out.println(kaffeemaschine.bohnen + " " + kaffeemaschine.wasser + " " + kaffeemaschine.dreck + " " + kaffeemaschine.kaffeesatz);
        kaffeemaschine.kaffeesatzLeeren();
        kaffeemaschine.wasserAuffuellen();
        kaffeemaschine.bohnenAuffuellen();
        kaffeemaschine.dreck = 50;
        kaffeemaschine.kaffeeziehen(200, 10);
    }
}
