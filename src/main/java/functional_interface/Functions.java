package functional_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Functions {
    public static void main(String[] args) {

        int increment = incrementByOne(0);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Integer increment3 = multiplyBy10Function.apply(increment2);
        System.out.println(increment3);

        Integer incrementAndMultiply = multiplyBy10Function.andThen(incrementByOneFunction).apply(3);
        System.out.println(incrementAndMultiply);

        Integer incrementAndMultiplyBiFunction = incrementByOneAndThenMultiply.apply(3, 10);
        System.out.println(incrementAndMultiplyBiFunction);
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndThenMultiply = (number, multiplyNumber) -> (number + 1) * multiplyNumber;

    static int incrementByOne (int number){
        return number + 1;
    }
}