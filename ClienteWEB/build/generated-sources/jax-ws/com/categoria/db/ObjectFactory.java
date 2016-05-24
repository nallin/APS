
package com.categoria.db;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.categoria.db package. 
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

    private final static QName _InscatResponse_QNAME = new QName("http://db.categoria.com/", "inscatResponse");
    private final static QName _Inscat_QNAME = new QName("http://db.categoria.com/", "inscat");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.categoria.db
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Inscat }
     * 
     */
    public Inscat createInscat() {
        return new Inscat();
    }

    /**
     * Create an instance of {@link InscatResponse }
     * 
     */
    public InscatResponse createInscatResponse() {
        return new InscatResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InscatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://db.categoria.com/", name = "inscatResponse")
    public JAXBElement<InscatResponse> createInscatResponse(InscatResponse value) {
        return new JAXBElement<InscatResponse>(_InscatResponse_QNAME, InscatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Inscat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://db.categoria.com/", name = "inscat")
    public JAXBElement<Inscat> createInscat(Inscat value) {
        return new JAXBElement<Inscat>(_Inscat_QNAME, Inscat.class, null, value);
    }

}
