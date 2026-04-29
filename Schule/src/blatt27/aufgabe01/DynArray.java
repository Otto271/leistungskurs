package blatt27.aufgabe01;

import java.util.Arrays;

public class DynArray {
    private int[] arr;

    public DynArray() {
        this.arr = null;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public boolean isEmpty() {
        if (arr == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return arr.length;
    }

    public int get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException(idx + " " + size());
        } else {
            return arr[idx];
        }
    }

    public boolean contains(int numb) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numb) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int numb) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numb) {
                return i;
            }
        }
        return -1;
    }

    public void add(int numb) {
        if (arr == null) {
            arr = new int[]{numb};
        } else  {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = numb;
        }
    }

    public void add(int numb, int idx) {
        if (arr == null) {
            if (idx == 0) {
                arr = new int[]{numb};
            } else {
                throw new ArrayIndexOutOfBoundsException(idx + " " + size());
            }
        } else {
            arr = Arrays.copyOf(arr, arr.length + 1);
            if (idx < 0 || idx > size()) {
                throw new ArrayIndexOutOfBoundsException(idx + " " + size());
            } else {
                for (int i = arr.length-1; i > idx; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[idx] = numb;
            }
        }
    }

    public void set(int idx, int numb) {
        arr[idx] = numb;
    }

    public int remove(int idx) {
        int a = arr[idx];
        arr[idx] = 0;
        for (int i = arr.length-1; i > idx; i--) {
            arr[i - 1] = arr[i];
        }
        return a;
    }

    public void clear() {
        arr = null;
    }
}
