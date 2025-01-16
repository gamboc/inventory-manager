import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {

	private Frame frame;
	private Button printsButton;
	
	public Menu(Frame frame, String tableName) {
		this.frame = frame;
		this.setPreferredSize(new Dimension(200, 0));
		this.setBackground(new Color(30, 30, 30));
		this.setLayout(null);
		
		this.printsButton = new Button("Prints");
		this.printsButton.setBounds(10, 20, 180, 40);
		this.printsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new PrintsPanel(frame));
				Frame.changeCurrentItem("prints");
			}
			
		});
		this.add(printsButton);
		
		JButton badgesButton = new Button("Badges");
		badgesButton.setBounds(10, 85, 180, 40);
		badgesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		badgesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new BadgesPanel(frame));
				Frame.changeCurrentItem("badges");
			}
			
		});
		this.add(badgesButton);
		
		JButton sootBadgesButton = new Button("Soot Badges");
		sootBadgesButton.setBounds(10, 150, 180, 40);
		sootBadgesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		sootBadgesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new SootBadgesPanel(frame));
				Frame.changeCurrentItem("sootbadges");
			}
			
		});
		this.add(sootBadgesButton);
		
		JButton stickersButton = new Button("Stickers");
		stickersButton.setBounds(10, 215, 180, 40);
		stickersButton.setFont(new Font("Arial", Font.PLAIN, 20));
		stickersButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new StickersPanel(frame));
				Frame.changeCurrentItem("stickers");
			}
			
		});
		this.add(stickersButton);
		
		JButton sootStickersButton = new Button("Soot Stickers");
		sootStickersButton.setBounds(10, 280, 180, 40);
		sootStickersButton.setFont(new Font("Arial", Font.PLAIN, 20));
		sootStickersButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new SootStickersPanel(frame));
				Frame.changeCurrentItem("sootstickers");
			}

		});
		this.add(sootStickersButton);
		
		JButton shirtsButton = new Button("Shirts");
		shirtsButton.setBounds(10, 345, 180, 40);
		shirtsButton.setFont(new Font("Arial", Font.PLAIN, 20));
		shirtsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new ShirtsPanel(frame));
				Frame.changeCurrentItem("shirts");
			}

		});
		this.add(shirtsButton);
		
		JButton hoodiesButton = new Button("Hoodies");
		hoodiesButton.setBounds(10, 410, 180, 40);
		hoodiesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		hoodiesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new HoodiesPanel(frame));
				Frame.changeCurrentItem("hoodies");
			}

		});
		this.add(hoodiesButton);
		
		JButton packsButton = new Button("Packs");
		packsButton.setBounds(10, 475, 180, 40);
		packsButton.setFont(new Font("Arial", Font.PLAIN, 20));
		packsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(new PacksPanel(frame));
				Frame.changeCurrentItem("packs");
			}

		});
		this.add(packsButton);
		
		if (tableName.equals("prints")) {
			printsButton.doClick();
		}
		else if (tableName.equals("badges")) {
			badgesButton.doClick();
		}
		else if (tableName.equals("sootbadges")) {
			sootBadgesButton.doClick();
		}
		else if (tableName.equals("stickers")) {
			stickersButton.doClick();
		}
		else if (tableName.equals("sootstickers")) {
			sootStickersButton.doClick();
		}
		else if (tableName.equals("shirts")) {
			shirtsButton.doClick();
		}
		else if (tableName.equals("hoodies")) {
			hoodiesButton.doClick();
		}
		else {
			packsButton.doClick();
		}
	}
}
