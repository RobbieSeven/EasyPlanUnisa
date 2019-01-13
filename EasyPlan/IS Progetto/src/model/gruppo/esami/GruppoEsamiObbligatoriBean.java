package model.gruppo.esami;

import java.util.ArrayList;

import model.esame.EsameBean;

public class GruppoEsamiObbligatoriBean {

  // VARIABILI D'ISTANZA
  private int codiceGeOb;
  private int anno;
  private int idCurriculum;
  private ArrayList<EsameBean> esami;

  // COSTRUTTORI
  public GruppoEsamiObbligatoriBean() {}

  /**
   * Metodo costruttore con parametri.
   * @param codiceGeOb codice del gruppo obbligatorio
   * @param anno anno del gruppo
   * @param idCurriculum id del curricula a cui appartiene
   * @param esami lista di esami sel gruppo
   */
  public GruppoEsamiObbligatoriBean(int codiceGeOb, int anno, int idCurriculum,
      ArrayList<EsameBean> esami) {
    this.codiceGeOb = codiceGeOb;
    this.anno = anno;
    this.idCurriculum = idCurriculum;
    this.esami = esami;
  }

  // GETTER E SETTER
  public int getCodiceGeOb() {
    return codiceGeOb;
  }

  public void setCodiceGeOb(int codiceGeOb) {
    this.codiceGeOb = codiceGeOb;
  }

  public int getAnno() {
    return anno;
  }

  public void setAnno(int anno) {
    this.anno = anno;
  }

  public int getIdCurriculum() {
    return idCurriculum;
  }

  public void setIdCurriculum(int idCurriculum) {
    this.idCurriculum = idCurriculum;
  }

  public ArrayList<EsameBean> getEsami() {
    return esami;
  }

  public void setEsami(ArrayList<EsameBean> esami) {
    this.esami = esami;
  }

  // METODI OBJECT
  @Override
  public String toString() {
    return "GruppoEsamiObbligatoriBean [codiceGEOb=" + codiceGeOb + ", anno=" + anno 
        + ", idCurriculum=" + idCurriculum
        + "]";
  }
}
