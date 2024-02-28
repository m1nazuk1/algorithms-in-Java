/**
 * @author_Nizami_Alekperov
 *
 * @Laba-5
 *
 * @Ex-2
 *
 * todo Task:
 * Реализовать алгоритм поиска подстроки в строке:
 * Наивный алгоритм (Brute Force algorithm)
 */


package org.example.lab_5;

public class SubstringSearch {
    public static void main(String[] args) {
        String text = "hello world";
        String pattern = "world";
        int index = naiveSearch(text, pattern);
        System.out.println("Индекс первого появления: " + index);
    }

    public static int naiveSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i; // найдено :)
            }
        }
        return -1; // не найдено :(
    }
}
