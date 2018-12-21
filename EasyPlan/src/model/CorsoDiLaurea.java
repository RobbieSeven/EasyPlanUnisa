package model;

public class CorsoDiLaurea {

	//VARIABILI DI ISTANZA
	private String idCorsoDiLaurea;
	private boolean tipo;
	private String annoOffertaFormativa;
	
	//COSTRUTTORI
	public CorsoDiLaurea() {
		
	}

	public CorsoDiLaurea(String idCorsoDiLaurea, boolean tipo, String annoOffertaFormativa) {
		super();
		this.idCorsoDiLaurea = idCorsoDiLaurea;
		this.tipo = tipo;
		this.annoOffertaFormativa = annoOffertaFormativa;
	}

	//GETTER E SETTER
	public String getIdCorsoDiLaurea() {
		return idCorsoDiLaurea;
	}

	public void setIdCorsoDiLaurea(String idCorsoDiLaurea) {
		this.idCorsoDiLaurea = idCorsoDiLaurea;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public String getAnnoOffertaFormativa() {
		return annoOffertaFormativa;
	}

	public void setAnnoOffertaFormativa(String annoOffertaFormativa) {
		this.annoOffertaFormativa = annoOffertaFormativa;
	}
	
	//METODI OBJECT
	@Override
	public String toString() {
		return "CorsoDiLaurea [idCorsoDiLaurea=" + idCorsoDiLaurea + ", tipo=" + tipo + ", annoOffertaFormativa="
				+ annoOffertaFormativa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoOffertaFormativa == null) ? 0 : annoOffertaFormativa.hashCode());
		result = prime * result + ((idCorsoDiLaurea == null) ? 0 : idCorsoDiLaurea.hashCode());
		result = prime * result + (tipo ? 1231 : 1237);
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
		CorsoDiLaurea other = (CorsoDiLaurea) obj;
		if (annoOffertaFormativa == null) {
			if (other.annoOffertaFormativa != null)
				return false;
		} else if (!annoOffertaFormativa.equals(other.annoOffertaFormativa))
			return false;
		if (idCorsoDiLaurea == null) {
			if (other.idCorsoDiLaurea != null)
				return false;
		} else if (!idCorsoDiLaurea.equals(other.idCorsoDiLaurea))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
