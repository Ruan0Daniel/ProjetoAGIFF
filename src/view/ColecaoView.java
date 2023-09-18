package view;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.ColecaoController;
import model.Colecao;
import model.Publicacao;

public class ColecaoView {
	ColecaoController controller;
	Calendar c = Calendar.getInstance();
	ImageIcon icon_1 = new ImageIcon("C:\\Users\\caiod\\Documents\\Caio\\SI\\4_periodo\\POO\\Projeto\\src\\program\\logo_02.jpg");

	public ColecaoView(ColecaoController controller){
		this.controller = controller;
	}
	public void displayTelaInicial() {
		JOptionPane.showMessageDialog(null, "Bem vindo!", "AgIFF", JOptionPane.PLAIN_MESSAGE, icon_1);
		String[] arrayOpcoes = new String[4];
		arrayOpcoes[0] = "Cadastrar Coleção";
		arrayOpcoes[1] = "Cadastrar Publicação";
		arrayOpcoes[2] = "Visualizar Coleções Cadastradas";
		arrayOpcoes[3] = "Sair";
		Object opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma opção.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		displayEscolha(opcaoEscolhida,arrayOpcoes);
	}
	public void displayEscolha(Object opcaoEscolhida, String[] arrayOpcoes) {
		
		while((opcaoEscolhida != null) && (opcaoEscolhida.toString().length()>0)) {	
			int i =0;
			if(opcaoEscolhida == "Cadastrar Coleção") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da coleção: ");
				Date data = c.getTime();
				String usuario = JOptionPane.showInputDialog("Informe o usuário: ");			
				this.controller.adicionarColecao(new Colecao(titulo,data, usuario));
				i +=1;
			}
			if(opcaoEscolhida == "Cadastrar Publicação") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da publicação: ");
				String autor = JOptionPane.showInputDialog("Informe o autor da publicação: ");
				String link = JOptionPane.showInputDialog("Informe o link da publicação: ");
				Date data = c.getTime();
				String colecaoTitulo = JOptionPane.showInputDialog("Informe a coleção a qual a publicação será adicionada: ");
			
				if(this.controller.adicionarPublicacao(new Publicacao(titulo, autor, link, data), colecaoTitulo) == true) {
					JOptionPane.showMessageDialog(null, "Publicação adicionada em " + colecaoTitulo + ".", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Coleção não encontrada.", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
	
			}
			if(opcaoEscolhida == "Visualizar Coleções Cadastradas") {
				String listagem = this.controller.imprimirColecoesEPublicacoes();
				JOptionPane.showMessageDialog(null, listagem, "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
			}
			opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha uma opção.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		}
}
}
