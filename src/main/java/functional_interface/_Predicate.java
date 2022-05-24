package functional_interface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("6944575487"));
        System.out.println(isPhoneNumberValid("694443234233"));
        System.out.println(isPhoneNumberValid("12944575487"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("6944575487"));
        System.out.println(isPhoneNumberValidPredicate.test("694443234233"));
        System.out.println(isPhoneNumberValidPredicate.test("12944575487"));

        System.out.println("With Chained Predicates");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("6944575487"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("694443234233"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("12944575487"));
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("69") && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("69") && phoneNumber.length() == 10;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
