package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OffertaFormativaBeanDAO {

	//Funzione per inserire una nuova offerta formativa
			public synchronized int doSave(OffertaFormativaBean of) throws IOException {
				Connection conn = null;
				PreparedStatement ps = null;
				
				try {
					conn = DriverManagerConnectionPool.getConnection();
					
					String query = null;
					
					query = "INSERT INTO offertaformativa(AnnoOffertaFormativa) values (?)";
					ps = conn.prepareStatement(query);
					
					ps.setString(1, of.getAnnoOffertaFormativa());
					
					int i = ps.executeUpdate();
					if(i != 0) {
						return 1;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return 0;
			}
			
		
			//Funzione per salvare e modificare un'offerta formativa
			public synchronized boolean doSaveOrUpdate(OffertaFormativaBean of) throws IOException {
		
				Connection conn = null;
				PreparedStatement ps = null;
			
				try {
					conn = DriverManagerConnectionPool.getConnection();
				
					String query = null;
					ResultSet result= ps.executeQuery("SELECT AnnoOffertaFormativa FROM offertaformativa WHERE AnnoOffertaFormativa='"+of.getAnnoOffertaFormativa()+"'");

					if(result.next()) {
						query="UPDATE offertaformativa SET AnnoOffertaFormativa=? WHERE AnnoOffertaFormativa=?";
						ps = conn.prepareStatement(query);
					
						ps.setString(1, of.getAnnoOffertaFormativa());
					
						int i = ps.executeUpdate();
						if(i != 0) {
							return true;
							}
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
					return false;
				}
		
			//Funzione per ricercare un offerta formativa data la sua chiave
			public synchronized OffertaFormativaBean doRetrieveByKey(String offertaformativa) {
				OffertaFormativaBean of = new OffertaFormativaBean();
				Connection conn = null;
				PreparedStatement ps = null;
			
				try {	
					conn = DriverManagerConnectionPool.getConnection(); 
		
					String query = "SELECT * FROM offertaformativa WHERE AnnoOffertaFormativa= ?";
					ps = conn.prepareStatement(query);
					ps.setString(1, of.getAnnoOffertaFormativa());

					ResultSet items = ps.executeQuery();

					while(items.next()) {
						of.setAnnoOffertaFormativa(offertaformativa);
						
					}
				}catch(SQLException e) {
				e.printStackTrace();
				}
				return of;
			}
		
			// Funzione per eliminare un offerta formativa data la sua chiave
			public synchronized boolean doDelete(String offertaformativa) throws IOException {
				Connection conn = null;
				PreparedStatement ps = null;
				
				try {	
					conn = DriverManagerConnectionPool.getConnection(); 
					
					String query = "DELETE FROM offertaformativa WHERE AnnoOffertaFormativa=?";

					ps = conn.prepareStatement(query);
					ps.setString(1, offertaformativa);
					
					int i = ps.executeUpdate();
					if(i != 0) 
						return true;			
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return false;
			}
			
			//Funzione per selezionare tutte le offerte formative
			public synchronized ArrayList<OffertaFormativaBean> doRetriveByAll() throws ClassNotFoundException, SQLException {

				ArrayList<OffertaFormativaBean> lista=new ArrayList<OffertaFormativaBean>();
				Connection conn = null;
				PreparedStatement ps = null;
				
				try {	
					conn = DriverManagerConnectionPool.getConnection(); 
					String query = "SELECT * FROM offertaformativa";

					ps = conn.prepareStatement(query);
					
					ResultSet items = ps.executeQuery();

					while(items.next()) {
						OffertaFormativaBean of= new OffertaFormativaBean();
						of.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));
						lista.add(of);
						}
					}catch(SQLException e) {
						e.printStackTrace();
						}
				return lista;
		}
}
