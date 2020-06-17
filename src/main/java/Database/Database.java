package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;

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
	public boolean init() { // implementes ServletContextListener : contextInizialized
		Connection conn = getConnection();
		ScriptRunner sr = new ScriptRunner(conn);
		File folder = new File( getClass().getClassLoader().getResource("DataBaseHomeBanking").getFile() );
		
		if (folder == null)
			return false;
		
		for (File sqlFile : folder.listFiles()) {
			try ( Reader reader = new BufferedReader(new FileReader(sqlFile.toString())); ) {
				sr.runScript(reader);
				System.out.println(sqlFile.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
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

	
	public static void main(String[] args)  {
		Database d = new Database();
		d.init();
		try {
			d.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
