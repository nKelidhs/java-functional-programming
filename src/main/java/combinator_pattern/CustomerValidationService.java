package combinator_pattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationService {

    public boolean isEmailValid(String email){
        return email.contains("@");
    }

    public boolean isNumberValid(String phoneNumber){
        return phoneNumber.startsWith("69") && phoneNumber.length() == 10;
    }

    public boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() >= 18;
    }

    public boolean customerIsValid(Customer customer){
        return isEmailValid(customer.getEmail()) && isNumberValid(customer.getNumber()) && isAdult(customer.getDob());
    }
}
