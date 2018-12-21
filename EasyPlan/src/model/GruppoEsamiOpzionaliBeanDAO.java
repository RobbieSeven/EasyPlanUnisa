package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
