import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

class SearchPanel extends JPanel {
	
	String title;
	JTextField searchField;
	JComboBox<String> printSizes;
	JComboBox<String> shirtSizes;
	JComboBox<String> colors;
	JFormattedTextField amountField;
	
	private String[] createSearchTerm() {
		if (this.title.equals("PRINTS")) {
			return new String[] {this.searchField.getText(), this.printSizes.getSelectedItem().toString(), this.amountField.getText()};
		}
		else if (this.title.equals("SHIRTS") || this.title.equals("HOODIES")) {
			return new String[] {this.searchField.getText(), this.shirtSizes.getSelectedItem().toString(), this.colors.getSelectedItem().toString(), this.amountField.getText()};
		}
		else {
			return new String[] {this.searchField.getText(), this.amountField.getText()};
		}
	}
	
	public SearchPanel(String title, TableSearchPanel tableSearchPanel) {
		this.title = title;
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel search = new JLabel();
		search.setFont(new Font("Arial", Font.PLAIN, 20));
		search.setText("Search: ");
		search.setForeground(Color.white);
		
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableSearchPanel.getTablePanel().createTable(title.toLowerCase().replaceAll(" ", ""), createSearchTerm());
				tableSearchPanel.getTablePanel().redraw();
			}
		};
		
		this.searchField = new JTextField();
		this.searchField.setColumns(7);
		this.searchField.setFont(new Font("Arial", Font.PLAIN, 20));
		this.searchField.setBackground(new Color(30, 30, 30));
		this.searchField.setCaretColor(Color.white);
		this.searchField.setForeground(Color.white);
		this.searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				tableSearchPanel.getTablePanel().createTable(title.toLowerCase().replaceAll(" ", ""), createSearchTerm());
				tableSearchPanel.getTablePanel().redraw();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				tableSearchPanel.getTablePanel().createTable(title.toLowerCase().replaceAll(" ", ""), createSearchTerm());
				tableSearchPanel.getTablePanel().redraw();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				tableSearchPanel.getTablePanel().createTable(title.toLowerCase().replaceAll(" ", ""), createSearchTerm());
				tableSearchPanel.getTablePanel().redraw();
			}
		});
		
		JLabel printSizesLabel = new JLabel("Size: ");
		printSizesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		printSizesLabel.setForeground(Color.white);
		this.printSizes = new JComboBox<String>(new String[] {"All", "A2", "A3", "A4", "A5", "A6"});
		this.printSizes.setFont(new Font("Arial", Font.PLAIN, 17));
		this.printSizes.setForeground(Color.white);
		this.printSizes.setBackground(new Color(30, 30, 30));
		this.printSizes.addActionListener(actionListener);
		
		JLabel shirtSizesLabel = new JLabel("Size: ");
		shirtSizesLabel.setForeground(Color.white);
		shirtSizesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		this.shirtSizes = new JComboBox<String>(new String[] {"All", "S", "M", "L", "XL", "XXL", "XXXL"});
		this.shirtSizes.setFont(new Font("Arial", Font.PLAIN, 17));
		this.shirtSizes.setForeground(Color.white);
		this.shirtSizes.setBackground(new Color(30, 30, 30));
		this.shirtSizes.addActionListener(actionListener);
		
		JLabel colorsLabel = new JLabel("Color: ");
		colorsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		colorsLabel.setForeground(Color.white);
		this.colors = new JComboBox<String>(new String[] {"All", "Black", "White", "Red", "Yellow"});
		this.colors.setFont(new Font("Arial", Font.PLAIN, 17));
		this.colors.setForeground(Color.white);
		this.colors.setBackground(new Color(30, 30, 30));
		this.colors.addActionListener(actionListener);
		
		JLabel amountLabel = new JLabel();
		amountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		amountLabel.setText("Less than: ");
		amountLabel.setForeground(Color.white);
		amountLabel.setBackground(new Color(30, 30, 30));
		amountLabel.setBounds(820, 20, 110, 30);
		
		NumberFormat format = NumberFormat.getInstance();
	    format.setGroupingUsed(false);
	    NumberFormatter formatter = new NumberFormatter(format) {
	    	@Override
	    	public Object stringToValue(String text) throws ParseException {
	    	    if (text.length() == 0)
	    	        return null;
	    	    return super.stringToValue(text);
	    	}
	    };
	    formatter.setValueClass(Integer.class);
	    formatter.setAllowsInvalid(false);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);

		this.amountField = new JFormattedTextField(formatter) {
			@Override
			public void invalidEdit() {
			}
		};
		this.amountField.setColumns(5);
		this.amountField.setFont(new Font("Arial", Font.PLAIN, 20));
		this.amountField.setForeground(Color.white);
		this.amountField.setBackground(new Color(30, 30, 30));
		this.amountField.setCaretColor(Color.white);
		this.amountField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				tableSearchPanel.getTablePanel().createTable(title.toLowerCase().replaceAll(" ", ""), createSearchTerm());
				tableSearchPanel.getTablePanel().redraw();
			}
		});

		JButton clearSearch = new JButton();
		clearSearch.setFocusable(false);
		clearSearch.setText("X");
		clearSearch.setFont(new Font("Arial", Font.PLAIN, 17));
		clearSearch.setForeground(Color.white);
		clearSearch.setBackground(new Color(30, 30, 30));
		clearSearch.setBounds(750, 20, 30, 30);
		clearSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchField.setText("");
				printSizes.setSelectedIndex(0);
				shirtSizes.setSelectedIndex(0);
				colors.setSelectedIndex(0);
				amountField.setText("");
				System.out.println(title.toLowerCase());
				tableSearchPanel.getTablePanel().createTable(title.toLowerCase().replaceAll(" ", ""), new String[] {""});
				tableSearchPanel.getTablePanel().redraw();
			}
			
		});
		
		this.add(search);
		this.add(searchField);
		
		if(title.equals("PRINTS")) {
			this.add(printSizesLabel);
			this.add(printSizes);
		}
		
		if(title.equals("SHIRTS") || title.equals("HOODIES")) {
			this.add(shirtSizesLabel);
			this.add(shirtSizes);
			this.add(colorsLabel);
			this.add(colors);
		}
		
		this.add(amountLabel);
		this.add(amountField);
		this.add(clearSearch);
	}
}

