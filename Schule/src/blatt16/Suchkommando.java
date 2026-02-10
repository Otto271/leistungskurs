package blatt16;

import blatt07.ArbeitMitArrays;

import java.io.File;
import java.util.Objects;

public class Suchkommando {
    public static void suchen(String name) {
        String path = "C:\\";
        while (true) {
            File file = new File(path);
            String[] list = file.list();
            if (list != null) {
                for (int i = 0; i < list.length; i++) {
                    if (Objects.equals(list[i], name)) {
                        System.out.println(file.getAbsolutePath() + name);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        suchen("eula.1028.txt");
    }
}
