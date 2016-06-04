package service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Movimento;
import modelo.MovimentoDAO;

@WebService(serviceName = "Finance")
public class Finance {

    public boolean debugar;

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return *
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
    public String atualizarCategoria(@WebParam(name = "cat") String txt1, String txt2) {
        try {
            Categoria nova = new Categoria();
            nova.setName(txt1);
            CategoriaDAO cat = new CategoriaDAO();
            cat.atualizar(nova, txt2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Inserido");

    }

    @WebMethod(operationName = "listarCategoria")
    public String listarCategoria() {
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

    @WebMethod(operationName = "inserirMovimento")
    public String inserirMovimento(@WebParam(name = "mov") String tit, String desc, String dat, float v, int lan, int cat) throws ParseException {

        try {
            Movimento nova = new Movimento(cat, lan, tit, desc, v);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = df.parse(dat);
            nova.setVencimento(dt);
            MovimentoDAO mov = new MovimentoDAO();
            mov.inserir(nova);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Inserido");
    }

    @WebMethod(operationName = "apagarMovimento")
    public String apagarMovimento(@WebParam(name = "mov") String txt) {
        try {
            Movimento nova = new Movimento();
            nova.setTitulo(txt);
            MovimentoDAO mov = new MovimentoDAO();
            mov.apagarPeloTitulo(nova);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Apagado");
    }

    @WebMethod(operationName = "atualizarMovimento")
    public String atualizarMovimento(@WebParam(name = "mov") String txt1, String txt2) {
        try {
            Movimento nova = new Movimento();
            nova.setTitulo(txt1);
            MovimentoDAO mov = new MovimentoDAO();
            mov.atualizarTitulo(nova, txt2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Inserido");

    }

    @WebMethod(operationName = "listarMovimento")
    public String listarMovimento() {
        String lista = "";
        try {
            Movimento nova = new Movimento();
            MovimentoDAO mov = new MovimentoDAO();
            lista = "\n" + mov.listar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
