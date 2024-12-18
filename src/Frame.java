import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Frame extends JFrame {

	private JPanel centerPanel;
	private static String currentItem;
	
	public static void changeCurrentItem(String newItem) {
		currentItem = newItem;
	}
	
	public static String getCurrentItem() {
		return currentItem;
	}
	
	private void sucessfulLogin() {
		this.getContentPane().removeAll();
		
		this.setLayout(new BorderLayout());
		
		this.centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		this.add(centerPanel, BorderLayout.EAST);
		
		MenuBar menuBar = new MenuBar(this);
		this.add(menuBar, BorderLayout.WEST);
		
		this.revalidate();
		this.repaint();
	}
	
	public void changePanel(JPanel panel) {
		this.centerPanel.removeAll();
		this.centerPanel.add(panel);
		this.centerPanel.revalidate();
		this.centerPanel.repaint();
	}
	
	public Frame() {
		this.setTitle("Database");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1400, 900));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		
		JLabel databaseName = new JLabel();
		databaseName.setFont(new Font("Arial", Font.PLAIN, 20));
		databaseName.setText("Database: ");
		databaseName.setForeground(Color.white);
		databaseName.setBounds(100, 165, 180, 40);
		
		JTextField databaseNameField = new JTextField("inventory");
		databaseNameField.setColumns(7);
		databaseNameField.setFont(new Font("Arial", Font.PLAIN, 20));
		databaseNameField.setBackground(new Color(30, 30, 30));
		databaseNameField.setCaretColor(Color.white);
		databaseNameField.setForeground(Color.white);
		databaseNameField.setBounds(210, 165, 180, 40);
		
		JLabel username = new JLabel();
		username.setFont(new Font("Arial", Font.PLAIN, 20));
		username.setText("Username: ");
		username.setForeground(Color.white);
		username.setBounds(100, 215, 180, 40);
		
		JTextField usernameField = new JTextField("root");
		usernameField.setColumns(7);
		usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
		usernameField.setBackground(new Color(30, 30, 30));
		usernameField.setCaretColor(Color.white);
		usernameField.setForeground(Color.white);
		usernameField.setBounds(210, 215, 180, 40);
		
		JLabel password = new JLabel();
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setText("Password: ");
		password.setForeground(Color.white);
		password.setBounds(100, 265, 180, 40);
		
		JTextField passwordField = new JTextField("password");
		passwordField.setColumns(7);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBackground(new Color(30, 30, 30));
		passwordField.setCaretColor(Color.white);
		passwordField.setForeground(Color.white);
		passwordField.setBounds(210, 265, 180, 40);

		JLabel address = new JLabel();
		address.setFont(new Font("Arial", Font.PLAIN, 20));
		address.setText("Address: ");
		address.setForeground(Color.white);
		address.setBounds(100, 315, 180, 40);
		
		JTextField addressField = new JTextField("127.0.0.1");
		addressField.setColumns(7);
		addressField.setFont(new Font("Arial", Font.PLAIN, 20));
		addressField.setBackground(new Color(30, 30, 30));
		addressField.setCaretColor(Color.white);
		addressField.setForeground(Color.white);
		addressField.setBounds(210, 315, 180, 40);
		
		JLabel port = new JLabel();
		port.setFont(new Font("Arial", Font.PLAIN, 20));
		port.setText("Port: ");
		port.setForeground(Color.white);
		port.setBounds(100, 365, 180, 40);
		
		JTextField portField = new JTextField("3306");
		portField.setColumns(7);
		portField.setFont(new Font("Arial", Font.PLAIN, 20));
		portField.setBackground(new Color(30, 30, 30));
		portField.setCaretColor(Color.white);
		portField.setForeground(Color.white);
		portField.setBounds(210, 365, 180, 40);
		
		JButton login = new MenuBarButton();
		login.setText("Login");
		login.setBounds(210, 415, 180, 40);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Database database = new Database();
				if (database.tryLogin(usernameField.getText(), passwordField.getText(), addressField.getText(), portField.getText())) {
					if (!database.checkSchema(databaseNameField.getText(), usernameField.getText(), passwordField.getText(), addressField.getText(), portField.getText())) {
						database.generate(databaseNameField.getText(), usernameField.getText(), passwordField.getText(), addressField.getText(), portField.getText());
					}
					
					sucessfulLogin();
				}
			}
		});
		
		this.add(databaseName);
		this.add(databaseNameField);
		this.add(username);
		this.add(usernameField);
		this.add(password);
		this.add(passwordField);
		this.add(address);
		this.add(addressField);
		this.add(port);
		this.add(portField);
		this.add(login);
	}
}
