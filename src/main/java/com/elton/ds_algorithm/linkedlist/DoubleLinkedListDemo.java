package com.elton.ds_algorithm.linkedlist;

import lombok.ToString;

/**
 * @Auther: Elton Ge
 * @Date: 5/8/21
 * @Description: com.elton.ds_algorithm.linkedlist
 * @version: 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 heroNode1 = new HeroNode2(1, "songjiang", "jishiyu");
        HeroNode2 heroNode2 = new HeroNode2(2, "wuyong", "zhiduoxing");
        HeroNode2 heroNode3 = new HeroNode2(3, "linchong", "baozitou");
        HeroNode2 heroNode4 = new HeroNode2(4, "linchong2", "baozitou2");
//        HeroNode heroNode1Edit = new HeroNode(4, "songjiang2", "songjiang2");
//        doubleLinkedList.addHeroNode(heroNode1);
//        doubleLinkedList.addHeroNode(heroNode1);
//        doubleLinkedList.addHeroNode(heroNode2);
//        doubleLinkedList.addHeroNode(heroNode3);
//        doubleLinkedList.addHeroNode(heroNode4);

        doubleLinkedList.addHeroNodeByOrder(heroNode4);
        doubleLinkedList.addHeroNodeByOrder(heroNode3);
        doubleLinkedList.addHeroNodeByOrder(heroNode2);
        doubleLinkedList.addHeroNodeByOrder(heroNode1);
        doubleLinkedList.showHeroNodes();
        HeroNode2 heroNode5 = new HeroNode2(3, "linchong3", "baozitou3");

//        doubleLinkedList.editHeroNode(heroNode5);
        
//        doubleLinkedList.deleteHeroNode(heroNode5);
//        doubleLinkedList.showHeroNodes();

    }
}

class DoubleLinkedList {
    private HeroNode2 headNode = new HeroNode2(0, "head", "head");

    public void showHeroNodes() {
        HeroNode2 temp = headNode;
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

    public void addHeroNode(HeroNode2 heroNode) {
        HeroNode2 temp = headNode;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }
            if (temp.next != null) {
                temp = temp.next;
            }
        }
    }
    public void addHeroNodeByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = headNode;
        HeroNode2 temp2;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            if (temp.next.no > heroNode.no) {       //bingo
                heroNode.next = temp.next;
                temp.next = heroNode;
                heroNode.pre=temp;
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


    public void editHeroNode(HeroNode2 heroNode) {
        HeroNode2 temp = headNode;
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

    public void deleteHeroNode(HeroNode2 heroNode) {
        HeroNode2 temp = headNode;
        if (temp.next == null) {
            System.out.println("list is empty");
            return;
        }
        while (true) {
            if (temp.next == null) {
                System.out.println("cannot find the targeted hero Node");
                break;
            }
            temp = temp.next;
            if (heroNode.no != temp.no) {
                continue;
            } else {
//                temp.next = temp.next.next;
                if (temp.next != null) {
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.pre;
                } else {
                    temp.pre.next = null;
                }
                break;
            }
        }
    }

}

//@ToString
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
