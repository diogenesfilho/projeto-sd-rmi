package model.tutorial.org;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String enderecoRua;
	private String enderecoBairro;
	private String enderecoNumero;
	private String telefone;
	
	public Person (String nome, String endercoRua, String endereroBairro, String enderecoNumero, String telefone) {
		this.nome = nome;
		this.enderecoRua = enderecoRua;
		this.enderecoBairro = enderecoBairro;
		this.enderecoNumero = enderecoNumero;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnderecoRua() {
		return enderecoRua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
