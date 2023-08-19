package Single;

public class Main {
    public static void main(String[] args) {
        LinkedListRemoveDuplicatesImpl<Integer> list = new LinkedListRemoveDuplicatesImpl<>();

        // Construa uma lista ligada com alguns duplicados
        SingleLinkedListNode<Integer> node5 = new SingleLinkedListNode<>(5, new SingleLinkedListNode<>());
        SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>(4, node5);
        SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(4, node4);
        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(3, node3);
        SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>(1, node2);
        
        // Remova os duplicados da lista ligada
        SingleLinkedListNode<Integer> head = list.removeDuplicates(node1);

        // Imprima a lista ligada depois de remover os duplicados
        while (!head.isNIL()) {
            System.out.print(head.getData() + " -> ");
            head = head.getNext();
        }
        System.out.println("NIL");
    }
}
