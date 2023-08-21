package entities; 

import java.sql.Date;
import Users.Moderador;
import Users.Usuario;

public class Publicacao {

	private String autor, titulo, link;
	private Date dataCriacao;
	private Moderador moderador;
	private Usuario usuario;
	private Colecao colecao;
	
	public Publicacao(String autor, String titulo, String link, Date dataCriacao, Moderador moderador, Usuario usuario, Colecao colecao) {
		this.autor = autor;
		this.titulo = titulo;
		this.link = link;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
		this.colecao = colecao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Moderador getModerador() {
		return moderador;
	}

	public void setModerador(Moderador moderador) {
		this.moderador = moderador;
	}

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}

	public boolean adicionarPublicacao(){
		return  true;
	}
	
	public boolean determinarAprovacao() {
		return  true;
	}
	
	public boolean cadastrarPublicacao(String autor, String titulo, String link, Date dataCriacao) {
		return  true;
	}

	
}
