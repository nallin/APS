package com.categoria.db;

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
 * @author Desktop
 */
@WebService(serviceName = "NovoWebService")
public class NovoWebService {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
    
     */
    @WebMethod(operationName = "inscat")
    public String inserircat (@WebParam(name = "cat") String txt){
 
        try {
            Categoria nova = new Categoria();
            nova.setName(txt);
            CategoriaDAO cat = new CategoriaDAO();
            cat.inserir(nova);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NovoWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("Inserido");
        
    }
    /*  @WebMethod(operationName = "updcat")
    public String atualizarcat (@WebParam(name = "cat") String txt){
    
    try {
    Categoria nova = new Categoria();
    nova.setName(txt);
    CategoriaDAO cat = new CategoriaDAO();
    cat.inserir(nova);
    } catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(NovoWebService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return("Inserido");*/
        
    
}
