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
    private Node insertInner(Node node, tkey key, tvalue value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (comparator.compare(node.keyAndValue.first(), key) > 0) {
            node.leftSubtree = insertInner(node.leftSubtree, key, value);
        }
        else if (comparator.compare(node.keyAndValue.first(), key) < 0) {
            node.rightSubtree = insertInner(node.rightSubtree, key, value);
        }
        else {
            throw new IllegalArgumentException("Key already inserted");
        }

        return node;
    }

    private Node findInner(Node node, tkey key) {
        if (node == null) {
            return null;
        }
        if (comparator.compare(node.keyAndValue.first(), key) == 0) {
            return node;
        }

        return comparator.compare(node.keyAndValue.first(), key) > 0
            ? findInner(node.leftSubtree, key)
            : findInner(node.rightSubtree, key);
    }

    private Node findSmallestValue(Node node) {
        return node.leftSubtree == null ? node : findSmallestValue(node.leftSubtree);
    }

    private Node removeInner(Node node, tkey key) {
        if (node == null) {
            return null;
        }
        if (comparator.compare(node.keyAndValue.first(), key) == 0) {
            if (node.leftSubtree == null && node.rightSubtree == null) {
                return null;
            }
            if (node.leftSubtree == null) {
                return node.rightSubtree;
            }
            if (node.rightSubtree == null) {
                return node.leftSubtree;
            }

            Node successor = findSmallestValue(node.rightSubtree);
            node.keyAndValue.setFirst(successor.keyAndValue.first());
            node.keyAndValue.setSecond(successor.keyAndValue.second());
            node.rightSubtree = removeInner(node.rightSubtree, successor.keyAndValue.first());

            return node;
        }

        if (comparator.compare(node.keyAndValue.first(), key) > 0) {
            node.leftSubtree = removeInner(node.leftSubtree, key);
        }
        else {
            node.rightSubtree = removeInner(node.rightSubtree, key);
        }

        return node;
    }

    @Override
    public AssociativeContainer<tkey, tvalue> insert(tkey key, tvalue value) {
        root = insertInner(root, key, value);
        return this;
    }

    @Override
    public tvalue find(tkey key) {
        Node findNode = findInner(root, key);
        if (findNode != null) {
            return findNode.keyAndValue.second();
        }
        else {
            throw new NullPointerException("Key not found");
        }
    }

    @Override
    public AssociativeContainer<tkey, tvalue> remove(tkey key) {
        root = removeInner(root, key);
        return this;
    }
}
