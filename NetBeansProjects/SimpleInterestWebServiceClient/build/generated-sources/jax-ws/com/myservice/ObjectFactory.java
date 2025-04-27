
package com.myservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.myservice package. 
 * <p>An ObjectFactory allows you to programatically 
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

    private final static QName _CalculateSimpleInterest_QNAME = new QName("http://myservice.com/", "calculateSimpleInterest");
    private final static QName _CalculateSimpleInterestResponse_QNAME = new QName("http://myservice.com/", "calculateSimpleInterestResponse");
    private final static QName _Hello_QNAME = new QName("http://myservice.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://myservice.com/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.myservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateSimpleInterest }
     * 
     */
    public CalculateSimpleInterest createCalculateSimpleInterest() {
        return new CalculateSimpleInterest();
    }

    /**
     * Create an instance of {@link CalculateSimpleInterestResponse }
     * 
     */
    public CalculateSimpleInterestResponse createCalculateSimpleInterestResponse() {
        return new CalculateSimpleInterestResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateSimpleInterest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.com/", name = "calculateSimpleInterest")
    public JAXBElement<CalculateSimpleInterest> createCalculateSimpleInterest(CalculateSimpleInterest value) {
        return new JAXBElement<CalculateSimpleInterest>(_CalculateSimpleInterest_QNAME, CalculateSimpleInterest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateSimpleInterestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.com/", name = "calculateSimpleInterestResponse")
    public JAXBElement<CalculateSimpleInterestResponse> createCalculateSimpleInterestResponse(CalculateSimpleInterestResponse value) {
        return new JAXBElement<CalculateSimpleInterestResponse>(_CalculateSimpleInterestResponse_QNAME, CalculateSimpleInterestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
