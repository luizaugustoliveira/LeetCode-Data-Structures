package SortList.Iterativo;

public class Main {
  public static void main(String[] args) {
      Solution solution = new Solution();
      
      // Caso de teste 1: [4,2,1,3]
      ListNode head1 = new ListNode(4);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(1);
      head1.next.next.next = new ListNode(3);
      ListNode sorted1 = solution.sortList(head1);
      printList(sorted1); // Resultado esperado: [1,2,3,4]
      
      // Caso de teste 2: [-1,5,3,4,0]
      ListNode head2 = new ListNode(-1);
      head2.next = new ListNode(5);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);
      head2.next.next.next.next = new ListNode(0);
      ListNode sorted2 = solution.sortList(head2);
      printList(sorted2); // Resultado esperado: [-1,0,3,4,5]
  }
  
  // Método auxiliar para imprimir a lista
  private static void printList(ListNode head) {
      ListNode curr = head;
      while (curr != null) {
          System.out.print(curr.val + " ");
          curr = curr.next;
      }
      System.out.println();
  }
}

/*
 * A estratégia para resolver a questão "Sort List" do LeetCode é aplicar o algoritmo de ordenação merge sort para ordenar a lista encadeada. O merge sort é um algoritmo de ordenação eficiente que divide a lista em metades menores, ordena essas metades separadamente e, em seguida, combina as metades ordenadas para obter a lista final ordenada.

Aqui está uma visão geral passo a passo da estratégia de resolução:

Caso Base: Verificar se a lista está vazia ou contém apenas um elemento. Se for esse o caso, a lista já está ordenada, então retorne a lista original.

Divisão: Dividir a lista em duas partes aproximadamente iguais. Isso pode ser feito encontrando o nó do meio da lista usando o algoritmo "floyd's tortoise and hare".

Ordenação Recursiva: Chamar recursivamente a função sortList nas duas metades da lista dividida.

Mesclagem: Mesclar as duas metades ordenadas usando uma função merge que compara os valores dos nós e os mescla em ordem crescente.

Retorno: Retornar a cabeça da lista mesclada.

Essa abordagem é eficiente porque o merge sort possui uma complexidade de tempo média de O(n log n) e, ao usar a recursão, podemos dividir a lista em partes menores até que cada parte contenha apenas um elemento. Em seguida, a mesclagem das partes individuais é feita em tempo linear, resultando em uma lista ordenada final.

A implementação fornecida anteriormente segue essa estratégia, dividindo a lista em metades, ordenando-as recursivamente e, em seguida, mesclando as metades ordenadas. Tanto a implementação iterativa quanto a recursiva seguem a mesma estratégia básica, apenas diferem na forma como as divisões e mesclagens são realizadas.
 */
