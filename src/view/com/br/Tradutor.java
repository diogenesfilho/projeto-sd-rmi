package view.com.br;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tradutor.com.br.Palavra;
import tradutor.com.br.TradutorInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cliente.com.br.Cliente;
import constantes.com.br.Constantes;


public class Tradutor extends BorderPane {
	private HBox hbox, hbox1, hbox2, hbox3;
	private VBox vbox;
	private TextField portField, ingField, aplicField;
	private Label ing, port, aplicEmFrase;
	private Button traduzir, btLimpar, enviarTrad;
	
	private static final String HOST = "localhost";
	private static final int PORTA = Constantes.porta;
	private static Registry registro;
	
	public Tradutor(){
		MeuMenu vboxtop = new MeuMenu();
		
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
		enviarTrad = new Button("Enviar Tradução");
		
		port = new Label("Português");
		ing = new Label("Inglês");
		
		aplicEmFrase = new Label("Aplicação em uma frase: ");
		aplicEmFrase.setTranslateY(-40);
		
		hbox.getChildren().addAll(port, ing);
		hbox.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(portField, ingField);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.getChildren().addAll(traduzir,btLimpar,enviarTrad);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.getChildren().addAll(aplicEmFrase, aplicField);
		hbox3.setAlignment(Pos.CENTER);
		
		
		vbox.getChildren().addAll(hbox, hbox1, hbox2, hbox3);
		vbox.setAlignment(Pos.CENTER);
		setCenter(vbox);
		setTop(vboxtop);
		
		traduzir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String palavraField = portField.getText();
				
				System.out.println("Traduzindo");
				
				if (palavraField.equals("")){
					System.out.println("Digite alguma palavra.");
					aplicField.setText("Digite uma palavra!!");
				}
				
				if(!palavraField.equals("")){
					try{
						registro = LocateRegistry.getRegistry(HOST, PORTA);
						
						TradutorInterface servico = (TradutorInterface) registro.lookup(TradutorInterface.class.getName());
						
						Palavra palavra = servico.traducaoPtEn(palavraField);
						
						System.out.println("Tradução de '" + palavraField + "' é '" + palavra.getTraducao()+"'.");
						
						ingField.setText(palavra.getTraducao());
						
						System.out.println("Aplicação na frase de '" + palavraField + "' é '" + palavra.getFraseCom() + "'.");
						
						aplicField.setText(palavra.getFraseCom());
					
					}catch (Exception e){
						
						ingField.setText("Ainda não existe tradução cadastrada!");
						aplicField.setText("Ainda não existe aplicação em frase cadastrada!");
						
						System.err.println("Algo deu errado!");
					}
				}
			}
		});
		
		btLimpar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				System.out.println("Limpa Tela");
				
				ingField.setText("");
				aplicField.setText("");
				portField.setText("");
				
			}
		});
		
		enviarTrad.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				String palavraField = portField.getText();
				
				System.out.println("Enviando tradução");
				
				if (palavraField.equals("")){
					System.out.println("Digite alguma palavra.");
					aplicField.setText("Digite uma palavra!!");
				}
				
				if(!palavraField.equals("")){
					try{
						registro = LocateRegistry.getRegistry(HOST, PORTA);
						
						TradutorInterface servico = (TradutorInterface) registro.lookup(TradutorInterface.class.getName());
						
						Palavra palavra = new Palavra(portField.getText(), ingField.getText(), aplicField.getText());
						
						servico.enviarTraduçãoPtEn(palavra);
						
						System.out.println("Sucesso!");
						
					}catch(Exception e){
						
						System.err.println("Deu merda hein!");
						
					}
				}	
			}
		});
	}
}


