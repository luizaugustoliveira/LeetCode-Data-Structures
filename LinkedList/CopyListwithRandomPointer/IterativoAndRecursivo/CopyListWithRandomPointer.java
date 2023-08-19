package CopyListwithRandomPointer.IterativoAndRecursivo;

import java.util.HashMap;
import java.util.Map;

// Definição da classe Node com o valor, próximo e ponteiro aleatório
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
  }
}

public class CopyListWithRandomPointer {
  // Versão iterativa
  public Node copyRandomListIterative(Node head) {
      if (head == null) {
          return null;
      }

      // Passo 1: Criar cópias dos nós e ligá-las à lista original
      Node curr = head;
      while (curr != null) {
          Node copy = new Node(curr.val);
          copy.next = curr.next;
          curr.next = copy;
          curr = copy.next;
      }

      // Passo 2: Atualizar os ponteiros aleatórios das cópias
      curr = head;
      while (curr != null) {
          if (curr.random != null) {
              curr.next.random = curr.random.next;
          }
          curr = curr.next.next;
      }

      // Passo 3: Separar a lista original da lista copiada
      Node dummy = new Node(0);
      Node copyCurr = dummy;
      curr = head;
      while (curr != null) {
          copyCurr.next = curr.next;
          curr.next = curr.next.next;
          curr = curr.next;
          copyCurr = copyCurr.next;
      }

      return dummy.next;
  }

  // Versão recursiva
  public Node copyRandomListRecursive(Node head) {
      return copyRandomListRecursive(head, new HashMap<>());
  }

  private Node copyRandomListRecursive(Node head, Map<Node, Node> map) {
      if (head == null) {
          return null;
      }

      if (map.containsKey(head)) {
          return map.get(head);
      }

      Node copy = new Node(head.val);
      map.put(head, copy);
      copy.next = copyRandomListRecursive(head.next, map);
      copy.random = copyRandomListRecursive(head.random, map);

      return copy;
  }

  // Classe main com os casos de teste
  public static void main(String[] args) {
      // Exemplo de caso de teste
      CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
      Node node1 = new Node(1);
      Node node2 = new Node(2);
      Node node3 = new Node(3);
      node1.next = node2;
      node2.next = node3;
      node1.random = node3;
      node2.random = node1;

      // Teste iterativo
      Node copyIterative = solution.copyRandomListIterative(node1);
      System.out.println("Iterative Copy:");
      printList(copyIterative);

      // Teste recursivo
      Node copyRecursive = solution.copyRandomListRecursive(node1);
      System.out.println("Recursive Copy:");
      printList(copyRecursive);
  }

  // Método auxiliar para imprimir a lista
  private static void printList(Node head) {
      Node curr = head;
      while (curr != null) {
          System.out.print("[" + curr.val + ", ");
          if (curr.random != null) {
              System.out.print(curr.random.val);
          } else {
              System.out.print("null");
          }
          System.out.print("] -> ");
          curr = curr.next;
      }
      System.out.println("null");
  }
}

/*Explicação:

Primeiro, definimos a classe Node, que representa um nó na lista ligada com ponteiro aleatório. Cada nó tem um valor, um ponteiro para o próximo nó na lista e um ponteiro para um nó aleatório.

Em seguida, criamos a classe CopyListWithRandomPointer, que contém a implementação das funções copyRandomListIterative e copyRandomListRecursive, além de uma função auxiliar printList para imprimir a lista.

A função copyRandomListIterative realiza uma cópia da lista ligada de forma iterativa. A estratégia utilizada é dividida em três passos:

No primeiro passo, percorremos a lista original e criamos cópias de cada nó, inserindo-as imediatamente após os nós originais. Isso nos permite mapear corretamente os ponteiros aleatórios posteriormente.
No segundo passo, atualizamos os ponteiros aleatórios das cópias. Para cada nó original, verificamos se ele possui um ponteiro aleatório não nulo e, se sim, atribuímos o ponteiro aleatório da cópia correspondente.
No terceiro passo, separamos a lista original da lista copiada, restaurando os ponteiros next corretos para ambos os grupos de nós.
A função copyRandomListRecursive realiza a cópia da lista ligada de forma recursiva. Ela utiliza um mapa para armazenar as correspondências entre os nós originais e suas cópias. A cada chamada recursiva, verificamos se o nó atual já foi copiado. Se sim, retornamos a cópia correspondente; caso contrário, criamos uma nova cópia, atualizamos seus ponteiros next e random através de chamadas recursivas e a armazenamos no mapa.

A função main contém um exemplo de caso de teste, onde criamos uma lista ligada com três nós e ponteiros aleatórios entre eles. Em seguida, testamos a função copyRandomListIterative e copyRandomListRecursive, imprimindo a lista resultante.

O método printList é um utilitário auxiliar para imprimir a lista ligada original ou copiada, mostrando os valores dos nós e os valores dos nós aleatórios (ou "null" se for nulo). */

