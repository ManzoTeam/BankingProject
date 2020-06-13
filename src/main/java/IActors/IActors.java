package IActors;

import java.sql.Connection;

import Database.Database;

public interface IActors {

	public static final Connection conn = new Database().getConnection();
	
}
