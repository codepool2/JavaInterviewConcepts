package codingninjas.trees;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {


    public int getNumberOfNodes(BinaryTreeNode<Integer> rootNode) {

        if (rootNode == null)
            return 0;

        int leftNum = getNumberOfNodes(rootNode.left);
        int rightNum = getNumberOfNodes(rootNode.right);

        return (leftNum + rightNum + 1);

    }

    public static void printNodesAtDepthK(BinaryTreeNode<Integer> root, int k) {

        if (root == null) {
            return;
        }
        if (k == 0) {

            System.out.println(root.data);
            return;
        }

        printNodesAtDepthK(root.left, k - 1);
        printNodesAtDepthK(root.right, k - 1);


    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {

        changeToDepthTree(root, 0);

    }

    private static void changeToDepthTree(BinaryTreeNode<Integer> root, int i) {

        if (root == null)
            return;

        root.data = i;
        if (root.left != null) {

            changeToDepthTree(root.left, i + 1);
        }

        if (root.right != null) {
            changeToDepthTree(root.right, i + 1);
        }
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }

        int count = root.data > x ? 1 : 0;

        if (root.left != null) {
            count += countNodesGreaterThanX(root.left, x);

        }

        if (root.right != null) {
            count += countNodesGreaterThanX(root.right, x);

        }

        return count;

    }

    public static int getSum(BinaryTreeNode<Integer> root) {

        if (root == null)
            return 0;

        int leftNodeSum = getSum(root.left);
        int rightNodeSum = getSum(root.right);

        return leftNodeSum + rightNodeSum + root.data;
    }

    public static void preOrder(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(BinaryTreeNode<Integer> root) {

        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static int getNodeWithLargestData(BinaryTreeNode<Integer> root) {

        if (root == null)
            return -1;

        int leftCount = getNodeWithLargestData(root.left);
        int rightCount = getNodeWithLargestData(root.right);

        return Math.max(Math.max(leftCount, rightCount), root.data);
    }

    public static void inOrder(BinaryTreeNode<Integer> root) {

        if (root == null)
            return;

        postOrder(root.left);
        System.out.println(root.data);
        postOrder(root.right);

    }

    public void travsersal(BinaryTreeNode<Integer> node) {

        if (node == null) {
            return;
        }

        System.out.println(node.data + ": L " + node.left.data + ", R " + node.right.data);

        travsersal(node.left);
        travsersal(node.right);

    }


    public static BinaryTreeNode<Integer> takeInputElements()  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = scanner.nextInt();

        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {

            BinaryTreeNode<Integer> rootNode = pendingChildren.poll();

            System.out.println("Enter left child for :" + rootNode.data);
            int left = scanner.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(left);
                rootNode.left = leftNode;

                pendingChildren.add(leftNode);

            }

            System.out.println("Enter right child for :" + rootNode.data);
            int right = scanner.nextInt();

            if (right != -1) {

                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(right);
                rootNode.right = rightNode;

                pendingChildren.add(rightNode);
            }


        }

        return root;
    }
}
