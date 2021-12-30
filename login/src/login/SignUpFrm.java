package login;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

import javax.swing.*;


public class SignUpFrm extends JFrame implements ActionListener{
	
	public static final int SIZEOFARRAY = 50;
	
	ForConnection connection = new ForConnection();
	ResultSet rs;
	
	static String id;
	static String pw;
	static String nme;
	static String bday;
	static String phNo;
	static String gen;
	
	public static int cnt = 0;
	
	JLabel setIDLbl, setNmeLbl, setPwLbl, setbdayLbl, setphNoLbl, setGenLbl, pwCdtn;
	JTextField setIDFld, setNmeFld, setPwFld, setbdayFld, setphNoFld, setGenFld;
	
	
	JButton sgnUp, idChk;
	
	public SignUpFrm () {
		
		setSize(500, 500);
		setTitle("Sign Up");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(7, 1));
		
	
		
		setIDLbl = new JLabel("ID:");
		setIDFld = new JTextField(10);
	
		idChk = new JButton("아이디 중복 체크");
		idChk.addActionListener(this);
		
		
		p1.add(setIDLbl);
		p1.add(setIDFld);
		p1.add(idChk);
		
		c.add(p1);
		
		setPwLbl = new JLabel("Password:");
		setPwFld = new JTextField(10);
		pwCdtn = new JLabel("(비밀번호 조건: 숫자와 영문 조합으로 8자 이상)");
	
		
		p2.add(setPwLbl);
		p2.add(setPwFld);
		p2.add(pwCdtn);
		c.add(p2);
		
		setNmeLbl = new JLabel("Name:");
		setNmeFld = new JTextField(10);
	
		p3.add(setNmeLbl);
		p3.add(setNmeFld);
		
		c.add(p3);
		
		setbdayLbl = new JLabel("Birthday:");
		setbdayFld = new JTextField(10);
		
		
		p4.add(setbdayLbl);
		p4.add(setbdayFld);
		
		c.add(p4);
		
		setphNoLbl = new JLabel("Phone Number:");
		setphNoFld = new JTextField(10);
	
		
		p5.add(setphNoLbl);
		p5.add(setphNoFld);
		c.add(p5);
	
		
		setGenLbl = new JLabel("Gender");
		setGenFld = new JTextField(10);

		
		p6.add(setGenLbl);
		p6.add(setGenFld);
		c.add(p6);
		
		sgnUp = new JButton("Sign Up");
		sgnUp.addActionListener(this);
		c.add(sgnUp);
		
		
	
		//pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == sgnUp) {
			
			id = setIDFld.getText();
			pw = setPwFld.getText();
			nme = setNmeFld.getText();
			bday = setbdayFld.getText();
			phNo = setphNoFld.getText();
			gen = setGenFld.getText();
		
			
			try {
				connection.statement = connection.connection.createStatement();
				connection.statement.executeUpdate("insert into Users " + "(ID, Password, Name, Birthday, PhoneNo, GENDER) value ('" + id + "','"  + pw + "','"  + nme + "','"  + bday + "','"  + phNo + "','" + gen + "')");
				
			} catch(SQLException ex) {
				
			}
	
			
			
	
			
		}
		
		
		
		if (e.getSource() == idChk) {
			
		}
		
	}
	
	
}
