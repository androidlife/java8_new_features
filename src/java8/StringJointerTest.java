package java8;

import java.util.ArrayList;
import java.util.StringJoiner;

public class StringJointerTest {
	public static void main(String[] args) {
		stringJoiner();
	}

	private static ArrayList<Person> personList = new ArrayList<Person>() {
		{
			add(new Person("Hello", 1));
			add(new Person("Hello2", 1));
			add(new Person("Hello3", 1));
		}
	};

	private static void stringJoiner() {
		StringJoiner stringJointer = new StringJoiner(",");
		personList.forEach(p -> stringJointer.add(p.name));
		System.out.println(stringJointer);
	}
}
