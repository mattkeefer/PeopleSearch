package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BinaryUI extends GBFrame {

	JButton add = addButton("Add", 3,1,3,1);
	JTextField name = addTextField("", 1,2,2,1);
	IntegerField age = addIntegerField(0, 2,2,2,1);
	JLabel nameLbl = addLabel("Name:", 1,1,1,1);
	JLabel ageLbl = addLabel("Age:", 2,1,1,1);
	JButton search = addButton("Search", 5,5,1,2);
	JTextField searchInput = addTextField("", 4,4,2,1);
	JList<String> output = addList(1,4,2,2);
	ButtonGroup searchMethod = new ButtonGroup();
	JRadioButton linear = addRadioButton("Sequential Search", 3,4,1,1);
	JRadioButton binary = addRadioButton("Binary Search", 3,5,1,1);
	JLabel spacer = addLabel("this is for spacing bc bad", 4,2,2,1);
	EpicArray people;
	private int count;
	
	public BinaryUI() {
		people = new EpicArray();
		age.setText("");
		search.setEnabled(false);
		searchInput.setEnabled(false);
		searchMethod.add(linear);
		searchMethod.add(binary);
		linear.setEnabled(false);
		binary.setEnabled(false);
		output.setBackground(new Color(247, 236, 111));
		spacer.setForeground(new Color(230, 214, 41));
	}
	
	public static void main(String[] args) {
		JFrame frm = new BinaryUI();
		frm.getContentPane().setBackground(new Color(230, 214, 41));
		frm.setTitle("Updated Yellow Pages");
		frm.setSize(600, 250);
		frm.setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button == add) {
			try {
				people.add(new Person(name.getText(), age.getNumber()));
				name.setText("");
				age.setText("");
				searchInput.setEnabled(true);
				search.setEnabled(true);
				linear.setEnabled(true);
				binary.setEnabled(true);
				initializeList();
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		if(button == search) {
			if(linear.isSelected()) {
				try {
					SearchDlg sd = new SearchDlg(this, linearSearch(searchInput.getText()), count, people);
				}
				catch(FormatException e) {
					messageBox(e.getMessage());
				}
			}
			else {
				try {
					SearchDlg sd = new SearchDlg(this, binarySearch(searchInput.getText()), count, sortNames());
				}
				catch( FormatException e) {
					messageBox(e.getMessage());
				}
			}
			initializeList();
			searchInput.setText("");
			if(people.size()<1) {
				linear.setEnabled(false);
				binary.setEnabled(false);
				search.setEnabled(false);
				searchInput.setEnabled(false);
			}
		}
	}
	
	private void initializeList() {
		DefaultListModel<String> model = (DefaultListModel<String>)output.getModel();
		model.removeAllElements();
		for(String str : sortNames().getOutput()) {
			addToList(str);
		}
	}
	
	private void addToList(String str) {
		DefaultListModel<String> model = (DefaultListModel<String>)output.getModel();
		model.addElement(str);
	}
	
	public void listItemSelected(JList<String> li) {
		try {
			SearchDlg sd = new SearchDlg(this, linearSearch(sortNames().get(li.getSelectedIndex()).getName()), count, sortNames(), true);
		}
		catch( FormatException e) {
			messageBox(e.getMessage());
		}
		initializeList();
		if(people.size()<1) {
			linear.setEnabled(false);
			binary.setEnabled(false);
			search.setEnabled(false);
			searchInput.setEnabled(false);
		}
	}
	
	private EpicArray sortNames() {
		EpicArray pplArr = people;
		if(pplArr.size() > 1) {
			for(int i=0; i<pplArr.size()-1; i++) {
				int min = i;
				for(int j=i+1; j<pplArr.size(); j++) {
					if(pplArr.get(j).compareTo(pplArr.get(min))<0) {
						min = j;
					}
				}
				if(min != i) {
					Person holder = pplArr.get(min);
					pplArr.set(min, pplArr.get(i));
					pplArr.set(i, holder);
				}
			}
		}
		return pplArr;
	}
	
	private Person linearSearch(String n) {
		count = 0;
		for(int i=0; i<people.size(); i++) {
			count++;
			if(people.get(i).getName().toLowerCase().equals(n.toLowerCase())) {
				return people.get(i);
			}
		}
		return null;
	}
	
	public Person binarySearch(String n) throws FormatException {
		if(searchInput.getText().trim().equals("")) {
			throw new FormatException("Person not found.");
		}
		count = 0;
		EpicArray pplArr = sortNames();
		int start = 0;
		int end = pplArr.size();
		int mid = (end-start)/2;
		int compare;
		while(pplArr.size()>1) {
			count++;
			compare = pplArr.get(mid).getName().toLowerCase().compareTo(n.toLowerCase());
			if(compare==0) {
				return pplArr.get(mid);
			}
			if(compare>0) {
				end = mid-1;
				mid = (end-start)/2;
			} 
			if(compare<0) {
				start = mid+1;
				if((end-start)/2 > mid) {
					mid = (end-start)/2;
				}
				else {
					mid++;
				}
			}
		}
		return null;
	}
}