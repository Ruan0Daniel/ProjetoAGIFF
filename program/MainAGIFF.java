package program;

import view.MainView;
import controller.ColecaoController;
import controller.PublicacaoController;
import controller.RelacaoColecaoTagController;
import controller.TagController;
import model.RelacaoColecaoTag;

public class MainAGIFF {

	public static void main(String[] args) {
		ColecaoController colecaoController = new ColecaoController();
		PublicacaoController publicacaoController = new PublicacaoController();
		TagController tagController = new TagController();
		RelacaoColecaoTagController relacaoController = new RelacaoColecaoTagController();
		MainView view = new MainView(colecaoController, publicacaoController,tagController, relacaoController);
		view.displayTelaInicial();
	} 
}