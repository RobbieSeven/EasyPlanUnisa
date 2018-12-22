package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GruppoEsamiOpzionaliBeanDAO {
	
	public synchronized int doSave(GruppoEsamiOpzionaliBean gb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManagerConnectionPool.getConnection();
			
			String query = null;
			
			query = "INSERT INTO gruppoesamiopzionali(CodiceGEOp, Anno, TotCFU, IDCurriculum) "
					   + "values (?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, gb.getCodiceGEOp());
			ps.setInt(2, gb.getAnno());
			ps.setInt(3, gb.getTotCFU());
			ps.setInt(4, gb.getIdCurriculum());
						
			int i = ps.executeUpdate();
			if(i != 0) {
				return gb.getIdCurriculum();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public synchronized boolean doSaveOrUpdate(GruppoEsamiOpzionaliBean gb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;
	
		try {
			conn = DriverManagerConnectionPool.getConnection();
		
			String query = null;
			ResultSet result= ps.executeQuery("SELECT CodiceGEOp FROM gruppoesamiopzionali WHERE CodiceGEOp='"+gb.getCodiceGEOp()+"'");

			if(result.next()) {
				query="UPDATE gruppoesamiopzionali SET Anno=?, TotCFU=?, IDCurriculum=? WHERE CodiceGEOp=?";
				ps = conn.prepareStatement(query);
			
				ps.setInt(1, gb.getAnno());
				ps.setInt(2, gb.getTotCFU());
				ps.setInt(3,gb.getIdCurriculum());
				ps.setInt(4, gb.getCodiceGEOp());
			
				int i = ps.executeUpdate();
				if(i != 0)
					return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public synchronized GruppoEsamiOpzionaliBean doRetrieveByKey(int codiceGEOp) {
		GruppoEsamiOpzionaliBean gb = new GruppoEsamiOpzionaliBean();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {	
			conn = DriverManagerConnectionPool.getConnection(); 
	
			String query = "SELECT * FROM gruppoesamiopzionali WHERE CodiceGEOp= ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, codiceGEOp);

			ResultSet items = ps.executeQuery();

			while(items.next()) {
				gb.setCodiceGEOp(codiceGEOp);
				gb.setAnno(items.getInt("Anno"));
				gb.setIdCurriculum(items.getInt("IDCurriculum"));
				gb.setTotCFU(items.getInt("TotCFU"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return gb;
	}
	
	public synchronized ArrayList<GruppoEsamiOpzionaliBean> doRetriveAll() throws ClassNotFoundException, SQLException {
		ArrayList<GruppoEsamiOpzionaliBean> lista = new ArrayList<GruppoEsamiOpzionaliBean>();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {	
			conn = DriverManagerConnectionPool.getConnection(); 
			String query = "SELECT * FROM gruppoesamiopzionali";

			ps = conn.prepareStatement(query);
			
			ResultSet items = ps.executeQuery();

			while(items.next()) {
				GruppoEsamiOpzionaliBean gb= new GruppoEsamiOpzionaliBean();
				gb.setAnno(items.getInt("Anno"));
				gb.setCodiceGEOp(items.getInt("CodiceGEOp"));
				gb.setIdCurriculum(items.getInt("IDCurriculum"));
				gb.setTotCFU(items.getInt("TotCFU"));
				
				lista.add(gb);
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public synchronized boolean doDelete(int codiceGEOp) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;
			
		try {	
			conn = DriverManagerConnectionPool.getConnection(); 
				
			String query = "DELETE FROM gruppoesamiopzionali WHERE CodiceGEOp=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, codiceGEOp);
				
			int i = ps.executeUpdate();
			if(i != 0) 
				return true;			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
