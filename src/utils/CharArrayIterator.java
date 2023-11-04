package utils;

import java.util.Iterator;

public class CharArrayIterator {
    private final char[] array;
    private int index = - 1;

    public CharArrayIterator(char[] chars){
        this.array = chars;
    }

    public boolean hasNext() {
        return index < array.length;
    }

    public char next() {
        index++;
        if(index < array.length){
            return array[index];
        }
        return '$';
    }
}
