class ListNode {
  int val; // Valor do nó atual
  ListNode next; // Referência ao próximo nó na lista

  ListNode() {}

  ListNode(int val) { this.val = val; } // Construtor para criar um nó com um valor específico

  ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Construtor para criar um nó com valor e próximo nó especificados
}

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummyHead = new ListNode(0); // Cabeça de lista fictícia para facilitar a manipulação da lista resultante

      // Ponteiros para percorrer as duas listas
      ListNode p = l1, q = l2, current = dummyHead;

      int carry = 0; // Carry armazena a "sobra" ao somar dois dígitos

      // Enquanto houver elementos em qualquer uma das listas
      while (p != null || q != null) {
          int x = 0;
          // Se p não é nulo, obtemos seu valor
          if (p != null) {
              x = p.val;
              p = p.next;
          }

          int y = 0;
          // Se q não é nulo, obtemos seu valor
          if (q != null) {
              y = q.val;
              q = q.next;
          }

          // Calcula a soma de x, y e carry
          int sum = carry + x + y;
          carry = sum / 10; // Atualiza carry para a próxima iteração

          // Adiciona o novo nó com o valor da soma mod 10 à lista de resultados
          current.next = new ListNode(sum % 10);
          current = current.next; // Avança o ponteiro para a próxima posição
      }

      // Se houver carry restante após terminar a iteração, adiciona-o à lista de resultados
      if (carry > 0) {
          current.next = new ListNode(carry);
      }

      // Retorna a lista resultante, descartando o cabeçalho fictício
      return dummyHead.next;
  }
}

