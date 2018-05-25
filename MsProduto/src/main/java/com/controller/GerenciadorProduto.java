package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Produto;


@RestController
public class GerenciadorProduto {
	private ArrayList<Produto>listaProdutos;
	public GerenciadorProduto() {
		this.listaProdutos = new ArrayList<>();
		Produto p1 = new Produto("1", "Notebook", 1000.00f, 10, "Muito rápido");
		Produto p2 = new Produto("2", "Celular", 1300.00f, 2, "Android");
		Produto p3 = new Produto("3", "Relogio", 500.00f, 1, "Luxuoso");
		this.listaProdutos.add(p1);
		this.listaProdutos.add(p2);
		this.listaProdutos.add(p3);
	}
	@RequestMapping(value = "produto/obterQuantidadeProduto/{nome}", method = RequestMethod.GET)
	private int verificaDisponibilidade(@PathVariable String nome) {
		for(int i=0;i<this.listaProdutos.size();i++) {
			if(this.listaProdutos.get(i).getNome().equals(nome)) {
				return this.listaProdutos.get(i).getQuantidade();
			}
		}
		return -1;
	}
	@RequestMapping(value = "produto/atualizaEstoque/", method = {RequestMethod.GET, RequestMethod.POST})
	private String atualizaEstoque(@RequestParam("id") String id, @RequestParam("quantidade") String quantidade) {
		int quant = Integer.parseInt(quantidade);
		System.err.println("Produto id: " + id + " quantidade: " + quantidade);
		for(int i=0;i<this.listaProdutos.size();i++) {
			if(this.listaProdutos.get(i).getId().equals(id)) {
				int qntAtual = this.listaProdutos.get(i).getQuantidade();
				if(qntAtual > 0) {
					this.listaProdutos.get(i).setQuantidade(qntAtual - quant);
					return "Sucesso!";
				}
				else if(qntAtual-quant<0) {
					return "Nao eh possivel vender essa quantidade!";
				}
				
			}
		}
		return "Produto indisponivel!";
	}
	@RequestMapping(value = "produto/obterProdutos", method = RequestMethod.GET)
	private ArrayList<Produto> mostrarTodosProdutos(){
		return this.listaProdutos;
	}
}
