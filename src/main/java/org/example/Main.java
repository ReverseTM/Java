package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        AssociativeContainer<Integer, Integer> bst = new BinarySearchTree<>(Comparator.comparingInt(left -> left));
        bst.insert(10, 123);
        bst.insert(4, 123421);
        bst.insert(6, 312);
        bst.insert(15, 31);
        bst.insert(12, 3131);
        bst.remove(10);
        bst.remove(4);
        bst.remove(15);
        bst.remove(12);
        bst.remove(6);
    }
}