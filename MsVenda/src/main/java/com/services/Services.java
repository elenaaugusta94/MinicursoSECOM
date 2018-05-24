package com.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.intercomm.InterfaceProduto;

public class Services {
	
	@Autowired
	InterfaceProduto product;
	
	
	public boolean serviceUpdateStock(String ids[], String qtds[]) throws IOException {
        StringBuilder urlParameters = new StringBuilder("");
        urlParameters.append("id=").append(ids[0]);
        for (int i = 1; i < ids.length; i++) {
            urlParameters.append("&id=").append(ids[i]);
        }
        for (int i = 0; i < qtds.length; i++) {
            urlParameters.append("&qt=").append(qtds[i]);
        }
       String result = product.updateStock(ids, qtds);
      	//	Services.callServiceViaPost(linkUpdateStock, urlParameters.toString());
        return result.equalsIgnoreCase("sucess");
    }
}
