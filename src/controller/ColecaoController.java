package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import model.Colecao;

public class ColecaoController {
	private LinkedList<Colecao> listaColecoes = new LinkedList<Colecao>();
	
	public void adicionarColecao(Colecao colecao) {
		this.listaColecoes.add(colecao);
	}

	public LinkedList<Colecao> getListaColecoes() {
		return this.listaColecoes;
	}

	
}
