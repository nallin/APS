package service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    //Categoria
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
        String result  = "";
        try {
            
            Categoria nova = new Categoria();
            nova.setName(txt);
            CategoriaDAO cat = new CategoriaDAO();
            cat.apagarPeloNome(nova);
            result = "Categoria apagada!";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            result = "A categoria não pode ser apagada, pois está sendo associada a um movimento!";
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

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
            CategoriaDAO cat = new CategoriaDAO();
            lista = "\n" + cat.listar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    //Movimento / Frequente
    @WebMethod(operationName = "inserirMovimento")
    public String inserirMovimento(@WebParam(name = "mov") String tit, String desc, String dat, float v, int lan, int cat, String periodo) throws ParseException {
        try {
            Movimento nova = new Movimento(cat, lan, tit, desc, v, periodo);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = df.parse(dat);
            nova.setVencimento(dt);
            MovimentoDAO mov = new MovimentoDAO();          
            mov.inserir(nova);
            mov.Periodo(nova);
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

    @WebMethod(operationName = "atualizarTituloMovimento")
    public String atualizarTitulo(@WebParam(name = "mov") String txt1, String txt2) {
        try {
            Movimento nova = new Movimento();
            nova.setTitulo(txt1);
            MovimentoDAO mov = new MovimentoDAO();
            mov.atualizarTitulo(nova, txt2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Atualizado titulo");
    }
    
    @WebMethod(operationName = "atualizarDescriçãoMovimento")
    public String atualizarDescrição(@WebParam(name = "mov") String txt1, String txt2) {
        try {
            Movimento nova = new Movimento();
            nova.setDescricao(txt1);
            MovimentoDAO mov = new MovimentoDAO();
            mov.atualizarDescricao(nova, txt2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Atualizado descrição");
    }
    
    @WebMethod(operationName = "atualizarValorMovimento")
    public String atualizarValor(@WebParam(name = "mov") float txt1, float txt2) {
        try {
            Movimento nova = new Movimento();
            nova.setValor(txt1);
            MovimentoDAO mov = new MovimentoDAO();
            mov.atualizarValor(nova, txt2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Atualizado valor");
    }

    @WebMethod(operationName = "listarTituloMovimento")
    public String listarTitulo() {
        String listaTitulo = "";
        try { 
            MovimentoDAO mov = new MovimentoDAO();
            listaTitulo = "\n" + mov.listarTituloMovimento();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTitulo;
    } 

    @WebMethod(operationName = "listarDescricaoMovimento")
    public String listarDescricao() {
        String listaDescricao = "";
        try { 
            MovimentoDAO mov = new MovimentoDAO();
            listaDescricao = "\n" + mov.listarDescricaoMovimento();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDescricao;
    }
    
    @WebMethod(operationName = "listarVencimentoMovimento")
    public String listarVencimento() {
        String listarVencimento = "";
        try { 
            MovimentoDAO mov = new MovimentoDAO();
            listarVencimento = "\n" + mov.listarVencimentoMovimento();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarVencimento;
    }
    
    @WebMethod(operationName = "listarValorMovimento")
    public String listarValor() {
        String listarValor = "";
        try { 
            MovimentoDAO mov = new MovimentoDAO();
            listarValor = "\n" + mov.listarValorMovimento();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarValor;
    }
    
    @WebMethod(operationName = "Saldo")
        public String listarSaldo() {
        String lista = "";
        try {
            Movimento nova = new Movimento();
            MovimentoDAO mov = new MovimentoDAO();
            lista = "\n" + mov.listarSaldo();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }  
        
  @WebMethod(operationName = "SaldoInicial")
    public String SaldoInicial(@WebParam(name = "mov") float v) throws ParseException { 
        try {
            Movimento nova = new Movimento(v);
            MovimentoDAO mov = new MovimentoDAO();          
            mov.SaldoInicial(nova);
         
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("Inserido");
    }
}