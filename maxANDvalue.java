//fins the maximum AND value of two numbers in an array and also finds the two numbers that give the maximum AND value
public class maxANDvalue {
    public static void main(String[] args) {
        int[] arr = {4, 8, 12, 16, 20};
        int maxAND = findMaxAND(arr);
        System.out.println("Maximum AND value: " + maxAND);
    }

    public static int findMaxAND(int[] arr) {
        int maxAND = 0;
        int num1 = 0, num2 = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentAND = arr[i] & arr[j];
                if (currentAND > maxAND) {
                    maxAND = currentAND;
                    num1 = arr[i];
                    num2 = arr[j];
                }
            }
        }

        System.out.println("Numbers giving maximum AND value: " + num1 + " and " + num2);
        return maxAND;
    }
}

/* just to find the maximum AND value:

public class maxANDvalue {
    public static void main(String[] args) {
        int[] arr = {4, 8, 12, 16};
        int maxAND = findMaxAND(arr);
        System.out.println("Maximum AND value: " + maxAND);

    }

    public static int findMaxAND(int[] arr) {
        int maxAND = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int andValue = arr[i] & arr[j];
                if (andValue > maxAND) {
                    maxAND = andValue;
                }
            }
        }
        return maxAND;
    }
}
     */