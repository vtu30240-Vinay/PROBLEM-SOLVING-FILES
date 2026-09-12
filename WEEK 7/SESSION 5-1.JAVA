import java.util.*;

class Printer {

    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Printer printer = new Printer();

        int n = sc.nextInt();

        Integer[] intArray = new Integer[n];

        for (int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();
        }

        n = sc.nextInt();

        String[] stringArray = new String[n];

        for (int i = 0; i < n; i++) {
            stringArray[i] = sc.next();
        }

        printer.printArray(intArray);
        printer.printArray(stringArray);

        sc.close();
    }
}

INPUT;
3
1
2
3
2
Hello
World
OUTPUT;
1
2
3
Hello
World
