package Actors;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import IActors.IAmministratore;
import IActors.IConto;
import IActors.ISessione;
import IActors.IUtente;

public class Amministratore implements IAmministratore {

	private final int id;
	private String email;
	private String password;

	public Amministratore() {
		this.id = 0;
		
	}
	
	public Amministratore(String email, String password) {
		super();
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
	public boolean modificaEmail() {

		try (Statement stmt = conn.createStatement()) {

			String modificaEmail = "update amministratore set email=?";
			String dbString = email;
			PreparedStatement ps = conn.prepareStatement(modificaEmail);
			ps.setString(1, dbString);
			ps.executeQuery();

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean modificaPassword() {
		
		try (Statement stmt = conn.createStatement()) {

			String modificaPsw = "update amministratore set password_admin=?";
			String dbString = password;
			PreparedStatement ps = conn.prepareStatement(modificaPsw);
			ps.setString(1, dbString);
			ps.executeQuery();
			

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
		
	}
	
	@Override
	public IUtente creaUtente(String email, String password, Object... params) {
		
		try(Statement stmt = conn.createStatement()){
			
			String cercaUtente = "select * from cliente where email=?";
			String dbString = email;
			PreparedStatement ps = conn.prepareStatement(cercaUtente);
			ps.setString(1, dbString);
			ResultSet rs = ps.getResultSet();
			
			
			String cercaAzienda = "select * from azienda where mail=?";
			String dbString1 = email;
			PreparedStatement ps1 = conn.prepareStatement(cercaAzienda);
			ps1.setString(1, dbString1);
			ResultSet rs1 = ps1.getResultSet();
			
			ps1.executeQuery();
			ps.executeQuery();
			
			if(rs.getObject("email").equals(email) || rs1.getObject("mail").equals(email)) {
				String insertUtente = "insert into utente(email,password)values("+ email + "'" + "'" + password + ")";
				String insertAzienda = "insert into azienda(mail,password)values(" + email + "'" + "'" + password + ")";
				int cont = stmt.executeUpdate(insertUtente);
				int cont1 = stmt.executeUpdate(insertAzienda);
				if(cont>0 || cont1>0) {
					System.out.println("Utente aggiunto");
				}
			}else {
				System.out.println("Utente non trovato");
			}
			
			
			stmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean cancellaConto(int numeroConto) {
		try(Statement stmt = conn.createStatement()){
			
			String cercaConto = "select * from conto where numero_conto=?";
			String dbString = String.valueOf(numeroConto);
			PreparedStatement ps = conn.prepareStatement(cercaConto);
			ps.setString(1, dbString);
			ResultSet rs = ps.getResultSet();
			if(rs.getObject("numero_conto").equals(numeroConto)) {
				String cancellaConto = "delete from conto where numero_conto=?";
				 int cont = stmt.executeUpdate(cancellaConto);

			        if(cont > 0) {
			        	System.out.println("Cancellazione conto riuscita.");
			        }
			        
			        stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Amministratore login(String email,String password) {
		try(Statement stmt = conn.createStatement()){
			
			String login = "select * from amministratore where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(login);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Amministratore amm = null;
			if(!rs.equals(null)) {
				amm = new Amministratore();
				amm.setEmail(email);
			}
			
			return amm;

		}catch(SQLException e) {
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
	public Collection<IUtente> getElenco() {
		
		try(Statement stmt = conn.createStatement()){
			
			String elencoAzienda = "select * from azienda";
			String elencoUtente = "select * from utente";
			
			PreparedStatement ps = conn.prepareStatement(elencoAzienda);
			PreparedStatement ps1 = conn.prepareStatement(elencoUtente);

			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs.next()) {
				Azienda az = new Azienda(rs.getString("mail"),rs.getString("password"));
				Utente ut = new Utente(rs.getString("email"),rs.getString("password"));
				
				int cont = stmt.executeUpdate(elencoAzienda);
				int cont1 = stmt.executeUpdate(elencoUtente);
				
			}
			
		

		}catch(SQLException e) {
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IAmministratore creaAmministratore(String mail, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
