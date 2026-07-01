// public class checkSubstring {
//     public static void main(String[] args) {
//         String str = "Hello, World!";
//         String substr = "World";

//         boolean isSubstring = checkSubstring(str, substr);

//         if (isSubstring) {
//             System.out.println("\"" + substr + "\" is a substring of \"" + str + "\".");
//         } else {
//             System.out.println("\"" + substr + "\" is not a substring of \"" + str + "\".");
//         }
//     }

//     public static boolean checkSubstring(String str, String substr) {
//         return str.contains(substr); // Check if str contains substr
//     }
// }
// Java program to check if a string is substring of other
// using nested loops


// class GfG {
    
//     // Function to find if pat is a substring of txt
//     static int findSubstring(String txt, String pat) {
//         int n = txt.length();
//         int m = pat.length();

//         // Iterate through txt
//         for (int i = 0; i <= n - m; i++) {//n-m cause if pat is longer than txt, we can stop searching

//             // Check for substring match
//             int j;
//             for (j = 0; j < m; j++) {

//                 // Mismatch found
//                 if (txt.charAt(i + j) != pat.charAt(j)) {
//                     break;
//                 }
//             }

//             // If we completed the inner loop, we found a match
//             if (j == m) {

//                 // Return starting index
//                 return i;
//             }
//         }

//         // No match found
//         return -1;
//     }

//     public static void main(String[] args) {
//         String txt = "geeksforgeeks";
//         String pat = "eks";
//         System.out.println(findSubstring(txt, pat));

//     }
// }

//check if a string is substring of other without using inbuilt functions
public class checkSubstring {
    public static void main(String[] args) {
        String str = "Hello, World!";
        String substr = "World";
        boolean isSubstring = checkSubstring(str, substr);
        if (isSubstring) {
            System.out.println("\"" + substr + "\" is a substring of \"" + str + "\".");
        } else {
            System.out.println("\"" + substr + "\" is not a substring of \"" + str + "\".");
        }
    }

    public static boolean checkSubstring(String str, String substr) {
        int n = str.length();
        int m = substr.length();

        if (m > n) {
            return false;
        }

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (str.charAt(i + j) != substr.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }
}