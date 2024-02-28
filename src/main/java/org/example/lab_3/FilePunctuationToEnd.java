/**
 * @author_Nizami_Alekperov
 *
 * @Laba-3
 *
 * @Ex-3
 *
 * todo Task:
 * Не использовать стандартные коллекции, структуры реализовывать самостоятельно
 * Пусть дан текстовый файл А. Перепишите его содержимое в файл В, перенося при
 * этом в конец каждой строки все входящие в нее знаки препинания.
 */


package org.example.lab_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FilePunctuationToEnd {

    public static void main(String[] args) {
        String sourceFile = "src/main/java/org/example/lab_3/filesForProgramOperation/filaA.txt";
        String destinationFile = "src/main/java/org/example/lab_3/filesForProgramOperation/filaB.txt";

        try {
            processFile(sourceFile, destinationFile);
            System.out.println("Файл успешно обработан.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при обработке файла: " + e.getMessage());
        }
    }

    private static void processFile(String sourceFile, String destinationFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             PrintWriter writer = new PrintWriter(new FileWriter(destinationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(movePunctuationToEnd(line));
            }
        }
    }

    private static String movePunctuationToEnd(String line) {
        StringBuilder punctuation = new StringBuilder();
        StringBuilder text = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (isPunctuation(c)) {
                punctuation.append(c);
            } else {
                text.append(c);
            }
        }

        return text.append(punctuation).toString();
    }

    private static boolean isPunctuation(char c) {
        return c == '.' || c == ',' || c == '!' || c == '?' || c == ';' || c == ':' || c == '-' || c == '"';
    }
}
