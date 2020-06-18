package Actors;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import IActors.IPersona;

public class Persona extends Utente implements IPersona{
	private String nome;
	private String cognome;
	private Date annoNascita;
	private String codiceFiscale;
	private List<Conto> conti;

	public Persona(String email, String password, String nome, String cognome, Date annoNascita, String codiceFiscale) {
		super(email, password);
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.codiceFiscale = codiceFiscale;
		this.conti = new ArrayList<Conto>();
	}
	
	public void modificaInformazioniAccount(String nome, String cognome,String codiceFiscale,Date annoNascita,String password) {
		
		try(Statement stmt =  conn.createStatement()) {
		
		String query="UPDATE cliente SET NOME=?,COGNOME=?,CF=?,ANNO_DI_NASCITA=?,PASSWORD=? WHERE MAIL=?";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		
		ps.setString(1, nome);
		ps.setString(2, cognome);
		ps.setString(3, codiceFiscale);
		ps.setDate(4, (java.sql.Date) annoNascita);
		ps.setString(5, password);
		ps.setString(6, super.getEmail());
		
		
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.annoNascita=annoNascita;
		super.setPassword(password);
		
		
	}catch (SQLException ex){
	// handle any errors
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	}	
	
	
}

	

}