package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Colecao {

	private String titulo;
	private Date dataCriacao;
	private String usuario;
	private LinkedList<Publicacao> ListaPublicacoes = new LinkedList<Publicacao>();
	private LinkedList<Tag> ListaTags = new LinkedList<Tag>();
	
	
	public Colecao(String titulo, Date dataCriacao, String usuario) {
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
	}
	public Colecao() {
	}
	
	public void adicionarPublicacao(Publicacao publicacao) {
		this.ListaPublicacoes.add(publicacao);
		publicacao.setColecao(this);
	}
	public void adicionarTag(Tag tag) {
		this.ListaTags.add(tag);
		tag.associarColecao(this);
	}	

	public String getTitulo() {
		return titulo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LinkedList getListaPublicacoes() {
		return this.ListaPublicacoes;
	}
	public LinkedList getListaTags() {
		return this.ListaTags;
	}
	public Publicacao getPublicacaoNaLista(int i) {
		return this.ListaPublicacoes.get(i);
	}
	public Tag getTagNaLista(int i) {
		return this.ListaTags.get(i);
	}

}
