package ActorsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import IActorsDao.IContoDAO;
import IActorsDao.IMovimentoDAO;

public class ContoDAO implements IContoDAO{

	@Override
	public Collection<IMovimentoDAO> getMovimenti(int numeroConto) {
	ResultSet rs = null;
		
		try(Statement stmt =  conn.createStatement()) {
			
			String query="SELECT * FROM movimenti WHERE NUMERO_CONTO_MOVIMENTO=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1,numeroConto);
			
			 rs=ps.executeQuery();
			
			 Collection<IMovimentoDAO> listaMovimento = new ArrayList<>();

			 while(rs.next()) {
					listaMovimento.add(new MovimentoDAO());
					}
		conn.close();
		return listaMovimento;
		}
		catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return null;
	}

	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
