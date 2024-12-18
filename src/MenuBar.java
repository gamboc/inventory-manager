import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


class MenuBarButton extends JButton {
	
	public MenuBarButton() {
		this.setBackground(new Color(30, 30, 30));
		this.setForeground(Color.white);
		this.setFocusPainted(false);
		this.setFont(new Font("Arial", Font.PLAIN, 20));
	}
}

public class MenuBar extends JPanel {

	private Frame frame;
	
	public MenuBar(Frame frame) {
		this.frame = frame;
		this.setPreferredSize(new Dimension(200, 0));
		this.setBackground(new Color(30, 30, 30));
		this.setLayout(null);
		
		JButton printsButton = new MenuBarButton();
		printsButton.setText("Prints");
		printsButton.setBounds(10, 20, 180, 40);
		printsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new PrintsPanel());
				Frame.changeCurrentItem("prints");
			}
			
		});
		this.add(printsButton);
		
		JButton badgesButton = new MenuBarButton();
		badgesButton.setText("Badges");
		badgesButton.setBounds(10, 85, 180, 40);
		badgesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		badgesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new BadgesPanel());
				Frame.changeCurrentItem("badges");
			}
			
		});
		this.add(badgesButton);
		
		JButton sootBadgesButton = new MenuBarButton();
		sootBadgesButton.setText("Soot Badges");
		sootBadgesButton.setBounds(10, 150, 180, 40);
		sootBadgesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		sootBadgesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new SootBadgesPanel());
				Frame.changeCurrentItem("sootbadges");
			}
			
		});
		this.add(sootBadgesButton);
		
		JButton stickersButton = new MenuBarButton();
		stickersButton.setText("Stickers");
		stickersButton.setBounds(10, 215, 180, 40);
		stickersButton.setFont(new Font("Arial", Font.PLAIN, 20));
		stickersButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new StickersPanel());
				Frame.changeCurrentItem("stickers");
			}
			
		});
		this.add(stickersButton);
		
		JButton sootStickersButton = new MenuBarButton();
		sootStickersButton.setText("Soot Stickers");
		sootStickersButton.setBounds(10, 280, 180, 40);
		sootStickersButton.setFont(new Font("Arial", Font.PLAIN, 20));
		sootStickersButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new SootStickersPanel());
				Frame.changeCurrentItem("sootstickers");
			}

		});
		this.add(sootStickersButton);
		
		JButton shirtsButton = new MenuBarButton();
		shirtsButton.setText("Shirts");
		shirtsButton.setBounds(10, 345, 180, 40);
		shirtsButton.setFont(new Font("Arial", Font.PLAIN, 20));
		shirtsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new ShirtsPanel());
				Frame.changeCurrentItem("shirts");
			}

		});
		this.add(shirtsButton);
		
		JButton hoodiesButton = new MenuBarButton();
		hoodiesButton.setText("Hoodies");
		hoodiesButton.setBounds(10, 410, 180, 40);
		hoodiesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		hoodiesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new HoodiesPanel());
				Frame.changeCurrentItem("hoodies");
			}

		});
		this.add(hoodiesButton);
		
		JButton packsButton = new MenuBarButton();
		packsButton.setText("Packs");
		packsButton.setBounds(10, 475, 180, 40);
		packsButton.setFont(new Font("Arial", Font.PLAIN, 20));
		packsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new PacksPanel());
				Frame.changeCurrentItem("packs");
			}

		});
		this.add(packsButton);
		
		printsButton.doClick();
	}
}
