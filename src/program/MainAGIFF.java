package program;

import view.MainView;
import controller.ColecaoController;
import controller.PublicacaoController;

public class MainAGIFF {

	public static void main(String[] args) {
		ColecaoController colecaoController = new ColecaoController();
		PublicacaoController publicacaoController = new PublicacaoController();
		MainView view = new MainView(colecaoController, publicacaoController);
		view.displayTelaInicial();
	} 
}