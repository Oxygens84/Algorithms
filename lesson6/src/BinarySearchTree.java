/*
 * Created by Oxana Lobysheva on 02/06/2019.
 */

public class BinarySearchTree {

    Node root;

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        public Node(int key, Node parent) {
            this.key = key;
            this.parent = parent;
        }

    }

    public Node find(int key) {
        return find(root, key);
    }

    public void add(int key) {
        root = add(root, null, key);
    }

    public void delete(int key) {
        delete(root, key);
    }

    public void printKeys() {
        printKeys(root);
        System.out.println();
    }

    public void printTree(int type) {
        if (type == 1)  printTreePreOrder(root);
        if (type == 2)  printTreeInOrder(root);
        if (type == 3)  printTreePostOrder(root);
        System.out.println();
    }

    public void printTreePreOrder() {
        printTreePreOrder(root);
        System.out.println();
    }

    public void printTreeInOrder() {
        printTreeInOrder(root);
        System.out.println();
    }

    public void printTreePostOrder() {
        printTreePostOrder(root);
        System.out.println();
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            printTreePreOrder(node);
            System.out.println();
            printKeys(node);
            System.out.println();
            return node;
        }
        if (key < node.key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }


    private Node add(Node node, Node parent, int key) {
        if (node == null) {
            node = new Node(key, parent);
        } else {
            if (key < node.key) {
                node.left = add(node.left, node, key);
            } else {
                node.right = add(node.right, node, key);
            }
        }
        return node;
    }

    private void replace(Node a, Node b) {
        if (a.parent == null) {
            root = b;
        } else if (a == a.parent.left) {
            a.parent.left = b;
        } else {
            a.parent.right = b;
        }
        if (b != null) {
            b.parent = a.parent;
        }
    }

    private void delete(Node node, int key) {
        if (node == null) return;
        if (key < node.key) {
            delete(node.left, key);
        } else if (key > node.key) {
            delete(node.right, key);
        } else if (node.left != null && node.right != null) {
            Node tmp = node.right;
            while (tmp.left != null)
                tmp = tmp.left;
            node.key = tmp.key;
            replace(tmp, tmp.right);
        } else if (node.left != null) {
            replace(node, node.left);
        } else if (node.right != null) {
            replace(node, node.right);
        } else {
            replace(node, null);
        }
    }

    private void printKeys(Node node) {
        if (node != null) {
            printKeys(node.left);
            System.out.print(" key:" + node.key + " ");
            printKeys(node.right);
        }
    }

    private void printTreePreOrder(Node node) {
        if (node != null) {

            System.out.print(" " + node.key + " ");

            System.out.print("(");
            if (node.left == null) {
                System.out.print("null");
            } else {
                printTreePreOrder(node.left);
            }

            System.out.print(",");

            if (node.right == null) {
                System.out.print("null");
            } else {
                printTreePreOrder(node.right);
            }

            System.out.print(")");

        }
    }

    private void printTreeInOrder(Node node) {
        if (node != null) {

            System.out.print("(");

            if (node.left == null) {
                System.out.print("null");
            } else {
                printTreeInOrder(node.left);
            }

            System.out.print(", " + node.key + " ,");

            if (node.right == null) {
                System.out.print("null");
            } else {
                printTreeInOrder(node.right);
            }

            System.out.print(")");

        }
    }

    private void printTreePostOrder(Node node) {
        if (node != null) {

            System.out.print("(");

            if (node.left == null) {
                System.out.print("null");
            } else {
                printTreePostOrder(node.left);
            }

            System.out.print(",");

            if (node.right == null) {
                System.out.print("null");
            } else {
                printTreePostOrder(node.right);
            }

            System.out.print(")");

            System.out.print(" " + node.key + " ");

        }
    }


    public void fillTree(String data){
        data = data.replaceAll( "[^\\d]", "," );
        String[] parts = data.split(",");
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].equals("")) {
                int tmp = Integer.valueOf(parts[i]);
                add(tmp);
            }
        }
    }

}