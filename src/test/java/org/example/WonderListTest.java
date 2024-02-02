package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class WonderListTest {


    @Test
    public void testAddAndGet() {
        Wonder<String> wonderList = new WonderList<>();
        wonderList.add("Element1");
        wonderList.add("Element2");
        wonderList.add("Element3");

        assertEquals("Element1", wonderList.get(0));
        assertEquals("Element2", wonderList.get(1));
        assertEquals("Element3", wonderList.get(2));
    }

    @Test
    public void testAddByIndex() {
        Wonder<String> wonderList = new WonderList<>();
        wonderList.add("Element1");
        wonderList.add("Element3");

        wonderList.add(1, "Element2");

        assertEquals("Element1", wonderList.get(0));
        assertEquals("Element2", wonderList.get(1));
        assertEquals("Element3", wonderList.get(2));
    }

    @Test
    public void testRemove() {
        Wonder<String> wonderList = new WonderList<>();
        wonderList.add("Element1");
        wonderList.add("Element2");
        wonderList.add("Element3");

        wonderList.remove("Element2");

        assertEquals("Element1", wonderList.get(0));
        assertEquals("Element3", wonderList.get(1));
    }

    @Test
    public void testClear() {
        Wonder<String> wonderList = new WonderList<>();
        wonderList.add("Element1");
        wonderList.add("Element2");
        wonderList.add("Element3");

        wonderList.clear();

        assertEquals(0, wonderList.size());
    }

    @Test
    public void testQuickSort() {
        Wonder<String> wonderList = new WonderList<>();
        wonderList.add("Banana");
        wonderList.add("Apple");
        wonderList.add("Orange");

        wonderList.quickSort();

        assertEquals("Apple", wonderList.get(0));
        assertEquals("Banana", wonderList.get(1));
        assertEquals("Orange", wonderList.get(2));
    }


}
