import java.util.Stack;

public class QueueStack {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    private Stack<Node> stack1;
    private Stack<Node> stack2;

    public QueueStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);
        stack1.push(newNode);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack2.pop().data;
    }

    // Display the queue
    public void display() {
        for (Node node : stack1) {
            System.out.print(node.data + " -> ");
        }
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i).data + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display(); // Output: 1 -> 2 -> 3 -> null

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 1
        queue.display(); // Output: 2 -> 3 -> null

        queue.enqueue(4);
        queue.display(); // Output: 2 -> 3 -> 4 -> null
    }
}