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

    @Override
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity();

        // Сдвигаем элементы вправо, чтобы освободить место для нового элемента
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    @Override
    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                removeAtIndex(i);
                return;
            }
        }
    }

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

        // Сдвигаем элементы влево, чтобы удалить элемент по указанному индексу
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Освобождаем последний элемент
    }

    @Override
    public int size() {
        return size;
    }

    /////////////////////////////////Быстрая сортировка
    @Override
    public void quickSort() {
        if (size > 1) {
            quickSort(0, size - 1);
        }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (get(j).compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    private void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = value;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);// Копируем существующий массив и величиваем его размер
        }
    }

////////////////////////////////////////////Сортировка слянием
    @Override
    public void mergeSort() {
        if (size > 1) {
            T[] tempArray = (T[]) Arrays.copyOf(elements, size);
            mergeSort(tempArray, 0, size - 1);
        }
    }

    private void mergeSort(T[] tempArray, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(tempArray, left, mid);
            mergeSort(tempArray, mid + 1, right);
            merge(tempArray, left, mid, right);
        }
    }

    private void merge(T[] tempArray, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tempArray[i].compareTo(tempArray[j]) <= 0) {
                elements[k++] = tempArray[i++];
            } else {
                elements[k++] = tempArray[j++];
            }
        }

        while (i <= mid) {
            elements[k++] = tempArray[i++];
        }

        while (j <= right) {
            elements[k++] = tempArray[j++];
        }
    }
///////////////////////////////////////////////////

}




