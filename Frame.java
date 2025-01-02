import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	private JPanel centerPanel;
	private Database database;
	private static String currentItem;
	
	public static void changeCurrentItem(String newItem) {
		currentItem = newItem;
	}
	
	public static String getCurrentItem() {
		return currentItem;
	}
	
	public Database getDatabase() {
		return this.database;
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
		this.setResizable(true);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		
		Label databaseName = new Label("Database: ");
		databaseName.setBounds(100, 165, 180, 40);
		this.add(databaseName);
		
		TextField databaseNameField = new TextField("inventory");
		databaseNameField.setBounds(210, 165, 180, 40);
		this.add(databaseNameField);
		
		Label username = new Label("Username: ");
		username.setBounds(100, 215, 180, 40);
		this.add(username);
		
		TextField usernameField = new TextField("root");
		usernameField.setBounds(210, 215, 180, 40);
		this.add(usernameField);
		
		Label password = new Label("Password");
		password.setBounds(100, 265, 180, 40);
		this.add(password);
		
		TextField passwordField = new TextField("password");
		passwordField.setBounds(210, 265, 180, 40);
		this.add(passwordField);
		
		Label address = new Label("Address: ");
		address.setBounds(100, 315, 180, 40);
		this.add(address);
		
		TextField addressField = new TextField("127.0.0.1");
		addressField.setBounds(210, 315, 180, 40);
		this.add(addressField);
		
		Label port = new Label("Port: ");
		port.setBounds(100, 365, 180, 40);
		this.add(port);
		
		TextField portField = new TextField("3306");
		portField.setBounds(210, 365, 180, 40);
		this.add(portField);
		
		JButton login = new Button("Login");
		login.setBounds(210, 415, 180, 40);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				database = new Database(databaseNameField.getText(), usernameField.getText(), passwordField.getText(), addressField.getText(), portField.getText());
				if (database.tryLogin(usernameField.getText(), passwordField.getText(), addressField.getText(), portField.getText())) {
					if (!database.checkSchema(databaseNameField.getText(), usernameField.getText(), passwordField.getText(), addressField.getText(), portField.getText())) {
						database.generate(databaseNameField.getText(), usernameField.getText(), passwordField.getText(), addressField.getText(), portField.getText());
					}
					
					sucessfulLogin();
				}
			}
		});
		this.add(login);
	}
}
