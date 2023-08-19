package MiddleoftheLinkedList.IterativoAndRecursivo;

public class SolutionRecursive {
  // Classe auxiliar para manter o nó e o número de nós processados
  class NodeCount {
      ListNode node;
      int count;
      NodeCount(ListNode node, int count) {
          this.node = node;
          this.count = count;
      }
  }

  public ListNode middleNode(ListNode head) {
      return middleNodeHelper(head, 0).node; // chama a função auxiliar recursiva
  }

  private NodeCount middleNodeHelper(ListNode head, int count) {
      if(head == null) { // caso base: chegamos ao final da lista
          return new NodeCount(null, count); // retorna o número de nós processados
      }
      NodeCount nc = middleNodeHelper(head.next, count + 1); // chamada recursiva para o próximo nó
      
      // se a contagem total de nós até agora é igual ao dobro da contagem atual, estamos no meio da lista
      if(nc.count / 2 == count) {
          nc.node = head; // atualiza o nó a ser retornado
      }
      return nc; // retorna o nó e a contagem atualizada
  }
}

/*
 * A solução recursiva é um pouco mais complexa. Ela ainda usa a ideia de contagem, mas de uma maneira diferente. A função recursiva middleNodeHelper percorre a lista vinculada até o final, contando o número de nós ao longo do caminho. Quando ela retorna da recursão, ela verifica se o número total de nós até agora é o dobro do número de nós desde a cabeça até o nó atual. Se for, isso significa que o nó atual é o nó do meio.

No código, middleNodeHelper é chamado recursivamente com o próximo nó (middleNodeHelper(head.next, count + 1)), aumentando a contagem em cada chamada. Quando a função atinge o final da lista (quando head é null), ela retorna o número total de nós na lista (em count). Em cada retorno da chamada recursiva, verifica se o número total de nós (nc.count) é o dobro da contagem atual (count). Se for, o nó atual (head) é o nó do meio, então ele é armazenado em nc.node.

A função principal middleNode apenas chama middleNodeHelper e retorna o nó do meio (node) do resultado.
 */
