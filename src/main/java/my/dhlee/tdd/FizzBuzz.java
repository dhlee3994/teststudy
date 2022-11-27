package my.dhlee.tdd;

// 3의 배수면 Fizz
// 5의 배수면 Buzz
// 3과 5의 배수면 FizzBuzz
// 그 외의 수는 숫자를 출력
public class FizzBuzz {

    public static String compute(int i) {

        StringBuilder result = new StringBuilder();

        if (i % 3 == 0) {
            result.append("Fizz");
        }
        if (i % 5 == 0) {
            result.append("Buzz");
        }

        if (result.length() == 0) {
            result.append(i);
        }

        return result.toString();
    }
}
