package com.omenroman.set;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by roman on 15.05.17.
 */
class SetTest {
    Set set;
    ArrayList<String> listValue;

    @BeforeEach
    void setUp() {
        set = new Set();
        listValue = new ArrayList<>();
        listValue.addAll(Arrays.asList(
                "7",
                "9",
                "3",
                "8",
                "2",
                "5",
                "1",
                "4",
                "6"
        ));
    }

    void addSomeValues() {
        for (int i = 0; i < listValue.size(); i++) {
            set.add(listValue.get(i));
        }
    }

    @Test
    void testAddReturn() {
        String name = listValue.get(0);
        assertTrue(set.add(name), "Must return true in add String");
    }

    @Test
    void testAddExist() {
        addSomeValues();
        String name = listValue.get(0);
        assertFalse(set.add(name), "Must return false in add exist string - ");
    }

    @Test
    void testAddNull() {
        String name = null;
        assertFalse(set.add(name), "Must return false in add NULL");
    }

    @Test
    void testAddContains() {
        String name = "Roshan";
        set.add(name);
        assertTrue(set.contains(name), "You string -" + name + " not added");
    }

    @Test
    void testRemoveReturn() {
        addSomeValues();
        String name = listValue.get(0);
        assertTrue(set.remove(name), "Must return true at remove exist string");

    }

    @Test
    void testRemove() {
        addSomeValues();
        String name = "fds";
        assertFalse(set.remove(name), "Must return false");

    }

    @Test
    void testRemoveNull() {
        assertFalse(set.remove(null), "Must return false in remove null");
    }

    @Test
    void testRemoveContains() {
        addSomeValues();
        String name = listValue.get(0);
        set.remove(name);
        assertFalse(set.contains(name), "Must return false, you element non contains in Set");

    }

    @Test
    void testDepth() {
        addSomeValues();
        int expected = 4;
        int actual = set.depth();
        assertEquals(expected, actual, "depth mast return 3, but return - " + actual);
    }
    @Test
    void testDepthAnother() {
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        int expected = 7;
        int actual = set.depth();
        assertEquals(expected, actual, "depth mast return 3, but return - " + actual);
    }

    @Test
    void testNotContains() {
        addSomeValues();
        String name = "Mark";
        assertFalse(set.contains(name), "Must return false, string \"" + name + "\" not contains in Set");
    }
    @Test
    void testContains() {
        addSomeValues();
        String name = listValue.get(0);
        assertTrue(set.contains(name), "Must return true, string \"" + name + "\" must contains in Set");
    }
    @Test
    void testContainsNull(){
        assertFalse(set.contains(null),"Must return false in contains -null");
    }

    @Test
    void testSizeEmpty() {
        int expected = 0;
        int actual = set.size();
        assertEquals(expected, actual, "Must return 0, but return -" + actual);
    }

    @Test
    void testSizeAdd() {
        addSomeValues();
        int expected = listValue.size();
        int actual = set.size();
        assertEquals(expected, actual, "Must return 4, but return - " + actual);
    }

    @Test
    void testSizeRemove() {
        addSomeValues();
        set.remove("Mort");
        int expected = listValue.size();
        int actual = set.size();
        assertEquals(expected, actual, "Must return 3, but return - " + actual);
    }

}