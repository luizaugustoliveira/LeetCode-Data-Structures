package LinkedListCycleII;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class Solution {
  public ListNode detectCycle(ListNode head) {
      // Create two pointers
      ListNode slow = head; // This will move one step at a time
      ListNode fast = head; // This will move two steps at a time
      
      // This loop will break when slow and fast meet
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          
          if (slow == fast) { // Cycle detected
              ListNode slow2 = head; // Create a new pointer
              
              // Find the node where the cycle begins
              while (slow != slow2) {
                  slow = slow.next;
                  slow2 = slow2.next;
              }
              return slow;
          }
      }
      
      return null; // No cycle found
  }
}

