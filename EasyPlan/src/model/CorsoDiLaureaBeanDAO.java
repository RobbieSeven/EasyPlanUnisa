package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorsoDiLaureaBeanDAO {
	
	public synchronized int doSave(CorsoDiLaureaBean cb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {			
			conn = DriverManagerConnectionPool.getConnection();
			
			String query = null;
			
			query = "INSERT INTO corsodilaurea(IDCorsoDiLaurea, Tipo, AnnoOffertaFormativa) "
					   + "values (?, ?, ?)";
			ps = conn.prepareStatement(query);
				
			ps.setInt(1, cb.getIdCorsoDiLaurea());
			ps.setBoolean(2, cb.isTipo());
			ps.setString(3, cb.getAnnoOffertaFormativa());
			
			int i = ps.executeUpdate();
			if(i != 0) {
				return cb.getIdCorsoDiLaurea();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public synchronized CorsoDiLaureaBean doRetrieveByKey(int IdCorsoDiLaurea) {
		CorsoDiLaureaBean cb = new CorsoDiLaureaBean();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {	
			conn = DriverManagerConnectionPool.getConnection(); 
	
			String query = "SELECT * FROM corsodilaurea WHERE IDCorsoDiLaurea=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, IdCorsoDiLaurea);

			ResultSet items = ps.executeQuery();

			while(items.next()) {
				cb.setIdCorsoDiLaurea(IdCorsoDiLaurea);
				cb.setTipo(items.getBoolean("Tipo"));
				cb.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}
	
}
