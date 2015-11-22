package tradutor.com.br;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TradutorInterface extends Remote{

	public Palavra traducaoPtEn (String palavra) throws RemoteException;
	public void enviarTraduçãoPtEn (Palavra palavra) throws RemoteException;
	
}
