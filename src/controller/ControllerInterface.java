package controller;

import java.util.LinkedList;

import model.*;

public interface ControllerInterface {
	
	void adicionarColecao(Colecao coleacao);
	
	boolean adicionarPublicacao(Publicacao publicacao, String colecaoTitulo );
	
	void associarTageColecao(String tituloDaColecao, Tag tag);
	
	String imprimirInfo(String titulo);
	

}
