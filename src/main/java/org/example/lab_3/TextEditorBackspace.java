/**
 * @author_Nizami_Alekperov
 *
 * @Laba-3
 *
 * @Ex-2
 *
 * todo Task:
 * Не использовать стандартные коллекции, структуры реализовывать самостоятельно
 * В любой из 3х задач использовать стандартные коллекции, сравнить время
 * выполнения при использовании собственных структур и стандартных коллекций
 * Пусть символ # определен в текстовом редакторе как стирающий символ Backspace, т.е.
 * строка abc#d##c в действительности является строкой ac. Дан текст, в котором
 * встречается символ #. Преобразовать его с учетом действия этого символа
 */


package org.example.lab_3;

import java.util.LinkedList;

public class TextEditorBackspace {
    public static void main(String[] args) {
        String text = "hell#o,#### my# nam##e# is# Mas##hka###";
        System.out.println("Исходный текст: " + text);
        System.out.println("Преобразованный текст: " + processText(text));

        long startTime = System.nanoTime();
        processText(text);
        long endTime = System.nanoTime();
        System.out.println("Время выполнения без стандартных коллекций: " + (endTime - startTime) + " нс");


        long startTimeWithCollection = System.nanoTime();
        processTextWithCollection(text);
        long endTimeWithCollection = System.nanoTime();
        System.out.println("Время выполнения с использованием стандартных коллекций: " + (endTimeWithCollection - startTimeWithCollection) + " нс");
    }

    private static String processText(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != '#') {
                result.append(c);
            } else if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return result.toString();
    }


    private static String processTextWithCollection(String text) {
        LinkedList<Character> processed = new LinkedList<>();
        for (char c : text.toCharArray()) {
            if (c != '#') {
                processed.addLast(c);
            } else if (!processed.isEmpty()) {
                processed.removeLast();
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : processed) {
            result.append(c);
        }
        return result.toString();
    }

}
