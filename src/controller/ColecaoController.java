package controller;

import java.util.LinkedList;

import model.Colecao;
import model.Publicacao;
import model.Tag;

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
	public void associarTageColecao(String tituloDaColecao, Tag tag) {
		for(int j = 0; j<= this.getListaColecoes().size()-1; j++) {
			if(this.getListaColecoes().get(j).getTitulo().contains(tituloDaColecao)) {
				 this.getListaColecoes().get(j).adicionarTag(tag);
				 tag.associarColecao(this.getListaColecoes().get(j));
			}
		}
	}
	public String imprimirInfoColecoes() {
		String listagem = "Confira a lista de Coleções\n";
		for(int n = 0; n <this.getListaColecoes().size(); n++) {
			listagem += "Título da Coleção: " + this.getListaColecoes().get(n).getTitulo() +"\n"+ "Criado em: "+ this.getListaColecoes().get(n).getDataCriacao() +"\n" + "Publicações: " +"\n" ;
			for(int m =0; m<=this.getListaColecoes().get(n).getListaPublicacoes().size()-1; m++) {
				listagem += this.getListaColecoes().get(n).getPublicacaoNaLista(m).getTitulo() + "\n";
			}
			listagem += "Tags da Coleção:\n";
			for(int k =0; k<=this.getListaColecoes().get(n).getListaTags().size()-1; k++) {
				listagem += this.getListaColecoes().get(n).getTagNaLista(k).getNome() + "\n";
			}	
			listagem +=  "========\n";
		}
		return listagem;
	}
	public String imprimirInfoColecao(String string) {
		String infoColecao = "Confira o conteúdo da Coleção " + string;
		for(int j = 0; j<= this.getListaColecoes().size()-1; j++) {
			if(this.getListaColecoes().get(j).getTitulo().contains(string)) {
				infoColecao += "\n"+ "Criado em: "+ this.getListaColecoes().get(j).getDataCriacao().toString() +"\n" + "Publicações: ";
				infoColecao += "Publicações: " +"\n" ;
				for(int m =0; m<= this.getListaColecoes().get(j).getListaPublicacoes().size()-1; m++) {
					infoColecao+= this.getListaColecoes().get(j).getPublicacaoNaLista(m).getTitulo() + "\n";
				}
				infoColecao += "Tags da Coleção:\n";
				for(int k =0; k<=this.getListaColecoes().get(j).getListaTags().size()-1; k++) {
					infoColecao += this.getListaColecoes().get(j).getTagNaLista(k).getNome() + "\n";
				}
				infoColecao +=  "========\n";
			}
		}
		return infoColecao;
	}
	public LinkedList<Colecao> getListaColecoes() {
		return this.listaColecoes;
	}
}
