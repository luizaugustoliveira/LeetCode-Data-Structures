package LinkedListCycle.IterativoandRecursivo;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class Solution {
  public boolean hasCycle(ListNode head) {
      // Cria dois ponteiros, um se moverá mais rápido que o outro
      ListNode slow = head;
      ListNode fast = head;
      
      // O loop continua até que o ponteiro rápido atinja o final da lista vinculada
      while (fast != null && fast.next != null) {
          // O ponteiro lento se move um passo de cada vez
          slow = slow.next;
          // O ponteiro rápido se move dois passos de cada vez
          fast = fast.next.next;
          
          // Se os dois ponteiros se encontrarem, significa que há um ciclo na lista vinculada
          if (slow == fast) {
              return true;
          }
      }
      
      // Se o ponteiro rápido atingir o final, isso significa que não há ciclo na lista vinculada
      return false;
  }
}
