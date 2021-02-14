package codingninjas.linkedlist.assignment;

import codingninjas.linkedlist.LinkedListNode;

public class LinkedList1Assignment {

    public static int findNode(LinkedListNode<Integer> head, int n) {
        //Your code goes here

        int index = 0;
        while (head.next != null) {

            if(head.data==n){
                return index;
            }

            head = head.next;

            index++;

        }
        return -1;
    }
}
