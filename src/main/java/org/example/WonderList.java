package org.example;

import java.util.Arrays;

/**
 * WonderList is an implementation of the Wonder interface using an array.
 *
 * @param <T> the type of elements in the list.
 */
public class WonderList<T extends Comparable<T>> implements Wonder<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    int size;

    /**
     * Constructs an empty WonderList with an initial capacity of 10.
     */
    public WonderList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructs an empty Wonder List and sets the capacity.
     */
    public WonderList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added.
     */
    @Override
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Retrieves the element at a specified index in the list.
     *
     * @param index   the index of the element to retrieve.
     * @param element the element to be added.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        // Move the elements to the right to make room for a new element
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Retrieves the element at a specified index in the list.
     *
     * @param index the index of the element to retrieve.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to be removed.
     */
    @Override
    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                removeAtIndex(i);
                return;
            }
        }
    }

    /**
     * Clears the entire list, removing all elements.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Move the elements to the left to delete the element at the specified index
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Releasing the last element
    }

    /**
     * Increases the capacity of this ArrayList instance, if necessary.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Returns the current size (number of elements) in the list.
     *
     * @return the size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index – index of the element to replace
     * @param value to be stored at the specified position
     */
    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = value;
    }
}




