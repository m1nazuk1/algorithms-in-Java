/**
 * @author_Nizami_Alekperov
 *
 * @Laba-1
 *
 * todo Task:
 * Найти все прямоугольники с целыми длинами сторон данной целочисленной
 * площади. Например, для площади, равной 12, подходят три прямоугольника
 * 1 х 12, 2 х 6, 3 х 4.
 */

package org.example.lab_1;

import java.util.Scanner;

public class RectangleFinder {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int area = scanner.nextInt();
        int area = 120;
        func1(area);
    }

    public static void func1(int area) {
        long startTime = System.currentTimeMillis();

        System.out.println("Площадь: " + area);
        int height = 0;
        for (int width = 1; width * width <= area; width++) {
            if (area % width == 0) {
                height = area / width;
                System.out.println(width + " x " + height);
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Время выполнения (в наносекундах): " + duration);
    }
}
