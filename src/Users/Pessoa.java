package Users;

import java.util.Date;

public abstract class Pessoa {

	private String nome, email, telefone;
	private Date data;
	
	public Pessoa(String nome, String email, String telefone, Date data) {
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.data = data;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
