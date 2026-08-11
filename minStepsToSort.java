// Minimum Swaps to Sort an array (Using cycle detection)
import java.util.*;

class minStepsToSort {
    public int solution(int N, int arr[]) {
        Pair[] a = new Pair[N];

        for (int i = 0; i < N; i++) {
            a[i] = new Pair(arr[i], i);
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x.value, y.value));

        boolean[] visited = new boolean[N]; 
        int swaps = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i] || a[i].index == i)
                continue;

            int cycle = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = a[j].index;
                cycle++;
            }

            swaps += cycle - 1;
        }

        return swaps;
    }

    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
// return Math.abs(n/2);