/*
 * Abordagem Recursiva:

Na abordagem recursiva, atravessamos a lista até o fim usando uma recursão, e à medida que a pilha de chamadas recursivas é desfeita, mantemos uma contagem dos nós visitados. Quando essa contagem se igualar a 'n', sabemos que chegamos ao n-ésimo nó a partir do fim. Nesse ponto, similar à abordagem iterativa, "pulamos" o nó que queremos remover, atualizando a referência para o próximo nó.

Em ambas as abordagens, é importante considerar o caso em que a cabeça da lista é o nó que deve ser removido. Para tratar isso de forma eficiente, criamos um "nó fictício" que aponta para a cabeça da lista. Isso simplifica a lógica de remoção do nó, pois sempre teremos um nó antes do nó que queremos remover.

A escolha entre a abordagem iterativa e recursiva geralmente depende das circunstâncias e requisitos específicos do problema em mãos. A abordagem iterativa é tipicamente mais eficiente em termos de espaço, pois não usa espaço extra na pilha de chamadas. No entanto, a abordagem recursiva pode ser mais simples e mais direta para entender e implementar.
 */

package RemoveNthNodeFromEndofList.Recursivo;

public class SolutionRecursive {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private int n;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        return removeNthFromEndHelper(head);
    }

    private ListNode removeNthFromEndHelper(ListNode node) {
        if (node == null) {
            return null;
        }
        node.next = removeNthFromEndHelper(node.next);
        n--;
        if (n == 0) {
            return node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        SolutionRecursive solution = new SolutionRecursive();
        ListNode result = solution.removeNthFromEnd(head, 2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}


