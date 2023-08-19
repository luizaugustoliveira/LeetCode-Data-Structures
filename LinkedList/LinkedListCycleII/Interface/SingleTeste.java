package LinkedListCycleII.Interface;

Aqui está uma interface que define os métodos necessários para resolver a questão "Linked List Cycle II" usando a classe SingleLinkedListNode<T>:

java
Copy code
public interface LinkedListCycle {
    /**
     * Encontra o nó onde o ciclo começa na lista encadeada.
     *
     * @param head O nó de cabeça da lista encadeada
     * @param <T>  O tipo de dados armazenados nos nós
     * @return O nó onde o ciclo começa, ou nulo se não houver ciclo
     */
    <T> SingleLinkedListNode<T> detectCycle(SingleLinkedListNode<T> head);
}
Essa interface define um único método detectCycle, que recebe o nó de cabeça da lista encadeada e retorna o nó onde o ciclo começa, ou nulo se não houver ciclo.

Você pode implementar essa interface na classe Solution para resolver o problema da "Linked List Cycle II". Basta alterar o nome da classe Solution para Solution implements LinkedListCycle e implementar o método detectCycle usando a classe SingleLinkedListNode<T>.

public class Solution implements LinkedListCycle {
  @Override
  public <T> SingleLinkedListNode<T> detectCycle(SingleLinkedListNode<T> head) {
      return detectCycleIterative(head);
      // return detectCycleRecursive(head);
  }

  private <T> SingleLinkedListNode<T> detectCycleIterative(SingleLinkedListNode<T> head) {
      if (head == null || head.getNext() == null) {
          return null;
      }

      SingleLinkedListNode<T> slow = head;
      SingleLinkedListNode<T> fast = head;

      while (fast != null && fast.getNext() != null) {
          slow = slow.getNext();
          fast = fast.getNext().getNext();

          if (slow == fast) { // Cycle detected
              SingleLinkedListNode<T> slow2 = head;

              while (slow != slow2) {
                  slow = slow.getNext();
                  slow2 = slow2.getNext();
              }
              return slow;
          }
      }

      return null; // No cycle found
  }

  private <T> SingleLinkedListNode<T> detectCycleRecursive(SingleLinkedListNode<T> head) {
      if (head == null || head.getNext() == null) {
          return null;
      }

      return detectCycleRecursiveHelper(head, head);
  }

  private <T> SingleLinkedListNode<T> detectCycleRecursiveHelper(
          SingleLinkedListNode<T> slow, SingleLinkedListNode<T> fast) {
      if (fast == null || fast.getNext() == null) {
          return null; // No cycle found
      }

      if (slow == fast) { // Cycle detected
          SingleLinkedListNode<T> slow2 = slow.getNext();

          while (slow != slow2) {
              slow = slow.getNext();
              slow2 = slow2.getNext();
          }
          return slow;
      }

      return detectCycleRecursiveHelper(slow.getNext(), fast.getNext().getNext());
  }
}
Na implementação iterativa (detectCycleIterative), usamos dois ponteiros, slow (lento) e fast (rápido), que se movem pela lista em velocidades diferentes. Se houver um ciclo, os dois ponteiros se encontrarão.

Na implementação recursiva (detectCycleRecursive), usamos a recursão para avançar os ponteiros slow e fast até encontrarem um ciclo, ou até chegarem ao final da lista. Para isso, criamos um método auxiliar detectCycleRecursiveHelper que realiza a lógica recursiva.

Você pode escolher qual método utilizar na função detectCycle comentando/descomentando a linha correspondente (iterativa ou recursiva).

Aqui está a classe Main com alguns casos de teste e seus respectivos prints:

java
Copy code
public class Main {
    public static void main(String[] args) {
        // Caso 1: Lista com ciclo
        SingleLinkedListNode<Integer> head1 = new SingleLinkedListNode<>(3, null);
        SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>(2, null);
        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(0, null);
        SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(-4, null);

        head1.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1); // Cria o ciclo

        LinkedListCycle solution = new Solution();
        SingleLinkedListNode<Integer> cycleNode1 = solution.detectCycle(head1);
        System.out.println("Ciclo começa no nó com valor: " + cycleNode1.getData());

        // Caso 2: Lista sem ciclo
        SingleLinkedListNode<Integer> head2 = new SingleLinkedListNode<>(1, null);
        SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>(2, null);
        head2.setNext(node4);

        SingleLinkedListNode<Integer> cycleNode2 = solution.detectCycle(head2);
        System.out.println("Ciclo começa no nó com valor: " + (cycleNode2 != null ? cycleNode2.getData() : "Nenhum ciclo"));

        // Caso 3: Lista vazia
        SingleLinkedListNode<Integer> head3 = null;

        SingleLinkedListNode<Integer> cycleNode3 = solution.detectCycle(head3);
        System.out.println("Ciclo começa no nó com valor: " + (cycleNode3 != null ? cycleNode3.getData() : "Nenhum ciclo"));
    }
}
Saída esperada:

yaml
Copy code
Ciclo começa no nó com valor: 2
Ciclo começa no nó com valor: Nenhum ciclo
Ciclo começa no nó com valor: Nenhum ciclo
Nesse exemplo, criamos três casos de teste:

No caso 1, construímos uma lista com um ciclo e imprimimos o valor do nó onde o ciclo começa, que é 2.
No caso 2, construímos uma lista sem ciclo e imprimimos que não há ciclo.
No caso 3, usamos uma lista vazia e imprimimos que não há ciclo.
Esses casos de teste ilustram a detecção correta do nó onde o ciclo começa ou a ausência de ciclo, conforme implementado nas classes que implementam a interface LinkedListCycle.
