package functional_interface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {

        System.out.println("DB Connection without Supplier");
        System.out.println(getDBConnectionUrl());

        System.out.println("DB Connection with Supplier");
        System.out.println(getDBConnectionUrlSupplier.get());

    }

    static String getDBConnectionUrl(){
        return "jdbc://localhost:5432/user";
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/user";
}