class TopBar extends JPanel {
	
	private Database database;
	
	public TopBar(String title, TableSearchPanel tableSearchPanel, Frame frame) {
		this.database = frame.getDatabase();
		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(0, 70));
		this.setBackground(new Color(30, 30, 30));
		JLabel titleLabel = new JLabel();
		titleLabel.setForeground(Color.white);
		titleLabel.setText(title);
		titleLabel.setBounds(15, 10, 450, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		
		SearchPanel searchPanel = new SearchPanel(title, tableSearchPanel);
		searchPanel.setBounds(450, 30, 735, 50);
		searchPanel.setBackground(new Color(30, 30, 30));
		if(title.equals("SHIRTS") || title.equals("HOODIES")) {
			titleLabel.setBounds(15, 10, 300, 50);
			searchPanel.setBounds(300, 30, 885, 50);
		}
		this.add(titleLabel);
		this.add(searchPanel);
	}
}

class TableSearchPanel extends JPanel {
	
	private TablePanel tablePanel;
	
	public TablePanel getTablePanel() {
		return this.tablePanel;
	}
	
	public TableSearchPanel(String tableName, Frame frame) {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1200, 800));
		this.setBackground(new Color(30, 30, 30));
		this.tablePanel = new TablePanel(tableName, frame);
		this.add(tablePanel);
		this.add(new SidePanel(tableName, frame));
	}
}

class TablePanel extends JPanel {
	private JTable table;
	private Database database;
	private String tableName;
	private JScrollPane scrollPane;
	
	public void redraw() {
		this.scrollPane.setViewportView(this.table);
	}
	
