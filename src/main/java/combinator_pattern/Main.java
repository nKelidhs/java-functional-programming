package combinator_pattern;

import java.time.LocalDate;

import static combinator_pattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Nikos",
                "nkelidhs@gmail.com",
                "690110000000",
                LocalDate.of(1994, 2, 27)
        );

        System.out.println(new CustomerValidationService().customerIsValid(customer));

        //Using combinatorPattern
        ValidationResult result = isEmailValid()
                .and(isNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);
        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }


    }

}
