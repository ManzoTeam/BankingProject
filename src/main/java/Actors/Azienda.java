package Actors;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import IActors.IAzienda;
import IActors.IConto;
import IActors.ISessione;

public class Azienda extends Utente implements IAzienda{
	
	private String ragioneSociale;
	private String partitaIva;
	private String codiceFiscale;
	private String citta;
	private List<Conto> conti;

	public Azienda(String email, String password) {
		super(email, password);
		this.ragioneSociale=ragioneSociale;
		this.partitaIva=partitaIva;
		this.codiceFiscale=codiceFiscale;
		this.citta=citta;
		/*try(Statement stmt =  conn.createStatement()) {
			
			String query="INSERT INTO Azienda (MAIL,PASSWORD_A)"
						+ "values (?,?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			this.conti = new ArrayList<>();
			ps.executeQuery();
			 
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	*/
		
		
		
	}
	@Override
	public void modificaInformazioniAccount(String ragioneSociale,String codiceFiscale,String partitaIva,String citta) {
		
			try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE Azienda SET RAGIONESOCIALE=?,PARTITAIVA=?,CF=?,CITTA=? WHERE MAIL=? WHERE MAIL=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			
			ps.setString(1, ragioneSociale);
			ps.setString(2, partitaIva);
			ps.setString(3, codiceFiscale);
			ps.setString(4, citta);
			ps.setString(5, super.getEmail());
			
			
			this.ragioneSociale=ragioneSociale;
			this.partitaIva=partitaIva;
			this.codiceFiscale=codiceFiscale;
			this.citta=citta;
			
			
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
		
	}


	@Override
	public List<Conto> visualizzaConti() {
		ResultSet rs = null;
		
		try(Statement stmt =  conn.createStatement()) {
			
			String query="SELECT * FROM conto WHERE PROPRIETARIO_AZIENDA=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1,super.getEmail());
			
			 rs=ps.executeQuery();
			 
			 while(rs.next()) { 
					conti.add(new Conto(rs.getInt("NUMERO_CONTO"),rs.getDouble("SALDO"),super.getUtente()));
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

	
}
	

