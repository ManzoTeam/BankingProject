package Models;

import java.util.Date;
import java.util.List;

public class PersonaModel extends UtenteModel {
	private String nome;
	private String cognome;
	private Date annoNascita;
	private String codiceFiscale;
	private List<ContoModel> conti;

	public PersonaModel(String email, String password, String nome, String cognome, Date annoNascita, String codiceFiscale, List<ContoModel> conti) {
		super(email, password);
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.codiceFiscale = codiceFiscale;
		this.conti = conti;
	}
	

}
