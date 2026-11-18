package blatt41.aufgabe02;

import blatt41.aufgabe01.Nachricht;

import java.net.*;
import java.io.*;

public class FirstServer {
    int port;

    public FirstServer(int port) {
        this.port = port;
    }

    public Socket start() throws IOException {
        ServerSocket server =new ServerSocket(this.port);
        Socket client = server.accept();
        return client;
    }

    public void communicate(Socket socket) throws IOException {
        Nachricht nachricht = new Nachricht("GRE", "Hallo");
        nachricht.sendMessage(socket);
        System.out.println("Server: " + nachricht.prepareMessage());
        nachricht.receiveMessage(socket);
        System.out.println("Client: " + nachricht.prepareMessage());
        nachricht.setMessage("OST|Wie geht es dir?");
        nachricht.sendMessage(socket);
        System.out.println("Server: " + nachricht.prepareMessage());
        nachricht.receiveMessage(socket);
        System.out.println("Client: " + nachricht.prepareMessage());
        nachricht.setMessage("FIN|Danke.");
        nachricht.sendMessage(socket);
        System.out.println("Server: " + nachricht.prepareMessage());
        nachricht.receiveMessage(socket);
        System.out.println("Client: " + nachricht.prepareMessage());
        socket.close();
    }
}
