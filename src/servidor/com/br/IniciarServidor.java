package servidor.com.br;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import constantes.com.br.Constantes;
import tradutor.com.br.TradutorInterface;

public class IniciarServidor {
	
	private static final int porta = Constantes.porta;
	private static Registry registro;
	
	public static void iniciarRegistro () throws RemoteException{
		registro = LocateRegistry.createRegistry(porta);
	}
	
	public static void registraObjeto (String nome, Remote obj) throws AccessException, RemoteException, AlreadyBoundException{
		registro.bind(nome, obj);
	}
	
	
	public static void main (String[] args) throws Exception{
		
		iniciarRegistro();
		
		registraObjeto(TradutorInterface.class.getName(), new TradutorServicoImp());
		
		System.out.println("Servidor Iniciado!");
	}
}
