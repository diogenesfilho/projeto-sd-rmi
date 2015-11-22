package view.com.br;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TelaPrincipal extends BorderPane {
	public TelaPrincipal(){
		MeuMenu menu = new MeuMenu();
		VBox vbox = new VBox();
		vbox.getChildren().addAll(menu);
		vbox.setAlignment(Pos.CENTER);
		setTop(vbox);	
	}
}