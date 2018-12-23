package model;

public class OffertaFormativa {

	//VARIABILI D'ISTANZA
	private String annoOffertaFormativa;
	
	//COSTRUTTORI
	public OffertaFormativa() {};

	public OffertaFormativa(String annoOffertaFormativa) {
		this.annoOffertaFormativa = annoOffertaFormativa;
	}
	
	//GETTER E SETTER
	public String getAnnoOffertaFormativa() {
		return annoOffertaFormativa;
	}

	public void setAnnoOffertaFormativa(String annoOffertaFormativa) {
		this.annoOffertaFormativa = annoOffertaFormativa;
	}

	//METODI OBJECT
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
		OffertaFormativa other = (OffertaFormativa) obj;
		if (annoOffertaFormativa == null) {
			if (other.annoOffertaFormativa != null)
				return false;
		} else if (!annoOffertaFormativa.equals(other.annoOffertaFormativa))
			return false;
		return true;
	}
	
}
