package Swings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrationFiles implements ActionListener {

		private JTextField t1;
		private JTextField t2;
		private JTextField t3;
		private JTextField t4;
		private JTextField t5;
		private JRadioButton r1;
		private JRadioButton r2;
		private JButton submit;
		private JTextArea area;
		private JTextArea text_area;

		public RegistrationFiles(JTextField t1, JTextField t2, JTextField t3, 
				JTextField t4, JTextField t5, JRadioButton r1,JRadioButton r2,
				JButton submit, JTextArea area, JTextArea ta) 
		{
			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
			this.t4 = t4;
			this.t5 = t5;
			this.r1 = r1;
			this.r2 = r2;
			this.submit = submit;
			this.area = area;
			this.text_area = ta;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// Registration
			if (e.getSource() == submit) {

				String data1, data2, data3, data4;
				String reg_no, file_name;
				String name = t1.getText()+ " " + t2.getText();
				String reg = t3.getText();
				String mail = t4.getText();
				String mobile = t5.getText();

				data1 = "NAME : " + name.toUpperCase() + "\n" + 
						"REGISTRATION NUMBER : " +reg + "\n" + 
						"EMAIL : " + mail + "\n" + 
						"MOBILE : " + mobile + "\n";
				if (r1.isSelected()) {
					data2 = "GENDER : Male";
				} else {
					data2 = "GENDER : Female";
				}

				data3 = "\n" + "ADDRESS :" + area.getText();

				reg_no = t3.getText().toUpperCase();
				file_name = "D:\\student_info\\" + reg_no + ".txt";

				if (t1.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
						|| t5.getText().equals("")) {
					text_area.setText("\n\n\tAll the above fields are mandatory please fill them!!");
				} else {
					Random random = new Random();
					int p = random.nextInt(1000000);
					String password = t1.getText()+"@"+ p;
					data4 = "\nPASSWORD : " + password;

					text_area.setText("\n\n\t\tRegistartion Successfull!" + "\n\t\tPassword is : " + password);
					try {
						File file = new File(file_name);
						if (file.createNewFile()) {
							FileWriter writer = new FileWriter(file);
							writer.write(data1 + data2 + data3 + data4);
							writer.close();
						} else {
							text_area.setText("\n\n\t\tUser already exists!");
						}
					} catch (IOException e1) {
						text_area.setText("Something went wrong Try again");
					}
				}
			}
		}
	}



