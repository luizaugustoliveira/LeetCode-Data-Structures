package SortList.Iterativo;

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
      
      // Obtem o tamanho da lista
      int length = getLength(head);
      
      // Cria um nó fictício para ser o início da lista
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      
      // Divide a lista em sub-listas e realiza a mesclagem iterativamente
      for (int step = 1; step < length; step *= 2) {
          ListNode prev = dummy;
          ListNode curr = dummy.next;
          
          while (curr != null) {
              ListNode left = curr;
              ListNode right = split(left, step);
              curr = split(right, step);
              prev = merge(left, right, prev);
          }
      }
      
      return dummy.next;
  }
  
  // Retorna o tamanho da lista
  private int getLength(ListNode head) {
      int length = 0;
      ListNode curr = head;
      while (curr != null) {
          length++;
          curr = curr.next;
      }
      return length;
  }
  
  // Divide a lista em duas sub-listas com o tamanho especificado
  private ListNode split(ListNode head, int size) {
      if (head == null)
          return null;
      
      ListNode curr = head;
      for (int i = 1; i < size && curr.next != null; i++) {
          curr = curr.next;
      }
      
      ListNode right = curr.next;
      curr.next = null;
      return right;
  }
  
  // Mescla duas sub-listas ordenadas e retorna o último nó mesclado
  private ListNode merge(ListNode left, ListNode right, ListNode prev) {
      ListNode curr = prev;
      
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
      
      curr.next = (left != null) ? left : right;
      while (curr.next != null) {
          curr = curr.next;
      }
      
      return curr;
  }
}

