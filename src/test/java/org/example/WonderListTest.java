package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WonderListTest {
    public Wonder<String> wonderList;

    @Before
    public void setUp() {
        wonderList = new WonderList<>();
        wonderList.add("Banana");
        wonderList.add("Orange");
    }

    @Test
    public void testAddAndGet() {
        wonderList.add("Watermelon");

        assertEquals("Banana", wonderList.get(0)); // несколько ассертов в assertALl всегда
        assertEquals("Orange", wonderList.get(1));
        assertEquals("Watermelon", wonderList.get(2));
    }

    @Test
    public void testAddByIndex() {
        wonderList.add(1, "Apple");

        assertEquals("Banana", wonderList.get(0));
        assertEquals("Apple", wonderList.get(1));
        assertEquals("Orange", wonderList.get(2));
    }

    @Test
    public void testRemove() {
        wonderList.remove("Banana");

        assertEquals("Orange", wonderList.get(0));
    }

    @Test
    public void testSize() {
        assertEquals(2, wonderList.size());
    }

    @Test
    public void testClear() {
        wonderList.clear();

        assertEquals(0, wonderList.size());
    }
    @Test
    public void testSet() {
        wonderList.set(0, "Apple");
        wonderList.set(1, "Kiwi");

        assertEquals("Apple", wonderList.get(0));
        assertEquals("Kiwi", wonderList.get(1));
    }

    @Test
    public void testQuickSort() {
        wonderList.add("Watermelon");
        wonderList.add("Apple");
        wonderList.add("Kiwi");
        wonderList.add("Persimmon");
        wonderList.add("Mandarin");
        wonderList.add("Lemon");
        wonderList.add("Grapefruit");

        Sort<String> quickSort = new QuickSort<>();
        quickSort.sort(wonderList);

        assertEquals("Apple", wonderList.get(0));
        assertEquals("Banana", wonderList.get(1));
        assertEquals("Grapefruit", wonderList.get(2));
        assertEquals("Kiwi", wonderList.get(3));
        assertEquals("Lemon", wonderList.get(4));
        assertEquals("Mandarin", wonderList.get(5));
        assertEquals("Orange", wonderList.get(6));
        assertEquals("Persimmon", wonderList.get(7));
        assertEquals("Watermelon", wonderList.get(8));
    }

}
