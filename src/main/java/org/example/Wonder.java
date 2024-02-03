package org.example;

/**
 * Wonder interface represents a basic list with common operations.
 *
 * @param <T> the type of elements in the list.
 */
public interface Wonder<T> {

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added.
     */
    void add(T element);

    /**
     * Adds an element at a specific index in the list.
     *
     * @param index   the index at which the element should be added.
     * @param element the element to be added.
     */
    void add(int index, T element);

    /**
     * Retrieves the element at a specified index in the list.
     *
     * @param index the index of the element to retrieve.
     */
    T get(int index);

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to be removed.
     */
    void remove(T element);

    /**
     * Clears the entire list, removing all elements.
     */
    void clear();

    /**
     * Returns the current size (number of elements) in the list.
     *
     * @return the size of the list.
     */
    int size();

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index – index of the element to replace
     * @param value to be stored at the specified position
     */
    void set(int index, T value);
}

