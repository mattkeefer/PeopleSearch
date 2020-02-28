package main;

public class Person {

	private String name;
	private int age;
	
	public Person(String n, int a) {
		name = n;
		age = a;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		age = a;
	}
	
	public int compareTo(Object obj) {
		return name.toLowerCase().compareTo(((Person)obj).getName().toLowerCase());
	}
}