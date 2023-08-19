package ReverseNodesinkGroup;

public class Main {
  // Função para imprimir a lista de nós
  public static void printList(ListNode head) {
      ListNode curr = head;
      while (curr != null) {
          System.out.print(curr.val + " ");
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
      // Criação da lista de nós de teste: 1 -> 2 -> 3 -> 4 -> 5
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      
      Solution solution = new Solution();
      
      // Teste iterativo
      ListNode reversedIterative = solution.reverseKGroup(head, 2);
      System.out.print("Iterative: ");
      printList(reversedIterative);
      
      // Criação da lista de nós de teste novamente: 1 -> 2 -> 3 -> 4 -> 5
      head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      
      // Teste recursivo
      ListNode reversedRecursive = solution.reverseKGroup(head, 3);
      System.out.print("Recursive: ");
      printList(reversedRecursive);
  }
}

/*A lógica e a estratégia para construir o código de reversão dos nós em grupos de tamanho k são as seguintes:

1. O objetivo é inverter os nós de uma lista em grupos de tamanho k. Ou seja, dada uma lista 1 -> 2 -> 3 -> 4 -> 5 e k = 2, o resultado desejado é 2 -> 1 -> 4 -> 3 -> 5.

2. Tanto a abordagem iterativa quanto a recursiva utilizam uma estratégia semelhante, que consiste em percorrer a lista em grupos de tamanho k e inverter os nós de cada grupo.

3. A estratégia iterativa utiliza um loop para percorrer a lista e uma pilha para inverter os nós de cada grupo. A cada iteração, verificamos se existem k nós restantes. Se sim, adicionamos esses k nós em uma pilha. Quando a pilha estiver cheia com k nós, começamos a retirar os nós da pilha e conectá-los novamente na lista, invertendo a ordem. Repetimos esse processo até percorrer toda a lista.

4. A estratégia recursiva é baseada em uma abordagem de dividir e conquistar. Percorremos a lista inicialmente para verificar se existem pelo menos k nós restantes. Se sim, chamamos recursivamente a função `reverseKGroup` para o restante da lista após k nós. Em seguida, invertemos os nós do grupo atual (k nós) e conectamos novamente na lista. O resultado final será a lista com os grupos de nós invertidos.

5. Tanto na abordagem iterativa quanto na recursiva, utilizamos variáveis auxiliares para rastrear os nós atuais, a contagem de nós e a conexão entre os grupos invertidos.

6. O código implementado utiliza a classe `ListNode` para representar um nó da lista, contendo o valor do nó e uma referência para o próximo nó.

7. A classe `Solution` contém o método `reverseKGroup` que recebe a lista de nós e o tamanho do grupo (k). A função retorna a lista com os grupos invertidos.

8. A classe `Main` é responsável por criar uma lista de nós de teste e testar a função `reverseKGroup`, tanto na abordagem iterativa quanto na recursiva. Em seguida, imprime os resultados obtidos.

Essa é a lógica e a estratégia utilizada para construir o código de reversão dos nós em grupos de tamanho k. As abordagens iterativa e recursiva proporcionam soluções eficientes para o problema, dependendo dos requisitos específicos e da preferência do desenvolvedor. */
