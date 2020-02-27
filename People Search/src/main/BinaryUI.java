package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;

public class BinaryUI extends GBFrame {

	JButton add = addButton("Add", 3,1,3,1);
	JTextField name = addTextField("", 1,2,2,1);
	JTextField age = addTextField("", 2,2,2,1);
	JLabel nameLbl = addLabel("Name:", 1,1,1,1);
	JLabel ageLbl = addLabel("Age:", 2,1,1,1);
	JButton search = addButton("Search", 3,5,1,2);
	JTextField searchInput = addTextField("", 3,4,2,1);
	JTextArea output = addTextArea("", 1,4,2,2);
	JLabel spacer = addLabel("this is for spacing bc bad", 4,2,2,1);
	EpicArray people;
	
	public BinaryUI() {
		people = new EpicArray();
		search.setEnabled(false);
		output.setEditable(false);
		searchInput.setEnabled(false);
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
			//add person
			//update sorted text area
			//enable search buttons + text fields
			people.add(new Person("Zach", 37));
			people.add(new Person("Alex", 15));
			people.add(new Person("Daniel", 25));
			people.add(new Person("Charlie", 12));
			output.setText(new Sorter(people).sortNames().toString());
		}
		if(button == search) {
			
		}
	}
}