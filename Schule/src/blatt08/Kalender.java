package blatt08;

public class Kalender {
    /**
     * Diese Funktion bekommt ein Datum und gibt dann den Tag als Integer zurück
     * @param datum (__.__.____)
     * @return Tag als Integer
     */
    public static int getTag(String datum) {
        String tag_string = datum.substring(0, 2);
        int tag = Integer.parseInt(tag_string);
        return tag;
    }

    /**
     * Diese Funktion schaut ob das Jahr ein Schaltjahr ist
     * @param jahr als integer
     * @return true wenn es ein Schaltjahr ist, false wenn es keins ist
     */
    public static boolean istSchaltjahr(int jahr) {
        if (jahr % 400 == 0 || (jahr % 4 == 0 && jahr % 100 != 0)) {
            return true;
        }
        return false;
    }

    /**
     * Diese Funktion bekommt Tag, Monat und Jahr als integer angegeben und wandelt es in einen String um
     * @param tag als Integer
     * @param monat als Integer
     * @param jahr als Integer
     * @return Datum als String (__.__.____)
     */
    public static String zuDatum(int tag, int monat, int jahr) {
        return tag + "." + monat + "." + jahr;
    }

    /**
     * Diese Funktion kriegt ein Datum und gibt das Datum vom nächsten Tag wieder
     * @param datum (__.__.____)
     * @return Datum als String (__.__.____)
     */
    public static String naechsterTag(String datum) {
        int tag = getTag(datum);
        String monatString = datum.substring(3, 5);
        int monat = Integer.parseInt(monatString);
        String jahrString = datum.substring(6, 10);
        int jahr = Integer.parseInt(jahrString);
        if (!istSchaltjahr(jahr) && monat == 02 && tag == 28) {
            tag = 1;
            monat++;
            return zuDatum(tag, monat, jahr);
        } else if (tag == 31 && monat == 12) {
            tag = 01;
            jahr++;
            monat = 01;
            return zuDatum(tag, monat, jahr);
        } else if (((monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10) && tag == 31) || ((monat == 4 || monat == 6 || monat == 9 || monat == 11) && tag == 30)) {
            monat++;
            tag = 01;
            return zuDatum(tag, monat, jahr);
        }if (istSchaltjahr(jahr) && monat == 2 && tag == 29) {
            tag = 1;
            monat++;
            return zuDatum(tag, monat, jahr);
        }
        tag++;
        return zuDatum(tag, monat, jahr);
    }
    public static void main(String[] args) {
        System.out.println(getTag("11.02.2008"));
        System.out.println(zuDatum(11, 11, 2011));
        System.out.println(naechsterTag("28.02.2007"));
    }
}
