import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

class PrintsPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public PrintsPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("prints");
		
		this.add(new TopBar("PRINTS", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class BadgesPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public BadgesPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("badges");
		
		this.add(new TopBar("BADGES", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class SootBadgesPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public SootBadgesPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("sootbadges");
		
		this.add(new TopBar("SOOT BADGES", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class StickersPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public StickersPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("stickers");
		
		this.add(new TopBar("STICKERS", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class SootStickersPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public SootStickersPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("sootstickers");
		
		this.add(new TopBar("SOOT STICKERS", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class ShirtsPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public ShirtsPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("shirts");
		
		this.add(new TopBar("SHIRTS", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class HoodiesPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public HoodiesPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("hoodies");
		
		this.add(new TopBar("HOODIES", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class PacksPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public PacksPanel() {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("packs");
		
		this.add(new TopBar("PACKS", this.tableSearchPanel), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

