package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Cliente;
import com.google.gson.Gson;

@RestController
public class GerenciadorCliente {
	private ArrayList<Cliente> listaClientes;
	public GerenciadorCliente() {
		this.listaClientes = new ArrayList();
		Cliente cliente1 = new Cliente("1","Nacif", "123456789","nacif@nacif" );
		Cliente cliente2 = new Cliente("2","Glaucia ", "147258369","glaucia@glaucia" );
		Cliente cliente3 = new Cliente("3","Daniel", "789456123","daniel@daniel" );
		this.listaClientes.add(cliente1);
		this.listaClientes.add(cliente2);
		this.listaClientes.add(cliente3);
	}
	// IMPLEMENTAR OUTROS MÉTODOS NECESSÁRIOS PARA RECUPERAR INFORMAÇÕES DO CLIENTE
	@RequestMapping(value = "obter/{nome}", method = RequestMethod.GET)
	public Cliente obterClientePorNome(@PathVariable String nome) {
		for(int i=0; i<listaClientes.size();i++) {
			if(this.listaClientes.get(i).getNome().equals(nome)) {
				return this.listaClientes.get(i);
			}
		}
		return null;
	}
	
	@RequestMapping(value = "cliente/getClienteCpfPOST/")
	public String obterClientePorCPFPost(@RequestParam("cpf") String cpf) {
		Gson gson = new Gson();
		
		for(int i=0; i<listaClientes.size();i++) {
			System.out.println(listaClientes.get(i).getCpf()+ " o cpf: " + cpf);
			if(this.listaClientes.get(i).getCpf().equals(cpf)) {
				String respostaJson = gson.toJson(listaClientes.get(i));
				return respostaJson;
			}
		}
		return null;
	}
}
