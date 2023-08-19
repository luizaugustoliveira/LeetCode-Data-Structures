package PartitionList.Recursivo;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SolutionRecursive {
  public ListNode partition(ListNode head, int x) {
      if (head == null || head.next == null) {
          return head;
      }
      
      ListNode dummyNode = new ListNode(0, head);
      return partitionHelper(dummyNode, head, x);
  }

  private ListNode partitionHelper(ListNode prev, ListNode curr, int x) {
      if (curr == null) {
          return prev.next;
      }
      
      if (curr.val < x) {
          if (prev.next == curr) {
              return partitionHelper(curr, curr.next, x);
          } else {
              prev.next = curr.next;
              curr.next = prev.next.next;
              prev.next.next = curr;
          }
      }
      return partitionHelper(prev.next, curr.next, x);
  }
}

