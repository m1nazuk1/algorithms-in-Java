/**
 * @author_Nizami_Alekperov
 *
 * @Laba-4
 *
 * todo Task:
 * 1. Реализовать заданный алгоритм
 * 2. Измерить время выполнения алгоритма
 * 3. Исследовать вычислительную сложность алгоритма
 * Написать программу, сортирующую набор строк, состоящих из целых чисел, по убыва
 * нию суммы элементов строк и использующую сортировку чёт-нечёт.
 */

package org.example.lab_4;

import java.util.Arrays;

public class OddEvenSortStrings {

    public static void main(String[] args) {
        String[] data = {"3 5 2", "1 2 3", "4 4 4", "2 2 8", "1 1 1"};
        long startTime = System.nanoTime();
        sortStringsBySumDesc(data);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        System.out.println(Arrays.toString(data));
        System.out.println("Время выполнения: " + duration + " наносекунд");
    }

    private static void sortStringsBySumDesc(String[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            // Odd phase
            for (int i = 1; i <= arr.length - 2; i += 2) {
                if (sumOfString(arr[i]) < sumOfString(arr[i + 1])) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            // Even phase
            for (int i = 0; i <= arr.length - 2; i += 2) {
                if (sumOfString(arr[i]) < sumOfString(arr[i + 1])) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

    private static int sumOfString(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sum();
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}