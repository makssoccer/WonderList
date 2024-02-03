package org.example;

/**
 * Interface for sorting elements of type T.
 *
 * @param <T> The type of elements to be sorted.
 */
public interface Sort<T> {

    /**
     * Sorts the given array of elements.
     *
     * @param list The array of elements to be sorted.
     */
    void sort(Wonder<T> list);
}
