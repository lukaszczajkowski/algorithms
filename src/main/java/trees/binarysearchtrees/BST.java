package trees.binarysearchtrees;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        // number of nodes in subtree rooted here
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return node.size;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node current, Key key) {
        if (current == null) {
            return null;
        }

        int compare = key.compareTo(current.key);

        if (compare > 0) {
            return get(current.right, key);
        } else if (compare < 0) {
            return get(current.left, key);
        } else {
            return current.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node current, Key key, Value value) {
        if (current == null) {
            return new Node(key, value, 1);
        }

        int compare = key.compareTo(current.key);

        if (compare > 0) {
            current.right = put(current.right, key, value);
        } else if (compare < 0) {
            current.left = put(current.left, key, value);
        } else {
            current.value = value;
        }

        current.size = size(current.left) + size(current.right) + 1;
        return current;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node current) {
        if (current.left == null) {
            return current;
        }

        return min(current.left);
    }

    public Key floor(Key key) {
        Node floor = floor(root, key);

        return floor == null ? null : floor.key;
    }

    private Node floor(Node current, Key key) {
        if (current == null) {
            return null;
        }

        int cmp = key.compareTo(current.key);

        if (cmp == 0) {
            return current;
        } else if (cmp < 0) {
            return floor(current.left, key);
        } else {
            Node t = floor(current.right, key);
            return t != null ? t : current;
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node current) {
        if (current.left == null) {
            return current.right;
        }

        current.left = deleteMin(current.left);
        current.size = 1 + size(current.left) + size(current.right);

        return current;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node current, Key key) {
        if (current == null) {
            return null;
        }

        int cmp = key.compareTo(current.key);

        if (cmp > 0) {
            current.right = deleteMin(current.right);
        } else if (cmp < 0) {
            current.left = deleteMin(current.left);
        } else {
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            Node toDelete = current;
            current = min(toDelete);
            current.right = deleteMin(toDelete.right);
            current.left = toDelete.left;
        }

        current.size = 1 + size(current.left) + size(current.right);
        return current;
    }
}
