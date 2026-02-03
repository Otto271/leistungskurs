package blatt16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Schreibprozess {
    public static void main(String[] args) throws IOException {
        File io = new File("io");
        if (!io.exists()) {
            io.mkdir();
        } else if (!io.isDirectory()) {
            io.mkdir();
        }
        File f = new File("io\\Test01.txt");
        FileWriter fw = new FileWriter(f);
        fw.write("Moin,\n");
        fw.write("wie gehts,\n");
        fw.write("Yalah!\n");
        fw.close();
        File html = new File("io\\Test02.html");
        FileWriter fwhtml = new FileWriter(html);
        fwhtml.write("""
                <!DOCTYPE html>
                <html>
                <head>
                <title>HTML aus Java</title>
                </head>
                <body>
                <h1>HTML aus Java</h1>
                <p>Es geht Wirklich</p>
                </body>""");
        fwhtml.close();
    }
}
