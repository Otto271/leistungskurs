package blatt15;
import schisch_visualizer.*;
import blatt13.Zufall;
public class Farben {
    public static int zaehlen(int teamnummer,char[][] arr){
        int count = 0;
        if (teamnummer == 7) {
            for  (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == '7') {
                        count++;
                    }
                }
            }
        } else if (teamnummer == 9) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == '9') {
                        count++;
                    } else if (arr[i][j] == 'P') {
                        
                    }
                }
            }
        } else if (teamnummer == 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == ' ') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void initialisiereSpielfeld(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == 0 || i == arr.length-1) {
                    arr[i][j] = '8';
                } else if (j == 0 || j == arr[i].length-1) {
                    arr[i][j] = '8';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
    }
    public static void startPosition(char[][] arr, int[] posx, int[] posy) {
        for (int i = 4; i > 0; i--) {
            int zufallx = Zufall.zufallGanz(1, arr.length/2);
            int zufally = Zufall.zufallGanz(1, arr.length-1);
            arr[zufallx][zufally] = 'P';
            posx[i] = zufallx;
            posy[i] = zufally;
        }
        for (int i = 4; i > 0; i--) {
            int zufallx = Zufall.zufallGanz(arr.length/2+1, arr.length-1);
            int zufally = Zufall.zufallGanz(1, arr.length-1);
            arr[zufallx][zufally] = 'P';
            posx[i] = zufallx;
            posy[i] = zufally;
        }
    }
    public static int[] positionx(char[][] arr, int[] posx) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'P') {
                    posx[count] = i;
                    count++;
                }
            }
        }
        return posx;
    }
    public static int[] positiony(char[][] arr, int[] posy) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'P') {
                    posy[count] = i;
                    count++;
                }
            }
        }
        return posy;
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] arr = new char[80][80];
        int[] posx = new int[8];
        int[] posy = new int[8];
        initialisiereSpielfeld(arr);
        startPosition(arr, posx, posy);
        sv.step(arr);
        sv.start();
    }
}
