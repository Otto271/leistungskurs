package blatt16;

import blatt13.Zufall;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Systemsprenger {
    public static void sprengen(int anzahl) throws IOException {
        File sprengtest = new File("sprengtest");
        int j = 0;
        if (!sprengtest.exists()) {
            sprengtest.mkdir();
        } else if (!sprengtest.isDirectory()) {
            sprengtest.mkdir();
        } else {
            File[] s = sprengtest.listFiles();
            j =  s.length;
        }
        for (int i = j; i < anzahl+j; i++) {
            File file = new File("sprengtest\\boom" + i + ".txt");
            FileWriter fw = new FileWriter(file);
            int[] arr = Zufall.zufallArray(65,122,20);
            for(int k = 0; k < arr.length; k++){
                char a = (char)arr[k];
                fw.write(a);
            }
            fw.close();
        }
    }
    public static void main(String[] args) throws IOException {
        sprengen(4);
    }
}
