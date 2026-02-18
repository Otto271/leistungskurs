package blatt13;

import blatt12.SelectionSort;

public class Risiko {
    static int attackwin = 0;
    static int defensewin = 0;
    static int draw = 0;
    public static void simulation(int durchgänge) {
        for (int i = 0; i < durchgänge; i++) {
            int tempa = 0;
            int tempb = 0;
            int[] att = Zufall.zufallArray(1, 7, 3);
            int[] def = Zufall.zufallArray(1, 7, 2);
            SelectionSort.SelectionSort(att, true);
            SelectionSort.SelectionSort(def, true);
            for (int j = 0; j < 3; j++) {
                if (j < 2){
                    if (att[j] > def[j]){
                        tempa++;
                    } else if (att[j] < def[j]) {
                        tempb++;
                    }
                } else {
                    if (def[j-1] > att[j]){
                        tempb++;
                    } else if (def[j-1] < att[j]){
                        tempa++;
                    }
                }
            }
            if (tempa > tempb) {
                attackwin++;
            } else if (tempa < tempb) {
                defensewin++;
            } else  {
                draw++;
            }
        }
    }

    public static void main(String[] args) {
        simulation(100);
        System.out.println("att: " + attackwin + " defensewin: " + defensewin + " draw: " + draw);
    }
}
