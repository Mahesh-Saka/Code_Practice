package DataStructure;

import java.util.ArrayList;

public class CircularQueue {

    int size;
    int front = -1, rear = -1;

    ArrayList<Integer> list = new ArrayList<>();

    CircularQueue(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueQueue(10);
    }

    void enqueQueue(int data) {
        if ((front == 0 || rear == size - 1) || (rear == (front - 1) / (size - 1)) {
            System.out.print("Queue is Full");
        } else if (front == -1) {
            front = 0;
            rear = 0;
            list.add(data);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            list.set(rear, data);
        } else {
            rear = rear + 1;
            if (front <= rear) {
                list.add(rear, data);
            } else {
                list.set(rear, data);
            }
        }
    }

    void deque() {

    }
}
