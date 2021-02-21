package codingninjas.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeAssignment2 {


    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new BinaryTreeNode<>(-1));

        while (!queue.isEmpty()) {

            System.out.println();

            BinaryTreeNode<Integer> rootElementNode = queue.poll();
            BinaryTreeNode<Integer> rootElement = rootElementNode;

            while (rootElement.data != -1) {

                System.out.print(rootElement.data + " ");
                rootElement = queue.poll();

            }

            if (rootElementNode.left != null) {

                queue.add(rootElementNode.left);
            }

            if (rootElementNode.right != null) {
                queue.add(rootElementNode.right);
            }

            if (rootElementNode.left != null || rootElementNode.right != null)
                queue.add(new BinaryTreeNode<>(-1));
        }

    }


    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);


        BinaryTreeNode<Integer> temp = root.left;

        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(root.data);
        root.left = node;


        root.left.left = temp;


    }

    public static void main(String[] args) {

        // printLevelWise( BinaryTree.takeInputElements());
        BinaryTreeNode<Integer> root = BinaryTree.takeInputElements();
        insertDuplicateNode(root);
        printLevelWise(root);
    }

}
