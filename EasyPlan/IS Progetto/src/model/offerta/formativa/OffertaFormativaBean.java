package model.offerta.formativa;

import java.util.ArrayList;

import model.corso.di.laurea.CorsoDiLaureaBean;

public class OffertaFormativaBean {

  // VARIABILI D'ISTANZA
  private String annoOffertaFormativa;
  private ArrayList<CorsoDiLaureaBean> lauree;
  private boolean visibilita;

  // COSTRUTTORI
  public OffertaFormativaBean() {}

  /**
   * Metodo costruttore con parametri.
   * @param annoOffertaFormativa anno dell'offerta formativa
   * @param lauree lista di lauree
   * @param visibilita visibilità per il lato utente
   */
  public OffertaFormativaBean(String annoOffertaFormativa, ArrayList<CorsoDiLaureaBean> lauree, 
      boolean visibilita) {
    this.annoOffertaFormativa = annoOffertaFormativa;
    this.lauree = lauree;
    this.visibilita = visibilita;
  }

  // GETTER E SETTER
  public String getAnnoOffertaFormativa() {
    return annoOffertaFormativa;
  }

  public void setAnnoOffertaFormativa(String annoOffertaFormativa) {
    this.annoOffertaFormativa = annoOffertaFormativa;
  }

  public ArrayList<CorsoDiLaureaBean> getLauree() {
    return lauree;
  }

  public void setLauree(ArrayList<CorsoDiLaureaBean> lauree) {
    this.lauree = lauree;
  }

  public void setVisibilita(boolean visibilita) {
    this.visibilita = visibilita;
  }

  public boolean isVisibilita() {
    return visibilita;
  }

  // METODI OBJECT
  @Override
  public String toString() {
    return "OffertaFormativa [annoOffertaFormativa=" + annoOffertaFormativa + "]";
  }
}