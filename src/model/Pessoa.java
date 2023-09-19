package model;

public class Pessoa {
	private String nome, email, telefone;

	public Pessoa(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Pessoa() {

	}
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}
}
