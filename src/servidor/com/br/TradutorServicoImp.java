package servidor.com.br;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import banco.com.br.Banco;
import tradutor.com.br.Palavra;
import tradutor.com.br.TradutorInterface;

public class TradutorServicoImp extends UnicastRemoteObject implements TradutorInterface {

	private Banco bd;
	
	private static final long serialVersionUID = 1L;
	
	protected TradutorServicoImp() throws RemoteException {
		super();
	}

	@Override
	public synchronized Palavra traducaoPtEn(String palavra) throws RemoteException{
		
		bd = IniciarServidor.getBanco();
		
		System.out.println("Função tradução busca banco.");
		
		Palavra retorno;
		
		try{
			retorno = bd.buscarTraducao(palavra);
			System.out.println("Palavra encontrada!");
			
		}catch (Exception e){
			
			e.printStackTrace();
			
			System.err.println("Palavra não existe");
			
			retorno = new Palavra ("sem tradução", "inválido", "não existe");
		}
		
		//bd.close();
		return retorno;
	}

	@Override
	public void enviarTraduçãoPtEn(Palavra palavra) throws RemoteException {
		
		bd = IniciarServidor.getBanco();
		
		try{
			bd.addObjeto(palavra);
			
			System.out.println("Adição bem sucedida!");
			
			//bd.close();
			
		}catch(Exception e){
			System.err.println("Não adicionou no banco.");
		}
	}
}
