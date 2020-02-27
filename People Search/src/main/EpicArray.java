package main;
import java.util.Arrays;

public class EpicArray {
	
	private static final int START_SIZE = 1;
	private int size = 0;
	private Person people[] = {};
	
	public EpicArray() {
		people = new Person[START_SIZE];
	}
	
	public void add(Person p) {
		if (size == people.length) {
			increaseSize();
		}
		people[size++] = p;
	}
	
	private void increaseSize() {
		people = Arrays.copyOf(people, people.length+1);
	}
	
	public int size() {
		return size;
	}
	
	public Person get(int i) {
		return people[i];
	}
	
	public void set(int i, Person p) {
		people[i] = p;
	}
	
	public String toString() {
		String out = "";
		for(Person p : people) {
			out += p.getName() + " - " + p.getAge() + "\n";
		}
		return out;
	}
}