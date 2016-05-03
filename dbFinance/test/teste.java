
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guilhermemn
 */
public class teste {
    public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException{
        Pessoa p = new Pessoa();
        p.setNome("Anderson");
        p.setEmail("asantos@unicarioca.edu.br");
        p.setCpf("000.000.000-00");
        p.setTelefone("9999-8888");
        p.setSexo(true);
        Date datanascimento = new SimpleDateFormat("yyyy-MM-dd").parse("1974-01-01");
        p.setDatanascimento(datanascimento);
        
        
        PessoaDAO operacao = new PessoaDAO();
        
        int resultado = operacao.inserir(p);
        
        System.out.println(resultado==1?"INSERIU":"NÃO INSERIU");
        
    }
    
}
