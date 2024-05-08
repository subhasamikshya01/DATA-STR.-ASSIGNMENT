package Q7;
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

public class Q7 {
    BNode root;

    public Q7() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private BNode insertNode(BNode root, int value) {
        if (root == null) {
            return new BNode(value);
        }

        if (value < root.info) {
            root.left = insertNode(root.left, value);
        } else if (value > root.info) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    public void inorderTraversal(BNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.info + " ");
            inorderTraversal(root.right);
        }
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    private BNode deleteNode(BNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.info) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.info) {
            root.right = deleteNode(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.info = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.info);
        }

        return root;
    }

    private int minValue(BNode node) {
        int min = node.info;
        while (node.left != null) {
            min = node.left.info;
            node = node.left;
        }
        return min;
    }

    public static void main(String[] args) {
        Q7 bst = new Q7();

        // Insert nodes into the binary search tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print the original BST
        System.out.println("Original BST:");
        bst.inorderTraversal(bst.root);
        System.out.println();

        // Delete node 30 from the BST
        bst.delete(30);

        // Print the BST after deletion
        System.out.println("BST after deleting node 30:");
        bst.inorderTraversal(bst.root);
    }
}
