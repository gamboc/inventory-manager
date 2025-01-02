import java.awt.BorderLayout;

import javax.swing.JPanel;

class PrintsPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public PrintsPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("prints", frame);
		
		this.add(new TopBar("PRINTS", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class BadgesPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public BadgesPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("badges", frame);
		
		this.add(new TopBar("BADGES", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class SootBadgesPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public SootBadgesPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("sootbadges", frame);
		
		this.add(new TopBar("SOOT BADGES", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class StickersPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public StickersPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("stickers", frame);
		
		this.add(new TopBar("STICKERS", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class SootStickersPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public SootStickersPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("sootstickers", frame);
		
		this.add(new TopBar("SOOT STICKERS", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class ShirtsPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public ShirtsPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("shirts", frame);
		
		this.add(new TopBar("SHIRTS", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class HoodiesPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public HoodiesPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("hoodies", frame);
		
		this.add(new TopBar("HOODIES", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

class PacksPanel extends JPanel {
	
	private TableSearchPanel tableSearchPanel;
	
	public PacksPanel(Frame frame) {
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new BorderLayout());
		
		this.tableSearchPanel = new TableSearchPanel("packs", frame);
		
		this.add(new TopBar("PACKS", this.tableSearchPanel, frame), BorderLayout.NORTH);
		this.add(this.tableSearchPanel, BorderLayout.WEST);
	}
}

