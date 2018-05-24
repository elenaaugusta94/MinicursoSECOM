package com.intercomm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class CustomerProductService {

	private String id = "";
	
	@Autowired
	private  CustomerProductInterface product;
	
	public CustomerProductService(){}
	
	@Bean //Bean método somente em classe com anotacao Configuration
	public String getProductsInCustomer(String id) {
		try {
			String produto = product.getProductID("1");//id);
			return produto;
			

		} catch (ArrayIndexOutOfBoundsException e) {

			throw new UnsupportedOperationException("Not supported yet.");

		}

	}


	public CustomerProductInterface getProduct() {
		return product;
	}


	public void setProduct(CustomerProductInterface product) {
		this.product = product;
	}


}
