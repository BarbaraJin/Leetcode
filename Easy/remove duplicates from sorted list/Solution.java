/*Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
        	return null;
        }
        ListNode pre = head;
        ListNode post = head.next;
        while(post != null){
        	if(post.val != pre.val){
        		pre.next = post;
	        	pre = pre.next;
	        }
	        else if(post.next == null){
	        	pre.next = null;
	        }
	        post = post.next;
        }
        return head;
    }
}