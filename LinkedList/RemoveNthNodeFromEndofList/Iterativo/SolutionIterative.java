/*
 * A questão pede a remoção do n-ésimo nó a partir do fim da lista, porém as listas encadeadas, por sua natureza, apenas nos permitem acessar os elementos de forma sequencial, iniciando pelo começo da lista.

Para resolver essa questão, utilizamos duas estratégias principais: uma abordagem iterativa com dois ponteiros e uma abordagem recursiva.

Abordagem Iterativa com dois ponteiros:

A abordagem iterativa se baseia no uso de dois ponteiros para atravessar a lista, um primeiro ponteiro avança 'n+1' nós à frente, enquanto o segundo ponteiro começa no início da lista. Em seguida, movemos ambos os ponteiros um passo de cada vez até que o primeiro ponteiro atinja o fim da lista. Nesse momento, o segundo ponteiro estará 'n' nós atrás, ou seja, será o nó antes do nó que queremos remover. Nesse ponto, simplesmente "pulamos" o nó que queremos remover, atualizando a referência do próximo nó no segundo ponteiro, efetivamente removendo o n-ésimo nó da lista.
 */

package RemoveNthNodeFromEndofList.Iterativo;

public class SolutionIterative {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        SolutionIterative solution = new SolutionIterative();
        ListNode result = solution.removeNthFromEnd(head, 2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

