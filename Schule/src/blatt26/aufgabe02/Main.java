package blatt26.aufgabe02;

public class Main {
    public static void swap(Computer[] computers, int j){
        Computer a =  computers[j];
        computers[j] = computers[j++];
        computers[j] = a;
    }
    public static Computer[] sortComputer(Computer[] computers) {
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers.length - 1; j++){
                if (true) {
                    swap(computers, j);
                }
            }
        }
        return computers;
    }
    public static void main(String[] args) {

    }
}
