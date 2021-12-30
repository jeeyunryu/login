package login;


import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Main implements ActionListener{
	
	
	
	JFrame loginFrm = new JFrame();
	JLabel idLbl, pwLbl, newLbl;
	JButton etrBtn, newBtn;
	JTextField idTxt, pwTxt;
	JPanel pnl1, pnl2;
	Container contentPane = loginFrm.getContentPane();
	
	ForConnection connection = new ForConnection();
	
	public Main() {
		
		loginFrm.setTitle("Naber");
		loginFrm.setSize(250, 150);
		loginFrm.setLocationRelativeTo(null);
		loginFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contentPane.setLayout(new FlowLayout());
		
		etrBtn = new JButton("Enter");
		newBtn  = new JButton("Sign up");
		newBtn.addActionListener(this);
		
		idTxt = new JTextField(7);
		pwTxt = new JTextField(7);
	
		idLbl = new JLabel("ID:");
		pwLbl = new JLabel("PW:");
		
		pnl1 = new JPanel();
		
		pnl1.setLayout(new GridLayout(2, 2));
		
		pnl1.add(idLbl);
		pnl1.add(idTxt);
		pnl1.add(pwLbl);
		pnl1.add(pwTxt);
		pnl2 = new JPanel();
		pnl2.setLayout(new FlowLayout());
		pnl2.add(pnl1);
		pnl2.add(etrBtn);
		
		contentPane.add(pnl2, BorderLayout.CENTER);
		contentPane.add(newBtn, BorderLayout.SOUTH);
		
		loginFrm.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newBtn) {
			SignUpFrm frame = new SignUpFrm();
		}
		
		if (e.getSource() == etrBtn) {
			String sql = "SELECT * FROM Users"
					+ "WHERE ID=" + idTxt + " AND Password=" + pwTxt + ";";
			
			try {
				connection.statement = connection.connection.createStatement();
				//connection.statement.executeQuery(sql);
				connection.statement.executeUpdate(sql);
			
				
			}	catch(SQLException ex) {}
			
		}
		
//		try {
//			if (rs.next()) {
//				LoginFrm frm = new LoginFrm();
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	
		
	}

	public static void main(String[] args) {
		Main l = new Main();
	}

}
