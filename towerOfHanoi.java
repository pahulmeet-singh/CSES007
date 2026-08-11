public class towerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        char source = 'A'; // Source rod
        char destination = 'C'; // Destination rod
        char auxiliary = 'B'; // Auxiliary rod

        System.out.println("The sequence of moves involved in the Tower of Hanoi are:");
        solveTowerOfHanoi(n, source, destination, auxiliary);
    }

    public static void solveTowerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        solveTowerOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        solveTowerOfHanoi(n - 1, auxiliary, destination, source);
    }
}
