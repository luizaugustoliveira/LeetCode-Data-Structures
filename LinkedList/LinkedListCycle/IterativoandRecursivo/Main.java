package LinkedListCycle.IterativoandRecursivo;

public class Main {
  public static void main(String[] args) {
      // Primeiro caso de teste: uma lista vinculada com um ciclo
      ListNode node1 = new ListNode(3);
      ListNode node2 = new ListNode(2);
      ListNode node3 = new ListNode(0);
      ListNode node4 = new ListNode(-4);
      node1.next = node2;
      node2.next = node3;
      node3.next = node4;
      node4.next = node2;
      
      Solution solution = new Solution();
      System.out.println(solution.hasCycle(node1));  // Deve imprimir: true
      
      // Segundo caso de teste: uma lista vinculada sem um ciclo
      ListNode node5 = new ListNode(1);
      ListNode node6 = new ListNode(2);
      node5.next = node6;
      
      System.out.println(solution.hasCycle(node5));  // Deve imprimir: false
  }
}

/*Para resolver o problema "Linked List Cycle", foram utilizadas duas estratégias principais: uma abordagem iterativa usando o algoritmo de "Dois Ponteiros" (também conhecido como "Hare and Tortoise") e uma abordagem recursiva usando um HashSet para acompanhar os nós já visitados.

Abordagem Iterativa (Two Pointers / Hare and Tortoise):
Esta estratégia envolve o uso de dois ponteiros, um rápido (o "lebre") e um lento (a "tartaruga"). O ponteiro lento avança um passo de cada vez, enquanto o ponteiro rápido avança dois passos de cada vez. Se em algum momento, os dois ponteiros se encontrarem, isso indica que há um ciclo na lista vinculada. Se o ponteiro rápido chegar ao final da lista vinculada, isso indica que a lista vinculada não possui um ciclo.

Abordagem Recursiva (Com o uso de um HashSet):
Esta abordagem usa um HashSet para rastrear os nós já visitados na lista vinculada. A cada passo da recursão, o código verifica se o nó atual já foi visitado. Se sim, isso indica que há um ciclo. Se o nó atual for nulo, isso indica o final da lista vinculada, e que ela não possui um ciclo. Se o nó atual não foi visitado antes, é adicionado ao HashSet e o próximo nó na lista é analisado.

Ambas as abordagens permitem determinar eficientemente se há um ciclo em uma lista vinculada. A abordagem iterativa tem uma vantagem de espaço, pois não requer armazenamento extra, enquanto a abordagem recursiva é mais fácil de entender e implementar para alguns, mas usa espaço extra para armazenar os nós visitados. */
