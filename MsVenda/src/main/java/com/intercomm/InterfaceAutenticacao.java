package com.intercomm;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="MsAutenticacao")
public interface InterfaceAutenticacao {
	@RequestMapping( method = RequestMethod.GET, value="/autenticacao/autenticar/{nome}/{senha}")
	public boolean autenticarFuncionario(@PathVariable("nome") String nome, @PathVariable("senha") String senha);
}
