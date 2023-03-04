package LinkedList.Medium;

import java.util.*;

import javax.swing.text.TabExpander;

import print.ListNode;
import print.Print;

public class DesignLinkedList707 {

    static class MyLinkedList {
        ListNode node = null;

        // public class ListNode {
        //     int val;
        //     ListNode next;

        //     ListNode() {
        //     }

        //     ListNode(int val) {
        //         this.val = val;
        //     }

        //     ListNode(int val, ListNode next) {
        //         this.val = val;
        //         this.next = next;
        //     }
        // }

        public MyLinkedList() {
        }

        public int get(int index) {
            ListNode answer = getNodeAtInd(index);
            return answer == null ? -1 : answer.val;
        }

        public void addAtHead(int val) {
            ListNode head = new ListNode(val);
            head.next = node;
            node = head;
        }

        public void addAtTail(int val) {
            ListNode tail = node;
            if (tail == null) {
                node = new ListNode(val);
                return;
            }
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new ListNode(val);
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
            } else {
                ListNode prev = getNodeAtInd(index - 1);
                if (prev != null) {
                    ListNode next = prev.next;
                    prev.next = new ListNode(val);
                    prev.next.next = next;
                }
            }

        }

        public void deleteAtIndex(int index) {
            if (index == 0) {
                node = node.next;
            } else {
                ListNode prev = getNodeAtInd(index - 1);
                if (prev != null) {
                    ListNode cur = prev.next;
                    if (cur != null) {
                        prev.next = cur.next;
                    }
                }
            }

        }

        private ListNode getNodeAtInd(int index) {
            ListNode answer = node;
            for (int i = 1; i <= index && answer != null; i++) {
                answer = answer.next;
            }
            return answer;
        }
    }

    public static void main(String[] args) throws Exception {
        Date start = new Date();
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        Print.print(obj.get(1));
        obj.deleteAtIndex(0);
        Print.print(obj.get(0));

        Date end = new Date();
        // printListNode(obj.node);
        Print.printRunTime(start, end);
    }
}
