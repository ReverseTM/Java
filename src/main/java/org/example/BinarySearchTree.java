package org.example;

import java.util.Comparator;

public final class BinarySearchTree<tkey, tvalue> extends AssociativeContainer<tkey, tvalue> {
    private class Node {
        private final Pair<tkey, tvalue> keyAndValue;
        Node leftSubtree;
        Node rightSubtree;
        public Node(tkey key, tvalue value) {
            keyAndValue = new Pair<>(key, value);
            leftSubtree = null;
            rightSubtree = null;
        }
    }
    final Comparator<tkey> comparator;
    Node root;

    public BinarySearchTree(Comparator<tkey> comparator) {
        root = null;
        this.comparator = comparator;
    }
    private Node insertInner(Node root, tkey key, tvalue value) {
        if (root == null) {
            return new Node(key, value);
        }
        if (comparator.compare(root.keyAndValue.First(), key) > 0) {
            root.leftSubtree = insertInner(root.leftSubtree, key, value);
        }
        else if (comparator.compare(root.keyAndValue.First(), key) < 0) {
            root.rightSubtree = insertInner(root.rightSubtree, key, value);
        }
        else {
            return root;
        }

        return root;
    }
    private void removeInner(tkey key) {
        return;
    }

    private Node findInner(tkey key) {
        return null;
    }

    @Override
    public AssociativeContainer<tkey, tvalue> insert(tkey key, tvalue value) {
        root = insertInner(root, key, value);
        return this;
    }

    @Override
    public AssociativeContainer<tkey, tvalue> remove(tkey key) {
        removeInner(key);
        return this;
    }

    @Override
    public tvalue find(tkey key) {
        return findInner(key).keyAndValue.Second();
    }
}
