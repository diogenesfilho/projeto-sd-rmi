package cliente.com.br;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import constantes.com.br.Constantes;
import tradutor.com.br.Palavra;
import tradutor.com.br.TradutorInterface;
import view.com.br.Tradutor;

public class Cliente {

	private static final String HOST = "localhost";
	private static final int PORTA = Constantes.porta;
	private static Registry registro;
	
	private static String palavraPT;
	private static String traducao;
	private static String frase;
	
	
	public static boolean continua = true;
	
	public Cliente (String palavra) {
		this.palavraPT = palavra;
	}
	
	public static String getPalavraPT() {
		return palavraPT;
	}

	public static void setPalavraPT(String palavraPT) {
		Cliente.palavraPT = palavraPT;
	}

	public static String getTraducao() {
		return traducao;
	}

	public static void setTraducao(String traducao) {
		Cliente.traducao = traducao;
	}

	public static String getFrase() {
		return frase;
	}

	public static void setFrase(String frase) {
		Cliente.frase = frase;
	}

	public static void main (String[] args) throws Exception {
		
		registro = LocateRegistry.getRegistry(HOST, PORTA);
		
		TradutorInterface servico = (TradutorInterface) registro.lookup(TradutorInterface.class.getName());
		
		Tradutor tradutor = new Tradutor();
		
		/*
		 * Criar um while pra ficar recebendo várias vezes, talvez uma interface.
		 * Lembrar de colocar lowcase ou uppercase para não causar conflito.
		 */
		
		palavraPT = "aprender";
		
		Palavra palavra = servico.traducaoPtEn(palavraPT);
		
		//System.err.println("Chegou aqui");
		
		System.out.println("Tradução de '" + palavraPT + "' é '" + palavra.getTraducao()+"'.");
		
		System.out.println("Aplicação na frase de '" + palavraPT + "' é '" + palavra.getFraseCom() + "'.");
		
		
		System.out.println("----------------");
		
		palavraPT = "voar";
		
		palavra = servico.traducaoPtEn(palavraPT);
		
		System.out.println("Tradução de '" + palavraPT + "' é '" + palavra.getTraducao()+"'.");
		
		System.out.println("Aplicação na frase de '" + palavraPT + "' é '" + palavra.getFraseCom() + "'.");
		

		System.out.println("----------------");
		
		palavraPT = "veja";
		
		palavra = servico.traducaoPtEn(palavraPT);
		
		System.out.println("Tradução de '" + palavraPT + "' é '" + palavra.getTraducao()+"'.");
		
		System.out.println("Aplicação na frase de '" + palavraPT + "' é '" + palavra.getFraseCom() + "'.");
		
	}
}
