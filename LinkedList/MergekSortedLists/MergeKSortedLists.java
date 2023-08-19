package MergekSortedLists;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {
    // Solução iterativa
    public ListNode mergeKListsIterative(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Criação de uma fila de prioridade para manter o menor elemento de cada lista
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Adiciona todos os nós iniciais das listas à fila de prioridade
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Itera enquanto houver elementos na fila de prioridade
        while (!pq.isEmpty()) {
            // Remove o nó com o menor valor da fila de prioridade
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;

            // Avança para o próximo nó na lista original
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    // Solução recursiva
    public ListNode mergeKListsRecursive(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid + 1, right);

        return mergeTwoLists(leftList, rightList);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // Classe main com casos de teste
    public static void main(String[] args) {
        MergeKSortedLists merger = new MergeKSortedLists();

        // Caso de teste 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists1 = {list1, list2, list3};

        ListNode result1 = merger.mergeKListsIterative(lists1);
        printList(result1);

        // Caso de teste 2
        ListNode list4 = null;
        ListNode[] lists2 = {list4};

        ListNode result2 = merger.mergeKListsRecursive(lists2);
        printList(result2);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

/*Explicação:

A classe ListNode representa um nó em uma lista ligada, onde val armazena o valor do nó e next é uma referência ao próximo nó na lista.
A classe MergeKSortedLists contém os métodos mergeKListsIterative e mergeKListsRecursive para mesclar as listas ordenadas.
A solução iterativa usa uma fila de prioridade (PriorityQueue) para manter o menor elemento de cada lista. Os nós iniciais de todas as listas são adicionados à fila de prioridade e, em cada iteração, o nó com o menor valor é removido da fila e adicionado à lista mesclada. O próximo nó da lista original é adicionado à fila de prioridade.
A solução recursiva usa uma abordagem de divisão e conquista. As listas são divididas em duas partes e as duas partes são mescladas recursivamente. A função mergeTwoLists é usada para mesclar duas listas ligadas em ordem.
A classe main contém casos de teste para demonstrar o funcionamento das soluções. Duas listas são criadas para cada caso de teste, e as listas são passadas para os métodos mergeKListsIterative e mergeKListsRecursive. O resultado é então impresso usando o método printList.
O método printList imprime os valores dos nós da lista ligada separados por espaço. */