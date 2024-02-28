/**
 * @author_Nizami_Alekperov
 *
 * @Laba-6
 *
 * todo Task:
 * Организовать хеш-таблицу с открытой адресацией, используя хеш-функцию
 * h(k)=trunc(M*Frac(k*d)), где d=(sqrt(5)-1)/2, M - размер хеш-таблицы. Организовать
 * процедуру поиска по ключу в этой хеш-таблице. Результат поиска - номер ячейки
 * с найденным ключом или (-1)
 */

package org.example.lab_6;

public class OpenAddressingHashTable {
    private Integer[] table;
    private final int M; // размер хеш-таблицы
    private final double d = (Math.sqrt(5) - 1) / 2;

    public OpenAddressingHashTable(int M) {
        this.M = M;
        this.table = new Integer[M];
    }

    private int hash(int key) {
        return (int) Math.floor(M * ((key * d) % 1));
    }

    public void insert(int key) {
        int index = hash(key);
        while (table[index] != null) {
            index = (index + 1) % M; // линейное пробирование
        }
        table[index] = key;
    }

    public int search(int key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index] == key) {
                return index;
            }
            index = (index + 1) % M;
        }
        return -1; // не найден ключик :(
    }

    public static void main(String[] args) {
        OpenAddressingHashTable hashTable = new OpenAddressingHashTable(10);
        hashTable.insert(5);
        hashTable.insert(15);
        hashTable.insert(25);

        System.out.println("Поиск ключа 15: " + hashTable.search(15)); // поиск существующего ключа
        System.out.println("Поиск ключа 100: " + hashTable.search(100)); // поиск несуществующего ключа
    }
}
