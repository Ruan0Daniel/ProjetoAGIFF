package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Colecao {

	private String titulo;
	private Date dataCriacao;
	private String usuario;
	private int numeroDePublicacoes = 0;
	private LinkedList<Tag> ListaTags = new LinkedList<Tag>();
	
	
	public Colecao(String titulo, Date dataCriacao, String usuario) {
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
	}
	public Colecao() {
	}
	
	public void adicionarPublicacao(Publicacao publicacao) {
		//this.ListaPublicacoes.add(publicacao);
		this.numeroDePublicacoes++;
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
	public void setNumeroDePublicacoes(int numeroDePublicacoes) {
		this.numeroDePublicacoes = numeroDePublicacoes;
	}
	public int getNumeroDePublicacoes() {
		return this.numeroDePublicacoes;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public LinkedList getListaTags() {
		return this.ListaTags;
	}
	
	
	public Tag getTagNaLista(int i) {
		return this.ListaTags.get(i);
	}

}
