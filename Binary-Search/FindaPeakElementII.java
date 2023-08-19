/*
 * Find a Peak Element II
 * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

 Nesta solução, a função findPeakGrid recebe como parâmetro uma matriz bidimensional mat e retorna um array de inteiros contendo as coordenadas do pico encontrado na matriz.

A função usa um loop while para dividir a matriz em submatrizes menores até que o pico seja encontrado ou até que a matriz seja reduzida a uma submatriz de tamanho 1x1.

Dentro do loop while, a função calcula o elemento central da submatriz atual e procura o índice da coluna com o maior valor nessa linha usando um loop for. Em seguida, a função verifica se o elemento central é um pico, ou se o pico está em uma das submatrizes superiores ou inferiores, e atualiza os limites das submatrizes apropriadas.

Finalmente, quando um pico é encontrado, as coordenadas do pico são armazenadas em um array de inteiros e retornadas pela função.
 */

 //Versão Iterativa

 class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] result = new int[2];
        int startRow = 0;
        int endRow = mat.length - 1;
        int startCol = 0;
        int endCol = mat[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            int midRow = (startRow + endRow) / 2;
            int maxCol = startCol;
            for (int i = startCol; i <= endCol; i++) {
                if (mat[midRow][i] > mat[midRow][maxCol]) {
                    maxCol = i;
                }
            }
            boolean isPeak = true;
            if (midRow > 0 && mat[midRow - 1][maxCol] > mat[midRow][maxCol]) {
                isPeak = false;
                endRow = midRow - 1;
            } else if (midRow < mat.length - 1 && mat[midRow + 1][maxCol] > mat[midRow][maxCol]) {
                isPeak = false;
                startRow = midRow + 1;
            }
            if (isPeak) {
                result[0] = midRow;
                result[1] = maxCol;
                break;
            }
        }
        return result;
    }
}


//Versão Recursiva
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] result = new int[2];
        findPeak(mat, 0, mat.length - 1, 0, mat[0].length - 1, result);
        return result;
    }
    
    private void findPeak(int[][] mat, int startRow, int endRow, int startCol, int endCol, int[] result) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }
        int midRow = (startRow + endRow) / 2;
        int maxCol = startCol;
        for (int i = startCol; i <= endCol; i++) {
            if (mat[midRow][i] > mat[midRow][maxCol]) {
                maxCol = i;
            }
        }
        if (midRow > 0 && mat[midRow - 1][maxCol] > mat[midRow][maxCol]) {
            findPeak(mat, startRow, midRow - 1, startCol, endCol, result);
        } else if (midRow < mat.length - 1 && mat[midRow + 1][maxCol] > mat[midRow][maxCol]) {
            findPeak(mat, midRow + 1, endRow, startCol, endCol, result);
        } else {
            result[0] = midRow;
            result[1] = maxCol;
        }
    }
}


// Versão Comparable