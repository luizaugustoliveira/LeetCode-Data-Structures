package PartitionList.Iterativo;

import java.lang.System;

// Definição para um nó da lista.
class ListNode {
  int val; // Valor do nó.
  ListNode next; // Ponteiro para o próximo nó.
  
  // Construtores do nó.
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Classe Solution contém o método para resolver o problema de forma iterativa.
class Solution {
  public ListNode partition(ListNode head, int x) {
      // Criação de duas listas auxiliares, uma para elementos menores que x (before) e outra para os restantes (after).
      ListNode before_head = new ListNode(0);
      ListNode before = before_head;
      ListNode after_head = new ListNode(0);
      ListNode after = after_head;
      
      // Iterando sobre a lista original.
      while (head != null) {
          // Se o valor do nó atual for menor que x, adicionamos à lista 'before'.
          if (head.val < x) {
              before.next = head;
              before = before.next;
          } else {
              // Caso contrário, adicionamos à lista 'after'.
              after.next = head;
              after = after.next;
          }
          // Passamos para o próximo nó.
          head = head.next;
      }
      
      // Fim da lista 'after'.
      after.next = null;
      // Ligamos a lista 'before' com a 'after'.
      before.next = after_head.next;
      
      // Retornamos a nova lista a partir do nó seguinte ao nó cabeça da lista 'before'.
      return before_head.next;
  }
}

// Classe SolutionRecursive contém o método para resolver o problema de forma recursiva.
class SolutionRecursive {
  public ListNode partition(ListNode head, int x) {
      // Se a lista estiver vazia ou contiver apenas um nó, a retornamos como está.
      if (head == null || head.next == null) {
          return head;
      }
      
      // Nó auxiliar que aponta para a cabeça da lista.
      ListNode dummyNode = new ListNode(0, head);
      // Chamamos o método recursivo auxiliar.
      return partitionHelper(dummyNode, head, x);
  }

  // Método recursivo para rearranjar os nós.
  private ListNode partitionHelper(ListNode prev, ListNode curr, int x) {
      // Caso base: se a lista estiver vazia, retornamos o próximo nó do nó auxiliar.
      if (curr == null) {
          return prev.next;
      }
      
      // Se o valor do nó atual for menor que x, o reposicionamos.
      if (curr.val < x) {
          // Se o nó atual estiver no lugar correto, passamos para o próximo nó.
          if (prev.next == curr) {
              return partitionHelper(curr, curr.next, x);
          } else {
              // Caso contrário, movemos o nó para a posição correta.
              prev.next = curr.next;
              curr.next = prev.next.next;
              prev.next.next = curr;
          }
      }
      // Chamada recursiva para o próximo nó.
      return partitionHelper(prev.next, curr.next, x);
  }
}

// Classe principal para executar os testes.
public class Main {
  public static void main(String[] args) {
      // Criação das instâncias das soluções.
      Solution sol = new Solution();
      SolutionRecursive solRecursive = new SolutionRecursive();

      // Criação das listas para teste.
      ListNode test1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
      ListNode test2 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
      
      // Teste da solução iterativa.
      printList(sol.partition(test1, 3));
      // Teste da solução recursiva.
      printList(solRecursive.partition(test2, 3));
  }
  
  // Método para imprimir a lista.
  public static void printList(ListNode node) {
      while (node != null) {
          // Imprime o valor do nó atual.
          System.out.print(node.val + " ");
          // Passamos para o próximo nó.
          node = node.next;
      }
      // Quebra de linha para separar os resultados.
      System.out.println();
  }
}

/*
 * O objetivo do problema "Partition List" é reorganizar os nós da lista ligada de tal maneira que todos os nós com valor menor que o valor de partição x venham antes dos nós com valor maior ou igual a x.

Para resolver este problema, adotamos duas estratégias distintas: uma iterativa e uma recursiva.

1. Solução Iterativa

A estratégia principal para a solução iterativa é dividir a lista original em duas listas separadas - uma contendo todos os elementos menores que x (a lista before) e outra contendo todos os elementos maiores ou iguais a x (a lista after).

Passo a passo, a lógica é a seguinte:

Criamos dois nós auxiliares, before_head e after_head, que agirão como nós fictícios ("dummy nodes") para as listas before e after respectivamente.
Iteramos através da lista original. Para cada nó, se o seu valor for menor que x, adicionamo-lo à lista before. Se for maior ou igual a x, adicionamo-lo à lista after.
No final dessa iteração, teremos duas listas separadas. Para finalizar, definimos o último nó da lista after como null (para evitar possíveis loops) e ligamos a lista before à lista after - ou seja, fazemos com que o último nó da lista before aponte para o primeiro nó da lista after.
Retornamos o nó após before_head como a cabeça da nova lista rearranjada.
2. Solução Recursiva

A solução recursiva é mais complexa e menos direta. Essencialmente, ela percorre a lista ligada original, e sempre que encontra um nó com valor menor que x, move esse nó para a parte frontal da lista.

Primeiro, verificamos se a lista está vazia ou se ela contém apenas um nó. Se for o caso, simplesmente retornamos a lista como está, pois não é necessário nenhum rearranjo.
Em seguida, criamos um nó auxiliar que aponta para a cabeça da lista e chamamos um método auxiliar recursivo com este nó auxiliar e a cabeça da lista.
Este método auxiliar verifica se o nó atual é null (o que significa que chegamos ao final da lista) e, se for o caso, retorna o próximo nó do nó auxiliar.
Se o nó atual tem um valor menor que x, ele deve ser movido para a frente da lista. Se o nó atual já está no lugar correto (ou seja, é o próximo nó do nó anterior), não fazemos nada e apenas passamos para o próximo nó. Caso contrário, reorganizamos os ponteiros para mover o nó atual para a frente da lista.
O método auxiliar é então chamado recursivamente para o próximo nó.
Por favor, note que a solução recursiva é menos intuitiva e mais difícil de entender do que a solução iterativa. Na prática, a solução iterativa provavelmente seria preferida para este problema, a menos que haja uma razão específica para usar uma abordagem recursiva.
 */