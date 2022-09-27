package Swings;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tabs extends JFrame {
	
	//Creating Tab
	JTabbedPane tab = new JTabbedPane();
	JPanel panel1, panel2, panel3;
	JScrollPane scroll;
	Container c;
	Container c1, c2;
	JLabel fname, lname, regno, email, mobile, gender, address;
	JLabel s, s1, s2, s3;
	JLabel username, pwd;
	JTextField t1, t2, t3, t4, t5;
	JTextField text1, text2, tsearch;
	JRadioButton r1, r2;
	JButton login, submit, searchb;
	JTextArea area, text_area;
	JLabel search;
	ButtonGroup bg;
	String reg_no, file_name;

	public Tabs() {
		
		// Creating Panels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		// panel1
		panel1.setLayout(new GridLayout(10, 2));

		fname = new JLabel("First Name :");
		lname = new JLabel("Last Name:");
		regno = new JLabel("Registration Number :");
		email = new JLabel("Email :");
		mobile = new JLabel("Mobile Number :");
		gender = new JLabel("Gender :");
		address = new JLabel("Address :");
		// labels for spacing purpose
		s = new JLabel();
		s1 = new JLabel();
		s2 = new JLabel();
		s3 = new JLabel();

		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);

		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		area = new JTextArea();

		submit = new JButton("Submit");
		submit.setBounds(100, 110, 90, 25);
		// button grouping
		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		// adding components to panel1
		panel1.add(fname);
		panel1.add(t1);
		panel1.add(lname);
		panel1.add(t2);
		panel1.add(regno);
		panel1.add(t3);
		panel1.add(email);
		panel1.add(t4);
		panel1.add(mobile);
		panel1.add(t5);
		panel1.add(gender);
		panel1.add(r1);
		panel1.add(s);
		panel1.add(r2);
		panel1.add(address);
		panel1.add(area);
		panel1.add(s1);
		panel1.add(s2);
		panel1.add(s3);
		panel1.add(submit);

		// panel2
		panel2.setLayout(null);

		username = new JLabel("User Name :");
		username.setBounds(100, 8, 70, 20);

		text1 = new JTextField();
		text1.setBounds(100, 28, 193, 28);

		pwd = new JLabel("Password :");
		pwd.setBounds(100, 55, 70, 20);

		text2 = new JTextField();
		text2.setBounds(100, 75, 193, 28);

		login = new JButton("Login");
		login.setBounds(100, 110, 90, 25);
		// adding components to panel2
		panel2.add(username);
		panel2.add(text1);
		panel2.add(pwd);
		panel2.add(text2);
		panel2.add(login);
		// panel3
		panel3.setLayout(null);
		search = new JLabel("Enter The Name Of The Student You Want To Search");
		search.setBounds(90, 20, 500, 40);

		tsearch = new JTextField(20);
		tsearch.setBounds(140, 80, 200, 30);

		searchb = new JButton("Search");
		searchb.setBounds(180, 150, 100, 30);
		// adding components to panel3
		panel3.add(search);
		panel3.add(tsearch);
		panel3.add(searchb);
		// container to add tab
		c = getContentPane();
		c.setLayout(new GridLayout(2, 2));
		// adding panels to tab
		tab.addTab("Registration", panel1);
		tab.addTab("LOGIN", panel2);
		tab.addTab("SEARCH", panel3);
		c.add(tab);
		// text area(ta) to display messages
		text_area = new JTextArea();
		//Scrolling
		scroll = new JScrollPane(text_area);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		text_area.setEditable(false);
		c.add(scroll);
		// ActionListener
		ActionListener listener1 = new RegistrationFiles(t1, t2, t3, t4, t5, r1, r2, submit, area, text_area);
		submit.addActionListener(listener1);
		
		ActionListener listener2 = new Validation(login, text1, text2, text_area);
		login.addActionListener(listener2);
		
		ActionListener listener3 = new Search(searchb, tsearch, text_area);
		searchb.addActionListener(listener3);
	}
}
