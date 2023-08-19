/*import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class BST<T extends Comparable<T>> extends BSTImpl<T> {

    @Override
    public void insert(T element) {
        insert(root, element);
    }

    protected void insert(BSTNode<T> node, T element) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode<T>());
            node.getLeft().setParent(node);
            node.setRight(new BSTNode<T>());
            node.getRight().setParent(node);
        } else {
            if (element.compareTo(node.getData()) < 0) {
                insert((BSTNode<T>)node.getLeft(), element);
            } else if (element.compareTo(node.getData()) > 0) {
                insert((BSTNode<T>)node.getRight(), element);
            }
        }
    }

    public boolean isValidBST() {
        return isBSTUtil(this.root, null, null);
    }

    private boolean isBSTUtil(BSTNode<T> node, T min, T max) {
        if (node.isEmpty()) {
            return true;
        }
        if ((min != null && node.getData().compareTo(min) <= 0) || (max != null && node.getData().compareTo(max) >= 0)) {
            return false;
        }
        return (isBSTUtil((BSTNode<T>)node.getLeft(), min, node.getData()) &&
                isBSTUtil((BSTNode<T>)node.getRight(), node.getData(), max));
    }
}
*/

/*Vamos analisar os pontos mais importantes da implementação:

1. `insert(T element)`: Este método é responsável por inserir um novo elemento na árvore. Se o nó atual está vazio, ele preenche o nó com o novo elemento e cria dois nós filhos vazios. Se o nó atual já tem um elemento, ele decide se o novo elemento deve ser inserido à esquerda ou à direita, baseando-se no resultado da comparação entre o novo elemento e o elemento atual. A inserção é então realizada recursivamente no subárvore apropriado.

2. `isValidBST()`: Este é o método de entrada para a validação da árvore binária. Ele inicia a verificação do nó raiz com valores mínimos e máximos inicialmente definidos como `null`, o que significa que inicialmente não há limite para o valor que o nó raiz pode ter.

3. `isBSTUtil(BSTNode<T> node, T min, T max)`: Este é o método que realiza a verificação da validade de cada nó. Ele recebe um nó e os valores mínimos e máximos permitidos para esse nó. A ideia é que para qualquer nó, todos os valores à esquerda desse nó devem ser menores que o valor do nó e todos os valores à direita devem ser maiores. Assim, se o nó atual violar essa condição, o método retorna `false`, indicando que a árvore não é uma BST válida.

   No início, verifica se o nó atual está vazio. Se estiver, retorna `true`, pois um nó vazio é por definição uma BST válida.
   
   Em seguida, verifica se o valor do nó atual está dentro dos limites permitidos (ou seja, é maior que o valor mínimo permitido e menor que o valor máximo permitido). Se não estiver, retorna `false`.
   
   Se o nó atual passar nas duas verificações, ele faz a mesma verificação para as subárvores esquerda e direita. Para a subárvore esquerda, o valor máximo permitido é o valor do nó atual, pois todos os valores na subárvore esquerda devem ser menores que o valor do nó atual. Para a subárvore direita, o valor mínimo permitido é o valor do nó atual, pois todos os valores na subárvore direita devem ser maiores que o valor do nó atual.

Assim, a validade de toda a árvore é verificada de maneira recursiva, e qualquer violação das propriedades da BST é detectada. Note que cada nó é visitado exatamente uma vez, por isso a complexidade temporal é O(N), onde N é o número de nós na árvore. */


/*public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        } else if (node.val <= min || node.val >= max) {
            return false;
        } else {
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
*/