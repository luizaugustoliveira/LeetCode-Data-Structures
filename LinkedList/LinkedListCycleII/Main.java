package LinkedListCycleII;

public class Main {
  public static void main(String[] args) {
      // Case 1: List has a cycle
      ListNode head = new ListNode(3);
      head.next = new ListNode(2);
      head.next.next = new ListNode(0);
      head.next.next.next = new ListNode(-4);
      head.next.next.next.next = head.next; // Create cycle

      Solution solution = new Solution();
      ListNode cycleNode = solution.detectCycle(head);
      System.out.println(cycleNode != null ? cycleNode.val : "No cycle");

      // Case 2: List does not have a cycle
      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);

      ListNode cycleNode2 = solution.detectCycle(head2);
      System.out.println(cycleNode2 != null ? cycleNode2.val : "No cycle");

      // Case 3: List is empty
      ListNode cycleNode3 = solution.detectCycle(null);
      System.out.println(cycleNode3 != null ? cycleNode3.val : "No cycle");
  }
}

/*
 * A estratégia usada para resolver o problema "Linked List Cycle II" é conhecida como "Algoritmo de detecção de ciclo de Floyd" ou "Algoritmo do coelho e da tartaruga". O objetivo é encontrar o nó onde o ciclo começa em uma lista encadeada.

A lógica do código é a seguinte:

Na solução iterativa, usamos dois ponteiros, chamados de "slow" (lento) e "fast" (rápido), para percorrer a lista. Inicialmente, ambos os ponteiros são iniciados na cabeça da lista.
Enquanto o ponteiro "fast" não chegar ao final da lista (ou seja, "fast" e "fast.next" não são nulos), movemos o ponteiro "slow" um passo de cada vez e o ponteiro "fast" dois passos de cada vez.
Se houver um ciclo na lista, eventualmente os ponteiros "slow" e "fast" se encontrarão em algum ponto. Isso ocorre porque, se houver um ciclo, o ponteiro "fast" eventualmente "alcançará" o ponteiro "slow".
Quando os ponteiros "slow" e "fast" se encontram, significa que há um ciclo na lista. Então, criamos um novo ponteiro chamado "slow2" e o movemos de volta para a cabeça da lista.
Agora, movemos os ponteiros "slow" e "slow2" um passo de cada vez até que se encontrem novamente. O ponto de encontro será o nó onde o ciclo começa.
Retornamos o nó onde o ciclo começa ou, se não houver ciclo, retornamos nulo.
A lógica por trás dessa abordagem é baseada no fato de que, se houver um ciclo na lista, o ponteiro "fast" percorrerá a lista mais rapidamente do que o ponteiro "slow". Eventualmente, o ponteiro "fast" alcançará o ponteiro "slow" dentro do ciclo. Em seguida, movemos um dos ponteiros de volta para a cabeça da lista e avançamos ambos os ponteiros em velocidade igual. O ponto onde eles se encontram é o nó onde o ciclo começa.

A solução recursiva não é diretamente aplicável a este problema, pois a detecção de ciclo requer manter o estado em várias iterações. No entanto, a solução iterativa é eficiente e satisfatória para resolver o problema.
 */
