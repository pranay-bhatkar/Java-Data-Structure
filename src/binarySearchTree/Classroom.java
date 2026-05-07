package binarySearchTree;

import java.util.ArrayList;

public class Classroom {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static Node createMirror(Node root) {
        if (root == null) return null;

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;

    }

    public static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static Node createBST(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }


    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;
        ;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balancedBST(Node root) {
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder =>balanced BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void main(String[] args) {

        /*
                8
               / \
              5   10
             / \    \
            3   6    11


    */


        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.left.left = new Node(6);
        root.right.right = new Node(11);

    /*
            Mirror BST
                8
               / \
              10  5
             /   /  \
            11  6    3

    */

        root = createMirror(root);
        preOrder(root);


        System.out.println();
        System.out.println("-----sorted Balanced BST-----");
        int[] arr = {3, 5, 6, 8, 10, 11, 12};
        Node root2 = createBST(arr, 0, arr.length - 1);
        preOrder(root2);

        System.out.println();
        System.out.println("-------- convert BST to Balnaced BST");
        root = balancedBST(root);
        preOrder(root);

    }
}