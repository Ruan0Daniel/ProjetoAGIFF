package view;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.ColecaoController;
import model.Colecao;
import model.Publicacao;
import model.Tag;

public class ColecaoView {
	ColecaoController controller;
	Calendar c = Calendar.getInstance();
	ImageIcon icon_1 = new ImageIcon("C:\\Users\\caiod\\Documents\\Caio\\SI\\4_periodo\\POO\\Projeto\\src\\program\\logo_02.jpg");

	public ColecaoView(ColecaoController controller){
		this.controller = controller;
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
				this.controller.adicionarColecao(new Colecao(titulo,data, usuario));

			}
			if((opcaoEscolhida == "Cadastrar Publicação") && (this.controller.getListaColecoes().isEmpty()!=true)) {	
				//Para cadastrar uma publicacao, o usuario deve escolher uma colecao primeiro
				String[] arrayOpcoesDeColecoes = new String[this.controller.getListaColecoes().size()];
				Iterator iterador = this.controller.getListaColecoes().iterator() ;
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
			
				if(this.controller.adicionarPublicacao(new Publicacao(titulo, autor, link, data), colecaoTitulo.toString()) == true) {
					JOptionPane.showMessageDialog(null, "Publicação adicionada em " + colecaoTitulo + ".", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Coleção não encontrada.", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
			}
			if(opcaoEscolhida == "Cadastrar uma Tag") {	
				String nome = JOptionPane.showInputDialog("Informe o nome da Tag: ");
				String descricao = JOptionPane.showInputDialog("Informe a descricacao da Tag: ");
				String[] arrayOpcoesDeColecoes = new String[this.controller.getListaColecoes().size()];
				Iterator iterador = this.controller.getListaColecoes().iterator() ;
				int i =0;
				while (iterador.hasNext()) {
					Colecao temp = (Colecao) iterador.next();
					arrayOpcoesDeColecoes[i] = temp.getTitulo();
					i++;
				}
				Object colecaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma coleção para cadastrar sua tag.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
				
				this.controller.associarTageColecao(colecaoEscolhida.toString(), new Tag(nome,descricao));
			}
			if(opcaoEscolhida == "Visualizar uma Coleção") {
				String[] arrayOpcoesDeColecoes = new String[this.controller.getListaColecoes().size()];
				Iterator iterador = this.controller.getListaColecoes().iterator() ;
				int i =0;
				while (iterador.hasNext()) {
					Colecao temp = (Colecao) iterador.next();
					arrayOpcoesDeColecoes[i] = temp.getTitulo();
					i++;
				}
				Object colecaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma coleção para visualizar.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoesDeColecoes, "Regular");
				JOptionPane.showMessageDialog(null, this.controller.imprimirInfoColecao(colecaoEscolhida.toString()), "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
			}
			if(opcaoEscolhida == "Visualizar Coleções Cadastradas") {
				String listagem = this.controller.imprimirInfoColecoes();
				JOptionPane.showMessageDialog(null, listagem, "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
			}
			opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma opção.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		}
}
}
