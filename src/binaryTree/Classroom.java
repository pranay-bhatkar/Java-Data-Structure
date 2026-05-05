package binaryTree;

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

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;

    }

    public static int count(Node root) {
        if (root == null) return 0;

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        return leftCount + rightCount + 1;
    }

    // approach 1 -> O(n^2)
    public static int sum(Node root) {
        if (root == null) return 0;

        int leftSum = sum(root.left);
        int righttSum = sum(root.right);

        return leftSum + righttSum + root.data;

    }

    // public static int diameter(Node root) {
    // if (root == null)
    // return 0;

    // int leftdiam = diameter(root.left);
    // int righttdiam = diameter(root.right);
    // int lh = height(root.left);
    // int rh = height(root.right);

    // int selfDiam = lh + rh + 1;

    // return Math.max(selfDiam, Math.max(leftdiam, righttdiam));
    // }

    public static int diameter2(Node root) {
        if (root == null) return 0;

        int leftdiam = diameter2(root.left);
        int righttdiam = diameter2(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiam = lh + rh + 1;

        return Math.max(selfDiam, Math.max(leftdiam, righttdiam));
    }

    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    // approach 2 -> O(n)
    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("height of the tree = " + height(root));

        System.out.println("count of nodes of the tree = " + count(root));

        System.out.println("sum of nodes of the tree = " + sum(root));

        System.out.println("Diameter of the tree = " + diameter(root).diam);

    }

}