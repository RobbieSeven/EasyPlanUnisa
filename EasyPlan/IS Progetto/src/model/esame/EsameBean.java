package model.esame;

import java.util.ArrayList;

import model.docente.DocenteBean;

public class EsameBean {

  // VARIABILI D'ISTANZA
  private int codiceEsame;
  private String nome;
  private int cfu;
  private String descrizione;
  private int oreLezione;
  private String semestre;
  private ArrayList<DocenteBean> docenti = new ArrayList<DocenteBean>();
  private boolean check = false;

  // COSTRUTTORI
  public EsameBean() {}

  /**
   * Metodo costruttore con parametri.
   * @param codiceEsame codice dell'esame
   * @param nome nome dell'esame
   * @param cfu cfu dell'esame
   * @param descrizione descrizione dell'esame
   * @param oreLezione ore di lezioni dell'esame
   * @param semestre semestre in cui si trova l'esame
   */
  public EsameBean(int codiceEsame, String nome, int cfu, 
      String descrizione, int oreLezione, String semestre) {
    this.codiceEsame = codiceEsame;
    this.nome = nome;
    this.cfu = cfu;
    this.descrizione = descrizione;
    this.oreLezione = oreLezione;
    this.semestre = semestre;
  }

  // GETTER E SETTER
  public int getCodiceEsame() {
    return codiceEsame;
  }

  public void setCodiceEsame(int codiceEsame) {
    this.codiceEsame = codiceEsame;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCfu() {
    return cfu;
  }

  public void setCfu(int cfu) {
    this.cfu = cfu;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public int getOreLezione() {
    return oreLezione;
  }

  public void setOreLezione(int oreLezione) {
    this.oreLezione = oreLezione;
  }

  public String getSemestre() {
    return semestre;
  }

  public void setSemestre(String semestre) {
    this.semestre = semestre;
  }

  public ArrayList<DocenteBean> getDocenti() {
    return docenti;
  }

  public void setDocenti(ArrayList<DocenteBean> docenti) {
    this.docenti = docenti;
  }

  public boolean isCheck() {
    return check;
  }

  public void setCheck(boolean check) {
    this.check = check;
  }

  // METODI OBJECT
  @Override
  public String toString() {
    return "EsameBean [codiceEsame=" + codiceEsame + ", nome=" + nome 
        + ", CFU=" + cfu + ", descrizione=" + descrizione
        + ", ore_lezione=" + oreLezione + ", semestre=" + semestre + "]";
  }
}
