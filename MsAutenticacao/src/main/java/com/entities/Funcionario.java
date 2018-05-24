package com.entities;

public class Funcionario {

	private String id;
	private String nome;
	private String senha;
	public Funcionario(String id, String usuario, String senha) {
		super();
		this.id = id;
		this.nome = usuario;
		this.senha = senha;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String usuario) {
		this.nome = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
