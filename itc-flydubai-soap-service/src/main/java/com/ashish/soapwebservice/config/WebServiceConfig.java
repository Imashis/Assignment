package com.ashish.soapwebservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan(basePackages = "com.ashish.soapwebservice")
public class WebServiceConfig extends WsConfigurerAdapter{

	private static final String CLIENT_XSD_PATH = "xsd/helloSoap.xsd";
	
	@Bean()
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
	    ApplicationContext applicationContext) {
		
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
		
	}
	
	@Bean("helloSoapService")
    public DefaultWsdl11Definition helloWsdl(XsdSchema clientSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setSchema(clientSchema);
        wsdl11Definition.setPortTypeName("ClientPort");
        wsdl11Definition.setLocationUri("http://localhost:8090/ws/helloSoapService");
        wsdl11Definition.setTargetNamespace("http://www.flydubai.com/HelloSoap");
        return wsdl11Definition;
    }
	
	@Bean("clientSchema")
	public SimpleXsdSchema bulkOrderSchema() {
		
		SimpleXsdSchema schema = new SimpleXsdSchema();
		schema.setXsd(new ClassPathResource(CLIENT_XSD_PATH));
		return schema;
		
	}
}
