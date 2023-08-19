package LinkedList.MergeTwoSortedLists.Single;

public interface MergeTwoSortedLists<T extends Comparable<T>> {
  SingleLinkedListNode<T> mergeTwoLists(SingleLinkedListNode<T> l1, SingleLinkedListNode<T> l2);
}

