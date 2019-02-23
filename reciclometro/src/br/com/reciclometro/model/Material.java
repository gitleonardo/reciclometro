package br.com.reciclometro.model;

public class Material extends MateriaPrima {

	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Material [tipo=" + tipo + "]";
	}
	
}
