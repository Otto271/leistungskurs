package blatt41.aufgabe02;

import blatt41.aufgabe01.Nachricht;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class FirstClient {
    int port;
    String ip;

    public FirstClient(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Socket connect() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        return socket;
    }

    public void communicate(Socket socket) throws IOException {
        Nachricht nachricht = new Nachricht();
        Scanner input = new Scanner(System.in);
        nachricht.receiveMessage(socket);
        System.out.println("Srever: " + nachricht.toString());
        nachricht.setMessage("GRE|Hallo");
        System.out.println("Client: " + nachricht.toString());
        nachricht.sendMessage(socket);
        nachricht.receiveMessage(socket);
        System.out.println("Server: " + nachricht.toString());
        nachricht.setMessage(input.nextLine());
        System.out.println("Client: " + nachricht.toString());
        nachricht.sendMessage(socket);
        nachricht.receiveMessage(socket);
        System.out.println("Server: " + nachricht.toString());
        nachricht.setMessage("FIN|Danke.");
        System.out.println("Client: " + nachricht.toString());
        socket.close();
    }
}
