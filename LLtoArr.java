public class LLtoArr {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static int[] linkedListToArray(Node head) {
        // First, count the number of nodes in the linked list
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Create an array of the appropriate size
        int[] arr = new int[count];

        // Fill the array with the linked list's data
        current = head;
        for (int i = 0; i < count; i++) {
            arr[i] = current.data;
            current = current.next;
        }

        return arr;
    }
}
