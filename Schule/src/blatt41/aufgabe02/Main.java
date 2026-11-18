package blatt41.aufgabe02;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        FirstServer server = new FirstServer(1500);
        Socket socket = server.start();
        server.communicate(socket);

    }
}
