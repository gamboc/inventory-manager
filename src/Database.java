import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private String databaseName;
	private String username;
	private String password;
	private String address;
	private String port;
	
	public boolean checkSchema(String name, String username, String password, String address, String port) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + address + ":" + port + "/";
			Connection connection = DriverManager.getConnection(url, username, password);
			DatabaseMetaData metaData = connection.getMetaData();
			
			ResultSet schemas = metaData.getCatalogs();
			while(schemas.next()) {
				String schemaName = schemas.getString(1);
				if (name.equals(schemaName)) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void generate(String databaseName, String username, String password, String address, String port) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + address + ":" + port + "/";
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE SCHEMA " + databaseName + ";");
			statement.executeUpdate("CREATE TABLE `" + databaseName + "`.`badges` (`id` INT NOT NULL, `name` VARCHAR(45) NULL, `amount` INT NOT NULL, PRIMARY KEY (`id`));");
			statement.executeUpdate("CREATE TABLE `" + databaseName + "`.`sootbadges` (`id` INT NOT NULL, `name` VARCHAR(45) NOT NULL, `amount` INT NOT NULL, PRIMARY KEY (`id`));");
			statement.executeUpdate("CREATE TABLE `" + databaseName + "`.`stickers` (`id` INT NOT NULL, `name` VARCHAR(45) NOT NULL, `amount` INT NOT NULL, PRIMARY KEY (`id`));");
			statement.executeUpdate("CREATE TABLE `" + databaseName + "`.`sootstickers` (`id` INT NOT NULL, `name` VARCHAR(45) NOT NULL, `amount` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));");
			statement.executeUpdate("CREATE TABLE `" + databaseName + "`.`shirts` (`id` INT NOT NULL, `name` VARCHAR(45) NOT NULL, `size` VARCHAR(45) NOT NULL, `amount` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));");
			statement.executeUpdate("CREATE TABLE `" + databaseName + "`.`hoodies` (`id` INT NOT NULL, `name` VARCHAR(45) NOT NULL, `size` VARCHAR(45) NOT NULL, `amount` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));");
			statement.executeUpdate("CREATE TABLE `" + databaseName + "`.`packs` (`id` INT NOT NULL, `name` VARCHAR(45) NOT NULL, `amount` INT NOT NULL, PRIMARY KEY (`id`));");
			Object[][] artworks = {{"Mona Lisa", "A4", 8}, {"Starry Night", "A3", 9}, {"The Scream", "A2", 7}, {"Girl with a Pearl Earring", "A5", 10}, {"The Persistence of Memory", "A4", 6}, {"The Last Supper", "A3", 9}, {"The Kiss", "A2", 7}, {"American Gothic", "A6", 5}, {"Guernica", "A3", 10}, {"The Birth of Venus", "A4", 8}, {"Las Meninas", "A5", 6}, {"The Arnolfini Portrait", "A6", 7}, {"The Night Watch", "A3", 8}, {"The Garden of Earthly Delights", "A2", 9}, {"The Hay Wain", "A5", 7}, {"Liberty Leading the People", "A4", 9}, {"The Swing", "A6", 6}, {"The School of Athens", "A3", 10}, {"The Son of Man", "A4", 7}};
			statement.executeUpdate("CREATE TABLE `inventory`.`prints` (`id` INT NOT NULL, `name` VARCHAR(45) NOT NULL, `size` VARCHAR(45) NOT NULL, `amount` INT NOT NULL, PRIMARY KEY (`id`));");
			for (Object[] entry : artworks) {
				insert("prints", entry);
			}
			Object[][] artworks2 = {{"Mona Lisa", 8}, {"Starry Night", 9}, {"The Scream", 7}, {"Girl with a Pearl Earring", 10}, {"The Persistence of Memory", 6}, {"The Last Supper", 9}, {"The Kiss", 7}, {"American Gothic", 5}, {"Guernica", 10}, {"The Birth of Venus", 8}, {"Las Meninas", 6}, {"The Arnolfini Portrait", 7}, {"The Night Watch", 8}, {"The Garden of Earthly Delights", 9}, {"The Hay Wain", 7}, {"Liberty Leading the People", 9}, {"The Swing", 6}, {"The School of Athens", 10}, {"The Son of Man", 7}};
			for (Object[] entry : artworks2) {
				insert("badges", entry);
				insert("sootbadges", entry);
				insert("stickers", entry);
				insert("sootstickers", entry);
				insert("packs", entry);
			}
			Object[][] artworks3 = {{"Mona Lisa", "M", 8}, {"Starry Night", "L", 9}, {"The Scream", "S", 7}, {"Girl with a Pearl Earring", "XL", 10}, {"The Persistence of Memory", "M", 6}, {"The Last Supper", "L", 9}, {"The Kiss", "S", 7}, {"American Gothic", "XS", 5}, {"Guernica", "L", 10}, {"The Birth of Venus", "M", 8}, {"Las Meninas", "S", 6}, {"The Arnolfini Portrait", "XS", 7}, {"The Night Watch", "L", 8}, {"The Garden of Earthly Delights", "S", 9}, {"The Hay Wain", "XL", 7}, {"Liberty Leading the People", "M", 9}, {"The Swing", "XS", 6}, {"The School of Athens", "L", 10}, {"The Son of Man", "M", 7}};
			for (Object[] entry : artworks3) {
				insert("shirts", entry);
				insert("hoodies", entry);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean tryLogin(String username, String password, String address, String port) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + address + ":" + port + "/";
			DriverManager.getConnection(url, username, password);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void insert(String tableName, Object[] data) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/inventory";
			Connection connection = DriverManager.getConnection(url, "root", "password");
			
			Object[] dataWithID = new Object[data.length + 1];
			dataWithID[0] = this.getMaxID(tableName) + 1;
			for (int i = 0; i < data.length; i++) {
				dataWithID[i + 1] = data[i];
			}
			
			String query = this.createInsertQuery(tableName, dataWithID);
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int getMaxID(String tableName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/inventory";
			Connection connection = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MAX(" + this.getColumnNames(tableName)[0] + ") FROM " + tableName + ";");
			rs.next();
			return rs.getInt("MAX(" + this.getColumnNames(tableName)[0] + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public String createInsertQuery(String tableName, Object[] row) {
		String query = "INSERT INTO " + tableName + " (";
		String[] columnNames = this.getColumnNames(tableName);
		for (int i = 0; i < columnNames.length; i++) {
			if (i == columnNames.length -1) {
				query += columnNames[i] + ") VALUES (";
			}
			else {
				query += columnNames[i] + ", ";
			}
		}
		
		for (int i = 0; i < row.length; i++) {
			if (i == row.length - 1) {
				query += String.format("'%s'", row[i]);
			}
			else {
				query += String.format("'%s', ", row[i]);
			}	
		}
		query += ");";
		
		return query;
	}
	
	public String[] getColumnNames(String tableName) {
		String[] columns = new String[0];
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/inventory";
			Connection connection = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = connection.createStatement();
			ResultSetMetaData  rsmd = statement.executeQuery("SELECT * FROM " + tableName + ";").getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			columns = new String[columnCount];
			for (int i = 1; i <= columnCount; i++) {
				columns[i - 1] = rsmd.getColumnName(i);
			}
			
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return columns;
		
	}
	
	private String createSearchQuery(String tableName, String[] term) {
		String query = "SELECT * FROM " + tableName;
		String[] columnNames = this.getColumnNames(tableName);
		boolean added = false;
		if (term.length > 1) {
			for (int i = 1; i < columnNames.length; i++) {
				if (!(term[i - 1] == null) && term[i - 1].length() > 0 && !term[i - 1].equals("All")) {
					if (!added) {
						added = true;
						query += " WHERE ";
					}
					else {
						query += " AND ";
					}
					if (i == 1) {
						query += columnNames[i] + " LIKE " + "'%" + term[i - 1] + "%'";
					}
					else if (i < columnNames.length - 1) {
						query += columnNames[i] + " = " + "'" + term[i - 1] + "'";
					}
					else {
						query += columnNames[i] + " <= " + "'" + term[i - 1] + "'";
					}
				}
			}
		}
		
		query += ";";
		return query;
	}
	
	public List<Object[]> getInfo(String tableName, String[] term) {
		List<Object[]> list = new ArrayList<Object[]>();
		
		try {
			String query = this.createSearchQuery(tableName, term);

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/inventory";
			Connection connection = DriverManager.getConnection(url, "root", "password");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			String[] columnNames = this.getColumnNames(tableName);
			while (rs.next()) {
				String[] row = new String[columnNames.length];
				for (int i = 0; i < columnNames.length; i++) {
					Object temp = rs.getObject(columnNames[i]);
					if (rs.getObject(columnNames[i]) instanceof String) {
						row[i] = rs.getString(columnNames[i]);
					}
					else {
						row[i] = Integer.toString(rs.getInt(columnNames[i]));
					}
				}
				list.add(row);
			}
			
			rs.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Database(String databaseName, String username, String password, String address, String port) {
	}
}
