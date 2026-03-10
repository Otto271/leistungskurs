package blatt20_0;

public class Main {
    public static void main(String[] args) {
        //Instanz 1
        Fahrrad fahrrad_1 = new Fahrrad();
        fahrrad_1.farbe = "Schwarz";
        fahrrad_1.anzahlGaenge = 27;
        fahrrad_1.lichtAn = true;
        fahrrad_1.reifengroesse = 30;
        fahrrad_1.klingeln();
        fahrrad_1.beschreiben();
        //Instanz 2
        Fahrrad fahrrad_2 = new Fahrrad();
        fahrrad_2.farbe = "Rot";
        fahrrad_2.anzahlGaenge = 21;
        fahrrad_2.lichtAn = false;
        fahrrad_2.reifengroesse = 40;
        fahrrad_2.klingeln();
        fahrrad_2.beschreiben();
        //Instanz 3
        Fahrrad fahrrad_3 = new Fahrrad();
        fahrrad_3.farbe = "Orange";
        fahrrad_3.anzahlGaenge = 14;
        fahrrad_3.lichtAn = true;
        fahrrad_3.reifengroesse = 55;
        fahrrad_3.klingeln();
        fahrrad_3.beschreiben();
    }
}
