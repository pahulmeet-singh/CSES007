public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    int n = arr.size();
    d = d % n;
    List<Integer> result = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
        result.add(arr.get((i + d) % n));
    }

    return result;
}