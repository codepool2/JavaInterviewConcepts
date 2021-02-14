package codingninjas.queues;

public class QueueUsingArray {

    int[] elements;
    int size;
    int first = -1;
    int rear = -1;

    public QueueUsingArray(int size) {

        elements = new int[size];
        this.size = size;

    }

    public void enqueue(int element) {

        if (elements.length == 0) {

            elements[0] = element;
            first++;
            rear++;

        } else {

            elements[rear++] = element;
        }
    }

    public int dequeue() {

        if (first < 0 || first > rear) {

            throw new RuntimeException("length is 0");

        }

        int returnvalue = elements[first];

        first++;

        return first;
    }
}
