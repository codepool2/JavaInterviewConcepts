package codingninjas.trees;

public class BinaryTreeUse {


    public static void main(String[] args) {

        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(1);

        BinaryTreeNode<Integer> rootsLeft = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rootsRight = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> rootsLeftLeft = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> rootsLeftright = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> rootsLeftrightRight = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> rootsLeftLeftRight = new BinaryTreeNode<>(7);

        rootNode.left = rootsLeft;
        rootNode.right = rootsRight;
        rootsLeft.left = rootsLeftLeft;
        rootsLeft.right = rootsLeftright;
        rootsLeftright.right=rootsLeftrightRight;
        rootsLeftLeft.right= rootsLeftLeftRight;

       // System.out.println(BinaryTreeAssignment.isNodePresent(rootNode, 1));

        BinaryTreeAssignment.printNodesWithoutSibling(rootNode);

        /*BinaryTree binaryTree = new BinaryTree();

     //   BinaryTree.printNodesAtDepthK(rootNode,2);
        BinaryTree.changeToDepthTree(rootNode);
        BinaryTree.preOrder(rootNode);*/
       // System.out.println(BinaryTree.getNodeWithLargestData(rootNode));
       //  System.out.println(binaryTree.getNumberOfNodes(rootNode ));
       // System.out.println(binaryTree.getSum(rootNode));
        /*binaryTree.travsersal(rootNode);

        System.out.println(rootNode);*/
    }
}
