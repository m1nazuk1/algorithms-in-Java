/**
 * @author_Nizami_Alekperov
 *
 * @Laba-2
 *
 * @Ex-2
 *
 * todo Task:
 * 1. Получить матрицу А (m*n) образованную по соответствующему закону (размер
 * матрицы и закон, по которому определяется каждый элемент матрицы А, для каждого
 * варианта задания приведены в столбце 2 таблицы).
 * 2. Получить матрицу В, осуществив соответствующие преобразования над матрицей
 * А (преобразование, которое необходимо сделать над матрицей А, для каждого варианта
 * задания приведено в столбце 3 таблицы).
 * 3. Построить матрицу С (6*6) соответствующего вида (вид матрицы С для каждого
 * варианта задания приведен в столбце 4 таблицы).
 * 4. Вычислить D=B*C.
 * 5. Получить матрицу Е, переставив блоки матрицы D (необходимые перестановки для
 * каждого варианта задания приведены в столбце 5 таблицы).
 * 6. Сделать соответствующие вычисления для матрицы Е (требуемые вычисления
 * приведены в столбце 6 таблицы).
 * На экран необходимо последовательно вывести матрицы А, В, С, D, Е и результат
 * вычисления пункта 6 задания.
 */


package org.example.lab_2;

import java.util.Arrays;

public class MatrixOperations {
    public static void main(String[] args) {
        double[][] A = new double[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                A[i][j] = (double) (i + 1 + j + 1) / Math.cos(j + 1);
            }
        }

        double[][] B = new double[6][6];
        for (int i = 0; i < 6; i++) {
            B[i] = Arrays.stream(A[i]).boxed().sorted().mapToDouble(Double::doubleValue).toArray();
        }

        double[][] C = new double[6][6];
        for (int i = 0; i < 6; i++) {
            C[i][i] = Math.pow(2, i);
        }

        double[][] D = new double[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    D[i][j] += B[i][k] * C[k][j];
                }
            }
        }

        double[][] E = new double[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                E[i][j] = D[i][j + 3];
                E[i][j + 3] = D[i][j];
            }
        }

        double minElement = E[0][0];
        double maxElement = E[0][0];
        for (int i = 1; i < 6; i++) {
            if (E[i][i] < minElement) {
                minElement = E[i][i];
            }
            if (E[i][i] > maxElement) {
                maxElement = E[i][i];
            }
        }
        double sumMinAndMax = minElement + maxElement;

        printMatrix("Матрица A", A);
        printMatrix("Матрица B", B);
        printMatrix("Матрица C", C);
        printMatrix("Матрица D", D);
        printMatrix("Матрица E", E);
        System.out.println("Сумма минимального и максимального элементов главной диагонали матрицы E: " + sumMinAndMax);
    }

    private static void printMatrix(String name, double[][] matrix) {
        System.out.println(name + ":");
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%9.4f ", value);
            }
            System.out.println();
        }
        System.out.println();
    }
}
