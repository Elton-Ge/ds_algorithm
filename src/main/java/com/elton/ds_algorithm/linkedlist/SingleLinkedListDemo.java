package com.elton.ds_algorithm.linkedlist;

import lombok.ToString;

import java.util.Stack;

/**
 * @Auther: Elton Ge
 * @Date: 27/7/21
 * @Description: com.elton.ds_algorithm.linkedlist
 * @version: 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "songjiang", "jishiyu");
        HeroNode heroNode2 = new HeroNode(2, "wuyong", "zhiduoxing");
        HeroNode heroNode3 = new HeroNode(3, "linchong", "baozitou");
        HeroNode heroNode4 = new HeroNode(4, "linchong2", "baozitou2");
//        HeroNode heroNode1Edit = new HeroNode(4, "songjiang2", "songjiang2");
//        singleLinkedList.addHeroNode(heroNode1);
        singleLinkedList.addHeroNodeByOrder(heroNode1);
        singleLinkedList.addHeroNodeByOrder(heroNode3);
        singleLinkedList.addHeroNodeByOrder(heroNode2);
        singleLinkedList.addHeroNodeByOrder(heroNode4);
//        singleLinkedList.generateReversedSingleLinkedList();
//        System.out.println(singleLinkedList.getNodeNumber());
//        System.out.println(singleLinkedList.findHeroNodeByIndex(4));
//        singleLinkedList.deleteHeroNode(heroNode3);
//        singleLinkedList.deleteHeroNode(heroNode1);
//        singleLinkedList.deleteHeroNode(heroNode2);
//        singleLinkedList.editHeroNode(heroNode1Edit);
//        singleLinkedList.addHeroNodeByOrder(heroNode3);
//        singleLinkedList.showHeroNodes();
        singleLinkedList.reversePrint();
    }
}

class SingleLinkedList {
    private HeroNode headNode = new HeroNode(0, "head", "head");
    private HeroNode reversedHeadNode = new HeroNode(0, "reverseHead", "head");

    public void reversePrint() {
        if (headNode.next == null) {
            System.out.println("list is empty");
            return;
        }
        HeroNode current = headNode.next;
        Stack<HeroNode> heroNodes = new Stack<HeroNode>();
        while (current != null) {
            heroNodes.push(current);
            current = current.next;
        }
        while (!heroNodes.isEmpty()) {
            System.out.println(heroNodes.pop());
        }
    }

    public void generateReversedSingleLinkedList() {
        HeroNode cur = headNode.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = reversedHeadNode.next;
            reversedHeadNode.next = cur;
            cur = next;
        }
        headNode.next = reversedHeadNode.next;
    }

    public int getNodeNumber() {
        HeroNode temp = headNode;
        int count = 0;
        if (temp.next == null) {
            return 0;
        }
        while (true) {
            if (temp.next != null) {
                count++;
                temp = temp.next;
                continue;
            }
            if (temp.next == null) {
                break;
            }
        }
        return count;

    }

    public HeroNode findHeroNodeByIndex(int k) {
        HeroNode temp = headNode;
        int totalLength = getNodeNumber();
//        System.out.println(totalLength);
        if (temp.next == null) {
            return null;
        }
        if (k <= 0 || k > totalLength) {
            return null;
        }
        for (int i = 0; i < totalLength - k + 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void addHeroNode(HeroNode heroNode) {
        HeroNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            if (temp.next != null) {
                temp = temp.next;
            }
        }
    }

    public void addHeroNodeByOrder(HeroNode heroNode) {
        HeroNode temp = headNode;
        HeroNode temp2;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            if (temp.next.no > heroNode.no) {       //bingo
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            } else if (temp.next.no < heroNode.no) {
                temp = temp.next;
            } else {
//                throw new RuntimeException();
                System.out.println(heroNode.no + "has existed");
                break;
            }
        }

    }

    public void editHeroNode(HeroNode heroNode) {
        HeroNode temp = headNode;
        if (temp.next == null) {
            System.out.println("list is empty");
            return;
        }
        while (true) {
            if (temp.next == null) {
                System.out.println("cannot find the targeted hero Node");
                break;
            }
            if (temp.next.no != heroNode.no) {
                temp = temp.next;
            } else {
                temp.next.name = heroNode.name;
                temp.next.nickname = heroNode.nickname;
                break;
            }
        }

    }

    public void deleteHeroNode(HeroNode heroNode) {
        HeroNode temp = headNode;
        if (temp.next == null) {
            System.out.println("list is empty");
            return;
        }
        while (true) {
            if (temp.next == null) {
                System.out.println("cannot find the targeted hero Node");
                break;
            }
            if (heroNode.no != temp.next.no) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
                break;
            }
        }
    }

    public void showHeroNodes() {
        HeroNode temp = headNode;
        //justify whether is empty
        if (temp.next == null) {
            System.out.println("list is empty");
            return;
        }
        while (true) {
            System.out.println(temp.next);
            temp = temp.next;
            if (temp.next == null) {
                break;
            }
        }
    }

}


@ToString
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
}