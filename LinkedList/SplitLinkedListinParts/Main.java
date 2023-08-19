package SplitLinkedListinParts;

// Definição da classe ListNode
class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
      this.val = val;
  }
}

class Solution {
  // Método para contar o tamanho da lista
  private int getListSize(ListNode head) {
      int count = 0;
      ListNode curr = head;
      while (curr != null) {
          count++;
          curr = curr.next;
      }
      return count;
  }

  public ListNode[] splitListToParts(ListNode head, int k) {
      int size = getListSize(head); // Obtém o tamanho da lista
      int quotient = size / k; // Quociente da divisão
      int remainder = size % k; // Resto da divisão
      ListNode[] result = new ListNode[k]; // Array para armazenar as listas resultantes
      ListNode curr = head;

      for (int i = 0; curr != null && i < k; i++) {
          result[i] = curr; // Inicializa cada elemento do array com o nó atual
          int partSize = quotient + (i < remainder ? 1 : 0); // Calcula o tamanho de cada parte

          // Percorre a lista até o final de cada parte
          for (int j = 1; j < partSize; j++) {
              curr = curr.next;
          }

          ListNode next = curr.next; // Salva o próximo nó após a parte atual
          curr.next = null; // Desconecta a parte atual do restante da lista
          curr = next; // Move para o próximo nó
      }

      return result;
  }

  public ListNode[] splitListToPartsRecursive(ListNode head, int k) {
      int size = getListSize(head); // Obtém o tamanho da lista
      int quotient = size / k; // Quociente da divisão
      int remainder = size % k; // Resto da divisão
      ListNode[] result = new ListNode[k]; // Array para armazenar as listas resultantes

      splitList(head, result, quotient, remainder, 0); // Chama o método auxiliar recursivo

      return result;
  }

  // Método auxiliar recursivo para dividir a lista
  private ListNode splitList(ListNode head, ListNode[] result, int quotient, int remainder, int index) {
      if (head == null) {
          return null;
      }

      result[index] = head; // Armazena o nó atual no array de resultados
      int partSize = quotient + (index < remainder ? 1 : 0); // Calcula o tamanho da parte atual

      ListNode nextHead = head;
      for (int i = 1; i < partSize; i++) {
          nextHead = nextHead.next; // Avança para o próximo nó
      }

      ListNode tail = splitList(nextHead.next, result, quotient, remainder, index + 1); // Chama recursivamente para o restante da lista
      nextHead.next = null; // Desconecta a parte atual do restante da lista

      return tail;
  }
}

public class Main {
  // Método auxiliar para imprimir a lista
  private static void printList(ListNode head) {
      ListNode curr = head;
      while (curr != null) {
          System.out.print(curr.val + " ");
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
      // Criação da lista de teste: 1 -> 2 -> 3 -> 4 -> 5 -> null
      ListNode head = new ListNode(1);
      ListNode node2 = new ListNode(2);
      ListNode node3 = new ListNode(3);
      ListNode node4 = new ListNode(4);
      ListNode node5 = new ListNode(5);
      head.next = node2;
      node2.next = node3;
      node3.next = node4;
      node4.next = node5;

      Solution solution = new Solution();
      int k = 3;

      System.out.println("Splitting the linked list iteratively:");
      ListNode[] resultList = solution.splitListToParts(head, k);
      for (ListNode result : resultList) {
          printList(result);
      }

      System.out.println("Splitting the linked list recursively:");
      ListNode[] recursiveResultList = solution.splitListToPartsRecursive(head, k);
      for (ListNode result : recursiveResultList) {
          printList(result);
      }
  }
}

/*O código acima implementa a questão 725 do LeetCode, "Split Linked List in Parts", tanto de forma iterativa quanto de forma recursiva. O método splitListToParts divide a lista em k partes aproximadamente iguais, enquanto o método splitListToPartsRecursive realiza a mesma tarefa de forma recursiva.

Na classe Main, criamos uma lista de teste com valores de 1 a 5. Em seguida, instanciamos a classe Solution e chamamos os métodos splitListToParts e splitListToPartsRecursive para dividir a lista em k = 3 partes. Por fim, imprimimos os resultados para verificar a divisão correta. */
