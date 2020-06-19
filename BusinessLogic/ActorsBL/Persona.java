package ActorsBL;

import java.util.Date;
import java.util.List;

import IActorsBL.IPersona;
import Models.ContoModel;

public class Persona extends Utente implements IPersona{

	private String nome;
	private String cognome;
	private Date annoNascita;
	private String codiceFiscale;
	private List<ContoModel> conti;

	public Persona(String email, String password, String nome, String cognome, Date annoNascita, String codiceFiscale, List<ContoModel> conti) {
		super(email, password);
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.codiceFiscale = codiceFiscale;
		this.conti = conti;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Date getAnnoNascita() {
		return annoNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public List<ContoModel> getConti() {
		return conti;
	}

	@Override
	public void modificaInformazioniAccount(String nome, String cognome, String codiceFiscale, Date annoNascita,
			String password) {
		// TODO Auto-generated method stub
		
	}

}
