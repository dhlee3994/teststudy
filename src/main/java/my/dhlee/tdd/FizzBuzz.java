package my.dhlee.tdd;

// 3의 배수면 Fizz
// 5의 배수면 Buzz
// 3과 5의 배수면 FizzBuzz
// 그 외의 수는 숫자를 출력
public class FizzBuzz {

    public static String compute(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(i);
        }
    }
}
