package model.docente;

public class DocenteBean {

  // VARIABILI DI ISTANZA
  private int codiceDocente;
  private String nome;
  private String cognome;
  private String indirizzoPaginaWeb;
  private String insegnamento;

  // COSTRUTTORI
  public DocenteBean() {
  }

  /**
   * Metodo costruttore con parametri.
   * @param codiceDocente id del docente
   * @param nome nome del docente
   * @param cognome cpgnome del docente
   * @param indirizzoPaginaWeb indirizzo della pagina web del docente
   * @param insegnamento valore per collegarlo nella tabella insegnamento del database
   */
  public DocenteBean(int codiceDocente, String nome, String cognome, String indirizzoPaginaWeb,
      String insegnamento) {
    super();
    this.codiceDocente = codiceDocente;
    this.nome = nome;
    this.cognome = cognome;
    this.indirizzoPaginaWeb = indirizzoPaginaWeb;
    this.insegnamento = insegnamento;
  }

  // GETTER E SETTER
  public int getCodiceDocente() {
    return codiceDocente;
  }

  public void setCodiceDocente(int codiceDocente) {
    this.codiceDocente = codiceDocente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getIndirizzoPaginaWeb() {
    return indirizzoPaginaWeb;
  }

  public void setIndirizzoPaginaWeb(String indirizzoPaginaWeb) {
    this.indirizzoPaginaWeb = indirizzoPaginaWeb;
  }

  public String getInsegnamento() {
    return insegnamento;
  }

  public void setInsegnamento(String insegnamento) {
    this.insegnamento = insegnamento;
  }

  @Override
  public String toString() {
    return "DocenteBean [codiceDocente=" + codiceDocente + ", nome=" + nome + ", cognome=" + cognome
        + ", indirizzoPaginaWeb=" + indirizzoPaginaWeb + ", insegnamento=" + insegnamento + "]";
  }
}
