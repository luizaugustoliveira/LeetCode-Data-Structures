// Prova período passado

package problems;
   
/**
 * Interface que representa uma busca binária em um array Bitônico.
 * 
 * Um array Bitônico é um array podendo conter duas partições: uma ordenada
 * de forma crescente (sempre vem primeiro) e outra ordenada de forma decrescente.
 * O ponto bitônico desse array é o maior valor que divide essas duas partições.
 * 
* Por exemplo:
* O ponto bitônico do array [7,12,16, 20, 7,4,2,1] é o 20, pois do início até ele
* tem-se os elementos em ordem crescente e apos ele tem-se os elementos em ordem
* decrescente.
* 
* Pode acontecer de uma das partições (crescente ou decrescente) não exista no array
* mas o ponto bitônico sempre será o elemento de maior valor.
*/
public interface BitonicPointBinarySearch<T extends Comparable<T>> {
   /**
    * Método para encontrar o ponto bitônico de um array usando a estratégia 
    * de busca binária.
    * 
    * Restrições:
    * - Seu algoritmo teve ser O(log n)
    * - Você não pode usar memória extra (a não ser variáveis simples). Arrays
    *   auxiliares ou qualquer tipo de coleção são proibidos
    * - Voce deve usar a estratégia de busca binária e RECURSÃO
    * 
    * @param array um array bitônico
    * @return o ponto bitônico do array. Caso o array não tenha elementos, retorna null
    */
   public T bitonicPoint(T[] array);
}

// resolução prova período passado

package problems;
   
public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T>{

    @Override
    public T bitonicPoint(T[] array) {
        return (T) buscaBitonico(array, 0, array.length - 1);
    }

   private Object buscaBitonico(T[] array, int inicio, int fim) {

       // verifica se o array é nulo ou tem tamanho 0 e retorna null
       // (como pedido na questão)
       if (array.length == 0 || array == null) {
           return null;
       }

       // encontra o meio do array para poder auxiliar na busca
       int meioDoArray = (inicio + fim) / 2;

       // busca se o elemento do meio é maior que o elemento à sua esquerda
       // e menor que os elementos à sua direita, sendo, retorna o meio do array
       // como sendo seu ponto bitônico
       if (array[meioDoArray].compareTo(array[meioDoArray + 1]) < 0 && array[meioDoArray].compareTo(array[meioDoArray - 1]) > 0) {
           return meioDoArray;
       }

       // caso o elemento à direita do meio seja menor que o meio
       // então, a busca será realizada apenas nos elementos à direita do meio (por recursão)
       if (array[meioDoArray].compareTo(array[meioDoArray + 1]) < 0) {
           return buscaBitonico(array, meioDoArray + 1, fim);
       }

       // caso o elemento à esquerda do meio seja maior que o meio
       // então, a busca será realizada apenas nos elementos à esquerda do meio (por recursão)
       if (array[meioDoArray].compareTo(array[meioDoArray - 1]) > 0) {
           return buscaBitonico(array, inicio, meioDoArray - 1);
       }

       return meioDoArray;

   }
}

// Outra forma de resolver
public interface BitonicPointBinarySearch<T extends Comparable<T>> {
    int findBitonicPoint(T[] arr);
}

public class RecursiveBitonicPointBinarySearch<T extends Comparable<T>> implements BitonicPointBinarySearch<T> {

    @Override
    public int findBitonicPoint(T[] arr) {
        return findBitonicPoint(arr, 0, arr.length - 1);
    }

    private int findBitonicPoint(T[] arr, int left, int right) {
        if (left == right) {
            return left;
        } else {
            int mid = (left + right) / 2;
            if (arr[mid].compareTo(arr[mid + 1]) < 0) {
                // We are in the increasing part of the bitonic array
                return findBitonicPoint(arr, mid + 1, right);
            } else {
                // We are in the decreasing part of the bitonic array
                return findBitonicPoint(arr, left, mid);
            }
        }
    }
}

// Outro exemplo de interface

1   package problems;
2   
3   /**
4    * Interface que representa uma busca binária em um array Bitônico.
5    * 
6    * Um array Bitônico é um array podendo conter duas partições: uma ordenada
7    * de forma crescente (sempre vem primeiro) e outra ordenada de forma decrescente.
8    * O ponto bitônico desse array é o maior valor que divide essas duas partições.
9    * 
10   * Por exemplo:
11   * O ponto bitônico do array [7,12,16, 20, 7,4,2,1] é o 20, pois do início até ele
12   * tem-se os elementos em ordem crescente e apos ele tem-se os elementos em ordem
13   * decrescente.
14   * 
15   * Pode acontecer de uma das partições (crescente ou decrescente) não exista no array
16   * mas o ponto bitônico sempre será o elemento de maior valor.
17   */
18  public interface BinarySearchInBitonicArray<T extends Comparable<T>> {
19      
20      /**
21       * Metodo para encontrar um elemento em um array bitonico. 
22       * O ponto bitonico funciona como o divisor do array, em cujas particoes
23       * a busca binaria deve funcionar de forma conveniente. 
24       * 
25       * Restricoes:
26       * - Sua solucao DEVE usar a estratégia de busca binaria para resolver o problema
27       * - Você NÃO pode percorrer o array linearmente
28       * - Você não pdoe usar memória extra 
29       * - Você não pode copiar (nem converter) o array (nem partes dele) para (em) outra estrutura
30       * 
31       * @param array um array bitonico
32       * @param elem o elemento a ser buscado
33       * @return retorna o elemento se ele existe no array bitonico
34       */
35      public int bitonicBinarySearch(T[] array, T elem);
36  }

