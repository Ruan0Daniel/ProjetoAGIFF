package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import model.Colecao;
import model.Publicacao;

public class ColecaoController {
	private LinkedList<Colecao> listaColecoes = new LinkedList<Colecao>();
	
	public void adicionarColecao(Colecao colecao) {
		this.listaColecoes.add(colecao);
	}
	
	public boolean adicionarPublicacao(Publicacao publicacao, String colecaoTitulo ) {
		for(int j = 0; j<= this.getListaColecoes().size()-1; j++) {
			if(this.getListaColecoes().get(j).getTitulo().contains(colecaoTitulo)) {
				 this.getListaColecoes().get(j).adicionarPublicacao(publicacao);
					return true;
			}
		}
		return false;
	}
	
	public String imprimirColecoesEPublicacoes() {
		String listagem = "Confira a lista de registros: \n";
		for(int n = 0; n <this.getListaColecoes().size(); n++) {
			listagem += "Título da colecação: " + this.getListaColecoes().get(n).getTitulo() +"\n"+ "Criado em: "+ this.getListaColecoes().get(n).getDataCriacao() +"\n" + "Publicações: " +"\n" ;
			for(int m =0; m<=this.getListaColecoes().get(n).getListaPublicacao().size()-1; m++) {
				listagem += this.getListaColecoes().get(n).getPublicacaoNaLista(m).getTitulo() + "\n";
			}
			listagem +=  "\n========\n";
		}
		return listagem;
	}

	public LinkedList<Colecao> getListaColecoes() {
		return this.listaColecoes;
	}

	
}
