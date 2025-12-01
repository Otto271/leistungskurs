package blatt14;
import schisch_visualizer_neo.*;
public class Bib {
    public static void main(String[] args) {
        char[][] charr = new char[3][3];
        for (int i = 0; i < charr.length; i++) {
            for (int j = 0; j < charr[i].length; j++) {
                charr[i][j] = (char)(i+j);
            }
        }
    }
}
