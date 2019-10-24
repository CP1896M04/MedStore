package main.cruid.model;

public class Cliente {
	private String nome;
	private Integer idade;
	private Integer id;

	public Cliente(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Cliente %d: %s - %d anos", id, nome, idade);
	}

}
