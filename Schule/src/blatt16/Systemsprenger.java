package blatt16;

import blatt13.Zufall;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

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
            int[] arr = Zufall.zufallArray(65,122,200);
            for(int k = 0; k < arr.length; k++){
                char a = (char)arr[k];
                fw.write(a);
            }
            fw.close();
        }
    }
    public static void reinigen() {
        File reinigen = new File("sprengtest");

        if (reinigen.exists()) {
            if (reinigen.isDirectory()) {
                for (int i = 0; i < Objects.requireNonNull(reinigen.listFiles()).length; i++) {
                    File file = new File("sprengtest\\" + Objects.requireNonNull(reinigen.listFiles())[i].getName() + ".txt");
                    if (file.isFile()) {
                        if (file.getName().equals("boom" + i + ".txt")) {
                            System.out.println(file.delete());

                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        reinigen();
    }
}
