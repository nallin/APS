package service;

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
@WebService(serviceName = "Finance")
public class Finance {

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return      *
     */
    @WebMethod(operationName = "inserirCategoria")
    public String inserirCategoria(@WebParam(name = "cat") String txt) {

        try {
            Categoria nova = new Categoria();
            nova.setName(txt);
            CategoriaDAO cat = new CategoriaDAO();
            cat.inserir(nova);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Inserido");

    }

    @WebMethod(operationName = "apagarCategoria")
    public String apagarCategoria(@WebParam(name = "cat") String txt) {

        try {
            Categoria nova = new Categoria();
            nova.setName(txt);
            CategoriaDAO cat = new CategoriaDAO();
            cat.apagarPeloNome(nova);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Apagado");

    }
    /*    
    @WebMethod(operationName = "atualizarCategoria")
    public String atualizarCategoria (@WebParam(name = "cat") String txt){
 
        try {
            Categoria nova = new Categoria();
            nova.setName(txt);
            CategoriaDAO cat = new CategoriaDAO();
            cat.atualizar(nova);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("Inserido");
        
    }    
    @WebMethod(operationName = "listarCategoria")
    public String listarCategoria (@WebParam(name = "cat") String txt){
 
        try {
            Categoria nova = new Categoria();
            nova.setName(txt);
            CategoriaDAO cat = new CategoriaDAO();
            cat.listar(nova);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("Inserido");
     */
}
