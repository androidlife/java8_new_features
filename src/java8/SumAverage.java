package java8;

import java.util.ArrayList;
import java.util.OptionalDouble;

public class SumAverage {

	public static void main(String[] args) {
		sumAndAverage();
	}

	private static void sumAndAverage() {
		
		Person person = new Person("Hello3",20);
		ArrayList<Person> personList = new ArrayList<Person>() {
			{
				add(new Person("Hello", 10));
				add(new Person("Hello", 10));
				add(new Person("Hello2", 10));
				
			}
		};

		int sum = personList.stream().mapToInt(p -> p.age).sum();
		System.out.println("Sum of person ages = " + sum);
		OptionalDouble average = personList.stream().mapToInt(p -> p.age).average();
		if(average.isPresent())
			System.out.println("Average of person ages "+average.getAsDouble());
		else
			System.out.println("Average couldn't be calculated");
		
		System.out.println("Distince elements = "+personList.stream().distinct().count());
		
		//personList.stream().map(p -> p.name).forEach(p-> System.out.println(p));
	}

}
