package com.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="MsProduto")
public interface InterfaceProduto {
	// Obter todos os produtos cadastrados 
	@RequestMapping( method = RequestMethod.GET, value="/produto/obterProdutos")
	public List obterTodosProdutos();
	
	@RequestMapping( method = RequestMethod.GET, value="/produto/obterProdutoPorId/{id}")
	public Object obterProdutoId(@PathVariable("id") String id);
	
//	@RequestMapping( method = RequestMethod.GET, value="/getProducts")
//	public String getAllProduct();
	
	@RequestMapping( method = RequestMethod.POST, value="/venda/{id}/{qnt}")
	public String updateStock(@PathVariable("id") String[] id, @PathVariable("qnt") String[] qnt);
}
