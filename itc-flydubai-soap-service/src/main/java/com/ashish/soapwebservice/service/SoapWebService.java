package com.ashish.soapwebservice.service;

import org.apache.camel.Exchange;

import com.ashish.soapwebservice.model.HelloSoapRequest;
import com.ashish.soapwebservice.model.HelloSoapResponse;

public interface SoapWebService {

	public HelloSoapResponse processSoapService(Exchange exchange, HelloSoapRequest helloSoapRequest);

}
