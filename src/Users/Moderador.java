package Users;

import java.util.Date;

public class Moderador extends Pessoa{

	
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Moderador(String nome, String email, String telefone, Date data, String cpf) {
		super(nome, email, telefone, data);
		this.cpf = cpf;
	}

	public boolean cadastrarModerador(String nome, String email, String telefone, Date data, String cpf) {
		return true;
	
	}
}
