package blatt06;

public class GesuchtGefunden {
    public static void main(String[] args) {
        double[] arr = new double[] {3.45, 7, 14, -66, 5.4, 33.33, 99.1, 42.3, 3.14, -3.14, 13.56, 7.8031, -54.35, 6.120, 6.435, -2.30001, 0.00005, -65.78, -29.57, 92, -83, 3174.56, -1469.349, -5.086, 27.135, 348.5, 52.3568, -47.320051, 8372.579, -593.2, 0.25874, -7.1952, 3587.6, -201.3, -65.92, 12, 5, 13.7, -30, 16.5, 10071, 1700.34, -50.05, 81.3576, -42};
        double gross = 0;
        double klein = 0;
        double summe = 0;
        double min_diff = 0;
        double zahl_1 = 0;
        double zahl_2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > gross) {
                gross = arr[i];
            }
        }
        System.out.println("Größte Zahl: " + gross);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < klein) {
                klein = arr[i];
            }
        }
        System.out.println("Kleinste Zahl: " + klein);
        for (int i = 0; i < arr.length; i++) {
            summe += arr[i];
        }
        System.out.println("Summe: " + summe);
        for (int i = 0; i < arr.length - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            if (diff < min_diff) {
                min_diff = diff;
                zahl_1 = arr[i];
                zahl_2 = arr[i + 1];
            }
        }
        System.out.println("Kleinste Paardifferenz: " + zahl_2 + " - " + zahl_1 + " = " + min_diff);
    }
}
