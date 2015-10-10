package tradutor.com.br;

import java.io.Serializable;

public class Palavra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String palavra;
	private String traducao;
	private String fraseCom;
	
	public Palavra (String palavra, String traducao, String fraseCom) {
		this.palavra = palavra;
		this.traducao = traducao;
		this.fraseCom = fraseCom;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getTraducao() {
		return traducao;
	}

	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}

	public String getFraseCom() {
		return fraseCom;
	}

	public void setFraseCom(String fraseCom) {
		this.fraseCom = fraseCom;
	}

}
