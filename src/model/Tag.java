package model;

import java.util.LinkedList;

public class Tag {
	private String nome, descricao;
	private LinkedList listaColecao = new LinkedList();
	
	public Tag(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public LinkedList getColecao() {
		return listaColecao;
	}

	public void adicionarColeca(Colecao colecao) {
		this.listaColecao.add(colecao);
	}
}
