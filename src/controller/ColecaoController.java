package controller;

import java.util.LinkedList;

import model.Colecao;


public class ColecaoController  {
	private LinkedList<Colecao> listaColecoes = new LinkedList<Colecao>();
	
	public void cadastrarColecao(Colecao colecao) {
		this.listaColecoes.add(colecao);
	}
	public LinkedList<Colecao> getListaColecoes() {
		return this.listaColecoes;
	}
	public Colecao buscarColecao(String colecaoTitulo){
		for(int j = 0; j<= this.getListaColecoes().size()-1; j++) {
			if(this.getListaColecoes().get(j).getTitulo().contains(colecaoTitulo)) {
					return this.getListaColecoes().get(j) ;
			}
		}
		return null;
	}
}
