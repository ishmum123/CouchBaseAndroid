package com.example.ishmum.couchbaseapp2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private final int limit;
    private int current;

    public static Range range(int limit) {
        return range(0, limit);
    }

    public static Range range(int min, int limit) {
        return new Range(min, limit);
    }

    private Range(int limit, int current) {
        this.limit = limit;
        this.current = current;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return (current < limit);
            }

            @Override
            public Integer next() {
                if (hasNext()) return current++;
                else throw new NoSuchElementException("Range Reached the End");
            }
        };
    }
}
