package main;

public class Sorter {

	private EpicArray people;
	
	public Sorter(EpicArray p) {
		people = p;
	}
	
	public EpicArray sortNames() {
		for(int i=0; i<people.size()-1; i++) {
			int min = i;
			for(int j=i+1; j<people.size(); j++) {
				if(people.get(j).compareTo(people.get(min))<0) {
					min = j;
				}
			}
			if(min != i) {
				Person holder = people.get(min);
				people.set(min, people.get(i));
				people.set(i, holder);
			}
		}
		return people;
	}
}