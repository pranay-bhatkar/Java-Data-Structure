package tree.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;


    }


    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subRoot); // left subtree -> true
        boolean rightAns = isSubtree(root.right, subRoot); //right subtree -> true

        return leftAns || rightAns;
    }

    static class Info2 {
        Node node;
        int hd;

        Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        // level order
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info2(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info2 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) { // first time my hd is occurring
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info2(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info2(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }


        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void kLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.removeLast();

        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node -> i - 1th

        return path1.get(i - 1);
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // left LCA = val right LCA = null
        if (rightLca == null) {
            return leftLca;
        }

        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) return -1;
        if (root.data == n) return 0;

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int KAncestor(Node root, int n, int k) {
        if (root == null) return -1;

        if (root.data == n) return 0;

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) return -1;

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k) System.out.println(root.data);

        return max + 1;

    }

    public static int transform(Node root) {

        if (root == null) return 0;

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;

    }

    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
         */


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

        /*
                2
               / \
              4   5
         */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println("subtree exist : " + isSubtree(root, subRoot));

        System.out.println("-----Top view of tree-----");
        topView(subRoot);

        System.out.println("---kth level of the tree----");

        int k = 2;
        kLevel(root, 1, k);

        System.out.println();

        System.out.println("----Lowest common ancestor-----");
        System.out.println(lca(root, 4, 5).data);
        System.out.println(lca2(root, 4, 5).data);

        System.out.println("-----Min dist bet Node-----");
        System.out.println(minDist(root, 4, 6));

        System.out.println("----Kth ancestor of Node-----");
        KAncestor(root, 4, 1);

        System.out.println("----transform to sum tree----");
        transform(root);
        preorder(root);

    }

}