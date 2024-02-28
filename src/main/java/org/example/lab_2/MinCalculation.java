/**
 * @author_Nizami_Alekperov
 *
 * @Laba-2
 *
 * @Ex-1
 *
 * Todo Task:
 * Даны: натуральное число n, действительные числа а1, а2, ...., аn.
 * Получить: min^2{a1, a2, ...an} - min{a1^2, a2^2,....an^2}.
 */


package org.example.lab_2;

public class MinCalculation {

    public static void main(String[] args) {
        double[] numbers = {1.5, 2.3, -1.2, 4.8, 0.5};

        double result = calculateMinSquareDifference(numbers);

        System.out.println("Результат: " + result);
    }

    private static double calculateMinSquareDifference(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        double min = numbers[0];
        double minSquare = numbers[0] * numbers[0];

        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
            double square = number * number;
            if (square < minSquare) {
                minSquare = square;
            }
        }

        double minSquared = min * min;
        System.out.println("min^2 = " + minSquared + "\t" + "min{a^2} = " + minSquare + "\n");
        return minSquared - minSquare;
    }
}
