import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Label extends JLabel {
	
	public Label(String text) {
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setText(text);
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(30, 30, 30));
	}
}

class TextField extends JTextField {
	
	public TextField(String text) {
		this.setText(text);
		this.setColumns(7);
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setBackground(new Color(30, 30, 30));
		this.setCaretColor(Color.white);
		this.setForeground(Color.white);
	}
}

class Button extends JButton {
	
	public Button(String text) {
		this.setText(text);
		this.setBackground(new Color(30, 30, 30));
		this.setForeground(Color.white);
		this.setFocusPainted(false);
		this.setFont(new Font("Arial", Font.PLAIN, 20));
	}
}