package model;

import java.util.ArrayList;

public class OffertaFormativaBean {

	// VARIABILI D'ISTANZA
	private String annoOffertaFormativa;
	private ArrayList<CorsoDiLaureaBean> lauree;
	private boolean visibilita;

	// COSTRUTTORI
	public OffertaFormativaBean() {
	};

	public OffertaFormativaBean(String annoOffertaFormativa, ArrayList<CorsoDiLaureaBean> lauree, boolean visibilita) {
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
		return true;
	}

}