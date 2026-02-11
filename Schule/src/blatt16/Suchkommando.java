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
                int count = 0;
                for (int i = 0; i < list.length; i++) {
                    File file1 = new File(path + list[i]);
                    if (Objects.equals(list[i], name)) {
                        System.out.println(file.getAbsolutePath() + name);
                        return;
                    } else if (file1.isDirectory()) {
                        list[count] = file1.getName();
                        count++;
                    }
                }
            }
            path = path + "";
        }
    }

    public static void main(String[] args) {
        suchen("eula.1028.txt");
    }
}
