public class Main {
  public static void main(String[] args) {
      // Criação de nós para o primeiro caso de teste
      ListNode node1 = new ListNode(1);
      ListNode node2 = new ListNode(1);
      ListNode node3 = new ListNode(2);
      
      // Ligação dos nós
      node1.next = node2;
      node2.next = node3;

      // Criação de nós para o segundo caso de teste
      ListNode node4 = new ListNode(1);
      ListNode node5 = new ListNode(1);
      ListNode node6 = new ListNode(2);
      ListNode node7 = new ListNode(3);
      ListNode node8 = new ListNode(3);

      // Ligação dos nós
      node4.next = node5;
      node5.next = node6;
      node6.next = node7;
      node7.next = node8;

      // Instanciação da classe Solution
      Solution solution = new Solution();

      System.out.println("Primeiro caso de teste:");
      printList(node1);
      ListNode result1 = solution.deleteDuplicates(node1);
      System.out.println("Após a remoção de duplicatas:");
      printList(result1);

      System.out.println("\nSegundo caso de teste:");
      printList(node4);
      ListNode result2 = solution.deleteDuplicates(node4);
      System.out.println("Após a remoção de duplicatas:");
      printList(result2);
  }

  public static void printList(ListNode node) {
      while (node != null) {
          System.out.print(node.val + " -> ");
          node = node.next;
      }
      System.out.println("null");
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
      public ListNode deleteDuplicates(ListNode head) {
          // Condição base: se a lista estiver vazia ou se o próximo nó for null
          if (head == null || head.next == null) {
              return head;
          }
          // Chama a função recursiva para o restante da lista
          head.next = deleteDuplicates(head.next);

          // Verifica se o valor do nó atual é igual ao valor do próximo nó
          if (head.val == head.next.val) {
              // Se for, retorna o próximo nó, efetivamente ignorando o nó atual (deletando-o)
              return head.next;
          } else {
              // Se não for, retorna o nó atual
              return head;
          }
      }
  }
}
