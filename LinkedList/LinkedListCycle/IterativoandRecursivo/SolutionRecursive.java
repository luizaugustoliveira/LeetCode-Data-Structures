package LinkedListCycle.IterativoandRecursivo;

import java.util.HashSet;
import java.util.Set;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class SolutionRecursive {
  public boolean hasCycle(ListNode head) {
      // Usamos um HashSet para armazenar os nós já visitados
      Set<ListNode> visitedNodes = new HashSet<>();
      return hasCycle(head, visitedNodes);
  }
  
  private boolean hasCycle(ListNode head, Set<ListNode> visitedNodes) {
      // Caso base: se o nó for nulo, não há ciclo
      if (head == null) {
          return false;
      }
      
      // Se já visitamos este nó, então há um ciclo
      if (visitedNodes.contains(head)) {
          return true;
      }
      
      // Adicionamos este nó aos nós visitados
      visitedNodes.add(head);
      
      // Continuamos a recursão com o próximo nó
      return hasCycle(head.next, visitedNodes);
  }
}

