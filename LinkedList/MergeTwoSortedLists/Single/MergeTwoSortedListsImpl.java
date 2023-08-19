package LinkedList.MergeTwoSortedLists.Single;

import LinkedList.MergeTwoSortedLists.Single.SingleLinkedListNode;


// A classe SingleLinkedListNode é uma implementação genérica de um nó de lista ligada.
class SingleLinkedListNode<T> {
  // O valor do nó.
  T val;
  // O próximo nó na lista ligada.
  SingleLinkedListNode<T> next;

  // Construtor padrão.
  SingleLinkedListNode() {}

  // Construtor que aceita um valor para o nó.
  SingleLinkedListNode(T val) {
      this.val = val;
  }

  // Construtor que aceita um valor e o próximo nó na lista.
  SingleLinkedListNode(T val, SingleLinkedListNode<T> next) {
      this.val = val;
      this.next = next;
  }
}

// A classe MergeTwoSortedListsImpl implementa a interface MergeTwoSortedLists.
// Ela fornece uma implementação para o método mergeTwoLists, que mescla duas listas ligadas ordenadas em uma única lista ordenada.
public class MergeTwoSortedListsImpl<T extends Comparable<T>> implements MergeTwoSortedLists<T> {

  // Implementação do método mergeTwoLists da interface MergeTwoSortedLists.
  @Override
  public SingleLinkedListNode<T> mergeTwoLists(SingleLinkedListNode<T> l1, SingleLinkedListNode<T> l2) {
      // Caso base da recursão: se l1 for null, retorne l2.
      // Isso acontece quando já percorremos toda a lista l1, então o restante da lista mesclada será apenas l2.
      if (l1 == null) {
          return l2;
      }
      // Caso base da recursão: se l2 for null, retorne l1.
      // Isso acontece quando já percorremos toda a lista l2, então o restante da lista mesclada será apenas l1.
      else if (l2 == null) {
          return l1;
      }
      // Se o valor do nó atual em l1 for menor ou igual ao nó atual em l2...
      else if (l1.val.compareTo(l2.val) <= 0) {
          // Definimos o próximo nó de l1 como o resultado da mesclagem do próximo nó de l1 e o nó atual de l2.
          l1.next = mergeTwoLists(l1.next, l2);
          // Retornamos l1, pois seu valor era menor ou igual.
          return l1;
      }
      // Se o valor do nó atual em l2 for menor que o nó atual em l1...
      else {
          // Definimos o próximo nó de l2 como o resultado da mesclagem do nó atual de l1 e o próximo nó de l2.
          l2.next = mergeTwoLists(l1, l2.next);
          // Retornamos l2, pois seu valor era menor.
          return l2;
      }
  }
}


