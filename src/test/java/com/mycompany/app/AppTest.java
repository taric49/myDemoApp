package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.*;

public class AppTest {

    @Test
    public void test1() {
        ArrayList<Integer> list1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        ArrayList<Integer> list2 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        boolean result = App.meaningFullFunct(list1, list2, "taric",
                "taric_but_cooler");
        assertEquals(result, true);
    }

    @Test
    public void test2() {
        ArrayList<Integer> list1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        ArrayList<Integer> list2 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        boolean result = App.meaningFullFunct(list1, list2, "taric",
                "not_taric");
        assertEquals(result, false);
    }

    @Test
    public void test3() {
        ArrayList<Integer> list1 = new ArrayList<Integer>() {
            {
                add(0);
                add(2);
                add(3);
            }
        };
        ArrayList<Integer> list2 = new ArrayList<Integer>() {
            {
                add(5);
                add(9);
                add(1);
            }
        };

        boolean result = App.meaningFullFunct(list1, list2, "taric",
                "airictbutrcooler");
        assertEquals(result, true);
    }

    @Test
    public void test4() {
        ArrayList<Integer> list1 = new ArrayList<Integer>() {
            {
                add(0);
                add(2);
                add(3);
            }
        };
        ArrayList<Integer> list2 = new ArrayList<Integer>() {
            {
                add(0);
                add(2);
                add(11);
            }
        };

        boolean result = App.meaningFullFunct(list1, list2, "taric",
                " taric");
        assertEquals(result, false);
    }

    @Test
    public void test5() {
        ArrayList<Integer> list1 = new ArrayList<Integer>() {
            {
                add(0);
                add(2);
            }
        };
        ArrayList<Integer> list2 = new ArrayList<Integer>() {
            {
                add(4);
                add(6);
                add(7);
            }
        };

        boolean result = App.meaningFullFunct(list1, list2, "taric",
                "hey_taric_howru?");
        assertEquals(result, true);
    }

}