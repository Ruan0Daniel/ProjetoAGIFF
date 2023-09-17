package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Colecao {

	private String titulo;
	private Date dataCriacao;
	private String usuario;
	private LinkedList<Publicacao> ListaPublicacao = new LinkedList<Publicacao>();
//	private List <ColecaoListener>colecaoListeners = new LinkedList();
	
	
	public Colecao(String titulo, Date dataCriacao, String usuario) {
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
	}
	public Colecao() {
		// TODO Auto-generated constructor stub
	}
	
	public void adicionarPublicacao(Publicacao publicacao) {
		this.ListaPublicacao.add(publicacao);
		publicacao.setColecao(this);
	}
	
	private synchronized void disparaNovaPublicacao(Publicacao publicacao){		{

		}
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

	public LinkedList getListaPublicacao() {
		return this.ListaPublicacao;
	}
	public Publicacao getPublicacaoNaLista(int i) {
		return this.ListaPublicacao.get(i);
	}

	public void adicionarPublicacao(String actionCommand) {
		// TODO Auto-generated method stub
		
	}
}
