class Node {
    int data;
    Node left, right, parent;
    char color; // 'R' for Red, 'B' for Black

    Node(int data) {
        this.data = data;
        left = right = parent = null;
        color = 'R'; // New nodes are always red
    }
}

public class RedBlackTree {
    private Node root;
    private Node TNULL; // Null leaf node

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = 'B';
        root = TNULL;
    }

    // Left rotate
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != TNULL) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    // Right rotate
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != TNULL) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }

        y.right = x;
        x.parent = y;
    }

    // Fix violations caused by insertion
    private void fixInsert(Node k) {
        Node uncle;
        while (k.parent.color == 'R') {
            if (k.parent == k.parent.parent.right) {
                uncle = k.parent.parent.left;

                // Case 1: Uncle is red
                if (uncle.color == 'R') {
                    uncle.color = 'B';
                    k.parent.color = 'B';
                    k.parent.parent.color = 'R';
                    k = k.parent.parent;
                } else {
                    // Case 2: k is left child
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    // Case 3: k is right child
                    k.parent.color = 'B';
                    k.parent.parent.color = 'R';
                    leftRotate(k.parent.parent);
                }
            } else {
                uncle = k.parent.parent.right;

                // Case 1: Uncle is red
                if (uncle.color == 'R') {
                    uncle.color = 'B';
                    k.parent.color = 'B';
                    k.parent.parent.color = 'R';
                    k = k.parent.parent;
                } else {
                    // Case 2: k is right child
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    // Case 3: k is left child
                    k.parent.color = 'B';
                    k.parent.parent.color = 'R';
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 'B';
    }

    // Insert a new node
    public void insert(int key) {
        Node node = new Node(key);
        node.left = TNULL;
        node.right = TNULL;

        Node y = null;
        Node x = root;

        // Find the position to insert
        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        // If new node is root, color it black and return
        if (node.parent == null) {
            node.color = 'B';
            return;
        }

        // If grandparent is null, return
        if (node.parent.parent == null) {
            return;
        }

        // Fix Red-Black tree violations
        fixInsert(node);
    }

    // Inorder traversal
    private void inorderTraversal(Node node) {
        if (node != TNULL) {
            inorderTraversal(node.left);
            System.out.print(node.data + "(" + node.color + ") ");
            inorderTraversal(node.right);
        }
    }

    // Print the tree
    public void printTree() {
        System.out.println("Inorder traversal of Red-Black Tree:");
        inorderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // Insert some values
        tree.insert(7);
        tree.insert(3);
        tree.insert(18);
        tree.insert(10);
        tree.insert(22);
        tree.insert(8);
        tree.insert(11);
        tree.insert(26);
        tree.insert(2);
        tree.insert(6);

        // Print the tree
        tree.printTree();
    }
}
