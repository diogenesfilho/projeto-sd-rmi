package organiza.com.br;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Consulta extends Remote {
	
	public String consultandoPorNome (String nome) throws RemoteException;
	
}
