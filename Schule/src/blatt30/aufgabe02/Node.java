package blatt30.aufgabe02;

public class Node {
    private int wert;
    private Node left;
    private Node right;

    public Node(int wert) {
        this.wert = wert;
        this.left = null;
        this.right = null;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node[] findInOrderNeighbour() {
        Node[] neighbours = new Node[2];
        Node current = this.left;
        while (current.right != null) {
            current = current.right;
        }
        neighbours[0] = current;
        current = this.right;
        while (current.left != null) {
            current = current.left;
        }
        neighbours[1] = current;
        return neighbours;
    }
}
