package optionals;

import java.util.Optional;

public class _optional {

    public static void main(String[] args) {
        Object value = Optional.ofNullable(null).orElseGet(() -> "default value");
        System.out.println(value);
        Object value2 = Optional.ofNullable("Hello").orElseGet(() -> "default value");
        System.out.println(value2);
//        Object value3 = Optional.ofNullable(null).orElseThrow(() -> new IllegalStateException());
//        System.out.println(value3);

        Optional.ofNullable("nikos").ifPresentOrElse(
                email -> System.out.println("Sending email to " + email),
                () -> System.out.println("Cannot Send email")
        );

    }
}
