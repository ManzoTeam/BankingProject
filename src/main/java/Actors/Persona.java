package Actors;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Utente {
	private String nome;
	private String cognome;
	private LocalDate annoNascita;
	private String codiceFiscale;
	private List<Conto> conti;

	public Persona(String email, String password, String nome, String cognome, LocalDate annoNascita, String codiceFiscale) {
		super(email, password);
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.codiceFiscale = codiceFiscale;
		this.conti = new ArrayList<Conto>();
	}
	
	public void modificaInformazioniAccount() {
		
		try(Statement stmt =  conn.createStatement()) {
		
		String query="UPDATE cliente SET NOME=?,COGNOME=?,CF=?,ANNO_DI_NASCITA=? WHERE MAIL=?";
		
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

}