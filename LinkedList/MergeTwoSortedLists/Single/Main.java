package LinkedList.MergeTwoSortedLists.Single;

public class Main {
  public static void main(String[] args) {
      // Cria a primeira lista ligada: 1 -> 2 -> 4
      SingleLinkedListNode<Integer> l1 = new SingleLinkedListNode<>(1);
      l1.next = new SingleLinkedListNode<>(2);
      l1.next.next = new SingleLinkedListNode<>(4);

      // Cria a segunda lista ligada: 1 -> 3 -> 4
      SingleLinkedListNode<Integer> l2 = new SingleLinkedListNode<>(1);
      l2.next = new SingleLinkedListNode<>(3);
      l2.next.next = new SingleLinkedListNode<>(4);

      // Cria um objeto da classe MergeTwoSortedListsImpl e mescla as duas listas
      MergeTwoSortedListsImpl<Integer> merger = new MergeTwoSortedListsImpl<>();
      SingleLinkedListNode<Integer> mergedList = merger.mergeTwoLists(l1, l2);

      // Imprime a lista mesclada
      printList(mergedList);
  }

  // Método auxiliar para imprimir uma lista ligada
  public static <T> void printList(SingleLinkedListNode<T> node) {
      while (node != null) {
          System.out.print(node.val + " ");
          node = node.next;
      }
  }
}

