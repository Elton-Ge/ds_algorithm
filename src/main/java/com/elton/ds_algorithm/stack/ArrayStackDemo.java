package com.elton.ds_algorithm.stack;

public class ArrayStackDemo {
  public static void main(String[] args) {
    ArrayStack arrayStack = new ArrayStack(3);
    arrayStack.push(10);
    arrayStack.push(3);
    arrayStack.push(4);
    arrayStack.showStack();
    int i = arrayStack.pop();
    System.out.println(i);
    //        arrayStack.showStack();
    arrayStack.push(99);
    arrayStack.showStack();
  }
}

class ArrayStack {
  private int maxSize;
  private int[] stack;
  private int top;

  public ArrayStack() {}

  public ArrayStack(int maxSize) {
    this.maxSize = maxSize;
    this.stack = new int[maxSize];
    this.top = -1;
  }

  public int peek() {
    return stack[top];
  }

  public boolean isFull() {
    return top == maxSize - 1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public void push(int data) {
    if (isFull()) {
      System.out.println("isFull");
      return;
    }
    top++;
    stack[top] = data;
  }

  public int pop() {
    if (isEmpty()) {
      //            System.out.println("isEmpty");
      //            return -1;
      throw new RuntimeException("isEmpty");
    }
    int data = stack[top];
    top--;
    return data;
  }

  public void showStack() {
    if (isEmpty()) {
      System.out.println("isEmpty");
      return;
    }
    // start from top
    for (int i = top; i >= 0; i--) {
      //            System.out.println(stack[i]);
      System.out.printf("stack[%d]=%d \n", i, stack[i]);
    }
  }
}
