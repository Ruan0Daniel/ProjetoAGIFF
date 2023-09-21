package controller;

import java.util.LinkedList;

import model.Colecao;
import model.Publicacao;
import model.Tag;

public class ColecaoController implements ControllerInterface {
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
	public Colecao buscarColecao(String colecaoTitulo){
		for(int j = 0; j<= this.getListaColecoes().size()-1; j++) {
			if(this.getListaColecoes().get(j).getTitulo().contains(colecaoTitulo)) {
					return this.getListaColecoes().get(j) ;
			}
		}
		return null;
	}
	public void associarTageColecao(String tituloDaColecao, Tag tag) {
		for(int j = 0; j<= this.getListaColecoes().size()-1; j++) {
			if(this.getListaColecoes().get(j).getTitulo().contains(tituloDaColecao)) {
				 this.getListaColecoes().get(j).adicionarTag(tag);
				 tag.associarColecao(this.getListaColecoes().get(j));
			}
		}
	}
	public String imprimirInfo(String colecaoTitulo) {
		String infoColecao = "Confira o conteúdo da Coleção " + colecaoTitulo;
		for(int j = 0; j<= this.getListaColecoes().size()-1; j++) {
			if(this.getListaColecoes().get(j).getTitulo().contains(colecaoTitulo)) {
				infoColecao += "\n"+ "Criado em: "+ this.getListaColecoes().get(j).getDataCriacao().toString() +"\n" + "Publicações: ";
				infoColecao +=  "========\n";
			}
		}
		return infoColecao;
	}
	public LinkedList<Colecao> getListaColecoes() {
		return this.listaColecoes;
	}
}
