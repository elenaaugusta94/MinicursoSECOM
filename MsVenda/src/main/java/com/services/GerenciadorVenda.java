package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.intercomm.InterfaceAutenticacao;
import com.intercomm.InterfaceCliente;
import com.intercomm.InterfaceProduto;

@Controller
public class GerenciadorVenda {

	@Autowired
	private InterfaceProduto produto;
	//
	 @Autowired
	 private InterfaceCliente cliente;
	//
	
	@Autowired
	private RestTemplate restTemplate;

	 @Autowired
	 private InterfaceAutenticacao autenticacao;

	public GerenciadorVenda() {
	}

	/**
	 * 
	 * Retorna os produtos atraves do product feign como uma string JSON
	 * 
	 * @return
	 */
	@RequestMapping(value = "venda/getProdutos", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList getProducts() {
		String url = "http://MsProduto/produto/obterProdutos";
		ArrayList response = restTemplate.getForObject(url, ArrayList.class);
		return response;
	}

	@RequestMapping(value = "venda/getProdutosFeign", method = RequestMethod.GET)
	@ResponseBody
	public List getProdutosFeign() {
		return produto.obterTodosProdutos();
	}

	@RequestMapping(value = "venda/getProdutoID/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object getProdutoIDFeign(@PathVariable String id) {
		return produto.obterProdutoId(id);
	}

	@RequestMapping(value="venda/autenticacaoRest/{user}/{senha}", method = RequestMethod.GET)
	@ResponseBody
	public boolean getAutenticacao(@PathVariable("user") String user, @PathVariable("senha") String senha) {
		String url = "http://MsAutenticacao/autenticacao/autenticarPOST/";
		LinkedMultiValueMap<String, String> parametros = new LinkedMultiValueMap<String,String>();
		parametros.add("nome", user);
		parametros.add("senha", senha);
		boolean response = restTemplate.postForObject(url, parametros, Boolean.class);
		return response;
	}
	
	@RequestMapping(value= "venda/autenticacao/{user}/{senha}",  method = RequestMethod.GET)
	@ResponseBody
	public boolean getAutenticacaoFeign(@PathVariable("user") String user, @PathVariable("senha") String senha) {
		System.err.println("User: " + user + "Senha: " + senha);
		return autenticacao.autenticarFuncionario(user, senha);
	}
	
	@RequestMapping(value="venda/getClienteCpfPOST/{cpf}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public String getClienteCPF(@PathVariable("cpf") String cpf) {
		String url = "http://MsCliente/cliente/getClienteCpfPOST/";
		LinkedMultiValueMap<String, String> parametros = new LinkedMultiValueMap<String,String>();
		parametros.add("cpf", cpf);
		String response = restTemplate.postForObject(url, parametros, String.class);
//		Gson g = new Gson();
//		return g.toJsonTree(response);
		return response;
	}
	
	@RequestMapping(value= "venda/getClienteCPF/{cpf}",  method = RequestMethod.GET)
	@ResponseBody
	public Object getClienteFeign(@PathVariable("cpf") String cpf) {
		System.err.println("Cpf: " + cpf);
		return cliente.getClientePorCpf(cpf);
	}
}
