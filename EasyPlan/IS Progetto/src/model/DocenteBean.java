package model;

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

	public DocenteBean(int codiceDocente, String nome, String cognome, String indirizzoPaginaWeb, String insegnamento) {
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

	// METODI OBJECT
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codiceDocente;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((indirizzoPaginaWeb == null) ? 0 : indirizzoPaginaWeb.hashCode());
		result = prime * result + ((insegnamento == null) ? 0 : insegnamento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "DocenteBean [codiceDocente=" + codiceDocente + ", nome=" + nome + ", cognome=" + cognome
				+ ", indirizzoPaginaWeb=" + indirizzoPaginaWeb + ", insegnamento=" + insegnamento + "]";
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
		if (insegnamento == null) {
			if (other.insegnamento != null)
				return false;
		} else if (!insegnamento.equals(other.insegnamento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
