import java.util.*;

class Result {
    public static int sherlockAndAnagrams(String s) {
    Map<String, Integer> freq = new HashMap<>();
    int n = s.length();

    for (int len = 1; len < n; len++) {
        for (int start = 0; start + len <= n; start++) {
            char[] chars = s.substring(start, start + len).toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
    }

    int pairs = 0;
    for (int count : freq.values()) {
        pairs += count * (count - 1) / 2;
    }

    return pairs;
}
}