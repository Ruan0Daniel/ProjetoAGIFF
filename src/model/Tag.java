package model;

import java.util.LinkedList;

public class Tag {
	private String nome, descricao;
	private LinkedList listaColecoes = new LinkedList();
	
	public Tag(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public LinkedList getListaColecoes() {
		return this.listaColecoes;
	}

	public void associarColecao(Colecao colecao) {
		this.listaColecoes.add(colecao);
	}
	public String getNome() {
		return this.nome;
	}
}
