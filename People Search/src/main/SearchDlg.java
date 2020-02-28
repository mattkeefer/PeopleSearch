package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;

public class SearchDlg extends GBDialog {
	
	JLabel nameLbl = addLabel("Name:", 1,1,1,1);
	JLabel ageLbl = addLabel("Age:", 2,1,1,1);
	JTextField name = addTextField("", 1,2,1,1);
	IntegerField age = addIntegerField(0, 2,2,1,1);
	JButton exit = addButton("Cancel", 4,1,1,1);
	JButton update = addButton("Update", 3,1,1,1);
	JButton delete = addButton("Delete", 3,2,1,1);
	
	public SearchDlg(JFrame frm, String str) {
		super(frm);
		
		getContentPane().setBackground(new Color(247, 236, 111));
		setTitle("Search");
		setSize(600, 250);
		setVisible(true);
	}
}