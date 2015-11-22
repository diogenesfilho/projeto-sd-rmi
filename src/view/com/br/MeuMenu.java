package view.com.br;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MeuMenu extends MenuBar{
	public MeuMenu() {
		
		
		Menu tradutor = new Menu("TradutorRMI");
		Menu banco = new Menu("Banco");
		Menu ajuda = new Menu("Ajuda");
		
		MenuItem executar = new MenuItem("Executar");
		MenuItem ajudaTrad = new MenuItem("Ajuda TradutorRMI");
		MenuItem sobre = new MenuItem("Sobre");
		
		tradutor.getItems().addAll(executar);
		ajuda.getItems().addAll(ajudaTrad, sobre);
		getMenus().addAll(tradutor, banco, ajuda);
		
		executar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				getScene().setRoot(new Tradutor());
				
				
			}
		});
		
	}	
}		
		
		
		
	
