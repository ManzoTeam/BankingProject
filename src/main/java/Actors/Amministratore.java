package Actors;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import IActors.IAmministratore;
import IActors.IConto;
import IActors.ISessione;
import IActors.IUtente;

public class Amministratore implements IAmministratore {

	private final int id;
	private String email;
	private String password;
	private static final int NUMERO_MAX_CONTI=3;

	public Amministratore() {
		this.id = 0;

	}

	public Amministratore(String email, String password) {
		this.id = 0;
		this.email = email;
		this.password = password;

	}

//	
//	public abstract boolean checkUserRegistration();
//	
//	public abstract boolean regAmministratore();
//	
//	public abstract Conto addContoCliente();
//	
//	public abstract Conto delContoCliente();
//	
//	public abstract Utente viewDati();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean modificaEmail(String emailModifica) {

		try (Statement stmt = conn.createStatement()) {

			String modificaEmail = "update amministratore set email=? where email=?";
			String dbString = email;
			PreparedStatement ps = conn.prepareStatement(modificaEmail);
			ps.setString(1, dbString);
			ps.setString(2, emailModifica);
			ps.executeQuery();

			//stmt.close();
			return true; 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean modificaPassword(String passwordModificata) {

		try (Statement stmt = conn.createStatement()) {

			String modificaPsw = "update amministratore set password_admin=? where email=?";
			String dbString = passwordModificata;
			PreparedStatement ps = conn.prepareStatement(modificaPsw);
			ps.setString(2, dbString);
			ps.setString(1, passwordModificata );
			ps.executeQuery();

			//stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public IUtente creaUtente(Utente utente) {

		try (Statement stmt = conn.createStatement()) {
			
			String query;
			PreparedStatement ps;
			
			if(utente instanceof Azienda) { 
				query="insert into azienda(mail,password_a) values (?,?) ";
				ps=conn.prepareStatement(query);
				ps.setString(1,utente.getEmail());
				ps.setString(2, utente.getPassword());
				}
			else {
				query="insert into cliente(mail,password_a) values (?,?) ";
				ps=conn.prepareStatement(query);
				ps.setString(1,utente.getEmail());
				ps.setString(2, utente.getPassword());
				
			}
			
			ps.executeQuery();
			
			return utente;
		}	

		 catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean cancellaConto(int numeroConto) {
		try (Statement stmt = conn.createStatement()) {

			String cercaConto = "select * from conto where numero_conto=?";
			PreparedStatement ps = conn.prepareStatement(cercaConto);
			ps.setInt(1, numeroConto);
			ResultSet rs = ps.executeQuery();

			if (!rs.equals(null)) {
				String cancellaConto = "delete from conto where numero_conto=?";
				PreparedStatement ps1 = conn.prepareStatement(cancellaConto);
				ps1.setInt(1, numeroConto);
				ps1.executeQuery();
				System.out.println("Cancellazione conto riuscita.");
				
//				stmt.close();
				return true;
			}
			
//			stmt.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Amministratore login(String email, String password) {
		try (Statement stmt = conn.createStatement()) {

			String login = "select * from amministratore where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(login);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Amministratore amm = null;
			if (!rs.equals(null)) {
				amm = new Amministratore();
				amm.setEmail(email);
			}
			conn.close();
			return amm;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Collection<IUtente> getElenco() {

		try (Statement stmt = conn.createStatement()) {

			String elencoAzienda = "select * from azienda";
			String elencoUtente = "select * from utente";

			PreparedStatement ps = conn.prepareStatement(elencoAzienda);
			PreparedStatement ps1 = conn.prepareStatement(elencoUtente);

			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();

			List<IUtente> lista = new ArrayList<>();

			while (rs.next() || rs1.next()) {
				Azienda azienda = new Azienda(rs.getString("mail"), rs.getString("password"));
				Utente utente = new Utente(rs.getString("email"), rs.getString("password"));
				lista.add(azienda);
				lista.add(utente);
			}
			conn.close();
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public IConto creaConto(int numeroConto, IUtente utente) {
		try (Statement stmt = conn.createStatement()) {
			String query;
			String query1;
			if(utente instanceof Azienda) {
				query= "select count(proprietario_azienda) as num_conto from conto where proprietario_azienda=?";
				query1="insert into conto(numero_conto,proprietario_azienda)values(?,?)";
			}
			else {
				query= "select count(proprietario_persona_fisica) as num_conto from conto where proprietario_persona_fisica=?";
				query1="insert into conto(numero_conto,proprietario_persona_fisica)values(?,?)";
			}

			 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ((Utente) utente).getEmail());
			ps.setInt(2, NUMERO_MAX_CONTI);
			ResultSet rs = ps.executeQuery();
			
			if(rs.equals(null)) 
				return null;

			PreparedStatement ps1;
			if(utente instanceof Azienda) {
				ps1=conn.prepareStatement(query1);
				ps1.setInt(1, numeroConto);
				ps1.setString(2,((Azienda) utente).getEmail());
			}
			else {
				ps1=conn.prepareStatement(query1);
				ps1.setInt(1, numeroConto);
				ps1.setString(2,((Azienda) utente).getEmail());
			}
			
			ps1.executeQuery(query1);
			return new Conto(numeroConto,((Azienda)utente));

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public IAmministratore creaAmministratore(String mail, String password) {
		
		try (Statement stmt = conn.createStatement()) {
			
			String query="insert into amministratore(mail,password_a) values (?,?) ";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,password);
				
			ps.executeQuery();
			
			return new Amministratore(email,password);
		}	

		 catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


}
