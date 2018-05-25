package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Funcionario;

@RestController
public class GerenciadorFuncionario {
	private ArrayList<Funcionario>listaFuncionarios;
	
	public GerenciadorFuncionario() {
		this.listaFuncionarios = new ArrayList<>();
		
    	Funcionario f2 = new Funcionario("2", "Augusto Cesar", "147");
    	Funcionario f3 = new Funcionario("3", "Danilo o Furao", "171");
    	Funcionario f1 = new Funcionario("1", "Elena", "123");
    	this.listaFuncionarios.add(f2);
    	this.listaFuncionarios.add(f3);
    	this.listaFuncionarios.add(f1);
	}
	// recuperar as informações de um determinado funcionario;
	
	@RequestMapping(value = "autenticacao/autenticar/{nome}/{senha}", method = RequestMethod.GET)
	@ResponseBody
	public boolean autenticarFuncionario(@PathVariable String nome, @PathVariable String senha) {
		for(int i=0; i<this.listaFuncionarios.size();i++) {
			if(this.listaFuncionarios.get(i).getNome().equals(nome)) {
				if(this.listaFuncionarios.get(i).getSenha().equals(senha)) {
					return true;
				}
			}
		}
		return false;
	}
}
