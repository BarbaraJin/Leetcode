
/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode answer;
    	ListNode cur1 = l1;
    	ListNode cur2 = l2;
    	if(cur1 == null || cur2==null){
    		if(cur1 == null){
    			return cur2;
    		}
    		else{
    			return cur1;
    		}
    	}


    	int curValue;
    	if(cur1.val<=cur2.val){
    		curValue = cur1.val;
    		cur1 = cur1.next;
    	}
    	else{
    		curValue = cur2.val;
    		cur2=cur2.next;
    	}
        answer = new ListNode(curValue);
        ListNode temAnswer = answer;
        while(cur1!=null||cur2!=null){
        	if(cur1 == null){
        		curValue = cur2.val;
        		cur2 = cur2.next;
        	}
        	else if(cur2 == null){
        		curValue = cur1.val;
        		cur1 = cur1.next;
        	}
        	else{
        		if(cur1.val<=cur2.val){
		    		curValue = cur1.val;
		    		cur1 = cur1.next;
		    	}
		    	else{
		    		curValue = cur2.val;
		    		cur2=cur2.next;
		    	}
        	}
        	temAnswer.next = new ListNode(curValue);
        	temAnswer = temAnswer.next;
        }
        return answer;
    }
}