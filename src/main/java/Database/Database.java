package Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database implements IDatabase {

	private static final String connectionString;
	
	static {
		String s = null;
		try (
		  InputStream in = ClassLoader.getSystemResourceAsStream("db.properties");
		  BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
				s = read_and_initialize_connectionString(reader);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		connectionString = s;
	}
	
	@Override
	public Connection getConnection() {
		try {
			return
				DriverManager.getConnection(connectionString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean init() {
		
	}
	
	private static String read_and_initialize_connectionString(BufferedReader reader) throws IOException {
		String l;
		int i = 1;
		StringBuilder stringBuilder = new StringBuilder();
		while ( (l = reader.readLine()) != null ) {
			String[] line = l.replaceAll("\\s+","").split("=");
			if (i == 3) 
				stringBuilder.append("?user=" + line[1] + "&password=");
			else
				stringBuilder.append(line[1]);
			i++;
		}
		
		return stringBuilder.toString();
	}

}
