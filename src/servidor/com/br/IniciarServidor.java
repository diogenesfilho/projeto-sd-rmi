package servidor.com.br;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Dictionary;
import banco.com.br.Banco;
import banco.com.br.Conteudo;
import constantes.com.br.Constantes;
import tradutor.com.br.Palavra;
import tradutor.com.br.TradutorInterface;

public class IniciarServidor {
	
	private static final int porta = Constantes.porta;
	private static Registry registro;
	
	private static Banco bd;
	
	public static Banco getBanco(){
		return bd;
	}
	
	public static void iniciarRegistro () throws RemoteException{
		registro = LocateRegistry.createRegistry(porta);
	}
	
	public static void registraObjeto (String nome, Remote obj) throws AccessException, RemoteException, AlreadyBoundException{
		registro.bind(nome, obj);
	}
	
	
	public static void main (String[] args) throws Exception{
		
		if(bd == null){
			
			bd = new Banco();	
			
			System.err.println("Banco criado, pois não existia.");
			
			//Teste de inserção e recuperação banco bem sucedido.
			Palavra p1 = new Palavra("aprender", "learn", "I learn English on vacation");
			bd.addObjeto(p1);
			
			Palavra p2 = new Palavra("voar", "fly", "The butterfly can fly");
			bd.addObjeto(p2);
			
			System.out.println("Inseridos no banco!");
			
			Conteudo.preencheBanco(bd);
			
			System.out.println("Tudo executado!");
			
		}else{
			
			System.err.println("Banco já existia!");
		}
		
		iniciarRegistro();
		
		registraObjeto(TradutorInterface.class.getName(), new TradutorServicoImp());
		
		System.out.println("Servidor Iniciado!");
	}
}
