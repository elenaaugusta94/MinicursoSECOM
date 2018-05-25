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

import com.intercomm.InterfaceAutenticacao;
import com.intercomm.InterfaceCliente;
import com.intercomm.InterfaceProduto;

@Controller
public class GerenciadorVenda {

	@Autowired
	private InterfaceProduto produto;
	
//	 @Autowired
//	 private InterfaceCliente cliente;
	
	@Autowired
	private RestTemplate restTemplate;

	 @Autowired
	 private InterfaceAutenticacao autenticacao;

	public GerenciadorVenda() {
	}

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

	
	@RequestMapping(value="venda/atualizaEstoque/{id}/{quantidade}", method = RequestMethod.GET)
	@ResponseBody
	public String updateListProduto(@PathVariable("id") String id, @PathVariable("quantidade") String quantidade) {
		//String url = "http://MsProduto/produto/atualizaEstoque/";
		String url = "http://MsProduto/produto/atualizaEstoque/";
		LinkedMultiValueMap<String,String> parametros = new LinkedMultiValueMap<String,String>();
		parametros.add("id", id);
		parametros.add("quantidade", quantidade);
		String response = restTemplate.postForObject(url, parametros, String.class);
		return response;
	}
	
	
	
	@RequestMapping(value="venda/getClienteCpfPOST/{cpf}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public String getClienteCPF(@PathVariable("cpf") String cpf) {
		String url = "http://MsCliente/cliente/getClienteCpfPOST/";
		LinkedMultiValueMap<String, String> parametros = new LinkedMultiValueMap<String,String>();
		parametros.add("cpf", cpf);
		String response = restTemplate.postForObject(url, parametros, String.class);
		return response;
	}
	
	
}
