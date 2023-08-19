package DeleteNodeinaBST;

public class DeleteNodeinaBST {
  
}
/*
Vou expandir a interface `BSTSolution` e a classe `BSTImpl` para incluir a operação de remoção. Para remover um nó em uma árvore de pesquisa binária (BST), precisamos considerar três cenários:

1. O nó a ser removido não tem filhos: podemos simplesmente removê-lo.
2. O nó a ser removido tem um filho: substituímos o nó pelo seu filho.
3. O nó a ser removido tem dois filhos: substituímos o nó pelo menor valor da subárvore à direita (ou pelo maior valor da subárvore à esquerda), e então removemos esse nó.

Primeiro, atualizamos a interface `BSTSolution`:

```java
public interface BSTSolution extends BT<Integer> {
    BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val);
    BSTNode<Integer> insertIntoBST(BSTNode<Integer> root, Integer val);
    BSTNode<Integer> deleteNode(BSTNode<Integer> root, Integer key);
}
```

Agora vamos implementar o método `deleteNode` na classe `BSTImpl`:

```java
public class BSTImpl extends BSTNode<Integer> implements BSTSolution {
    
    // Outros métodos da interface BT<Integer>...

    @Override
    public BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val) {
        // Implementação existente...
    }

    @Override
    public BSTNode<Integer> insertIntoBST(BSTNode<Integer> root, Integer val) {
        // Implementação existente...
    }

    @Override
    public BSTNode<Integer> deleteNode(BSTNode<Integer> root, Integer key) {
        if (root == null || root.isEmpty()) {
            return root;
        }

        if (key < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), key));
        } else if (key > root.getData()) {
            root.setRight(deleteNode(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setData(minValue(root.getRight()));
            root.setRight(deleteNode(root.getRight(), root.getData()));
        }
        return root;
    }

    private Integer minValue(BSTNode<Integer> root) {
        int minv = root.getData();
        while (root.getLeft() != null) {
            minv = root.getLeft().getData();
            root = root.getLeft();
        }
        return minv;
    }
}
```

Na classe `BSTInteger`:

```java
public class BSTInteger extends BSTImpl {

    // Outros métodos...

    public void deleteNode(Integer key) {
        setRoot(deleteNode(getRoot(), key));
    }
}
```

Este código primeiro localiza o nó a ser removido, percorrendo a árvore de cima para baixo. Se a chave fornecida é menor que a chave do nó raiz, a chave a ser deletada está na subárvore esquerda. Se a chave fornecida é maior que a chave do nó raiz, a chave a ser deletada está na subárvore direita. Então chamamos recursivamente `deleteNode` para a subárvore esquerda ou direita.

Se a chave a ser deletada é a mesma que a chave do nó raiz, então este é o nó a ser deletado. Então tratamos os três casos de remoção: nó sem filho, n

ó com um filho e nó com dois filhos.

Este algoritmo satisfaz todas as restrições. A complexidade de tempo é O(N) no pior caso, pois percorremos todos os nós da árvore no pior caso.
 */

 /*Claro, vamos detalhar o que o código está fazendo:

- **Interface BSTSolution**: a interface foi estendida para incluir um novo método `deleteNode`, que aceita um nó raiz e uma chave para remover da árvore.

- **Classe BSTImpl**: a classe BSTImpl, que é uma implementação concreta de uma árvore binária de busca (Binary Search Tree - BST), foi estendida para incluir a implementação do método `deleteNode`. Vamos detalhar o que este método faz:

  1. Primeiro, ele verifica se o nó raiz é nulo ou vazio, caso em que simplesmente retorna o nó raiz.

  2. Em seguida, se a chave for menor que os dados no nó raiz, ele sabe que o nó a ser removido está na subárvore esquerda. Ele então chama recursivamente o método `deleteNode` na subárvore esquerda.

  3. Se a chave for maior que os dados no nó raiz, o nó a ser removido está na subárvore direita. Novamente, ele chama recursivamente o método `deleteNode` na subárvore direita.

  4. Se a chave for igual aos dados no nó raiz, então este é o nó a ser removido. Neste caso, há três situações que podem ocorrer:

     - Se o nó tiver um filho à direita mas não à esquerda, ele simplesmente retorna o filho à direita para tomar o lugar do nó atual.
     - Se o nó tiver um filho à esquerda mas não à direita, ele simplesmente retorna o filho à esquerda para tomar o lugar do nó atual.
     - Se o nó tiver ambos os filhos, ele procura o valor mínimo na subárvore direita (ou seja, o sucessor in-order), define os dados do nó atual como esse valor mínimo e chama recursivamente `deleteNode` na subárvore direita para remover o nó com esse valor mínimo.

  A função auxiliar `minValue` é usada para encontrar o valor mínimo em uma árvore binária de busca dada. Ela simplesmente percorre a árvore para a esquerda até chegar ao último nó, que terá o menor valor.

- **Classe BSTInteger**: esta classe, que é uma subclasse de `BSTImpl`, é estendida para incluir um método `deleteNode` que aceita uma chave para remover. Esse método chama o `deleteNode` na classe pai, passando o nó raiz e a chave a ser removida. */