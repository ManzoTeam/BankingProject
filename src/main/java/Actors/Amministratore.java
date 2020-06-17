package Actors;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import IActors.IAmministratore;
import IActors.IUtente;

public abstract class Amministratore implements IAmministratore {

	private final int id;
	private String email;
	private String password;

	public Amministratore(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.id = 0;

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

	@Override
	public boolean modificaEmail() {

		try (Statement stmt = conn.createStatement()) {

			String modificaEmail = "update amministratore set email='" + email + "'";
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

			String modificaPsw = "update amministratore set password_admin='" + password + "'";
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
			
			String cercaUtente = "select * from cliente where email='"+ email + "'";
			String dbString = email;
			PreparedStatement ps = conn.prepareStatement(cercaUtente);
			ps.setString(1, dbString);
			ResultSet rs = ps.getResultSet();
			
			
			String cercaAzienda = "select * from azienda where mail='" + email +"'";
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
			
			String cercaConto = "select * from conto where numero_conto='"+numeroConto+"'";
			String dbString = String.valueOf(numeroConto);
			PreparedStatement ps = conn.prepareStatement(cercaConto);
			ps.setString(1, dbString);
			ResultSet rs = ps.getResultSet();
			if(rs.getObject("numero_conto").equals(numeroConto)) {
				String cancellaConto = "delete from conto where numero_conto="+numeroConto;
				 int cont = stmt.executeUpdate(cancellaConto);

			        if(cont > 0) {
			        	System.out.println("Cancellazione conto riuscita.");
			        }else{
			        	System.out.println("conto non trovato");
			        }
			        
			        stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
