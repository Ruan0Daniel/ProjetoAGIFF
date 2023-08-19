package Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario extends Pessoa {

	private String instituicaoEnsino;
	
	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public List<Usuario> getUser() {
		return user;
	}

	public void setUser(List<Usuario> user) {
		this.user = user;
	}

	public Usuario(String nome, String email, String telefone, Date data, String instituicaoEnsino,
			List<Usuario> user) {
		super(nome, email, telefone, data);
		this.instituicaoEnsino = instituicaoEnsino;
		this.user = user;
	}

	List<Usuario> user = new ArrayList<>();
	
	public boolean adicioarEditor() {
		return user.add(this);
	}
	
	public boolean cadastrarUsuario(String nome, String email, String telefone, Date dataNascimento, String instituicaoEnsino) {
		
	}
}
