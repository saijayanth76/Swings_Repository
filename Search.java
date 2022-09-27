package Swings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search implements ActionListener {
	private JButton searchb;
	private JTextField tsearch;
	private JTextArea text_area;

	public Search(JButton searchb, JTextField tsearch, JTextArea ta) {
		this.searchb = searchb;
		this.tsearch = tsearch;
		this.text_area = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		text_area.setText(" ");
		if (e.getSource() == searchb) {
			String search_name = tsearch.getText().toUpperCase();
			String name1 = null, start_line = null;
			String names = null;

			String path = "D:\\student_info\\";
			File directory = new File(path);
			File filesList[] = directory.listFiles();
			String arr_name[] = new String[5];
			if (tsearch.getText().equals("")) {
				text_area.setText("\n\n\t\tEnter The Student Name!");
			} else {
				for (File f : filesList) {
					if (f.isFile()) {
						name1 = f.getName();
						String fn = path + name1;

						try {
							BufferedReader bs = new BufferedReader(new FileReader(fn));
							start_line = bs.readLine();
							arr_name = start_line.split(" : ");
							names = arr_name[1];
							String data = arr_name[1], ln;

							if (names.contains(search_name)) {

								while ((ln = bs.readLine()) != null) {
									data += "\n" + ln;
								}
								text_area.append("\n\n" + data);
							}
						} catch (FileNotFoundException e1) {
							text_area.setText("Enter the valid Student name");
						} catch (IOException e1) {
							text_area.setText("Error!");
						}
					}
				}
			}
		}
	}
}
