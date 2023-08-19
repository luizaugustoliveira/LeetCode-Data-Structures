package MyDouble;

public class LinkedListRemoveDuplicatesImpl<T extends Comparable<T>> implements LinkedListRemoveDuplicates<T> {

// A função removeDuplicates é responsável por eliminar duplicatas numa lista ligada
@Override
public DoubleLinkedListNode<T> removeDuplicates(DoubleLinkedListNode<T> node) {
    // Verifica se o nó é NIL (ou seja, não contém dados) ou se o próximo nó é NIL.
    // Esta é uma condição base que interrompe a recursão quando alcançamos o final da lista ou se a lista está vazia
    if (node.isNIL() || node.getNext().isNIL()) {
        return node;
    }

    // Inicia uma referência para o nó atual com o nó fornecido como parâmetro
    DoubleLinkedListNode<T> currentNode = node;

    // Loop para percorrer a lista ligada
    while (!currentNode.isNIL() && !currentNode.getNext().isNIL()) {
        // Compara os dados do nó atual com os dados do próximo nó
        if (currentNode.getData().equals(currentNode.getNext().getData())) {
            // Se os dados forem iguais, faz o nó atual "pular" o próximo nó (ou seja, remove a referência ao próximo nó)
            currentNode.setNext(currentNode.getNext().getNext());
            
            // Verifica se o próximo nó é de fato uma instância de DoubleLinkedListNode
            // Isto é necessário para garantir que o próximo nó tem um método setPrevious
            if (currentNode.getNext() instanceof DoubleLinkedListNode) {
                // Cast o próximo nó para DoubleLinkedListNode, para que possamos chamar setPrevious
                DoubleLinkedListNode<T> nextNode = (DoubleLinkedListNode<T>) currentNode.getNext();
                
                // Se o próximo nó não for NIL (ou seja, contém dados), ajusta a referência "previous" desse nó para o nó atual
                if (!nextNode.isNIL()) {
                    nextNode.setPrevious(currentNode);
                }
            }
        } else {
            // Se os dados do nó atual e do próximo nó não forem iguais, move para o próximo nó
            // Isto também requer uma operação de cast, pois getNext retorna um SingleLinkedListNode, mas precisamos de um DoubleLinkedListNode
            currentNode = (DoubleLinkedListNode<T>) currentNode.getNext();
        }
    }

    // Retorna o nó fornecido como parâmetro, que é a cabeça da lista ligada
    // Após a execução desta função, qualquer duplicata na lista ligada terá sido removida
    return node;
}

}
