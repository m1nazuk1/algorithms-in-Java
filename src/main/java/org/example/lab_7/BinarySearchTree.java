/**
 * @author_Nizami_Alekperov
 *
 * @Laba-7
 *
 * todo Task:
 * Опишите класс — дерево, необходимое для решения задачи, указанной в вашем варианте задания, и реализуйте его методы.
 * Продемонстрируйте работу основных методов работы с деревом: построение, вывод, обход.
 * Составьте программу решения задачи, указанной в вашем варианте задания.
 * Задание: Найти дубликаты в списке чисел с использованием дерева поиска.
 */


package org.example.lab_7;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void create(int value) {
        root = insertRec(root, null, value);
    }

    void clear() {
        root = null;
    }

    Node insertRec(Node root, Node parent, int value) {
        if (root == null) {
            root = new Node(value);
            root.parent = parent;
            return root;
        }

        if (value < root.value)
            root.left = insertRec(root.left, root, value);
        else if (value > root.value)
            root.right = insertRec(root.right, root, value);

        return root;
    }

    void insert(int value) {
        root = insertRec(root, null, value);
    }

    Node search(Node root, int value) {
        if (root == null || root.value == value)
            return root;

        if (root.value < value)
            return search(root.right, value);

        return search(root.left, value);
    }

    Node addr(int value) {
        return search(root, value);
    }

    int value(Node node) {
        return node.value;
    }

    Node left(Node node) {
        return node.left;
    }

    Node right(Node node) {
        return node.right;
    }

    Node father(Node node) {
        return node.parent;
    }

    Node brother(Node node) {
        if (node == null || node.parent == null) {
            return null;
        }
        if (node.parent.left == node) {
            return node.parent.right;
        } else {
            return node.parent.left;
        }
    }

    boolean isLeft(Node node) {
        return node != null && node.parent != null && node.parent.left == node;
    }

    boolean isRight(Node node) {
        return node != null && node.parent != null && node.parent.right == node;
    }

    void writeTo(Node node, int level) {
        if (node == null)
            return;

        writeTo(node.right, level + 1);
        System.out.println(" ".repeat(level * 4) + node.value);
        writeTo(node.left, level + 1);
    }

    void printTree() {
        writeTo(root, 0);
    }

    int nodesQuantity(Node node) {
        if (node == null)
            return 0;
        return 1 + nodesQuantity(node.left) + nodesQuantity(node.right);
    }

    List<Integer> findDuplicates(List<Integer> numbers) {
        List<Integer> duplicates = new ArrayList<>();
        for (int number : numbers) {
            Node node = addr(number);
            if (node != null) {
                duplicates.add(number);
            } else {
                insert(number);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.create(20);

        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);

        System.out.println("Бинарное дерево поиска:");
        bst.printTree();

        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 10, 20);
        List<Integer> duplicates = bst.findDuplicates(numbers);
        System.out.println("Дубликаты: " + duplicates);
    }
}
