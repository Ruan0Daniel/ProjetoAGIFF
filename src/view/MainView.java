package view;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.*;
import model.Colecao;
import model.Publicacao;
import model.Tag;

public class MainView {
	ColecaoController colecaoController;
	PublicacaoController publicacaoController;
	Calendar c = Calendar.getInstance();
	ImageIcon icon_1 = new ImageIcon("C:\\Users\\caiod\\Documents\\Caio\\SI\\4_periodo\\POO\\Projeto\\src\\program\\logo_02.jpg");

	public MainView(ColecaoController colecaoController, PublicacaoController publicacaoControler){
		this.colecaoController = colecaoController;
		this.publicacaoController = publicacaoControler;
	}
	
	public void displayTelaInicial() {
		JOptionPane.showMessageDialog(null, "Bem vindo!", "AgIFF", JOptionPane.PLAIN_MESSAGE, icon_1);
		String[] arrayOpcoes = new String[6];
		arrayOpcoes[0] = "Cadastrar Coleção";
		arrayOpcoes[1] = "Cadastrar Publicação";
		arrayOpcoes[2] = "Cadastrar uma Tag";
		arrayOpcoes[3] = "Visualizar uma Coleção";
		arrayOpcoes[4] = "Visualizar Coleções Cadastradas";
		arrayOpcoes[5] = "Sair";
		Object opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma opção.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		displayEscolha(opcaoEscolhida,arrayOpcoes);
	}
	public void displayEscolha(Object opcaoEscolhida, String[] arrayOpcoes) {
		
		while((opcaoEscolhida != null) && (opcaoEscolhida.toString().length()>0) && (opcaoEscolhida != "Sair")) {	

			if(opcaoEscolhida == "Cadastrar Coleção") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da coleção: ");
				Date data = c.getTime();
				String usuario = JOptionPane.showInputDialog("Informe o usuário responsável pela coleção: ");
				if(titulo.isBlank() || titulo.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Título inválido", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					this.colecaoController.adicionarColecao(new Colecao(titulo,data, usuario));				
				}
			}
			if((opcaoEscolhida == "Cadastrar Publicação") && (this.colecaoController.getListaColecoes().isEmpty()!=true)) {	
				//Para cadastrar uma publicacao, o usuario deve escolher uma colecao primeiro
				String[] arrayOpcoesDeColecoes = new String[this.colecaoController.getListaColecoes().size()];
				Iterator iterador = this.colecaoController.getListaColecoes().iterator() ;
				int i =0;
				while (iterador.hasNext()) {
					Colecao temp = (Colecao) iterador.next();
					arrayOpcoesDeColecoes[i] = temp.getTitulo();
					i++;
				}
				Object colecaoTitulo = JOptionPane.showInputDialog(null, "Escolha uma coleção para cadastrar sua publicacao.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
				String titulo = JOptionPane.showInputDialog("Informe o título da publicação: ");
				String autor = JOptionPane.showInputDialog("Informe o autor da publicação: ");
				String link = JOptionPane.showInputDialog("Informe o link da publicação: ");
				Date data = c.getTime(); 
				if(this.publicacaoController.associarPublicacao(new Publicacao(titulo, autor, link, data), this.colecaoController.buscarColecao(colecaoTitulo.toString())) == true) {
					JOptionPane.showMessageDialog(null, "Publicação adicionada em " + colecaoTitulo + ".", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
			}
			if(opcaoEscolhida == "Cadastrar uma Tag") {	
				String nome = JOptionPane.showInputDialog("Informe o nome da Tag: ");
				String descricao = JOptionPane.showInputDialog("Informe a descricacao da Tag: ");
				String[] arrayOpcoesDeColecoes = new String[this.colecaoController.getListaColecoes().size()];
				Iterator iterador = this.colecaoController.getListaColecoes().iterator() ;
				int i =0;
				while (iterador.hasNext()) {
					Colecao temp = (Colecao) iterador.next();
					arrayOpcoesDeColecoes[i] = temp.getTitulo();
					i++;
				}
				Object colecaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma coleção para cadastrar sua tag.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
				
				this.colecaoController.associarTageColecao(colecaoEscolhida.toString(), new Tag(nome,descricao));
			}
			if(opcaoEscolhida == "Visualizar uma Coleção") {
				String[] arrayOpcoesDeColecoes = new String[this.colecaoController.getListaColecoes().size()];
				Iterator iterador = this.colecaoController.getListaColecoes().iterator();
				int i =0;
				try {
					while (iterador.hasNext()) {
						Colecao temp = (Colecao) iterador.next();
						arrayOpcoesDeColecoes[i] = temp.getTitulo();
						i++;
					}
					Object colecaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma coleção para visualizar.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
					JOptionPane.showMessageDialog(null,"Coleção "+this.colecaoController.buscarColecao(colecaoEscolhida.toString()).getTitulo()+"\nPublicações: \n"+this.publicacaoController.imprimirPublicacoes(this.colecaoController.buscarColecao(colecaoEscolhida.toString())) , "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
	
			}
			if(opcaoEscolhida == "Visualizar Coleções Cadastradas") {
				String impressaoTotal = "";
				Iterator iteradorColecoes = this.colecaoController.getListaColecoes().iterator();
				while (iteradorColecoes.hasNext()) {
					Colecao temp = (Colecao) iteradorColecoes.next();
					impressaoTotal += temp.getTitulo();
					impressaoTotal += "\n";
					impressaoTotal += this.publicacaoController.imprimirPublicacoes(temp);
					impressaoTotal += "==============\n";

				}
				JOptionPane.showMessageDialog(null, impressaoTotal, "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
			}
			opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma opção.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		}
	}
}
