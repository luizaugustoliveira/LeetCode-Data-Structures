package MyDouble;

public class Main {
    public static void main(String[] args) {
        // Criação de uma lista ligada com alguns valores duplicados
        DoubleLinkedListNode<Integer> node3 = new DoubleLinkedListNode<>(3, null, null);
        DoubleLinkedListNode<Integer> node2b = new DoubleLinkedListNode<>(2, node3, null);
        DoubleLinkedListNode<Integer> node2a = new DoubleLinkedListNode<>(2, node2b, null);
        DoubleLinkedListNode<Integer> node1 = new DoubleLinkedListNode<>(1, node2a, null);

        node2a.setPrevious(node1);
        node2b.setPrevious(node2a);
        node3.setPrevious(node2b);

        System.out.println("Lista ligada antes da remoção de duplicatas: " + node1);

        // Remoção de duplicatas
        LinkedListRemoveDuplicates<Integer> remover = new LinkedListRemoveDuplicatesImpl<>();
        remover.removeDuplicates(node1);

        System.out.println("Lista ligada após a remoção de duplicatas: " + node1);
    }
}
