package InsertionSortList;

public class Main {
  
}

/*A classe ListNode representa um nó de uma lista encadeada. A classe Solution contém os métodos insertionSortList (iterativo e recursivo) e o método main para executar os casos de teste. O método printList é uma função auxiliar para imprimir os elementos de uma lista encadeada.

No método insertionSortList iterativo, criamos um nó dummy para representar a cabeça da lista ordenada. Em seguida, percorremos a lista não ordenada usando o nó curr e, para cada nó, encontramos a posição correta na lista ordenada usando o nó prev. Depois disso, inserimos o nó atual na posição correta e continuamos com o próximo nó não ordenado. Finalmente, retornamos a lista ordenada.

No método insertionSortList recursivo, usamos um nó sortedTail para acompanhar a cauda da lista ordenada e um nó unsortedHead para acompanhar a cabeça da lista não ordenada. A cada passo recursivo, encontramos a posição correta para inserir o nó unsortedHead na lista sortedHead usando os nós curr e prev. Em seguida, ajustamos os ponteiros e chamamos recursivamente o método para continuar ordenando a lista não ordenada. A cada chamada recursiva, a lista ordenada cresce até incluir todos os nós.

Os casos de teste main criam duas listas encadeadas e chamam o método insertionSortList, imprimindo a lista ordenada resultante. */