	public void createTable(String tableName, String[] search) {
		this.tableName = tableName;
		TableModel tableModel = new DefaultTableModel(database.getColumnNames(tableName), 0);
		this.table = new JTable(tableModel);
		
		this.table.getTableHeader().setBackground(new Color(30, 30, 30));
		this.table.getTableHeader().setForeground(Color.white);
		this.table.setBackground(new Color(30, 30, 30));
		this.table.setForeground(Color.WHITE);
		
		List<Object[]> list = this.database.getInfo(tableName, search);
		int counter = 0;
		for (Object[] row : list) {
			((DefaultTableModel) this.table.getModel()).insertRow(counter, row);
			counter += 1;
		}
		
		this.table.setRowHeight(20);
		this.table.setFont(new Font("Helvetica", Font.PLAIN, 20));
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
		    defaults.put("Table.alternateRowColor", new Color(240, 240, 240));
		
		
		this.table.getTableHeader().setReorderingAllowed(false);
	}
	
	public TablePanel(String tableName, Frame frame) {
		this.database = frame.getDatabase();
		this.tableName = tableName;
		
		this.setLayout(null);
		this.setBounds(20, 10, 780, 680);
		
        createTable(this.tableName, new String[] {""});
        this.scrollPane = new JScrollPane(this.table);
        this.scrollPane.getViewport().setBackground(new Color(30, 30, 30));
        this.scrollPane.setBounds(0, 0, 780, 680);
        
        this.add(this.scrollPane, BorderLayout.CENTER);
	}
}

class SidePanel extends JPanel {
	
	private String tableName;
	private Database database;
	private ArrayList<JComponent> fieldList;
	
	private String capitalize(String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}
	
	public SidePanel(String tableName, Frame frame) {
		this.tableName = tableName;
		this.database = frame.getDatabase();
		this.setLayout(null);
		this.setBounds(820, 10, 360, 680);
		this.setBackground(new Color(30, 30, 30));
		this.setBorder(new LineBorder(Color.white));
		this.fieldList = new ArrayList<JComponent>();
		String[] columnNames = database.getColumnNames(this.tableName);
		for (int i = 1; i < columnNames.length; i++) {
			
			JLabel label = new JLabel(capitalize(columnNames[i]) + ":");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Arial", Font.PLAIN, 20));
			label.setBounds(10, 10 + 50*(i - 1), 100, 30);
			this.add(label);
			
			if (columnNames[i].equals("size")) {
				JComboBox<String> box = new JComboBox<String>();
				if (tableName.equals("prints")) {
					box.setModel(new DefaultComboBoxModel<String>(new String[] {"A2", "A3", "A4", "A5", "A6"}));
				}
				else {
					box.setModel(new DefaultComboBoxModel<String>(new String[] {"S", "M", "L", "XL", "XXL", "XXXL"}));
				}
				box.setFont(new Font("Arial", Font.PLAIN, 17));
				box.setForeground(Color.white);
				box.setBackground(new Color(30, 30, 30));
				box.setBounds(110, 10 + 50*(i - 1), 100, 30);
				
				this.fieldList.add(box);
				this.add(box);
			}
			else {
				JTextField field = new JTextField();
				field.setBackground(new Color(30, 30, 30));
				field.setForeground(Color.WHITE);
				field.setFont(new Font("Arial", Font.PLAIN, 20));
				field.setBounds(110, 10 + 50*(i - 1), 150, 30);
				
				this.fieldList.add(field);
				this.add(field);
			}
		}
		
		Button insertButton = new Button("Insert");
		insertButton.setBounds(10, 10 + 50*(columnNames.length - 1), 100, 30);
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] entries = new String[columnNames.length - 1];
				for (int i = 0; i < entries.length; i++) {
					if (fieldList.get(i) instanceof JTextField) {
						entries[i] = ((JTextField) fieldList.get(i)).getText();
					}
					else if (fieldList.get(i) instanceof JComboBox) {
						entries[i] = (String) ((JComboBox<?>) fieldList.get(i)).getSelectedItem();
					}
					else {
						//TODO create error message
					}
				}
				
				database.insert(tableName, entries);
			}
		});
		this.add(insertButton);
	}
}
