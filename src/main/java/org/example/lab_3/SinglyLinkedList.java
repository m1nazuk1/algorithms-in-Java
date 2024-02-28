/**
 * @author_Nizami_Alekperov
 *
 * @Laba-3
 *
 * @Ex-1
 *
 * todo Task:
 * Не использовать стандартные коллекции, структуры реализовывать самостоятельно
 * Реализовать односвязный (однонаправленный) список и следующие функции:
 * • Добавление элемента в начало списка
 * • Показ всех элементов списка
 * • Определение количества элементов списка
 * • Удаление первого элемента
 * • Поиск данного значения в списке
 * • Удаление элемента списка с данным значением
 * • Изменение всех элементов списка с данным значением на новое.
 * • Определение, является ли список симметричным.
 * • Определение, сколько различных значений содержится в списке.
 * • Сортировка элементов списка способом изменения указателей
 */


package org.example.lab_3;

import java.util.Scanner;

public class SinglyLinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void show() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int value) {
        if (head == null) return;
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void replaceAll(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
            }
            current = current.next;
        }
    }

    public boolean isSymmetric() {
        if (head == null) return true;
        return isSymmetricSubList(head, size());
    }

    private boolean isSymmetricSubList(Node start, int size) {
        if (size <= 1) return true;
        if (size == 2) return start.data == start.next.data;
        Node end = start;
        for (int i = 1; i < size; i++) {
            end = end.next;
        }
        return start.data == end.data && isSymmetricSubList(start.next, size - 2);
    }

    public int countDistinct() {
        Node current = head;
        int distinctCount = 0;
        while (current != null) {
            boolean isDistinct = true;
            Node checker = head;
            while (checker != current) {
                if (checker.data == current.data) {
                    isDistinct = false;
                    break;
                }
                checker = checker.next;
            }
            if (isDistinct) {
                distinctCount++;
            }
            current = current.next;
        }
        return distinctCount;
    }

    public void sort() {
        if (head == null || head.next == null) return;

        for (Node current = head; current.next != null; current = current.next) {
            Node min = current;
            for (Node checker = current.next; checker != null; checker = checker.next) {
                if (checker.data < min.data) {
                    min = checker;
                }
            }
            int temp = current.data;
            current.data = min.data;
            min.data = temp;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить элемент в начало");
            System.out.println("2. Показать все элементы");
            System.out.println("3. Посчитать элементы");
            System.out.println("4. Удалить первый элемент");
            System.out.println("5. Поиск значения");
            System.out.println("6. Удалить элемент с определенным значением");
            System.out.println("7. Заменить все вхождения значения");
            System.out.println("8. Проверить, симметричен ли список");
            System.out.println("9. Посчитать уникальные значения");
            System.out.println("10. Сортировать список");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите значение для добавления: ");
                    int addValue = scanner.nextInt();
                    list.addFirst(addValue);
                    break;
                case 2:
                    System.out.println("Элементы в списке:");
                    list.show();
                    break;
                case 3:
                    System.out.println("Количество элементов: " + list.size());
                    break;
                case 4:
                    list.removeFirst();
                    System.out.println("Первый элемент удален.");
                    break;
                case 5:
                    System.out.print("Введите значение для поиска: ");
                    int searchValue = scanner.nextInt();
                    System.out.println("Значение найдено: " + list.search(searchValue));
                    break;
                case 6:
                    System.out.print("Введите значение для удаления: ");
                    int removeValue = scanner.nextInt();
                    list.remove(removeValue);
                    System.out.println("Элемент удален.");
                    break;
                case 7:
                    System.out.print("Введите старое значение: ");
                    int oldValue = scanner.nextInt();
                    System.out.print("Введите новое значение: ");
                    int newValue = scanner.nextInt();
                    list.replaceAll(oldValue, newValue);
                    System.out.println("Значения заменены.");
                    break;
                case 8:
                    System.out.println("Список симметричен: " + list.isSymmetric());
                    break;
                case 9:
                    System.out.println("Количество уникальных значений: " + list.countDistinct());
                    break;
                case 10:
                    list.sort();
                    System.out.println("Список отсортирован.");
                    break;
                case 0:
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверная опция. Пожалуйста, попробуйте снова.");
            }
        }
    }

}
