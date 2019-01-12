package model.offerta.formativa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;

public class OffertaFormativaBeanDao {

  /**
   * Metodo per inserire un offerta formativa nel db.
   * @param of offerta formativa
   * @return un intero per controllare se l'inserimento è avvenuto
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized int doSave(OffertaFormativaBean of) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;

      query = "INSERT INTO offertaformativa(AnnoOffertaFormativa, visibilita) values (?, ?)";
      ps = conn.prepareStatement(query);

      ps.setString(1, of.getAnnoOffertaFormativa());
      ps.setBoolean(2, false);

      int i = ps.executeUpdate();
      if (i != 0) {
        return 1;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return 0;
  }

  /**
   * Metodo per inserire/aggiornare un offerta formativa nel db.
   * @param of offerta formativa
   * @return un boolean per controllare se l'inserimento/aggiornamento è avvenuto
   * @throws IOException eccezione lanciata su I/O
   */
  @SuppressWarnings("unused")
  public synchronized boolean doSaveOrUpdate(OffertaFormativaBean of) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;
      ResultSet result = null;

      query = "UPDATE offertaformativa SET visibilita=? WHERE AnnoOffertaFormativa=?";
      ps = conn.prepareStatement(query);

      ps.setBoolean(1, of.isVisibilita());
      ps.setString(2, of.getAnnoOffertaFormativa());

      int i = ps.executeUpdate();
      if (i != 0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   * Metodo che restituisce un offerta formativa tramite la sua chiave.
   * @param offertaformativa chiave dell'offerta formativa
   * @return offertaformativa
   */
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

      while (items.next()) {
        of.setAnnoOffertaFormativa(offertaformativa);
        of.setVisibilita(items.getBoolean("visibilita"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return of;
  }

  /**
   * Metodo per cancellare un offerta formativa.
   * @param offertaformativa chiave dell'offerta fromativa
   * @return un boolean per controllare se l'operazione ha avuto successo
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized boolean doDelete(String offertaformativa) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "DELETE FROM offertaformativa WHERE AnnoOffertaFormativa=?";

      ps = conn.prepareStatement(query);
      ps.setString(1, offertaformativa);

      int i = ps.executeUpdate();
      if (i != 0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   * Metodo che restituisce tutte le offerte formative.
   * @return lista di offerte formative
   * @throws ClassNotFoundException eccezione lanciata se la classe è diversa
   * @throws SQLException eccezione lanciata su I/O
   */
  public synchronized ArrayList<OffertaFormativaBean> doRetriveByAll() 
      throws ClassNotFoundException, SQLException {
    ArrayList<OffertaFormativaBean> lista = new ArrayList<OffertaFormativaBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "SELECT * FROM offertaformativa";

      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        OffertaFormativaBean of = new OffertaFormativaBean();
        of.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));
        of.setVisibilita(items.getBoolean("visibilita"));
        lista.add(of);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }
}
