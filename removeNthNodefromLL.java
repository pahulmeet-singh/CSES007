public class removeNthNodefromLL {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        // Use two pointers to find the nth node from the end
        Node fast = head;
        Node slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                // n is greater than the length of the list
                return head;
            }
            fast = fast.next;
        }

        // If fast is null, it means we need to remove the first node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return head;
    }
}