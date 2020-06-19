//package ActorsDao;
//
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//
//
//import java.sql.SQLException;
//import java.sql.Statement;
//import com.mysql.cj.xdevapi.Result;
//
//import IActorsDao.IMovimentoDAO;
//
//import java.util.Date;
//
//public class Movimento implements IMovimentoDAO {
//	
//	public Movimento(int idMovimento, double sommaDenaro, String versamentoPrelievo, java.sql.Date date, int numeroConto) {
//
//	}
//
//	@Override
//	public double getSommaMovimento(int id) {
//
//		ResultSet rs = null;
//
//		try (Statement stmt = conn.createStatement()) {
//
//			String query = "SELECT SOMMA_DENARO FROM movimenti WHERE ID_MOVIMENTO=? ";
//
//			PreparedStatement ps = conn.prepareStatement(query);
//
//			ps.setInt(1, id);
//
//			rs = ps.executeQuery();
//
//			conn.close();
//			
//			return rs.getDouble("SOMMA_DENARO");
//		} catch (SQLException ex) {
//			// handle any errors
//			System.out.println("SQLException: " + ex.getMessage());
//			System.out.println("SQLState: " + ex.getSQLState());
//			System.out.println("VendorError: " + ex.getErrorCode());
//		}
//
//		return 0.0;
//	}
//
//	@Override
//	public String getTipoMovimento(int id) {
//	ResultSet rs = null;
//			
//			try(Statement stmt =  conn.createStatement()) {
//				
//				String query="SELECT * FROM movimenti WHERE ID_MOVIMENTO=? ";
//				
//				PreparedStatement ps=conn.prepareStatement(query);
//				
//				ps.setInt(1,id);
//				
//				rs=ps.executeQuery();
//				 
//				conn.close();
//			    return rs.getString("VERSAMENTO_PRELIEVO");
//			}catch (SQLException ex){
//			// handle any errors
//				System.out.println("SQLException: " + ex.getMessage());
//				System.out.println("SQLState: " + ex.getSQLState());
//				System.out.println("VendorError: " + ex.getErrorCode());
//			}
//			
//			
//			return null;
//	}
//
//
//}
//
//
