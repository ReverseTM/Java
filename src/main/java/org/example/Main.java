package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        AssociativeContainer<Integer, Integer> bst = new BinarySearchTree<>(Comparator.comparingInt(left -> left));
        bst.insert(1, 123).insert(2, 123421);
        var x = 5;
    }
}