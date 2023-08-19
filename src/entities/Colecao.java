package entities;

import java.util.Date;

import Users.Usuario;

public class Colecao {

	private String titulo;
	private Date dataCriacao;
	private Usuario usuario;
	
	public Colecao(String titulo, Date dataCriacao, Usuario usuario) {
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.setUsuario(usuario);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
public boolean cadastrarColecao(String titulo, Date dataCriacao, Usuario criador) {
		
	}
}
