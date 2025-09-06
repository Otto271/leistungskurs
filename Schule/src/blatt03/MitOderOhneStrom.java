package blatt03;
import java.util.Scanner;
public class MitOderOhneStrom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wählen Sie zwischen einem NOT, OR, AND oder XOR Gatter!");
        String gatter = input.nextLine();
        if (gatter.equals("NOT")) {
            System.out.println("Das NOT-Gatter:");
            System.out.println("Verfügt über einen Eingang und kehrt den Wert um.");
            System.out.println("Befindet sich auf dem Eingang Strom? (true/false)");
            boolean not_eingang = input.nextBoolean();
            if (not_eingang) {
                System.out.println(true + " = " + false);
            } else if (!not_eingang) {
                System.out.println(false + " = " + true);
            }
        }
        if (gatter.equals("OR")) {
            System.out.println("Das OR-Gatter:");
            System.out.println("Verfügt über zwei Eingänge, Ergebnis ist true wnn mindestens einer true ist.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)");
            boolean or_eingang_1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean or_eingang_2 = input.nextBoolean();
            if (or_eingang_1 || or_eingang_2) {
                System.out.println(or_eingang_1 + " AND " + or_eingang_2 +  " = true");
            }else if (!or_eingang_1 || !or_eingang_2){
                System.out.println(false + " AND " + false + " = false");
            }
        }
        if (gatter.equals("AND")) {
            System.out.println("Das AND-Gatter:");
            System.out.println("Verfügt über zwei Eingänge, Ergebnis true wenn beide true sind.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)");
            boolean and_eingang_1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean and_eingang_2 = input.nextBoolean();
            if (and_eingang_1 && and_eingang_2) {
                System.out.println(true + " AND" + true + " = true");
            }else if (!and_eingang_1 && !and_eingang_2) {
                System.out.println(and_eingang_1 + " AND " + and_eingang_2 +  " = false");
            }
        }
        if (gatter.equals("XOR")) {
            System.out.println("Das XOR-Gatter:");
            System.out.println("Verfügt über zwei Eingänge, Ergebnis ist true wenn genau einer true ist.");
        }
    }
}
