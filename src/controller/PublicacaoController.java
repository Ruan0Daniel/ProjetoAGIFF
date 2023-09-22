package controller;

import java.util.Iterator;
import java.util.LinkedList;

import model.Colecao;
import model.Publicacao;

public class PublicacaoController {
	private LinkedList<Publicacao> listaPublicacoes = new LinkedList<Publicacao>();
	
	
	public LinkedList<Publicacao> getListaPublicacoes() {
		return listaPublicacoes;
	}
	public Publicacao buscarColecao(String publicacaoTitulo){
		for(int j = 0; j<= this.getListaPublicacoes().size()-1; j++) {
			if(this.getListaPublicacoes().get(j).getTitulo().contains(publicacaoTitulo)) {
					return this.getListaPublicacoes().get(j) ;
			}
		}
		return null;
	}
	public boolean associarPublicacao(Publicacao publicacao, Colecao colecao) {
		if(colecao != null) {
			this.listaPublicacoes.add(publicacao);
			colecao.setNumeroDePublicacoes(colecao.getNumeroDePublicacoes()+1);;
			publicacao.setColecao(colecao);
			return true;
		}
		else {
			return false;
		}

	}
	public String imprimirPublicacoes(Colecao colecao) {
		String publicaoesParaImpressao = "";
		Iterator iterador = this.listaPublicacoes.iterator();
		while(iterador.hasNext()) {
			Publicacao temp = (Publicacao) iterador.next();
			if(temp.getColecao() == colecao) {
				publicaoesParaImpressao += temp.toString() + "================\n";
			}
		}
		return publicaoesParaImpressao;
	}
}
