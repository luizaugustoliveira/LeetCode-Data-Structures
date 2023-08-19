package RemoveLinkedListElements.Iterativo;

public class Main {
  public static void main(String[] args) {
      // Cria uma instância da solução.
      Solution solution = new Solution();

      // Cria a lista ligada.
      ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

      // O valor a ser removido.
      int val = 6;

      // Chama o método removeElements e obtém o resultado.
      ListNode result = solution.removeElements(head, val);

      // Imprime o resultado.
      printList(result);
  }

  // Método para imprimir uma lista ligada.
  private static void printList(ListNode head) {
      // Enquanto a cabeça não é nula
      while(head != null) {
          // Imprime o valor da cabeça.
          System.out.print(head.val + " ");

          // Vá para o próximo nó.
          head = head.next;
      }
      // Imprime uma nova linha no final.
      System.out.println();
  }
}

