package com.ashish.soapwebservice.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.support.builder.Namespaces;
import org.springframework.beans.factory.annotation.Autowired;

import com.ashish.soapwebservice.model.HelloSoapRequest;
import com.ashish.soapwebservice.service.SoapWebService;

public class SoapRoute extends RouteBuilder {
	
	@Autowired
	private SoapWebService soapWebService;
	
	@Override
    public void configure() throws Exception {
		
		JaxbDataFormat jaxb = new JaxbDataFormat();
        jaxb.setContextPath(HelloSoapRequest.class.getPackage().getName()); 
        
        Namespaces ns = new Namespaces();
		ns.add("oep", "http://www.flydubai.com/HelloSoap");
		from("spring-ws:rootqname:{http://www.flydubai.com/HelloSoap}HelloSoapRequest?endpointMapping=#endpointMapping")
        .log("Received SOAP request: ${body}")
        .unmarshal(jaxb)
        .bean(soapWebService,"processSoapService")
        .marshal(jaxb)
		.log("Processed SOAP response: ${body}");
	}
}
