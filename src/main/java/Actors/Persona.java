package Actors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Utente {
	private String nome;
	private String cognome;
	private LocalDate annoNascita;
	private String codiceFiscale;
	private List<Conto> conti;

	public Persona(String email, String password, String nome, String cognome, LocalDate annoNascita,
			String codiceFiscale) {
		super(email, password);
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.codiceFiscale = codiceFiscale;
		this.conti = new ArrayList<Conto>();
	}

}