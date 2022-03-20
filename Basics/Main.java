package Basics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Main {
    static class Person {
        String name;
        Integer age;
        String gender;

        Person(String name, Integer age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        Integer getAge() {
            return age;
        }

        String getGender() {
            return gender;
        }

        String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Name is " + name + " Age is " + age + " Gender is " + gender;
        }

        /** returns a list of Person (HardCoded currently) */
        static List<Person> getPerson() {
            List<Person> Persons = new ArrayList<>();
            Persons.add(new Person("Peter", 40, "MALE"));
            Persons.add(new Person("Laura", 20, "FEMALE"));
            Persons.add(new Person("Jennifer", 15, "FEMALE"));
            Persons.add(new Person("Patriak", 50, "MALE"));
            Persons.add(new Person("Abhishek", 30, "MALE"));
            Persons.add(new Person("Nethan", 60, "MALE"));
            Persons.add(new Person("Jeany", 18, "FEMALE"));
            return Persons;
        }
    }

    public static void printPersonList(List<Person> list) {
        for (Person p : list) {
            System.out.println(p);
        }
    }

    public static void printPerson(Optional<Person> person) {
        System.out.println(person);
    }

    private static void printPersonList(Map<String, List<Person>> groupedByGenderPerson) {
        for (Map.Entry<String, List<Person>> iter : groupedByGenderPerson.entrySet()) {
            System.out.println("Group is " + iter.getKey());
            List<Person> persons = iter.getValue();
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    public static void main(String[] args) {
        // Part 1 -> Filter All the MALES from the list using stream API
        List<Person> males = Person.getPerson().stream().filter((Person) -> (Person.getGender().equals("MALE")))
                .collect(Collectors.toList());

        // printPersonList(males);

        // Part 2 -> Sort all the Persons According to age
        List<Person> ageSortedPerson = Person.getPerson().stream().sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        // printPersonList(ageSortedPerson);

        // Part 3 -> Person with Maximum age
        Optional<Person> maxAgePerson = Person.getPerson().stream().max(Comparator.comparing(Person::getAge));
        // printPerson(maxAgePerson);
        // Part 4 -> Person with Minimum age
        Optional<Person> minAgePerson = Person.getPerson().stream().min(Comparator.comparing(Person::getAge));
        // printPerson(minAgePerson);

        // Part 5 -> Group the people by Gender

        Map<String, List<Person>> groupedByGenderPerson = Person.getPerson().stream()
                .collect(Collectors.groupingBy(Person::getGender));
        printPersonList(groupedByGenderPerson);
    }

}