package model; 

public class DocenteBean {

	//VARIABILI DI ISTANZA
	private int codiceDocente;
	private String nome;
	private String cognome;
	private String indirizzoPaginaWeb;
	
	//COSTRUTTORI
	public DocenteBean() {
	}

	public DocenteBean(int codiceDocente, String nome, String cognome, String indirizzoPaginaWeb) {
		super();
		this.codiceDocente = codiceDocente;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzoPaginaWeb = indirizzoPaginaWeb;
	}
	
	//GETTER E SETTER
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
	
	//METODI OBJECT
	@Override
	public String toString() {
		return "DocenteBean [codiceDocente=" + codiceDocente + ", nome=" + nome + ", cognome=" + cognome
				+ ", indirizzoPaginaWeb=" + indirizzoPaginaWeb + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codiceDocente;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((indirizzoPaginaWeb == null) ? 0 : indirizzoPaginaWeb.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		DocenteBean other = (DocenteBean) obj;
		if (codiceDocente != other.codiceDocente)
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (indirizzoPaginaWeb == null) {
			if (other.indirizzoPaginaWeb != null)
				return false;
		} else if (!indirizzoPaginaWeb.equals(other.indirizzoPaginaWeb))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}
