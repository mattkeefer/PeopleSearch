package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;

public class SearchDlg extends GBDialog {
	
	JLabel count = addLabel("", 1,1,1,1);
	JLabel nameLbl = addLabel("Name:", 2,1,1,1);
	JLabel ageLbl = addLabel("Age:", 3,1,1,1);
	JTextField name = addTextField("", 2,2,1,1);
	IntegerField age = addIntegerField(0, 3,2,1,1);
	JButton exit = addButton("Cancel", 5,1,1,1);
	JButton update = addButton("Update", 4,1,1,1);
	JButton delete = addButton("Delete", 4,2,1,1);
	Person per;
	EpicArray ppl;
	private int cnt;
	
	public SearchDlg(JFrame frm, Person p, int c, EpicArray a) throws FormatException {
		super(frm);
		if(p == null) {
			throw new FormatException("Person not found.");
		}
		else {
			name.setText(p.getName());
			age.setNumber(p.getAge());
			count.setText(String.format("Number of Comparisons = %d", c));
			cnt = c;
			per = p;
			ppl = a;
		}
		getContentPane().setBackground(new Color(247, 236, 111));
		setTitle("Search");
		setSize(600, 250);
		setVisible(true);
	}
	
	public SearchDlg(JFrame frm, Person p, int c, EpicArray a, boolean b) throws FormatException {
		super(frm);
		if(p == null) {
			throw new FormatException("Person not found.");
		}
		else {
			name.setText(p.getName());
			age.setNumber(p.getAge());
			cnt = c;
			per = p;
			ppl = a;
		}
		getContentPane().setBackground(new Color(247, 236, 111));
		setTitle("Search");
		setSize(600, 250);
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button == update) {
			try {
				per.setName(name.getText());
				per.setAge(age.getNumber());
				dispose();
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		if(button == delete) {
			ppl.delete(cnt-1);
			dispose();
		}
		if(button == exit) {
			dispose();
		}
	}
}