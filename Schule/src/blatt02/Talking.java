package blatt02;
import java.util.Scanner; //Scanner importieren
public class Talking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner defienieren und ihn benennen
        System.out.println("Guten Tag, wie heißen Sie?"); //Frage
        String name = input.nextLine(); //Antwort des Nutzers
        System.out.println("Hallo " + name + "!"); //Ausgabe
    }
}
