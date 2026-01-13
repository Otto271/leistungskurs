package blatt15;
import schisch_visualizer.*;
import blatt14.Simulationen;
public class Kaese {
    public static char[][] wasser(char[][] arr){
        char[][] käse = blatt14.MultiArrays.copy2DCharArray(arr);
        for (int i = 0; i < käse.length; i++) {
            for (int j = 0; j < käse[0].length; j++) {
                if (arr[i][j] == '2') {
                    if (Simulationen.getNorden(arr, j, i, false) == '0'){
                        käse[j][i--] = '2';
                    }
                    if (Simulationen.getOsten(arr, j, i, false) == '0'){
                        käse[j++][i] = '2';
                    }
                    if (Simulationen.getSueden(arr, j, i, false) == '0'){
                        käse[j][i++] = '2';
                    }
                    if (Simulationen.getWesten(arr, j, i, false) == '0'){
                        käse[j--][i] = '2';
                    }
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] kaese = new char[10][10];
        kaese = blatt14.Simulationen.fuellen(kaese,'5', 0.6);
        sv.step(kaese);
        for (int i = 0; i < kaese.length; i++) {
            if (kaese[i][0] == '0') {
                kaese[i][0] = '2';
            }
        }
        sv.step(kaese);
        kaese = wasser(kaese);
        sv.step(kaese);
        sv.start();
    }
}
