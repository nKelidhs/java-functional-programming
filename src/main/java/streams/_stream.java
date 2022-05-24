package streams;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Nikos", Gender.MALE),
                new Person("Lena", Gender.FEMALE),
                new Person("Takis", Gender.MALE),
                new Person("Kostas", Gender.MALE),
                new Person("Eleni", Gender.FEMALE),
                new Person("Savvas", Gender.PREFER_NOT_TO_SAY)
        );

        //Take all the genders, convert to Set(no duplicates) and print all the genders. Same as .select.ToHashSet.foreach on LINQ
        people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(System.out::println);

        //Take all the genders, take all the names lengths and print them. Same as .select.foreach on LINQ
        people.stream().map(person -> person.name).mapToInt(String::length).forEach(System.out::println);

        // The same as before but with introduced Variables.
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = name -> name.length();
        IntConsumer println = x -> System.out.println(x);

        people.stream().map(personStringFunction).mapToInt(length).forEach(println);

        // Same as .All on LINQ
        var containsOnlyFemales = people.stream().allMatch(person -> person.gender.equals(Gender.FEMALE));
        System.out.println(containsOnlyFemales);

        // Same as .Any on LINQ
        var containsAnyPreferNotToSay = people.stream().anyMatch(person -> person.gender.equals(Gender.PREFER_NOT_TO_SAY));
        System.out.println(containsAnyPreferNotToSay);

        // Same as .FirstOrDefault on LINQ
        Optional<Person> nikos = people.stream().filter(person -> person.name == "Nikaos").findFirst();
        if (nikos.isPresent()){
            System.out.println(nikos.get().name);
        }else {
            System.out.println("Not Found");
        }


    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
