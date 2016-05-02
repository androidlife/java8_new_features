package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

import java8.interfaces.InterfaceWithArgs;
import java8.interfaces.PersonInterface;
import java8.interfaces.SimpleInterface;
import java8.interfaces.SomeOtherInterface;

public class FirstClass {

	public static void main(String[] args) {
		// simpleInterfaceTest();
		// builtInInterfaceTest();
		// forEachTest();
		// personTest();
		// methodTest();
		// interfaceDefaultTest();
		// serialParallelStreamTest();
		Optional<Person> somePerson = getPersonWithName("Harii");
		if (somePerson.isPresent()) {
			System.out.println("Person is present");
		} else {
			System.out.println("Person is absent");
		}

	}

	static Optional<Person> optionalPerson = Optional.empty();

	private static Optional<Person> getPersonWithName(String name) {
		Predicate<Person> withNamePredicate = (Person p) -> {
			return p.name.equals(name);
		};
		optionalPerson = persons.stream().filter(p -> withNamePredicate.test(p)).findFirst();
		return optionalPerson;
	}

	private static void serialParallelStreamTest() {
		Predicate<Person> somePredicate = (Person p) -> {
			return p.age > 40;
		};
		persons.stream().filter(somePredicate).forEach(p -> System.out.println(p.name));
		persons.stream().parallel().filter(somePredicate).forEach(p -> System.out.println(p.name));
	}

	private static void interfaceDefaultTest() {
		SecondClass secondClass = new SecondClass("Hello", 10);
		System.out.println(secondClass.combineNameNAge());
		System.out.println(PersonInterface.addAgeNName(30));
	}

	private static void simpleInterfaceTest() {
		SimpleInterface simpleInterface = () -> System.out.println("hello");
		simpleInterface.doSomething();

		InterfaceWithArgs interfaceWithArgs = (v1, v2) -> System.out.println(String.valueOf(v1) + v2);
		interfaceWithArgs.doSomething(10, "hello");
	}

	private static void builtInInterfaceTest() {
		Runnable runnable = () -> {
			System.out.println("Please run this");
		};
		new Thread(runnable).start();

		Comparator<String> someComparator = (String s1, String s2) -> {
			return s1.equalsIgnoreCase(s2) ? 1 : 0;
		};
	}

	private static void forEachTest() {
		ArrayList<String> strings = new ArrayList<String>() {
			{
				add("aa");
				add("cc");
				add("dd");
			}
		};

		strings.forEach(str -> {
			System.out.println(str);
		});
	}

	public static ArrayList<Person> persons = new ArrayList<Person>() {
		{
			add(new Person("Ram", 10));
			add(new Person("Hari", 80));
			add(new Person("Sita", 50));
		}
	};

	public static void personTest() {

		Predicate<Person> predicate = new Predicate<Person>() {

			@Override
			public boolean test(Person t) {
				// TODO Auto-generated method stub
				return t.age > 60;
			}
		};

		persons.forEach(person -> {
			if (predicate.test(person))
				System.out.println("Name of person = " + person.name);
		});

		Predicate<Person> predicateLambda = (Person person) -> {
			return person.age > 60;
		};

		persons.forEach(person -> {
			if (predicateLambda.test(person))
				System.out.println("Name of person = " + person.name);
		});
	}

	public static void methodTest() {
		Comparator<Person> comparator = Person::doComparePersonAges;
		Comparator<Person> comparator1 = Person::checkGreater;

		// this can also be achieved by
		Person person = new Person();
		Comparator<Person> comparator2 = person::checkPerson;
		Collections.sort(persons, comparator2);
		persons.forEach(personVal -> {
			System.out.println("Person name: age = " + personVal.name + " : " + personVal.age);
		});
	}

	public static void staticAccessTest() {
		SomeOtherInterface someOtherInterface = Person::somePerson;

	}
}
