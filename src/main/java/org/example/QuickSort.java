package org.example;

/**
 * Class implementing the Sort<T> interface using the QuickSort algorithm.
 *
 * @param <T> The type of elements that support comparison.
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    public QuickSort() {
    }

    /**
     * Method that invokes QuickSort for the given array.
     *
     * @param list The array of elements to be sorted.
     */
    @Override
    public void sort(Wonder<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Recursive method for QuickSort.
     *
     * @param list The array of elements to be sorted.
     * @param low  The low index of the array.
     * @param high The high index of the array.
     */
    private void quickSort(Wonder<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(Wonder<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(Wonder<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}


