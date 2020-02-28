package main;
import java.util.Arrays;

public class Sorter {

	private EpicArray people;
	int linearCount;
	int binaryCount;
	
	public Sorter(EpicArray p) {
		people = p;
		linearCount = 0;
		binaryCount = 0;
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
	
	public String linearSearch(String n) {
		for(int i=0; i<people.size(); i++) {
			linearCount++;
			if(people.get(i).getName().equals(n)) {
				return people.get(i).toString();
			}
		}
		return "The entered person is not contained in the array.";
	}
	
	public String binarySearch(String n) {
		people = sortNames();
		//binary search
		int start = 0;
		int end = people.size()-1;
		int mid = (end-start)/2;
		int compare;
		while(people.size()>0) {
			binaryCount++;
			compare = people.get(mid).getName().toLowerCase().compareTo(n.toLowerCase());
			if(compare==0) {
				return people.get(mid).toString();
			}
			if(compare>0) {
				end = mid-1;
				mid = (end-start)/2;
			}
			if(compare<0) {
				start = mid+1;
				mid = (end-start)/2;
			}
		}
		return "The entered person is not contained in the array.";
	}
	
	public int getLinearCount() {
		return linearCount;
	}
	
	public int getBinaryCount() {
		return binaryCount;
	}
}