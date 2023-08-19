/*
 * Searcha2DMatrixII
 * 
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 */

 // Versão Iterativa

 /*
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0;
    int high = m * n - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int i = mid / n;
        int j = mid % n;
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return false;
}
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Verifica se a matriz é válida
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // Obtém o número de linhas e colunas da matriz
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Percorre cada linha da matriz
        for (int i = 0; i < m; i++) {
            // Inicializa os índices para a busca binária
            int low = 0;
            int high = n - 1;
            
            // Realiza a busca binária na linha atual
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] == target) {
                    // Se o elemento for encontrado, retorna verdadeiro
                    return true;
                } else if (matrix[i][mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        
        // Se o elemento não for encontrado, retorna falso
        return false;
      }
    }
    
    public class Main {
        public static void main(String[] args) {
            Solution s = new Solution();
            int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
            };
            int target = 3;
            boolean result = s.searchMatrix(matrix, target);
            System.out.println(result); // true
            
            target = 13;
            result = s.searchMatrix(matrix, target);
            System.out.println(result); // false
        }
    }

 // Versão Recursiva

 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Verifica se a matriz é válida
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // Obtém o número de linhas e colunas da matriz
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Verifica se o target está dentro dos limites da matriz
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        
        // Varre linha por linha da matriz
        for (int i = 0; i < m; i++) {
            // Verifica se o target está dentro dos limites da linha atual
            if (target >= matrix[i][0] && target <= matrix[i][n-1]) {
                // Realiza uma busca binária na linha atual
                if (binarySearch(matrix[i], target)) {
                    return true;
                }
            }
        }
        
        // Se o elemento não for encontrado, retorna falso
        return false;
    }
    
    // Função de busca binária em uma linha da matriz
    private boolean binarySearch(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target1 = 5;
        int target2 = 20;
        
        System.out.println(sol.searchMatrix(matrix, target1)); // Deve imprimir "true"
        System.out.println(sol.searchMatrix(matrix, target2)); // Deve imprimir "false"
    }
}

//Versão Comparable

class Solution implements Comparable<Solution> {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Verifica se a matriz é válida
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // Obtém o número de linhas e colunas da matriz
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Verifica se o target está dentro dos limites da matriz
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        
        // Varre linha por linha da matriz
        for (int i = 0; i < m; i++) {
            // Verifica se o target está dentro dos limites da linha atual
            if (target >= matrix[i][0] && target <= matrix[i][n-1]) {
                // Realiza uma busca binária na linha atual
                if (binarySearch(matrix[i], target)) {
                    return true;
                }
            }
        }
        
        // Se o elemento não for encontrado, retorna falso
        return false;
    }
    
    // Função de busca binária em uma linha da matriz
    private boolean binarySearch(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return false;
    }
    
    // Implementação do método compareTo() da interface Comparable
    public int compareTo(Solution other) {
        // Define a ordem de precedência como a ordem lexicográfica dos valores dos atributos da classe
        // Nesse caso, como a classe não possui atributos, consideramos todas as instâncias iguais
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target1 = 5;
        int target2
