package codingninjas.linkedlist.linkedlist2;

import codingninjas.linkedlist.LinkedListNode;

public class LinkedList2Practice {


   /* public static LinkedListNode<Integer> insertRecursive(LinkedListNode<Integer> head, int pos, int data) {

        if (pos == 0) {
            


            LinkedListNode<Integer> linkedListNode = new LinkedListNode<>();
            linkedListNode.data = data;

            linkedListNode.next = head;

            return linkedListNode;
        }

        LinkedListNode<Integer> linkedListNode = insertRecursive(head.next, pos - 1, data);

        head.next = linkedListNode;


        return head;
    }*/

    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        //Your code goes here
        if(head==null){
            return head;
        }

        if(pos==0){

            return head.next;
        }

        LinkedListNode<Integer> smallOuput = deleteNodeRec(head.next, pos-1);
        head.next = smallOuput;

        return head;

    }

   /* public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
        //Your code goes here

        if(head==null){
            return head;
        }
        if(head.next==null){

            return head;
        }

        LinkedListNode<Integer> smallOutput = reverseLinkedListRec(head.next);

        head.next=null;

        LinkedListNode<Integer> temp = smallOutput;

        while(temp.next!=null){

            temp = temp.next;
        }
        temp.next = head;

        return smallOutput;
    }*/

     public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
        //Your code goes here

        if(head==null){
            return head;
        }
        if(head.next==null){

            return head;
        }

        LinkedListNode<Integer> smallOutput = reverseLinkedListRec(head.next);

        head.next.next = head;
        head.next=null;

        return smallOutput;


    }

    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
        //Your code goes here

        LinkedListNode<Integer>  fast = head;
        LinkedListNode<Integer>  slow = head;



        while(fast.next!=null && fast.next.next!=null){

            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

    }
}
