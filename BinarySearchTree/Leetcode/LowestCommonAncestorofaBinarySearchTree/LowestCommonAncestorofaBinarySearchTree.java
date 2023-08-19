package LowestCommonAncestorofaBinarySearchTree;

public class LowestCommonAncestorofaBinarySearchTree {
  
}

/*Podemos definir a interface `BSTSolution` para estender `BST<Integer>` com o método `lowestCommonAncestor`. Em seguida, implementaremos este método na classe `BSTImpl`. Observe que, devido à natureza da árvore de busca binária (BST), os elementos à esquerda de um nó são menores que o nó e os elementos à direita de um nó são maiores. Usaremos isso para encontrar o ancestral comum mais baixo.

```java
public interface BSTSolution<T extends Comparable<T>> extends BT<T> {
    BTNode<T> lowestCommonAncestor(T p, T q);
}

public class BSTImpl<T extends Comparable<T>> implements BSTSolution<T> {
    // variáveis de instância existentes...

    // métodos existentes...

    @Override
    public BTNode<T> lowestCommonAncestor(T p, T q) {
        return lowestCommonAncestor(root, p, q);
    }

    private BTNode<T> lowestCommonAncestor(BTNode<T> root, T p, T q) {
        if (root.isEmpty()) return null;

        if (root.getData().compareTo(p) > 0 && root.getData().compareTo(q) > 0)
            return lowestCommonAncestor(root.getLeft(), p, q);

        else if (root.getData().compareTo(p) < 0 && root.getData().compareTo(q) < 0)
            return lowestCommonAncestor(root.getRight(), p, q);

        else 
            return root;
    }
}
```
No código acima, o método `lowestCommonAncestor(T p, T q)` chama um método recursivo auxiliar que leva um nó adicional (o nó atual que estamos inspecionando na árvore). 

Na função auxiliar, nós:
- Primeiro verificamos se o nó atual está vazio, caso em que retornamos null.
- Em seguida, se os dois valores para os quais estamos procurando o ancestral comum mais baixo (p e q) são menores que o valor no nó atual, vamos para a subárvore à esquerda.
- Se p e q são ambos maiores que o valor no nó atual, vamos para a subárvore à direita.
- Caso contrário, o nó atual deve ser o ancestral comum mais baixo, então o retornamos.

A complexidade de tempo deste algoritmo é O(N) no pior caso, onde N é o número de nós na árvore (isso ocorreria no caso de uma árvore completamente inclinada). No entanto, em uma árvore de busca binária bem equilibrada, a complexidade do tempo seria O(log N). */