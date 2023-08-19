/*Count Negative Numbers in a Sorted Matrix

 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0


Na primeira linha do loop for, a variável left é definida como 0, e a variável right é definida como cols - 1, que é o índice da última coluna na linha.
O loop while faz a busca binária para encontrar o índice da primeira coluna com um valor negativo. A cada iteração, o índice do elemento do meio da matriz é calculado com mid = left + (right - left) / 2. Se o valor do elemento da matriz no índice mid for negativo, a pesquisa é continuada na metade esquerda da matriz ajustando o valor de right para mid - 1. Caso contrário, a pesquisa é continuada na metade direita da matriz ajustando o valor de left para mid + 1. Esse processo é repetido até que a primeira coluna com um valor negativo seja encontrada, ou até que left seja maior que right.
Após a busca binária ser concluída para uma linha, o número de elementos negativos restantes na linha pode ser calculado subtraindo o índice encontrado da primeira coluna do número total de colunas. Essa contagem é então adicionada ao contador total count.
O loop for continua a percorrer cada linha na matriz, e a busca binária é repetida para cada linha.
Quando o loop for termina, o valor de count é retornado, representando o número total de elementos negativos na matriz.

 */

 // Versão iterativa
 class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (grid[i][mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            count += cols - left;
        }
        
        return count;
    }
}

// Versão Recursiva

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols - 1;
            int index = binarySearchRecursive(grid[i], left, right);
            if (index != -1) {
                count += cols - index;
            }
        }

        return count;
    }

    public int binarySearchRecursive(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] < 0 && (mid == 0 || arr[mid - 1] >= 0)) {
            return mid;
        } else if (arr[mid] >= 0) {
            return binarySearchRecursive(arr, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, left, mid - 1);
        }
    }
}



// Versão com Comparable

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            count += binarySearch(grid[i], 0, cols - 1);
        }
        
        return count;
    }
    
    private int binarySearch(Comparable[] arr, int left, int right) {
        if (left > right) {
            return 0;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid].compareTo(0) < 0) {
            return right - mid + 1 + binarySearch(arr, left, mid - 1);
        } else {
            return binarySearch(arr, mid + 1, right);
        }
    }
    
    private int binarySearch(int[] arr, int left, int right) {
        Comparable[] compArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            compArr[i] = arr[i];
        }
        return binarySearch(compArr, left, right);
    }
}
