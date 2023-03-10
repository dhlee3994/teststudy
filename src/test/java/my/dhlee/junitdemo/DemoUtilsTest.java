package my.dhlee.junitdemo;

import my.dhlee.junitdemo.DemoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {
    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @DisplayName("Equals and Not Equals")
    @Order(3)
    @Test
    void testEqualsAndNotEquals() {

        int expected = 6;
        int unexpected = 8;

        int actual = demoUtils.add(2, 4);

        assertEquals(expected, actual, "2 + 4 = 6");
        assertNotEquals(unexpected, actual, "2 + 4 != 8");
    }

    @DisplayName("Null and Not Null")
    @Order(1)
    @Test
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @DisplayName("Same and Not Same")
    @Order(-7)
    @Test
    void testSameAndNotSame() {

        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @DisplayName("True and False")
    @Test
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @DisplayName("Array Equal")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");

        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }

    @DisplayName("Lined match")
    @Test
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should be match");
    }

    @DisplayName("Throws and Does Not Throw")
    @Test
    void testThrowsAndDoseNotThrow() {
        assertThrows(Exception.class, () -> {
            demoUtils.throwException(-1);
        }, "Should throw exception");

        assertDoesNotThrow(() -> {
            demoUtils.throwException(5);
        }, "Should not throw exception");
    }

    @DisplayName("Timeout")
    @Test
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            demoUtils.checkTimeout();
        }, "Method should execute in 3 seconds");
    }
}