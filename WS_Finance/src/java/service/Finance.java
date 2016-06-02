package service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Categoria;
import modelo.CategoriaDAO;

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
       
    /**
     *
     * @param txt
     * @param txt
     * @return
     */
    @WebMethod(operationName = "atualizarCategoria")
    public String atualizarCategoria (@WebParam(name = "cat")String txt1, String txt2){
        try {
            Categoria nova = new Categoria();
            nova.setName(txt1);
            CategoriaDAO cat = new CategoriaDAO();
            cat.atualizar(nova, txt2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("Inserido");
        
    }
   @WebMethod(operationName = "listarCategoria")
    public String listarCategoria (){
        String lista = "";
        try {
            //String lista = "";
            Categoria nova = new Categoria();
            //nova.setName(txt);
            CategoriaDAO cat = new CategoriaDAO();
            lista = "\n" + cat.listar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}    
