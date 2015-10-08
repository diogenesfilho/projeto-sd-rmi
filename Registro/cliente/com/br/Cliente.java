package cliente.com.br;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import organiza.com.br.Constantes;

public class Cliente {
	
    private static final String HOST = "localhost";
    private static final int PORT = Constantes.porta;
    private static Registry registry;
	
	 public static void main(String[] args) throws Exception {
		 
	        // Procurando o registro no host e porta específicos.
	        registry = LocateRegistry.getRegistry(HOST, PORT);
		 
		 
		 
	 }

}
