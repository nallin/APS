/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.dbfinance;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Categoria;
import modelo.CategoriaDAO;

/**
 *
 * @author amoreira
 */
@WebService(serviceName = "WebServiceServidor")
public class WebServiceServidor {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     * @throws java.lang.ClassNotFoundException
     */
    @WebMethod(operationName = "InserirCat")
    public String cat(@WebParam(name = "categoria") String txt) throws ClassNotFoundException {
        try {
            Categoria cat = new Categoria(txt);
            CategoriaDAO nv = new CategoriaDAO ();
            nv.inserir(cat);
            
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("inserido");
    }
    
    @WebMethod(operationName = "deletarCat")
    public String dcat(@WebParam(name = "categoria") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "updateCat")
    public String ucat(@WebParam(name = "categoria") String txt) {
        return "Hello " + txt + " !";
    }
    
    
    
    
}
