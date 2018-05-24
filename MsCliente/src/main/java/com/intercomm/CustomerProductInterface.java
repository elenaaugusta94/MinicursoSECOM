package com.intercomm;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="MsProduto")
public interface CustomerProductInterface {
	
	@RequestMapping( method = RequestMethod.GET,value ="/product/getProduct/{id}")
	String getProductID(@PathVariable("id") String id);
	 

}
