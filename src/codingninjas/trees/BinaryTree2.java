package codingninjas.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2 {


    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = queue.poll();
            int leftValue = -1;
            int rightValue = -1;

            if (currentNode.left != null) {

                leftValue = currentNode.left.data;

                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                rightValue = currentNode.right.data;

                queue.add(currentNode.right);
            }

            System.out.println(currentNode.data + ":L:" + leftValue + ",R:" + rightValue);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTree.takeInputElements();

        printLevelWise(root);
    }
}
