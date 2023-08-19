/*
 * 994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */

 import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Define as direções de movimento: cima, baixo, esquerda, direita
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Cria uma fila para armazenar as coordenadas das laranjas podres
        Queue<int[]> queue = new LinkedList<>();

        int freshOranges = 0; // Contador de laranjas frescas
        int minutes = 0; // Contador de minutos

        // Passo 1: Percorre a matriz para contar as laranjas frescas e adicionar as podres à fila
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
                else if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }

        // Passo 2: Simula o processo de apodrecimento das laranjas
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();

            // Processa todas as laranjas podres no mesmo minuto
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int x = orange[0];
                int y = orange[1];

                // Verifica as quatro direções e verifica se há laranjas frescas adjacentes
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // Verifica se a nova posição está dentro dos limites da matriz
                    // e se a laranja é fresca
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        // Marca a laranja como podre
                        grid[nx][ny] = 2;
                        freshOranges--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            // Incrementa o contador de minutos após processar todas as laranjas no mesmo minuto
            if (!queue.isEmpty())
                minutes++;
        }

        // Retorna -1 se ainda houver laranjas frescas, caso contrário, retorna o número de minutos
        return freshOranges == 0 ? minutes : -1;
    }
}

public class RottingOranges {
    public static void main(String[] args) {
        // Exemplo de uso da solução
        Solution solution = new Solution();

        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int minutes = solution.orangesRotting(grid);
        System.out.println(minutes); // Deve retornar 4
    }
}
