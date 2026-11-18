package blatt41.aufgabe01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Nachricht {
    String protokoll;
    String nachricht;

    public Nachricht(String protokoll, String nachricht) {
        this.protokoll = protokoll;
        this.nachricht = nachricht;
    }

    public Nachricht() {
        this.protokoll = "";
        this.nachricht = "";
    }

    public String prepareMessage() {
        if (this.protokoll.equals("") || this.nachricht.equals("")) {
            System.out.println("Nachricht und / oder Protokoll ist leer!");
            return "";
        } else {
            return this.protokoll + "|" + this.nachricht;
        }
    }

    public boolean isValid(String message) {
        if (message.isBlank()) {
            return false;
        }
        if (message.indexOf('|') >= 0) {
            return true;
        }
        return false;
    }

    public String getProtokoll(String message) {
        return message.substring(0, message.indexOf('|'));
    }

    public String getNachricht(String message) {
        return message.substring(message.indexOf('|') + 1);
    }

    public void setMessage(String message) {
        if (isValid(message)) {
            this.protokoll = getProtokoll(message);
            this.nachricht = getNachricht(message);
        }
    }

    public void sendMessage(Socket socket) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(this.prepareMessage());
    }

    public Nachricht receiveMessage(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = in.readLine();
        setMessage(message);
        return this;
    }
}
