package LinkedList.MergeTwoSortedLists.Recursivo;

public class Main {
  public static void main(String[] args) {
      // Cria a primeira lista ligada: 1 -> 2 -> 4
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(4);

      // Cria a segunda lista ligada: 1 -> 3 -> 4
      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(3);
      l2.next.next = new ListNode(4);

      // Cria um objeto da classe Solution e mescla as duas listas
      Solution solution = new Solution();
      ListNode mergedList = solution.mergeTwoLists(l1, l2);

      // Imprime a lista mesclada
      printList(mergedList);
  }

  // Método auxiliar para imprimir uma lista ligada
  public static void printList(ListNode node) {
      while (node != null) {
          System.out.print(node.val + " ");
          node = node.next;
      }
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
          return l2;
      } else if (l2 == null) {
          return l1;
      } else if (l1.val <= l2.val) {
          l1.next = mergeTwoLists(l1.next, l2);
          return l1;
      } else {
          l2.next = mergeTwoLists(l1, l2.next);
          return l2;
      }
  }
}

