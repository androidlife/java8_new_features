package java8;

import java8.interfaces.PersonInterface;

public class SecondClass implements PersonInterface {

	private int age;
	private String name;

	public SecondClass(String name, int age) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

}
