import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

class GridBagLayoutDemo extends JFrame {
	
	public GridBagLayoutDemo() {
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Demo");
		this.setLocationRelativeTo(null);
		this.setLayout(layout);
		
		JPanel menuBar = new JPanel();
		menuBar.setPreferredSize(new Dimension(200, 0));
		menuBar.setBackground(new Color(30, 30, 30));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(menuBar, gbc);
		
		JPanel center = new JPanel();
		center.setBackground(new Color(100, 0, 0));
		
		gbc.gridx = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(center, gbc);
		
	}
}

public class Test {

	public static void main(String[] args) {
		
		GridBagLayoutDemo frame = new GridBagLayoutDemo();
		frame.setVisible(true);
	}
}
