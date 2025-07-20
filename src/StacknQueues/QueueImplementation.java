package StacknQueues;

class QueueUsingArrays {
    int capacity = 4;
    int[] queue = new int[capacity];
    int front = 0;
    int rear = -1;
    int size = 0;

    void enqueue(int x){
        if (size == capacity) System.out.print("queue overflow");
        rear = (rear + 1) % capacity;
        queue[rear] = x;
        size++;
    }

    void dequeue(){
        if (size == 0) System.out.print("queue underflow");
        front = (front + 1) % capacity;
        size--;

    }

    int peek(){
        if (size == 0) System.out.print("queue underflow");
        return queue[front];
    }
}

class QueueUsingLL {
    private class Node{
        int data;
        Node next;

        Node(int data1){
            this.data = data1;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    void enqueue(int x){
        Node temp = new Node(x);
        if(rear == null) {
            front = rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    void dequeue(){
        if(front == null) System.out.print("underflow");
        else {
            front = front.next;
        }
    }

    int peek(){
        return front.data;
    }
}

public class QueueImplementation {
    public static void main(String[] args) {

    }
}
