package Swings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Validation implements ActionListener {

	private JButton login;
	private JTextField text1;
	private JTextField text2;
	private JTextArea text_area;

	public Validation(JButton login, JTextField text1, JTextField text2, JTextArea ta) {
		this.login = login;
		this.text1 = text1;
		this.text2 = text2;
		this.text_area = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			String user_name, line, file_check, pass = null;
			String pass_check;
			String arr[] = new String[5];
			user_name = text1.getText().toUpperCase();
			pass_check = text2.getText();
			file_check = "D:\\student_info\\" + user_name + ".txt";

			try {
				BufferedReader br = new BufferedReader(new FileReader(file_check));
				while ((line = br.readLine()) != null) {
					pass = line;
				}
				arr = pass.split(" : ");

				if (pass_check.equals(arr[1])) {
					text_area.setText("\n\n\t\tLogin Successfull!!");
				} else {
					text_area.setText("\n\n\t\tInvalid password!");
				}
			} catch (FileNotFoundException e1) {
				text_area.setText("\n\n\t\tEnter the valid Username!");
			} catch (IOException e2) {
				text_area.setText("\n\n\t\tSomething went wrong!");;
			}
		}

	}
}
