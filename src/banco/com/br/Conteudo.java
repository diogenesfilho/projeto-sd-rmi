package banco.com.br;

import tradutor.com.br.Palavra;

public class Conteudo {
	
	private static String[] portuguesP = {"veja", "escrever"};
	private static String[] traducaoEN = {"look", "write"};
	private static String[] aplicacaoFrase = {"Look this notebook","Everyone write once time this"};
	
	public static void preencheBanco (Banco banco) {
		
		for (int i = 0; i < portuguesP.length; i++) {
			Palavra p = new Palavra(portuguesP[i], traducaoEN[i], aplicacaoFrase[i]);
			banco.addObjeto(p);
		}
		
		System.out.println("Dicionário upado!");
	}
}
