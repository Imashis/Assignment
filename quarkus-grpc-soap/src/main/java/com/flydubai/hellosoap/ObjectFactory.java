
package com.flydubai.hellosoap;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.flydubai.hellosoap package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.flydubai.hellosoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloSoapRequest }
     * 
     * @return
     *     the new instance of {@link HelloSoapRequest }
     */
    public HelloSoapRequest createHelloSoapRequest() {
        return new HelloSoapRequest();
    }

    /**
     * Create an instance of {@link HelloSoapResponse }
     * 
     * @return
     *     the new instance of {@link HelloSoapResponse }
     */
    public HelloSoapResponse createHelloSoapResponse() {
        return new HelloSoapResponse();
    }

}
