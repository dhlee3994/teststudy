package my.dhlee.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 3의 배수면 Fizz
// 5의 배수면 Buzz
// 3과 5의 배수면 FizzBuzz
// 그 외의 수는 숫자를 출력
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    void testForDivisibleByThree() {

        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {

        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @DisplayName("Divisible By Three and Five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {

        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    @DisplayName("Not Divisible By Three or Five")
    @Test
    @Order(4)
    void testForNotDivisibleByThreeOrFive() {

        String expected = "1";

        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }

    @DisplayName("Loop over array")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @MethodSource("provideFizzBuzzLoopOverArray")
    @Order(5)
    void testLoopOverArray(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    private static Stream<Arguments> provideFizzBuzzLoopOverArray() {
        return Stream.of(
            Arguments.of(1, "1"),
            Arguments.of(2, "2"),
            Arguments.of(3, "Fizz"),
            Arguments.of(4, "4"),
            Arguments.of(5, "Buzz"),
            Arguments.of(15, "FizzBuzz"),
            Arguments.of(18, "Fizz"),
            Arguments.of(90, "FizzBuzz"),
            Arguments.of(100, "Buzz")
        );
    }


    @DisplayName("Loop over array by CSV")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(6)
    void testLoopOverArrayByCSV(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
