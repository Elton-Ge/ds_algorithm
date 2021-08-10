package com.elton.ds_algorithm.queue;

/**
 * @Auther: Elton Ge
 * @Date: 27/7/21
 * @Description: com.elton.ds_algorithm.queue
 * @version: 1.0
 */
public class ArrayQueue {
    public static void main(String[] args) {
//        CreatArrayQueue creatArrayQueue = new CreatArrayQueue(3);
//        creatArrayQueue.addQueue(1);
//        creatArrayQueue.addQueue(2);
//        creatArrayQueue.addQueue(3);
//        System.out.println(creatArrayQueue.getQueue());
//        System.out.println(creatArrayQueue.getQueue());
//        System.out.println(creatArrayQueue.getQueue());
//        creatArrayQueue.addQueue(4);
//        creatArrayQueue.showQueue();
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        circleArrayQueue.addQueue(1);
        circleArrayQueue.addQueue(2);
        circleArrayQueue.addQueue(3);
        System.out.println(circleArrayQueue.getQueue());
        circleArrayQueue.showQueue();
//        System.out.println(circleArrayQueue.getQueue());
//        System.out.println(circleArrayQueue.getQueue());
        circleArrayQueue.addQueue(4);
        circleArrayQueue.showQueue();

        System.out.println(circleArrayQueue.getQueue());
        circleArrayQueue.showQueue();

        circleArrayQueue.addQueue(5);
        circleArrayQueue.showQueue();
        System.out.println(circleArrayQueue.getQueue());
        circleArrayQueue.showQueue();

        circleArrayQueue.addQueue(5);
        circleArrayQueue.showQueue();
//        System.out.println(circleArrayQueue.getQueue());
    }
}

class CreatArrayQueue {
    private int[] array;
    private int maxSize;
    private int front;
    private int rear;

    public CreatArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.array = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        rear++;
        array[rear] = num;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("sorry, queue is empty");
        }
        front++;
        return array[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t", array[i]);
        }
        System.out.println();
    }

    public int showHeadOfQueue() {
        if (isEmpty()) {
            throw new RuntimeException("sorry, queue is empty");
        }
        return array[front + 1];
    }
}

class CreatArrayQueue2 {
    private int[] array;
    private int maxSize;
    private int front;
    private int rear;

    public CreatArrayQueue2(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.array = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        array[rear] = num;
        rear++;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("sorry, queue is empty");
        }
        int n = array[front];
        this.front++;
        return n;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t", array[i]);
        }
        System.out.println();
    }

    public int showHeadOfQueue() {
        if (isEmpty()) {
            throw new RuntimeException("sorry, queue is empty");
        }
        return array[this.front];
    }
}

class CircleArrayQueue {
    private int[] array;
    private int maxSize;
    private int front;
    private int rear;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.array = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        array[rear] = num;
        rear = (rear + 1) % maxSize;

    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("sorry, queue is empty");
        }
        int n = array[front];
        front = (front + 1) % maxSize;
        return n;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        for (int i = front; i < front + (rear - front + maxSize) % maxSize; i++) {
            System.out.printf("array[%d]=%d\t", i % maxSize, array[i % maxSize]);
        }
        System.out.println();
    }

    public int showHeadOfQueue() {
        if (isEmpty()) {
            throw new RuntimeException("sorry, queue is empty");
        }
        return array[this.front];
    }
}