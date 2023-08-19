package SortList.Recursivo;

class ListNode {
  int val;
  ListNode next;
  
  ListNode(int val) {
      this.val = val;
  }
}

class Solution {
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null)
          return head;
      
      // Divide a lista em duas metades
      ListNode mid = getMid(head);
      ListNode left = head;
      ListNode right = mid.next;
      mid.next = null;
      
      // Recursivamente ordena as duas metades
      ListNode sortedLeft = sortList(left);
      ListNode sortedRight = sortList(right);
      
      // Combina as duas metades ordenadas
      return merge(sortedLeft, sortedRight);
  }
  
  // Encontra o nó do meio da lista
  private ListNode getMid(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      
      while (fast.next != null && fast.next.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }
      
      return slow;
  }
  
  // Mescla duas listas ordenadas e retorna a cabeça da lista mesclada
  private ListNode merge(ListNode left, ListNode right) {
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      
      while (left != null && right != null) {
          if (left.val < right.val) {
              curr.next = left;
              left = left.next;
          } else {
              curr.next = right;
              right = right.next;
          }
          curr = curr.next;
      }
      
      if (left != null)
          curr.next = left;
      if (right != null)
          curr.next = right;
      
      return dummy.next;
  }
}

