package codingninjas.linkedlist;

public class InsertNodeINLL {


    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data) {
        //Your code goes here

        LinkedListNode<Integer> temp = head;

        int index = 0;

        if (pos == 0) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            newNode.next = head;
            return newNode;
        }
        while (temp != null && pos > 0) {

            if (index == (pos - 1)) {

                LinkedListNode<Integer> newNode = new LinkedListNode<>(data);

                if (temp.next == null) {

                    temp.next = newNode;
                } else {

                    newNode.next = temp.next;
                    temp.next = newNode;

                }

                break;

            }

            index++;
            temp = temp.next;

        }

        return head;


    }


    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
        //Your code goes here

        LinkedListNode<Integer> temp = head;

        int index = 0;

        if (pos == 0) {

            return head.next;
        }
        while (temp != null && pos > 0) {

            if (index == (pos - 1)) {


                if ((temp.next != null) && temp.next.next != null) {

                    temp.next = temp.next.next;



                } else {

                    temp.next = null;

                }

                break;

            }

            index++;
            temp = temp.next;

        }

        return head;
    }

}
