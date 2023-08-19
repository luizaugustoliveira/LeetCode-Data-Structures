/*
 * Definição para uma lista ligada.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val; // Copia o valor do próximo nó
        node.next = node.next.next; // 'Pula' o próximo nó
    }
}
