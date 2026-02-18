package blatt13;

public class MonteCarlo {
    static int regengesamt = 10000;
    static int regenbrunnen;
    static int regenaus;
    static double pi;
    public static void simulation() {
        for (int i = 0; i < regengesamt; i++) {
            double zufallx = Zufall.zufall(-0.5, 0.5);
            double zufally = Zufall.zufall(-0.5, 0.5);
            if (Math.pow(zufallx, 2) + Math.pow(zufally, 2) <= Math.pow(0.5, 2)) {
                regenbrunnen++;
            } else {
                regenaus++;
            }
        }
        pi = (double) (4 * regenbrunnen) / regengesamt;
    }
    public static void main(String[] args) {
        simulation();
        System.out.println("Regenbrunnen: " + regenbrunnen + " Regenaus: " + regenaus + " Pi: " + pi);
    }
}
