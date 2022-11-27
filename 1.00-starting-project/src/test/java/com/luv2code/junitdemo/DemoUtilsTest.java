package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {

        int expected = 6;
        int unexpected = 8;

        int actual = demoUtils.add(2, 4);

        assertEquals(expected, actual, "2 + 4 = 6");
        assertNotEquals(unexpected, actual, "2 + 4 != 8");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

}