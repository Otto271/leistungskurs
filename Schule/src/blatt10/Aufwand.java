package blatt10;

public class Aufwand {
    public static int zahlDerUmbrueche(char[] charr) {
        int o = 1;
        int b = 0;
        int count = 0;
        for (int i = 0; i < charr.length-1; i++) {
            o += 2;
            b++;
            if (charr[i] == '.') {
                b++;
                if (charr[i+1] == ' ') {
                    count++;
                    b++;
                    o++;
                }
            }
        }
        System.out.println(o + " " + b);
        return count;
    }

    public static char[] umbrueche(String s) {
        char[] charr = s.toCharArray();
        int c = zahlDerUmbrueche(charr);
        int k = 0;
        char[] charr2 = new char[charr.length+c];
        int o = 1;
        int b = 0;
        while (c > 0) {
            b++;
            for (int i = 0; i < charr.length-1; i++) {
                o += 2;
                b++;
                if (charr[i] == '.') {
                    b++;
                    if (charr[i+1] == ' ') {
                        b++;
                        charr2[i] = charr[i];
                        charr2[i+1] = '\n';
                        k++;
                        c--;
                        o += 4;
                    } else {
                        charr2[i+k] = charr[i];
                        o++;
                    }
                } else {
                    if (charr[i] == ' ' && charr[i-1] == '.') {
                        b++;
                    } else {
                        charr2[i] = charr[i];
                        o++;
                    }
                }
            }
        }
        System.out.println(o + " " + b);
        System.out.println(charr2.length);
        System.out.println(charr.length);
        return charr2;

    }

    public static void main(String[] args) {
        String eingabe = "Nussecken (1 Blech). Teig: 300g Mehl, 1 TL Backpulver, 130g Zucker, 1 Pkg Vanillezucker, 2 EL Leinsamen, 6 EL Wasser, 130g Margarine/Butter. Belag: 200g Margarine/Butter, 6 EL Wasser, 200g Zucker, 1 Pkg Vanillezucker, 400g gemahlene Haselnüsse/Mandeln. Außerdem: Erdbeer-/Himbeermarmelade, 100g Zartbitterschokolade. Schritte: Die Leinsamen in 6 EL Wasser aufquellen lassen. Alle Zutaten für den Teig vermischen und zu einem relativ weichen Teig zerkneten, dann auf einem mit Backpapier ausgelegten Backbleck dünn drücken. Marmelade dünn auf dem Teig verteilen. Margarine, Wasser, Zucker und Vanillezucker in einem Topf schmelzen und kurz aufkochen lassen, dann Nüsse dazugeben und alles vermischen. Belag auf der Marmelade verteilen. Im vorgeheizten Backofen bei 180° C Ober/Unterhitze oder 160° C Umluft ca. 30 Minuten backen. Glasur erwärmen und mit einem Löffel über das Blech sprenkeln (so wird es gleichmäßiger und geht schneller als die Ecken in Schokolade zu tunken), abkühlen lassen. Zu Ecken schneiden. ";
        System.out.println(eingabe.length());
        char[] ausgabe = umbrueche(eingabe);
        System.out.println(eingabe);
        System.out.println(ausgabe);
    }
    //b) 2089 Bedingungen, 5102 Operationen
    //c) 8049 Bytes
    //d) Ist Instabil, weil kleine Fehler einen Großen unterschied machen
    //e) Best Case wenn String 0 Char und worst case wenn String n char hat
}
