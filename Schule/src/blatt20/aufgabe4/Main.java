package blatt20.aufgabe4;

public class Main {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("Samsong", "S21", 0, 256, 1000, 15, 0, 0, "Android");
        Smartphone s2 = new Smartphone("Samsong", "S21", 100, 256, 100, 15, 1, 1, "Android");
        System.out.println(s1.equals(s2));
    }
}
