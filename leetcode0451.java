//problem: leetcode 451- sort characters by frequency. use the counting sort algorithm to sort the characters in a string based on their frequency of occurrence. The characters with higher frequency should come first in the sorted string. If two characters have the same frequency, they can appear in any order.
import java.util.HashMap;
import java.util.PriorityQueue;
public class leetcode0451 {
    public static void main(String[] args) {
        String s = "tree";
        String result = frequencySort(s);
        System.out.println(result);
    }
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
