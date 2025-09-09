package blatt03;
import java.util.Scanner;
public class MitOderOhneStrom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wählen Sie zwischen einem NOT, OR, AND oder XOR Gatter!"); //Gatter wird abgefragt
        String gatter = input.nextLine();

        if (gatter.equals("NOT")) {
            System.out.println("Das NOT-Gatter:");
            System.out.println("Verfügt über einen Eingang und kehrt den Wert um.");
            System.out.println("Befindet sich auf dem Eingang Strom? (true/false)"); //Stromfluss wird abgefragt
            boolean not_eingang = input.nextBoolean();

            if (not_eingang) { //in diesem Teil wird geschaut ob true oder false rauskommt
                System.out.println(true + " = " + false);
            } else if (not_eingang == false) {
                System.out.println(false + " = " + true);
            }

        }else if (gatter.equals("OR")) {
            System.out.println("Das OR-Gatter:");
            System.out.println("Verfügt über zwei Eingänge, Ergebnis ist true wnn mindestens einer true ist.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)"); //Stromfluss wird abgefragt
            boolean or_eingang_1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean or_eingang_2 = input.nextBoolean();

            if (or_eingang_1 || or_eingang_2 == true) { //in diesem Teil wird geschaut ob true oder false rauskommt
                System.out.println(or_eingang_1 + " OR " + or_eingang_2 +  " = true");
            }else if (or_eingang_1 || or_eingang_2 == false) {
                System.out.println(false + " OR " + false + " = false");
            }

        }else if (gatter.equals("AND")) {
            System.out.println("Das AND-Gatter:");
            System.out.println("Verfügt über zwei Eingänge, Ergebnis true wenn beide true sind.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)"); //Stromfluss wird abgefragt
            boolean and_eingang_1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean and_eingang_2 = input.nextBoolean();

            if (and_eingang_1 && and_eingang_2) { //in diesem Teil wird geschaut ob true oder false rauskommt
                System.out.println(true + " AND " + true + " = true");
            }else if (and_eingang_1 && and_eingang_2 == false) {
                System.out.println(and_eingang_1 + " AND " + and_eingang_2 +  " = false");
            }

        }else if (gatter.equals("XOR")) {
            System.out.println("Das XOR-Gatter:");
            System.out.println("Verfügt über zwei Eingänge, Ergebnis ist true wenn genau einer true ist.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)"); //Stromfluss wird abgefragt
            boolean xor_eingang_1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean xor_eingang_2 = input.nextBoolean();

            if (xor_eingang_1 && xor_eingang_2) { //in diesem Teil wird geschaut ob true oder false rauskommt
                System.out.println("true XOR true = false");
            } else if (!xor_eingang_1 && !xor_eingang_2) {
                System.out.println("false XOR false = false");
            } else if (xor_eingang_1 && !xor_eingang_2) {
                System.out.println("true XOR false = true");
            } else if (!xor_eingang_1 && xor_eingang_2) {
                System.out.println("false XOR true = true");
            }

        } else {
            System.out.println("Bitte geben Sie eins der genannten Gatter an! (NOT, OR, AND, XOR)"); //Fehlermeldung falls der user nicht eins der Gatter eingibt
        }
    }
}
