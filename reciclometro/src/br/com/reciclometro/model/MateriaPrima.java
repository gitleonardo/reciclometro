package br.com.reciclometro.model;

public class MateriaPrima {

	private String formulacao;

	public String getFormulacao() {
		return formulacao;
	}

	public void setFormulacao(String formulacao) {
		this.formulacao = formulacao;
	}

	@Override
	public String toString() {
		return "MateriaPrima [formulacao=" + formulacao + "]";
	}
		
}
