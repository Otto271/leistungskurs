package blatt30.aufgabe02;

public class BinBaum {
    private Node root;

    public BinBaum(Node root) {
        this.root = root;
    }

    public BinBaum() {
        this.root = null;
    }

    public Node search(int wert) {
        Node current = root;
        while(current != null) {
            if(current.getWert() == wert) {
                return current;
            } else if (current.getWert() < wert) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }
        return null;
    }

    public void add(int wert) {
        Node current = root;
        while(current != null) {
            if(current.getWert() == wert) {
                return;
            } else if (current.getWert() < wert) {
                current = current.getRight();
            } else  {
                current = current.getLeft();
            }
        }
        current = new Node(wert);
    }


}
