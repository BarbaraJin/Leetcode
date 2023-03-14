package LinkedList.Medium;

import java.util.*;

import print.Print;

public class DesignDoubleLinkedList707 {

    static class MyLinkedList {
        ListNode start = null;
        ListNode last = null;
        int length = 0;

        public class ListNode {
            int val;
            ListNode prev;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode prev, ListNode next) {
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }

        public MyLinkedList() {
        }

        public int get(int index) {
            ListNode answer = getNodeAtInd(index);
            return answer == null ? -1 : answer.val;
        }

        public void addAtHead(int val) {
            ListNode head = new ListNode(val);
            head.next = start;
            if (start != null) {
                start.prev = head;
            }
            start = head;
            if (length == 0) {
                last = start;
            }
            length++;
        }

        public void addAtTail(int val) {
            ListNode tail = new ListNode(val);
            tail.prev = last;
            if (last != null) {
                last.next = tail;
            }
            last = tail;
            if (length == 0) {
                start = last;
            }
            length++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == length) {
                addAtTail(val);
            } else {
                ListNode prev = getNodeAtInd(index - 1);
                if (prev != null) {
                    ListNode next = prev.next;
                    ListNode node = new ListNode(val);
                    prev.next = node;
                    node.prev = prev;
                    node.next = next;
                    if (next != null) {
                        next.prev = node;
                    }
                    length++;
                }
            }

        }

        public void deleteAtIndex(int index) {
            if (index >= length) {
                return;
            }
            if (index == 0) {
                ListNode node = start.next;
                start = node;
                if (node != null) {
                    node.prev = null;
                }
                length--;
            }else if (index == length - 1) {
                ListNode node = last.prev;
                last = node;
                if (node != null) {
                    node.next = null;
                }
                length--;
            } else {
                ListNode prev = getNodeAtInd(index - 1);
                if (prev != null) {
                    ListNode toDelete = prev.next;
                    if (toDelete != null) {
                        ListNode node = toDelete.next;
                        prev.next = node;
                        if (node != null) {
                            node.prev = prev;
                        }
                        length--;
                    }
                }
            }

        }

        private ListNode getNodeAtInd(int index) {
            ListNode answer = null;
            if (index <= length / 2) {
                answer = start;
                for (int i = 1; i <= index && answer != null; i++) {
                    answer = answer.next;
                }
            } else if (index < length) {
                answer = last;
                for (int i = length - 1; i > index && answer != null; i--) {
                    answer = answer.prev;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) throws Exception {
        Date start = new Date();
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        obj.deleteAtIndex(1);
        obj.deleteAtIndex(0);
        Print.print(obj.get(0));

        Date end = new Date();
        printListNodeFromStart(obj.start);
        printListNodeFromEnd(obj.last);
        Print.print(obj.length);
        Print.printRunTime(start, end);
    }

    public static void printListNodeFromStart(MyLinkedList.ListNode node) {
        if (node == null) {
            Print.print("null");
        }
        StringJoiner print = new StringJoiner("->");
        while (node != null) {
            print.add(String.valueOf(node.val));
            node = node.next;
        }
        System.out.println(print.toString());
    }

    public static void printListNodeFromEnd(MyLinkedList.ListNode node) {
        if (node == null) {
            Print.print("null");
        }
        StringJoiner print = new StringJoiner("->");
        while (node != null) {
            print.add(String.valueOf(node.val));
            node = node.prev;
        }
        System.out.println(print.toString());
    }
}
