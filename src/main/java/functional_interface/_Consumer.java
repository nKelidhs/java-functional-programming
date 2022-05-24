package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer consumer = new Customer("Nikos", "java");
        printProduct.accept(consumer);

        greetCustomer.accept(consumer, false);
        greetCustomer.accept(consumer, true);

    }

    static Consumer<Customer> printProduct = customer -> System.out.println(customer.product);

    static BiConsumer<Customer, Boolean> greetCustomer = (customer, showProduct) -> System.out.println(
            "Hello " + customer.name + (showProduct ? " thanks for ordering " + customer.product : "") + ".");

    static class Customer {

        public final String name;
        public final String product;

        public Customer(String name, String product) {
            this.name = name;
            this.product = product;
        }

        @Override
        public String toString() {
            return "Consumer{" +
                    "name='" + name + '\'' +
                    ", product='" + product + '\'' +
                    '}';
        }
    }
}
