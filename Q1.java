class BSTNode {
    int info;
    BSTNode left;
    BSTNode right;

    public BSTNode(int value) {
        this.info = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private BSTNode insertNode(BSTNode root, int value) {
        if (root == null) {
            return new BSTNode(value);
        }

        if (value < root.info) {
            root.left = insertNode(root.left, value);
        } else if (value > root.info) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }
}

public class Q1 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Inserting nodes into the binary search tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
    }
}
