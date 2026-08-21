```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of lines
        int n = sc.nextInt();

        // Store all lines
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // Number of elements in this line
            int d = sc.nextInt();

            ArrayList<Integer> line = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                line.add(sc.nextInt());
            }

            list.add(line);
        }

        // Number of queries
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {

            // x = line number, y = position
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                // ArrayList uses 0-based index
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
```

### Key idea

For input:

```text
5 41 77 74 22 44
```

The line is stored as:

```text
[41, 77, 74, 22, 44]
```

So query:

```text
1 3
```

means **line 1, position 3** → `74`.

Since Java `ArrayList` uses **0-based indexing**, we use:

```java
list.get(x - 1).get(y - 1)
```

If the requested line or position doesn't exist, we print:

```text
ERROR!
```
