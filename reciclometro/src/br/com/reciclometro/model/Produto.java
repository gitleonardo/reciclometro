package br.com.reciclometro.model;

public class Produto extends Material {

	private Integer id;
	private String descricao;
	private Double peso;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", peso=" + peso + "]";
	}
	
}
