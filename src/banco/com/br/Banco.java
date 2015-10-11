package banco.com.br;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import tradutor.com.br.Palavra;

public class Banco {
	
	// Em db são guardados os objetos
	private ObjectContainer db;
	
	
	// Criando o banco
	public Banco() {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "db");
	}
	
	// Adicionando no ObjectContainer
	public void addObjeto(Object o){
		db.store(o);
	}

	
	// Listando todos os objetos de determinada classe
	public ObjectSet listaObjeto(Class c){
		ObjectSet lista = db.query(c);
		return lista;
	}
	
	
	// Excluindo determinado objeto
	public void excluirObjeto(Object o){
		db.delete(o);
	}

	
	// Fechando banco
	public void close() {
		db.close();
	}
	
	public Palavra buscarTraducao(String palavra){

		String palavraBuscada = palavra;
		ObjectSet<Palavra> listaDoBanco = db.query(Palavra.class);
		
		for (int i = 0; i < listaDoBanco.size(); i++) {
			if (listaDoBanco.get(i).getPalavra().contains(palavraBuscada)) {
				return listaDoBanco.get(i);
			}
		}
		return null;
		
	} 
}