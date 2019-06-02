/*
 * Created by Oxana Lobysheva on 02/06/2019.
 */

public class StudentDataBase {

    Node root;

    static class Node {
        int key;
        String name;
        int age;
        Node left;
        Node right;
        Node parent;

        public Node(int key, String name, int age, Node parent) {
            this.key = key;
            this.name = name;
            this.age = age;
            this.parent = parent;
        }

    }

    public Node find(int key) {
        return find(root, key);
    }

    public void add(int key, String name, int age) {
        root = add(root, null, key, name, age);
    }

    public void delete(int key) {
        delete(root, key);
    }

    public void printKeys() {
        printKeys(root);
        System.out.println();
    }

    public void printValues(Node node) {
        System.out.print("\nN:" + node.key + " " + node.name + " (age " + node.age + ")");
    }


    public void printTreePreOrder() {
        printTreePreOrder(root);
        System.out.println();
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            printValues(node);
            return node;
        }
        if (key < node.key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }


    private Node add(Node node, Node parent, int key, String name, int age) {
        if (node == null) {
            node = new Node(key, name, age, parent);
        } else {
            if (key < node.key) {
                node.left = add(node.left, node, key, name, age);
            } else {
                node.right = add(node.right, node, key, name, age);
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
            printValues(node);
            printKeys(node.right);
        }
    }

    private void printTreePreOrder(Node node) {
        if (node != null) {

            System.out.print(" " + node.key + " (" + node.name + "," + node.age + ") ");

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

}