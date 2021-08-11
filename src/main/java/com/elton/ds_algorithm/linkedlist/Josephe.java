package com.elton.ds_algorithm.linkedlist;

import lombok.Getter;
import lombok.Setter;

public class Josephe {
  public static void main(String[] args) {
    CircledSingledLinkedList circledSingledLinkedList = new CircledSingledLinkedList();
    circledSingledLinkedList.addBoy(5);
    circledSingledLinkedList.showBoys();

    circledSingledLinkedList.countBoys(3, 2, 5);
  }
}

class CircledSingledLinkedList {
  private Boy first;

  public void addBoy(int no) {
    if (no < 1) {
      System.out.println("no must more than 1");
      return;
    }
    Boy curBoy = null;
    for (int i = 1; i <= no; i++) {
      Boy boy = new Boy(i);
      if (i == 1) {
        first = boy;
        first.setNext(first);
        //                curBoy = first;
      } else {
        curBoy.setNext(boy);
        boy.setNext(first);
      }
      curBoy = boy;
    }
  }

  public void showBoys() {
    if (first == null) {
      System.out.println("empty");
      return;
    }
    Boy curBoy = first;
    while (true) {
      System.out.printf("boy's ID is %d \n", curBoy.getNo());
      if (curBoy.getNext() == first) {
        break;
      }
      curBoy = curBoy.getNext();
    }
  }

  /**
   * @param startNo 起始
   * @param countNo 数几个
   * @param nums 总数量
   */
  public void countBoys(int startNo, int countNo, int nums) {
    if (first == null || startNo < 1 || startNo > nums || countNo > nums) {
      System.out.println("input error");
      return;
    }
    Boy helper = first;
    while (true) {
      if (helper.getNext() == first) {
        break;
      }
      helper = helper.getNext();
    }

    for (int j = 0; j < startNo - 1; j++) {
      first = first.getNext();
      helper = helper.getNext();
    }
    while (true) {
      if (helper == first) {
        break;
      }
      for (int i = 0; i < countNo - 1; i++) {
        first = first.getNext();
        helper = helper.getNext();
      }
      System.out.printf("boy %d will get out  \n", first.getNo());
      first = first.getNext();
      helper.setNext(first);
    }
    System.out.printf("last boy %d will get out  \n", first.getNo());
  }
}

@Setter
@Getter
class Boy {
  private int no;
  private Boy next;

  public Boy(int no) {
    this.no = no;
  }
}
