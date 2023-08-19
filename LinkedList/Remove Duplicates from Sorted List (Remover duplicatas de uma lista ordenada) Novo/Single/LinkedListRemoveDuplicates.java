package Single;

public interface LinkedListRemoveDuplicates<T extends Comparable<T>> {

    /**
     * Restrições:
     * - Você não pode usar nenhuma outra estrutura auxiliar.
     * - Você não pode converter a lista em coleção e depois operar a coleção.
     * - Seu algoritmo tem que ser estritamente O(N) onde N é o tamanho da lista.
     * - Seu algoritmo não pode ter performance O(kN), onde k > 1.
     */
    public SingleLinkedListNode<T> removeDuplicates(SingleLinkedListNode<T> node);
}
