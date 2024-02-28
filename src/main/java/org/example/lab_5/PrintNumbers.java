/**
 * @author_Nizami_Alekperov
 *
 * @Laba-5
 *
 * @Ex-1
 *
 * todo Task:
 * Дано натуральное число n. Выведите все числа от 1 до n.
 */

package org.example.lab_5;

import java.util.Scanner;

public class PrintNumbers {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();

        int n = 10;
        printNumbers(n);
    }

    public static void printNumbers(int n) {
        if (n < 1) {
            return;
        }
        printNumbers(n - 1);
        System.out.println(n);
    }
}
