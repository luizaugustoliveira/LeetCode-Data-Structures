class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // Chama a função recursiva passando o carry inicial como 0
      return addTwoNumbersRecursive(l1, l2, 0);
  }

  private ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2, int carry) {
      // Caso base: se l1, l2 e carry forem nulos, a recursão termina
      if (l1 == null && l2 == null && carry == 0) {
          return null;
      }

      int sum = carry; // Começa a soma com o carry
      // Se l1 não é nulo, adiciona seu valor à soma e avança para o próximo nó
      if (l1 != null) {
          sum += l1.val;
          l1 = l1.next;
      }

      // Se l2 não é nulo, adiciona seu valor à soma e avança para o próximo nó
      if (l2 != null) {
          sum += l2.val;
          l2 = l2.next;
      }

      // Cria um novo nó com o valor de sum mod 10
      ListNode result = new ListNode(sum % 10);

      // Recursivamente calcula o próximo nó, passando l1, l2 e o novo carry
      result.next = addTwoNumbersRecursive(l1, l2, sum / 10);

      // Retorna o nó atual da lista resultante
      return result;
  }
}

