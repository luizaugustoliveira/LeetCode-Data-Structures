public class Main {
  public static void main(String[] args) {
      // Criação de nós
      ListNode node1 = new ListNode(4);
      ListNode node2 = new ListNode(5);
      ListNode node3 = new ListNode(1);
      ListNode node4 = new ListNode(9);

      // Ligação dos nós
      node1.next = node2;
      node2.next = node3;
      node3.next = node4;

      // Instanciação da classe Solution
      Solution solution = new Solution();

      System.out.println("Lista ligada antes da exclusão:");
      printList(node1);

      // Deletando um nó
      solution.deleteNode(node2); // Deleta o nó com valor 5

      System.out.println("\nLista ligada após a exclusão:");
      printList(node1);
  }

  public static void printList(ListNode node) {
      while (node != null) {
          System.out.print(node.val + " -> ");
          node = node.next;
      }
      System.out.print("null"); // Final da lista
  }

  /*
  * Definição para uma lista ligada.
  */
  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public static class Solution {
      public void deleteNode(ListNode node) {
          node.val = node.next.val;
          node.next = node.next.next;
      }
  }
}
