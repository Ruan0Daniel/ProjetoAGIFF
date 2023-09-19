package program;

import view.ColecaoView;
import controller.ColecaoController;

public class MainAGIFF {

	public static void main(String[] args) {
		ColecaoController controller = new ColecaoController();
		ColecaoView view = new ColecaoView(controller);
		
		view.displayTelaInicial();

	} 
}