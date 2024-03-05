package com.ashish.soapwebservice.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

import com.ashish.soapwebservice.model.HelloSoapRequest;
import com.ashish.soapwebservice.model.HelloSoapResponse;

@Service
public class SoapWebServiceImpl implements SoapWebService {
	
	@Override
	public HelloSoapResponse processSoapService(Exchange exchange, HelloSoapRequest helloSoapRequest) {
		HelloSoapResponse helloSoapResponse = new HelloSoapResponse();
		String clientName = helloSoapRequest.getClientName();
		helloSoapResponse.setResponse("Welcome " + clientName);
		return helloSoapResponse;
	}

}
