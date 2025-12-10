package blatt13;

public class PenAndPaper {
    public static int wuerfel(int n, int m) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += blatt13.Zufall.zufallGanz(1, m);
        }
        return sum;
    }
    public static boolean check(int m, boolean vorteil, boolean nachteil) {
        int sum = wuerfel(1, 20);
        if (vorteil) {
            int wuerfel = wuerfel(1, 20);
            int wuerfel2 = wuerfel(1, 20);
            if (wuerfel > wuerfel2) {
                if (wuerfel == 20) {
                    System.out.println("kritischer Treffer");
                    return true;
                } else if (wuerfel == 1) {
                    System.out.println("kritischer Fehlschlag");
                    return false;
                } else if (wuerfel >= m) {
                    return true;
                }
                return false;
            } else {
                if (wuerfel2 == 20) {
                    System.out.println("kritischer Treffer");
                    return true;
                } else if (wuerfel2 == 1) {
                    System.out.println("kritischer Fehlschlag");
                    return false;
                } else if (wuerfel2 >= m) {
                    return true;
                }
                return false;
            }
        } else if (nachteil) {
            int wuerfel = wuerfel(1, 20);
            int wuerfel2 = wuerfel(1, 20);
            if (wuerfel < wuerfel2) {
                if (wuerfel == 20) {
                    System.out.println("kritischer Treffer");
                    return true;
                } else if (wuerfel == 1) {
                    System.out.println("kritischer Fehlschlag");
                    return false;
                } else if (wuerfel >= m) {
                    return true;
                }
                return false;
            } else {
                if (wuerfel2 == 20) {
                    System.out.println("kritischer Treffer");
                    return true;
                } else if (wuerfel2 == 1) {
                    System.out.println("kritischer Fehlschlag");
                    return false;
                } else if (wuerfel2 >= m) {
                    return true;
                }
                return false;
            }
        }
        if (sum == 20) {
            System.out.println("kritischer Treffer");
            return true;
        } else if (sum == 1) {
            System.out.println("kritischer Fehlschlag");
            return false;
        } else if (sum >= m) {
            return true;
        }
        return false;
    }
    public static int angriff(int menge, int wuerfel, boolean vorteil, boolean nachteil, int bonus, int rüstung, int treffer) {
        int schaden;
        if (check(treffer, vorteil, nachteil)) {
            schaden = wuerfel(menge, wuerfel);
            if (check(rüstung, vorteil, nachteil)) {
                schaden += bonus;
            }
            return schaden;
        }
        return -1;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int lebenA = 70;
            int lebenB = 42;
            int rüstungA = 14;
            int rüstungB = 10;
            int bonusA = 1;
            int bonusB = 2;
            boolean vorteilB = true;
            boolean nachteilA = true;
            int länge = 3;
            while (true) {
                lebenA -= angriff(1, 6, vorteilB, false, bonusB, rüstungA, 12);
                if (lebenA <= 0) {
                    System.out.println("Bard");
                    break;
                }
                lebenB -= angriff(1, 8, false, nachteilA, bonusA, rüstungB, 12);
                if (lebenB <= 0) {
                    System.out.println("Barbar");
                    break;
                }
                lebenB -= wuerfel(1, 10);
                länge--;
                if (länge == 0) {
                    vorteilB = false;
                    nachteilA = false;
                }
            }
        }
    }
}
