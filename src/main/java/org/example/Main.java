package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>(Comparator.comparingInt(left -> left));
        tree.insert(10, 123).insert(4, 123421).insert(6, 312).insert(15, 31).insert(12, 3131).insert(16, 1231);

        for (var i : tree) {
            System.out.println(i.getValue1());
        }
    }
}