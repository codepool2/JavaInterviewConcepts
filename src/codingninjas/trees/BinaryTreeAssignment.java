package codingninjas.trees;

public class BinaryTreeAssignment {


    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x){


        if(root==null){
            return false;
        }

        if (root.data == x) {
            return true;
        }

        boolean isLeftPresent = isNodePresent(root.left, x);
        boolean isRightPresent = isNodePresent(root.right, x);

        return isLeftPresent || isRightPresent;

    }

    public static void printNodesWithoutSiblings(BinaryTreeNode<Integer> root){

        if(root==null){
            return;
        }

        if(root.left!=null && root.right==null){
            System.out.print(root.left.data+" ");
            printNodesWithoutSiblings(root.left);
        }else if(root.left==null && root.right!=null){
            System.out.print(root.right.data+" ");
            printNodesWithoutSiblings(root.right);
        }else{

            printNodesWithoutSiblings(root.left);
            printNodesWithoutSiblings(root.right);
        }
    }
}
