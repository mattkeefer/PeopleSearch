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
		if(size == people.length) {
			increaseSize();
		}
		people[size++] = p;
	}
	
	private void increaseSize() {
		people = Arrays.copyOf(people, people.length+1);
	}
	
	public void delete(int i) {
		Person[] temp = new Person[people.length-1];
		System.arraycopy(people, 0, temp, 0, i);
		System.arraycopy(people, i+1, temp, i, people.length-i-1);
		people = new Person[temp.length];	
		people = temp;
		size--;
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
	
	public String[] getOutput() {
		String[] out = new String[size];
		int count = 0;
		for(Person p : people) {
			out[count] = p.getName() + " - " + p.getAge() + "\n";
			count++;
		}
		return out;
	}
}