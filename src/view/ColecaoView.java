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
		Object opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha um registro.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		displayEscolha(opcaoEscolhida,arrayOpcoes);
	}
	public void displayEscolha(Object opcaoEscolhida, String[] arrayOpcoes) {
		
		while((opcaoEscolhida != null) && (opcaoEscolhida.toString().length()>0)) {	
			int i =0;
			if(opcaoEscolhida == "Cadastrar Coleção") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da coleção: ");
				Date data = c.getTime();
				String usuario = JOptionPane.showInputDialog("Informe o usuário: ");
				this.controller.getListaColecoes().add(i,new Colecao(titulo,data, usuario));
				i +=1;
			}
			if(opcaoEscolhida == "Cadastrar Publicação") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da publicação: ");
				String autor = JOptionPane.showInputDialog("Informe o autor da publicação: ");
				String link = JOptionPane.showInputDialog("Informe o link da publicação: ");
				Date data = c.getTime();
				String colecaoTitulo = JOptionPane.showInputDialog("Informe a coleção a qual a publicação será adicionada: ");

				Colecao colecaoEscolhida = null;
				for(int j = 0; j<= this.controller.getListaColecoes().size()-1; j++) {
					if(this.controller.getListaColecoes().get(j).getTitulo().contains(colecaoTitulo)) {
						 this.controller.getListaColecoes().get(j).adicionarPublicacao(new Publicacao(autor, titulo, link, data, colecaoEscolhida));
						 colecaoEscolhida = this.controller.getListaColecoes().get(j);
					}
				}
				if(colecaoEscolhida == null) {
					JOptionPane.showMessageDialog(null, "Coleção não encontrada.", "AgIFF", JOptionPane.PLAIN_MESSAGE);
				}
	
			}
			if(opcaoEscolhida == "Visualizar Coleções Cadastradas") {
				String listagem = "Confira a lista de registros: \n";
				for(int n = 0; n <this.controller.getListaColecoes().size(); n++) {
					listagem += "Título da colecação: " + this.controller.getListaColecoes().get(n).getTitulo() +"\n"+ "Criado em: "+ this.controller.getListaColecoes().get(n).getDataCriacao() +"\n" + "Publicações: " +"\n" ;
					for(int m =0; m<=this.controller.getListaColecoes().get(n).getListaPublicacao().size()-1; m++) {
						listagem += this.controller.getListaColecoes().get(n).getPublicacaoNaLista(m).getTitulo() + "\n";
					}
					listagem +=  "\n========\n";
				}
				JOptionPane.showMessageDialog(null, listagem, "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
			}
			opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha um registro.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		}
}
}
