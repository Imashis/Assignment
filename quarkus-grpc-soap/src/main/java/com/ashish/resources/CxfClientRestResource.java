package com.ashish.resources;

import com.flydubai.hellosoap.ClientPort;
import com.flydubai.hellosoap.HelloSoapRequest;
import com.flydubai.hellosoap.HelloSoapResponse;

import io.quarkiverse.cxf.annotation.CXFClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


public class CxfClientRestResource {
	
	@CXFClient("testClient") 
	ClientPort client;
	
    public String soapCall(String clientName) {
		HelloSoapRequest helloSoapRequest = new HelloSoapRequest();
		helloSoapRequest.setClientName(clientName);
		System.out.println(clientName);
		HelloSoapResponse helloSoapResponse = client.helloSoap(helloSoapRequest);
		String response = helloSoapResponse.getResponse();
        return response;
    }
	
}
