package Single;

public class LinkedListRemoveDuplicatesImpl<T extends Comparable<T>> implements LinkedListRemoveDuplicates<T> {

    @Override
    public SingleLinkedListNode<T> removeDuplicates(SingleLinkedListNode<T> node) {
        // Condição base: se o nó é NIL (indicando que a lista está vazia ou chegamos ao final dela)
        if (node.isNIL() || node.getNext().isNIL()) {
            return node;
        }

        // Cria uma referência para o nó atual, inicialmente apontando para o nó de entrada
        SingleLinkedListNode<T> currentNode = node;
        
        // Percorre a lista enquanto o próximo nó não for NIL
        while (!currentNode.isNIL() && !currentNode.getNext().isNIL()) {
            // Compara o valor do nó atual com o valor do próximo nó
            if (currentNode.getData().equals(currentNode.getNext().getData())) {
                // Se for igual, faz o nó atual "pular" o próximo nó, efetivamente deletando-o
                currentNode.setNext(currentNode.getNext().getNext());
            } else {
                // Se não for igual, move para o próximo nó
                currentNode = currentNode.getNext();
            }
        }

        // Retorna a cabeça da lista, que agora não tem duplicatas
        return node;
    }
}
