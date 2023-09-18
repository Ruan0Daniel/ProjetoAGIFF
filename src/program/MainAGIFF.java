package program;

import model.*;


import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



import java.util.Date;
import java.util.Calendar;

public class MainAGIFF {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		ImageIcon icon_1 = new ImageIcon("C:\\Users\\caiod\\Documents\\Caio\\SI\\4_periodo\\POO\\Projeto\\src\\program\\logo_02.jpg");
		ArrayList<Colecao> listaColecoes = new ArrayList<Colecao>();
		//Interfaces para interação do usuário
		JOptionPane.showMessageDialog(null, "Bem vindo!", "AgIFF", JOptionPane.PLAIN_MESSAGE, icon_1);
		String[] arrayOpcoes = new String[3];
		arrayOpcoes[0] = "Cadastrar Coleção";
		arrayOpcoes[1] = "Cadastrar Publicação";
		arrayOpcoes[2] = "Visualizar Coleções Cadastradas";
		arrayOpcoes[3] = "Sair";
		Object opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha um registro.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		while((opcaoEscolhida != null) && (opcaoEscolhida.toString().length()>0)) {	
			int i =0;
			if(opcaoEscolhida == "Cadastrar Coleção") {	
				String titulo = JOptionPane.showInputDialog("Informe o título da coleção: ");
				Date data = c.getTime();
				String usuario = JOptionPane.showInputDialog("Informe o usuário: ");
				listaColecoes.add(i,new Colecao(titulo,data, usuario));
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
			if(opcaoEscolhida == "Visualizar Coleções Cadastradas") {
				String listagem = "Confira a lista de registros: \n";
				for(int n = 0; n <listaColecoes.size(); n++) {
					listagem += "Categoria: " + listaColecoes.get(n).getTitulo() +"\n"+ "Criado em: "+ listaColecoes.get(n).getDataCriacao() +"\n" +  "\n========\n";
				}
				JOptionPane.showMessageDialog(null, listagem, "AgIFF", JOptionPane.INFORMATION_MESSAGE, icon_1);
			}
			opcaoEscolhida = JOptionPane.showInputDialog(null, "Escolha um registro.", "AgIFF" , JOptionPane.PLAIN_MESSAGE, null, arrayOpcoes, "Regular");
		}
	} 
}