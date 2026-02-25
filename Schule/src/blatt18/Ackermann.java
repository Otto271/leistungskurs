package blatt18;

public class Ackermann {
    public static int ackermann(int x, int y) {
        if (x == 0) {
            return y + 1;
        } else if (y == 0) {
            return ackermann(x - 1, 1);
        } else {
            return ackermann(x - 1,ackermann(x, y - 1));
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(ackermann(4,2));
        long end = System.currentTimeMillis();
        long dur = end - start;
        System.out.println(dur + " Milliseconds");
        System.out.println(dur/1000 + " Seconds");
        // 1/3 = 1ms, 2/1 = 0ms, 2/4 = 4ms, 3/8 = 5ms, 3/14 = 19s, 4/1 = 4s, 4/2 =
    }
}
