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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((annoOffertaFormativa == null) ? 0 : annoOffertaFormativa.hashCode());
    result = prime * result + ((lauree == null) ? 0 : lauree.hashCode());
    result = prime * result + (visibilita ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OffertaFormativaBean other = (OffertaFormativaBean) obj;
    if (annoOffertaFormativa == null) {
      if (other.annoOffertaFormativa != null)
        return false;
    } else if (!annoOffertaFormativa.equals(other.annoOffertaFormativa))
      return false;
    if (lauree == null) {
      if (other.lauree != null)
        return false;
    } else if (!lauree.equals(other.lauree))
      return false;
    if (visibilita != other.visibilita)
      return false;
    return true;
  }
  
  
}