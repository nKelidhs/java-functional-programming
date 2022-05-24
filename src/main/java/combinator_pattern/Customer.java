package combinator_pattern;

import java.time.LocalDate;

public class Customer {

    private final String name;
    private final String email;
    private final String number;
    private final LocalDate dob;

    public Customer(String name, String email, String number, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getDob() {
        return dob;
    }
}
