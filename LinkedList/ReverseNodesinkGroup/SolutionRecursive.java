package ReverseNodesinkGroup;

class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
      this.val = val;
  }
}

class SolutionRecursive {
  public ListNode reverseKGroup(ListNode head, int k) {
      ListNode curr = head;
      int count = 0;
      
      // Conta o número de nós no grupo atual
      while (curr != null && count < k) {
          curr = curr.next;
          count++;
      }
      
      // Se houver k nós restantes, reverte-os
      if (count == k) {
          curr = reverseKGroup(curr, k);
          
          // Inverte os nós do grupo atual
          while (count-- > 0) {
              ListNode temp = head.next;
              head.next = curr;
              curr = head;
              head = temp;
          }
          
          head = curr;
      }
      
      return head;
  }
}

