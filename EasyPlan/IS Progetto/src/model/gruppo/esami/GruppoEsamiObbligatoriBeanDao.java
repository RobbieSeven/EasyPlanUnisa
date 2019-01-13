package model.gruppo.esami;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import model.esame.EsameBeanDao;

public class GruppoEsamiObbligatoriBeanDao {

  /**
   * Metodo per salvare un gruppo di esami obbligatori.
   * @param gb gruppo obbligatorio
   * @return intero per controllare che il salvataggio è andato a buon fine
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized int doSave(GruppoEsamiObbligatoriBean gb) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;

      query = "INSERT INTO gruppoesamiobbligatori(CodiceGEOb,Anno,Curriculum) values (?, ?, ?)";
      ps = conn.prepareStatement(query);

      ps.setInt(1, gb.getCodiceGeOb());
      ps.setInt(2, gb.getAnno());
      ps.setInt(3, gb.getIdCurriculum());

      int i = ps.executeUpdate();

      if (i != 0) {
        return gb.getIdCurriculum();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * Metodo per salvare un gruppo di esami obbligatori.
   * @param gb gruppo obbligatorio
   * @return boolean per controllare che il salvataggio è andato a buon fine
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized boolean doSaveOrUpdate(GruppoEsamiObbligatoriBean gb) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;

      query = "UPDATE gruppoesamiobbligatori SET Anno=?,Curriculum=? WHERE CodiceGEOb=?";
      ps = conn.prepareStatement(query);

      ps.setInt(1, gb.getAnno());
      ps.setInt(2, gb.getIdCurriculum());
      ps.setInt(3, gb.getCodiceGeOb());

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
   * Metodo che ritorna un gruppo obbligatorio data la sua chiave.
   * @param codiceGeOb codice del gruppo
   * @return gruppo obbligatorio
   */
  public synchronized GruppoEsamiObbligatoriBean doRetrieveByKey(int codiceGeOb) {
    GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "SELECT * FROM gruppoesamiobbligatori WHERE CodiceGEOb= ?";
      ps = conn.prepareStatement(query);
      ps.setInt(1, codiceGeOb);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        gb.setCodiceGeOb(codiceGeOb);
        gb.setAnno(items.getInt("Anno"));
        gb.setIdCurriculum(items.getInt("Curriculum"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return gb;
  }

  /**
   * Metodo che restituisce tutti i gruppi obbligatori.
   * @return lista di gruppi obbligatori
   * @throws ClassNotFoundException eccezione lanciata se la classe non corrisponde
   * @throws SQLException eccezione lanciata se c'è un problema sql
   */
  public synchronized ArrayList<GruppoEsamiObbligatoriBean> doRetriveAll() 
      throws ClassNotFoundException, SQLException {
    ArrayList<GruppoEsamiObbligatoriBean> lista = new ArrayList<GruppoEsamiObbligatoriBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "SELECT * FROM gruppoesamiobbligatori";

      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
        gb.setAnno(items.getInt("Anno"));
        gb.setCodiceGeOb(items.getInt("CodiceGEOb"));
        gb.setIdCurriculum(items.getInt("Curriculum"));
        lista.add(gb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo che cancella un gruppo obbligatorio.
   * @param codiceGeOb codice del gruppo
   * @return ritorna un booleano per controllare l'avvenuta cancellazione
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized boolean doDelete(int codiceGeOb) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "DELETE FROM gruppoesamiobbligatori WHERE CodiceGEOb=?";

      ps = conn.prepareStatement(query);
      ps.setInt(1, codiceGeOb);

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
   * Metodo che restituisce i gruppi obbligatori di un offerta formativa.
   * @param anno anno dell'offerta formativa
   * @param laurea codice della laurea
   * @param curricula nome del curricula
   * @return lista di gruppi obbligatori
   * @throws ClassNotFoundException lancia l'eccezione se la classe non corrisponde
   * @throws SQLException lancia l'eccezione se c'e' un problema sql
   */
  public synchronized ArrayList<GruppoEsamiObbligatoriBean> doRetriveGruppoEsamiObbByOfferta(
      String anno, int laurea,
      String curricula) throws ClassNotFoundException, SQLException {
    
    ArrayList<GruppoEsamiObbligatoriBean> lista = new ArrayList<GruppoEsamiObbligatoriBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "select go.CodiceGEOb, go.Anno, go.Curriculum"
          + " from ((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa"
          + " = c.AnnoOffertaFormativa ) join curriculum as cu \n"
          + " on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiobbligatori as "
          + "go on cu.IDCurriculum = go.Curriculum\n"
          + " where o.AnnoOffertaFormativa = ? && c.tipo = ? && cu.Nome = ?";

      ps = conn.prepareStatement(query);
      ps.setString(1, anno);
      ps.setInt(2, laurea);
      ps.setString(3, curricula);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
        gb.setAnno(items.getInt("Anno"));
        gb.setCodiceGeOb(items.getInt("CodiceGEOb"));
        gb.setIdCurriculum(items.getInt("Curriculum"));
        lista.add(gb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo che restituisce i gruppi obbligatori di un offerta formativa 
   *        di un determinato anno del curriculum.
   * @param anno anno dell'offerta formativa
   * @param laurea codice della laurea
   * @param curricula nome del curricula
   * @return lista di gruppi obbligatori
   * @throws ClassNotFoundException lancia l'eccezione se la classe non corrisponde
   * @throws SQLException lancia l'eccezione se c'e' un problema sql
   */
  public synchronized ArrayList<GruppoEsamiObbligatoriBean> doRetriveGruppoEsamiObbByOffertaAndAnno(
      String offertaForm,
      int laurea, String curricula, int anno) throws ClassNotFoundException, SQLException {
    
    ArrayList<GruppoEsamiObbligatoriBean> lista = new ArrayList<GruppoEsamiObbligatoriBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "select go.CodiceGEOb, go.Anno, go.Curriculum"
          + " from ((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa "
          + "= c.AnnoOffertaFormativa ) join curriculum as cu \n"
          + " on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiobbligatori "
          + "as go on cu.IDCurriculum = go.Curriculum\n"
          + " where o.AnnoOffertaFormativa = ? && c.tipo = ? && cu.Nome = ? && go.anno = ?";

      ps = conn.prepareStatement(query);
      ps.setString(1, offertaForm);
      ps.setInt(2, laurea);
      ps.setString(3, curricula);
      ps.setInt(4, anno);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
        gb.setAnno(items.getInt("Anno"));
        gb.setCodiceGeOb(items.getInt("CodiceGEOb"));
        gb.setIdCurriculum(items.getInt("Curriculum"));
        lista.add(gb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo che inserisce un esame all'interno di un gruppo.
   * @param codiceGruppo codice del gruppo
   * @param codiceEsame codice dell'esame
   * @return intero per il successo dell'operazione
   * @throws IOException eccezione  lancia su I/O
   */ 
  public synchronized int insertEsameInGruppo(int codiceGruppo, int codiceEsame)
      throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;

      query = "INSERT INTO formazione(CodiceGEOb,CodiceEsame) values (?,?)";
      ps = conn.prepareStatement(query);

      ps.setInt(1, codiceGruppo);
      ps.setInt(2, codiceEsame);

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
   * Metodo che cancella un esame da un gruppo e se non prensete in altri gruppi lo cancella dal db.
   * @param codiceGruppo codice del gruppo
   * @param codiceEsame codice dell'esame
   * @return intero per il successo dell'operazione
   * @throws IOException IOException eccezione  lancia su I/O
   */
  public synchronized int deleteEsameInGruppo(int codiceGruppo, int codiceEsame)
      throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;

      query = "DELETE FROM formazione WHERE CodiceGEOb = ? && CodiceEsame = ? ";
      ps = conn.prepareStatement(query);

      ps.setInt(1, codiceGruppo);
      ps.setInt(2, codiceEsame);

      int i = ps.executeUpdate();

      if (i != 0) {
        // controllo se � presente in formato
        query = "select count(*) as numeroDiOccorrenze"
            + " from esame as e join formato as f on e.CodiceEsame  = f.CodiceEsame" 
            + " where e.CodiceEsame = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, codiceEsame);

        int numeroDiOccorrenzeInGruppiObbligatori = 1;
        int numeroDiOccorrenzeInGruppiOpzionali = 1;

        ResultSet item = ps.executeQuery();
        while (item.next()) {
          numeroDiOccorrenzeInGruppiObbligatori = item.getInt("numeroDiOccorrenze");
          System.out.println(numeroDiOccorrenzeInGruppiObbligatori);
        }
        // controllo se � presente in formazione
        query = "select count(*) as numeroDiOccorrenze"
            + " from esame as e join formazione as f on e.CodiceEsame  = f.CodiceEsame" 
            + " where e.CodiceEsame = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, codiceEsame);

        item = ps.executeQuery();
        while (item.next()) {
          numeroDiOccorrenzeInGruppiOpzionali = item.getInt("numeroDiOccorrenze");
        }

        // se non � presente in nessun gruppo lo cancello dal database
        if (numeroDiOccorrenzeInGruppiObbligatori == 0 
            && numeroDiOccorrenzeInGruppiOpzionali == 0) {
          EsameBeanDao dao = new EsameBeanDao();
          dao.doDelete(codiceEsame);
        }

        return 1;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * Metodo che elimina un esame da un gruppo.
   * @param codiceGruppo codice del gruppo
   * @param codiceEsame codice dell'esame
   * @return intero per il successo dell'operazione
   * @throws IOException IOException eccezione  lancia su I/O
   */
  public synchronized int deleteEsame(int codiceGruppo, int codiceEsame) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;

      query = "DELETE FROM formazione WHERE CodiceGEOb = ? && CodiceEsame = ? ";
      ps = conn.prepareStatement(query);

      ps.setInt(1, codiceGruppo);
      ps.setInt(2, codiceEsame);

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
   * Metodo che ritorna l'ultimo id dei gruppi obbligatori.
   * @return ultimo id
   */
  public synchronized int doRetrieveLastId() {
    Connection conn = null;
    PreparedStatement ps = null;
    int codiceDocente = 0;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "SELECT max(CodiceGEOb) AS massimoID FROM gruppoesamiobbligatori";
      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();

      items.next();
      codiceDocente = items.getInt("massimoID");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return codiceDocente;
  }
}
