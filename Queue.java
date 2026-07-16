public class Queue {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    private Node front, rear;
    private int size;

    public QueueusingLL() {
        front = rear = null;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // If the queue becomes empty
        }
        size--;
        return data;
    }

    // Display the queue
    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Get the size of the queue
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueusingLL queue = new QueueusingLL();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("Queue after enqueuing 10, 20, 30:");
        queue.display();
        
        System.out.println("Dequeued: " + queue.dequeue());
        
        System.out.println("Queue after dequeuing:");
        queue.display();
        
        System.out.println("Current size of the queue: " + queue.getSize());
    }
}
