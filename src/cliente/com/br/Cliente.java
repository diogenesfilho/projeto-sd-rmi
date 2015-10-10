package cliente.com.br;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import constantes.com.br.Constantes;
import tradutor.com.br.Palavra;
import tradutor.com.br.TradutorInterface;

public class Cliente {

	private static final String HOST = "localhost";
	private static final int PORTA = Constantes.porta;
	private static Registry registro;
	
	public static boolean continua = true;
	
	
	public static void main (String[] args) throws Exception {
		
		registro = LocateRegistry.getRegistry(HOST, PORTA);
		
		TradutorInterface servico = (TradutorInterface) registro.lookup(TradutorInterface.class.getName());
		
		/*
		 * Criar um while pra ficar recebendo várias vezes, talvez uma interface.
		 * Lembrar de colocar lowcase ou uppercase para não causar conflito.
		 */
		
		String palavraPT = "palavra";
		
		Palavra palavra = servico.traducaoPtEn(palavraPT);
		
		System.out.println("Tradução de '" + palavraPT + "' é '" + palavra.getTraducao()+"'.");
		
		System.out.println("Aplicação na frase de  " + palavraPT + " é ' " + palavra.getFraseCom() + " '.");
		

		//System.out.println("Digita a palvara a ser traduzida do português para o inglẽs: ");		
		
	}
}
