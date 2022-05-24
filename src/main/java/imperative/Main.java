package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Person> persons = List.of(
                new Person("Nikos", Gender.MALE),
                new Person("Lena", Gender.FEMALE),
                new Person("Takis", Gender.MALE),
                new Person("Kostas", Gender.MALE),
                new Person("Eleni", Gender.FEMALE)
        );

        System.out.println("1st method");

        List<Person> females = new ArrayList<>();

        for (Person person: persons) {
            if (person.gender == Gender.FEMALE){
                females.add(person);
            }
        }

        for (Person female: females) {
            System.out.println(female);
        }

        System.out.println("2nd method");

        persons.stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                //.collect(Collectors.toList())
                .forEach(System.out::println);


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
        MALE, FEMALE
    }
}