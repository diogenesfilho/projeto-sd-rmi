package view.com.br;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cliente.com.br.Cliente;
import constantes.com.br.Constantes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tradutor.com.br.Palavra;
import tradutor.com.br.TradutorInterface;

public class Tradutor extends Application{

	private VBox vbox;
	private HBox hbox, hbox1, hbox2, hbox3;
	private TextField ingField, portField, aplicField;
	private Label ing, port, aplicEmFrase;
	private Button traduzir,btLimpar;
	
	private static final String HOST = "localhost";
	private static final int PORTA = Constantes.porta;
	private static Registry registro;
	
	private static String palavraPT;
	private static String traducao;
	private static String frase;
	
	public TradutorInterface servico;
	
	public static boolean continua = true;
	
	
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		vbox = new VBox(30);
		hbox = new HBox(180);
		//hbox.setPrefSize(100, 30);
		hbox1 = new HBox(30);
		
		hbox2 = new HBox(250);
		hbox3 = new HBox(30);
		
		portField = new TextField();
		portField.setPromptText("Palavra em Português");
		ingField = new TextField();
		ingField.setPromptText("Tradução");
		aplicField = new TextField();
		aplicField.setPrefSize(300, 100);
		
		traduzir = new Button("Traduzir");
		btLimpar = new Button("Limpar");
		
		port = new Label("Português");
		ing = new Label("Inglês");
		aplicEmFrase = new Label("Aplicação em uma frase: ");
		aplicEmFrase.setTranslateY(-40);
		
		hbox.getChildren().addAll(port, ing);
		hbox.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(portField, ingField);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.getChildren().addAll(traduzir, btLimpar);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.getChildren().addAll(aplicEmFrase, aplicField);
		hbox3.setAlignment(Pos.CENTER);
		
		vbox.getChildren().addAll(hbox, hbox1, hbox2, hbox3);
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox, 600, 400);
		primaryStage.setTitle("TradutorRMI");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		traduzir.setOnAction(new EventHandler<ActionEvent>() {
			
			private Object servico;

			@Override
			public void handle(ActionEvent arg0){
				
				String palavraField = portField.getText();
				
				try{
					registro = LocateRegistry.getRegistry(HOST, PORTA);
					
					TradutorInterface servico = (TradutorInterface) registro.lookup(TradutorInterface.class.getName());
					
					Tradutor tradutor = new Tradutor();
					
					Palavra palavra = servico.traducaoPtEn(palavraField);
					
					//System.err.println("Chegou aqui");
					
					System.out.println("Tradução de '" + palavraPT + "' é '" + palavra.getTraducao()+"'.");
					
					ingField.setText(palavra.getTraducao());
					
					System.out.println("Aplicação na frase de '" + palavraPT + "' é '" + palavra.getFraseCom() + "'.");
					
					aplicField.setText(palavra.getFraseCom());
				
				}catch (Exception e){
					
					ingField.setText("Ainda não existe tradução cadastrada!");
					aplicField.setText("Ainda não existe aplicação em frase cadastrada!");
					
					System.err.println("Algo deu errado!");
				}
			}
		});
		
		btLimpar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ingField.setText("");
				aplicField.setText("");
				portField.setText("");
				
			}
		});
	}
}

