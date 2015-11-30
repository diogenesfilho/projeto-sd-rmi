package app.com.br;

import view.com.br.TelaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private Scene scene;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.setProperty("java.rmi.server.hostname", "172.17.51.228");
		
		TelaPrincipal tela = new TelaPrincipal();
		scene = new Scene(tela, 600, 600);
		
		primaryStage.setTitle("Tradutor RMI");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
