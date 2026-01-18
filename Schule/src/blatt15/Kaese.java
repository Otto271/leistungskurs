package blatt15;
import blatt14.MultiArrays;
import schisch_visualizer.*;
import blatt14.Simulationen;
public class Kaese {
    public static char[][] kaesefill(int x, int y, double random) {
        char[][] kaese = MultiArrays.createEmpty2DCharArray(x,y);
        kaese = blatt14.Simulationen.fuellen(kaese,'5', random);
        return kaese;
    }
    public static char[][] wasserstart(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == ' ') {
                arr[i][0] = '2';
            }
        }
        return arr;
    }
    public static char[][] wasser(char[][] arr){
        char[][] käse = blatt14.MultiArrays.copy2DCharArray(arr);
        for (int i = 0; i < käse.length; i++) {
            for (int j = 0; j < käse[i].length; j++) {
                if (arr[i][j] == '2') {
                    if (Simulationen.zaehlenVier(käse, i, j, false, ' ') > 0) {
                        if (Simulationen.getNorden(arr, i, j, false) == ' ') {
                            käse[i][j-1] = '2';
                        }
                        if (Simulationen.getOsten(arr, i, j, false) == ' ') {
                            käse[i+1][j] = '2';
                        }
                        if (Simulationen.getSueden(arr, i, j, false) == ' ') {
                            käse[i][j+1] = '2';
                        }
                        if (Simulationen.getWesten(arr, i, j, false) == ' ') {
                            käse[i-1][j] = '2';
                        }
                    }
                }
            }
        }
        return käse;
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] kaese = kaesefill(10,10,0.5);
        sv.step(kaese);
        kaese = wasserstart(kaese);
        sv.step(kaese);
        char[][] neu = wasser(kaese);
        while (!MultiArrays.istIdentisch(kaese, neu)) {
            kaese = neu;
            sv.step(kaese);
            neu = wasser(kaese);
        }
        sv.start();
    }
}
