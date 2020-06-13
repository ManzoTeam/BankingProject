import java.sql.Connection;

import Database.Database;

public class Database_tests {

	public static void main(String[] args) {
		Database d = new Database();
		
		Connection c = d.getConnection();
		assert (c != null);
	}
}
