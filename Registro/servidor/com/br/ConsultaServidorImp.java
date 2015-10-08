package servidor.com.br;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import organiza.com.br.Consulta;

public class ConsultaServidorImp extends UnicastRemoteObject implements Consulta {
	
	
	public ConsultaServidorImp() throws RemoteException {
		super();
	}
	

	@Override
	public synchronized String consultandoPorNome(String nome) throws RemoteException {
		
		//
		
		
		/*
		 * Fazer ele procura no db4o aqui.
		 */
		
		
		
		return null;
	}

}
