package java8;

public class Person {

	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {

	}

	public static int doComparePersonAges(Person p1, Person p2) {
		Integer age = p1.age;
		return age.compareTo(p2.age);
	}

	public static int checkGreater(Person p1, Person p2) {
		Integer age1 = p1.age;
		return age1.compareTo(p2.age);
	}

	public static void somePerson(Person p) {

	}

	public int checkPerson(Person p1, Person p2) {
		Integer age1 = p1.age;
		return age1.compareTo(p2.age);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("Equal check");
		return obj !=null && obj instanceof Person && ((Person)obj).name.equals(name) && ((Person)obj).age == age;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()*age;
	}

}
