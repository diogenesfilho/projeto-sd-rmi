package servidor.com.br;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tradutor.com.br.Palavra;
import tradutor.com.br.TradutorInterface;

public class TradutorServicoImp extends UnicastRemoteObject implements TradutorInterface {

	private static final long serialVersionUID = 1L;
	
	protected TradutorServicoImp() throws RemoteException {
		super();
	}

	@Override
	public synchronized Palavra traducaoPtEn(String palavra) throws RemoteException{
		if (palavra.equals("palavra")) {
			return new Palavra ("palavra", "word", "This not a word!");
		}else
			return new Palavra ("sem tradução", "inválido", "não existe");
	}
}
