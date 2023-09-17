package program;

import model.*;


import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;



import java.util.Date;
import java.util.Calendar;

public class MainAGIFF {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Usuario usuario1 = new Usuario("John", "john@gmail.com", "9987654321");
		ArrayList<Colecao> listaColecoes = new ArrayList<Colecao>();
		Colecao colecao1 = new Colecao("Computação",c.getTime(), "John");
		listaColecoes.add(colecao1);
		
		//Publicacao publicacao1 = new Publicacao("Paul", "Artigo 1", "www.link.com", c.getTime(), usuario1, colecao1);
		//Publicacao publicacao2 = new Publicacao("Ringo", "Artigo 2", "www.alfa.com", c.getTime(), usuario1, colecao1);
		//colecao1.adicionarPublicacao(publicacao1);
		//colecao1.adicionarPublicacao(publicacao2);
		//System.out.println(colecao1.getPublicacaoNaLista(0).getAutor());
		//Interfaces para interação do usuário
		JOptionPane.showMessageDialog(null, "Bem vindo!", "AgIFF", JOptionPane.PLAIN_MESSAGE);
		String[] arrayOpcoes = new String[3];
		arrayOpcoes[0] = "Cadastrar Coleção";
		arrayOpcoes[1] = "Cadastrar Publicação";
		arrayOpcoes[2] = "Sair";
		Object opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha um registro.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		while((opcaoEscolhida != null) && (opcaoEscolhida.toString().length()>0)) {	
			int i =0;
			if(opcaoEscolhida == "Cadastrar Coleção") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da coleção: ");
				Date data = c.getTime();
				String usuario =JOptionPane.showInputDialog("Informe o usuário: ");
				listaColecoes.add(i,new Colecao( titulo,data, usuario));
				i +=1;
			}
			if(opcaoEscolhida == "Cadastrar Publicação") {	
				String autor = JOptionPane.showInputDialog("Informe o autor da publicação: ");
				String titulo = JOptionPane.showInputDialog("Informe o título da publicação: ");
				String link = JOptionPane.showInputDialog("Informe o link da publicação: ");
				Date data = c.getTime();
				String colecao = JOptionPane.showInputDialog("Informe a coleção a qual a publicação será adicionada: ");
				Colecao colecaoEscolhida = null;
				for(int j = 0; i<= listaColecoes.size()-1; j++) {
					if(listaColecoes.get(j).getTitulo().contains(colecao)) {
						 colecaoEscolhida = listaColecoes.get(j);
					}
				}
				new Publicacao(autor, titulo, link, data, colecaoEscolhida);
			}
			opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha um registro.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		}
	} 
}