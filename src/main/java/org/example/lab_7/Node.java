/**
 * @author_Nizami_Alekperov
 *
 * @Laba-7
 *
 * todo класс узла дерева
 */

package org.example.lab_7;

public class Node {
    int value;
    Node left, right, parent;

    Node(int item) {
        value = item;
        left = right = parent = null;
    }
}
