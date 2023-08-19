/*
933. Number of Recent Calls

You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

Example 1:

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 */

 import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Adiciona a solicitação atual à fila
        requests.offer(t);
        
        // Remove as solicitações antigas que estão fora da janela de tempo (3000 ms)
        while (requests.peek() < t - 3000) {
            requests.poll();
        }
        
        // Retorna o número de solicitações recentes
        return requests.size();
    }
}

public class NumberofRecentCalls {
    public static void main(String[] args) {
        // Cria uma instância do objeto RecentCounter
        RecentCounter counter = new RecentCounter();
        
        // Teste com algumas chamadas de ping
        System.out.println(counter.ping(100)); // Deve retornar 1
        System.out.println(counter.ping(3001)); // Deve retornar 2
        System.out.println(counter.ping(3002)); // Deve retornar 3
        System.out.println(counter.ping(7000)); // Deve retornar 1
        System.out.println(counter.ping(8000)); // Deve retornar 2
    }
}
