/*Claro! Podemos implementar uma interface que estende a interface `BST<Integer>`. No exemplo a seguir, estou supondo que a interface `BT` (Binary Tree) que `BST` estende possui uma classe interna `BTNode`, que representa um nó da árvore.

```java
public interface BSTSolution<T extends Comparable<T>> extends BT<T> {
    boolean isBST(BTNode<T> root);
}

public class BSTImpl<T extends Comparable<T>> implements BSTSolution<T> {
    // variáveis de instância existentes...
    BTNode<T> root;

    // métodos existentes...

    @Override
    public boolean isBST(BTNode<T> root) {
        return isBSTUtil(root, null, null);
    }

    private boolean isBSTUtil(BTNode<T> node, T min, T max) {
        if (node == null) {
            return true;
        }
        
        if ((min != null && node.getData().compareTo(min) <= 0) || 
            (max != null && node.getData().compareTo(max) >= 0)) {
            return false;
        }
        
        return isBSTUtil(node.getLeft(), min, node.getData()) && 
               isBSTUtil(node.getRight(), node.getData(), max);
    }
}
```

Neste código, a interface `BSTSolution` define um método `isBST` que recebe um nó e verifica se a árvore cujo nó raiz é esse nó é uma árvore de busca binária (BST).

Na classe `BSTImpl` que implementa `BSTSolution`, o método `isBST` é definido. Este método usa uma função auxiliar `isBSTUtil` que verifica se a árvore é uma BST, tomando como argumentos o nó raiz da árvore (ou subárvore) a ser verificada, bem como os limites mínimo e máximo que os dados no nó podem ter para a árvore ainda ser uma BST.

O método `isBSTUtil` verifica primeiro se o nó é nulo (caso em que a árvore é uma BST, pois é vazia). Em seguida, verifica se os dados do nó estão fora dos limites especificados (caso em que a árvore não é uma BST). Finalmente, chama a si mesmo recursivamente para os nós filhos esquerdo e direito do nó, atualizando os limites conforme necessário.

Esse método funciona porque em uma BST, todos os nós em uma subárvore esquerda devem ter dados menores que o nó raiz, e todos os nós em uma subárvore direita devem ter dados maiores que o nó raiz. Assim, ao percorrer a árvore, podemos manter os limites de quais valores seriam válidos para os dados no nó atual. Se os dados em um nó estiverem fora desses limites, então sabemos que a árvore não pode ser uma BST.

Esse método é O(N) em tempo de execução, onde N é o número de nós na árvore, porque cada nó é verificado uma vez.
 */