class Country {
    String name;
    int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country: " + name + ", Population: " + population;
    }
}

class BNode {
    Country info;
    BNode left;
    BNode right;

    public BNode(Country country) {
        this.info = country;
        this.left = null;
        this.right = null;
    }
}

class BST {
    BNode root;

    public BST() {
        root = null;
    }

    public void insert(Country country) {
        root = insertNode(root, country);
    }

    private BNode insertNode(BNode root, Country country) {
        if (root == null) {
            return new BNode(country);
        }

        if (country.name.compareTo(root.info.name) < 0) {
            root.left = insertNode(root.left, country);
        } else if (country.name.compareTo(root.info.name) > 0) {
            root.right = insertNode(root.right, country);
        }

        return root;
    }
}

public class Q3 {
    public static void main(String[] args) {
        BST bst = new BST();

        // Inserting countries into the binary search tree
        bst.insert(new Country("USA", 328000000));
        bst.insert(new Country("China", 1393000000));
        bst.insert(new Country("India", 1371000000));
        bst.insert(new Country("Brazil", 212000000));
        bst.insert(new Country("Pakistan", 225000000));

        // Print the countries in the binary search tree
        System.out.println("Countries in the binary search tree:");
        inorderTraversal(bst.root);
    }

    public static void inorderTraversal(BNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.info);
            inorderTraversal(root.right);
        }
    }
}
