package Actors;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import IActors.IConto;
import IActors.ISessione;
import IActors.IUtente;

public class Utente implements IUtente{
	
	
	private String email; // Chiave primaria
	private String password;
	
	public Utente() {

	}

	public Utente(String email, String password) {
		// Controlli Email, Password
		this.email = email;
		this.password = password;
	}
	
	public boolean modificaEmail(String email) {
		try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE Azienda SET EMAIL=? WHERE MAIL=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			
			ps.setString(1, email);
			ps.setString(2, this.email);
			
			this.email=email;
			
			
			return true;
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		return false;
	}

	@Override
	public boolean modificaPassword(String password) {
		try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE Azienda SET PASSWORD=? WHERE MAIL=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			
			ps.setString(1, password);
			ps.setString(2, email);
			
			this.password=password;
			
			
			return true;
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		return false;
	}

	@Override
	public ISessione login() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<IConto> visualizzaConti(Utente utente) {
		
		ResultSet rs = null;
		
		try(Statement stmt =  conn.createStatement()) {
			String query;
			
			if(!(utente instanceof Azienda)) 
				query="SELECT * FROM conto WHERE PROPRIETARIO_AZIENDA=? ";
			else 
				query="SELECT * FROM conto WHERE PROPRIETARIO_PERSONA_FISICA=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1,email);
			
			 rs=ps.executeQuery();
			 List<IConto> conti=new ArrayList<>();
			 
			 while(rs.next()) { 
					conti.add(new Conto(rs.getInt("NUMERO_CONTO"),rs.getDouble("SALDO"),utente));
					}
			 conn.close();
			 return conti;
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		return null;
	}
	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password=password;
	}

}
