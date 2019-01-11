package model;

import java.util.ArrayList;

public class CorsoDiLaureaBean {

  // VARIABILI DI ISTANZA
  private int idCorsoDiLaurea;
  private int tipo;
  private String annoOffertaFormativa;
  private ArrayList<CurriculumBean> curricula;

  // COSTRUTTORI
  public CorsoDiLaureaBean() {
  }

  /**
   * Metodo costruttore con parametri.
   * @param idCorsoDiLaurea id del corso di laurea
   * @param tipo tipo della laurea
   * @param annoOffertaFormativa anno dell'offerta formativa
   * @param curricula lista di curricula
   */
  public CorsoDiLaureaBean(int idCorsoDiLaurea, int tipo, String annoOffertaFormativa,
      ArrayList<CurriculumBean> curricula) {
    this.idCorsoDiLaurea = idCorsoDiLaurea;
    this.tipo = tipo;
    this.annoOffertaFormativa = annoOffertaFormativa;
    this.curricula = curricula;
  }

  // GETTER E SETTER
  public int getIdCorsoDiLaurea() {
    return idCorsoDiLaurea;
  }

  public void setIdCorsoDiLaurea(int idCorsoDiLaurea) {
    this.idCorsoDiLaurea = idCorsoDiLaurea;
  }

  public int isTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

  public String getAnnoOffertaFormativa() {
    return annoOffertaFormativa;
  }

  public void setAnnoOffertaFormativa(String annoOffertaFormativa) {
    this.annoOffertaFormativa = annoOffertaFormativa;
  }

  public ArrayList<CurriculumBean> getCurricula() {
    return curricula;
  }

  public void setCurricula(ArrayList<CurriculumBean> curricula) {
    this.curricula = curricula;
  }

  // METODI OBJECT
  @Override
  public String toString() {
    return "CorsoDiLaurea [idCorsoDiLaurea=" + idCorsoDiLaurea + ", "
        + "tipo=" + tipo + ", annoOffertaFormativa="
          + annoOffertaFormativa + "]";
  }
}
