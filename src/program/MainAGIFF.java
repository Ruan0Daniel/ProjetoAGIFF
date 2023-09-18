package program;

import model.*;
import view.ColecaoView;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.ColecaoController;

import java.util.Date;
import java.util.Calendar;

public class MainAGIFF {

	public static void main(String[] args) {
		ColecaoController controller = new ColecaoController();
		ColecaoView view = new ColecaoView(controller);
		
		view.displayTelaInicial();
		//Interfaces para interação do usuário



	} 
}