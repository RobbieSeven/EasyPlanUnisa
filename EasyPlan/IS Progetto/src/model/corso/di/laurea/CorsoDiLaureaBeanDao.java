package model.corso.di.laurea;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;

public class CorsoDiLaureaBeanDao {

  /**
   * Metodo per salvare nel database.
   * 
   * @param cb id del curricula
   * @return ritorna un intero per la conferma di avvenuta registrazione.
   * @throws IOException eccezione lanciata se già esiste l'elemento
   */
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
      ps.setInt(2, cb.isTipo());
      ps.setString(3, cb.getAnnoOffertaFormativa());

      int i = ps.executeUpdate();
      if (i != 0) {
        return cb.getIdCorsoDiLaurea();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * Metodo per salvare o aggiornare.
   * 
   * @param cb id del corso di laurea
   * @return un valore booleano per la conferma dell'operazione o del suo
   *         fallimento
   * @throws IOException eccezione lanciata se un problema con il salvataggio
   *                     dell'elemento
   */
  @SuppressWarnings("null")
  public synchronized boolean doSaveOrUpdate(CorsoDiLaureaBean cb) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;
      ResultSet result = ps.executeQuery(
          "SELECT IDCorsoDiLaurea FROM corsodilaurea WHERE IDCorsoDiLaurea='" 
          + cb.getIdCorsoDiLaurea() + "'");

      if (result.next()) {
        query = "UPDATE corsodilaurea SET Tipo=?, AnnoOffertaFormativa=? WHERE IDCorsoDiLaurea=?";
        ps = conn.prepareStatement(query);

        ps.setInt(1, cb.isTipo());
        ps.setString(2, cb.getAnnoOffertaFormativa());
        ps.setInt(3, cb.getIdCorsoDiLaurea());

        int i = ps.executeUpdate();
        if (i != 0) {
          return true;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   * Metodo che ritorna un corso di laurea dato il suo id.
   * @param idCorsoDiLaurea id del corso di laurea
   * @return un corso di laurea
   */
  public synchronized CorsoDiLaureaBean doRetrieveByKey(int idCorsoDiLaurea) {
    CorsoDiLaureaBean cb = new CorsoDiLaureaBean();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "SELECT * FROM corsodilaurea WHERE IDCorsoDiLaurea=?";
      ps = conn.prepareStatement(query);
      ps.setInt(1, idCorsoDiLaurea);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        cb.setIdCorsoDiLaurea(idCorsoDiLaurea);
        cb.setTipo(items.getInt("Tipo"));
        cb.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cb;
  }

  /**
   * Metodo che ritorna tutti i corsi di laurea.
   * @return una lista di corsi di laurea
   * @throws ClassNotFoundException se la classe non corrisponde lancia l'eccezione
   * @throws SQLException se c'e' un errore di query viene lanciata questa eccezione
   */
  public synchronized ArrayList<CorsoDiLaureaBean> doRetriveAll() 
      throws ClassNotFoundException, SQLException {
    ArrayList<CorsoDiLaureaBean> lista = new ArrayList<CorsoDiLaureaBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "SELECT * FROM corsodilaurea";

      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        CorsoDiLaureaBean cb = new CorsoDiLaureaBean();
        cb.setIdCorsoDiLaurea(items.getInt("IDCorsoDiLaurea"));
        cb.setTipo(items.getInt("Tipo"));
        cb.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));

        lista.add(cb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo per cancellare un corso di laurea.
   * 
   * @param idCorsoDiLaurea id del corso di laurea.
   * @return un valore boleano per la conferma dell'operazione.
   * @throws IOException eccezione lanciata se un problema con la cancellazione
   *                     dell'elemento
   */
  public synchronized boolean doDelete(int idCorsoDiLaurea) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "DELETE FROM corsodilaurea WHERE IDCorsoDiLaurea=?";

      ps = conn.prepareStatement(query);
      ps.setInt(1, idCorsoDiLaurea);

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
   * Metodo per ottenere i corsi di laurea.
   * 
   * @param nomeOfferta il nome dell'offerta formativa da cui prendere i corsi di
   *                    laurea
   * @return lista di corsi di laurea
   */
  public ArrayList<CorsoDiLaureaBean> getCorsiLaureaOfferta(String nomeOfferta) {
    ArrayList<CorsoDiLaureaBean> lista = new ArrayList<CorsoDiLaureaBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "select c.Tipo, c.IDCorsoDiLaurea, c.AnnoOffertaFormativa"
          + " from corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa "
          + "= c.AnnoOffertaFormativa\n" + " where o.AnnoOffertaFormativa = ?";

      ps = conn.prepareStatement(query);
      ps.setString(1, nomeOfferta);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        CorsoDiLaureaBean cb = new CorsoDiLaureaBean();
        cb.setIdCorsoDiLaurea(items.getInt("IDCorsoDiLaurea"));
        cb.setTipo(items.getInt("Tipo"));
        cb.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));

        lista.add(cb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo che ritorna l'ultimo id dei corsi di laurea.
   * @return id dell'ultimo corso di laurea.
   */
  public synchronized int doRetrieveLastId() {
    Connection conn = null;
    PreparedStatement ps = null;
    int codiceDocente = 0;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "SELECT max(IDCorsoDiLaurea) AS massimoID FROM corsodilaurea";
      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();

      items.next();
      codiceDocente = items.getInt("massimoID");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return codiceDocente;
  }

  /**
   * Metodo che ritorna i corsi di laurea di una determinata offerta.
   * @param anno codice dell'offerta formativa
   * @return una lista di crsi di laurea
   */
  public synchronized ArrayList<CorsoDiLaureaBean> doRetriveCorsoDiLaureaInOfferta(String anno) {
    ArrayList<CorsoDiLaureaBean> lista = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "select c.IDCorsoDiLaurea, c.Tipo, c.AnnoOffertaFormativa"
          + " from corsodilaurea as c join offertaformativa as o "
          + " on c.AnnoOffertaFormativa = o.AnnoOffertaFormativa " 
          + " where o.AnnoOffertaFormativa = ?";
      ps = conn.prepareStatement(query);

      ps.setString(1, anno);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        CorsoDiLaureaBean laurea = new CorsoDiLaureaBean();
        laurea.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));
        laurea.setCurricula(null);
        laurea.setIdCorsoDiLaurea(items.getInt("IDCorsoDiLaurea"));
        laurea.setTipo(items.getInt("Tipo"));

        lista.add(laurea);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }
}
