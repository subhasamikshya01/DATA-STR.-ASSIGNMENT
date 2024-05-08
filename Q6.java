package Q6;

class BNode {
    int info;
    BNode left;
    BNode right;

    public BNode(int value) {
        this.info = value;
        this.left = null;
        this.right = null;
    }
}

public class Q6 {
    BNode root;

    public Q6() {
        root = null;
    }

    public boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(BNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.info < min || node.info > max) {
            return false;
        }

        return isBSTUtil(node.left, min, node.info - 1) && isBSTUtil(node.right, node.info + 1, max);
    }

    public static void main(String[] args) {
        // Construct a binary tree
        Q6 tree = new Q6();
        tree.root = new BNode(4);
        tree.root.left = new BNode(2);
        tree.root.right = new BNode(6);
        tree.root.left.left = new BNode(1);
        tree.root.left.right = new BNode(3);
        tree.root.right.left = new BNode(5);
        tree.root.right.right = new BNode(7);

        // Check if the binary tree is a BST
        if (tree.isBST()) {
            System.out.println("The binary tree is a binary search tree.");
        } else {
            System.out.println("The binary tree is not a binary search tree.");
        }
    }
}

