/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guilhermemn
 */
public class FrequenteDAO {
    
    Connection banco;
    
    
    public int inserir(Frequente f) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = banco.prepareStatement("INSERT INTO categoria (id, lancamento_id, periodo) VALUES (?, ?, ?)");

        stmt.setInt(1, f.getId());
        stmt.setInt(2, f.getLancamento_id());
        stmt.setString(3, f.getPeriodo());
        return stmt.executeUpdate();
    }
    
    public int apagarPeloPeriodo(Frequente f) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("DELETE FROM lancamento_id WHERE periodo LIKE ?");
        stmt.setString(1, "%"+f.getPeriodo()+"%");
        return stmt.executeUpdate();
    }
    
    public int atualizarPeriodo(Frequente f, String periodo) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("UPDATE lancamento_id SET periodo=? WHERE periodo LIKE ?");
        stmt.setString(1, periodo);
        stmt.setString(2, "%"+f.getPeriodo()+"%");
        return stmt.executeUpdate();        
    }
    
    public ArrayList listar() throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("SELECT * FROM lancamento_id");
        ArrayList<Frequente> lista = new ArrayList<Frequente>();
        
        ResultSet resultado = stmt.executeQuery();
        Frequente f;
        while(resultado.next()){
            f = new Frequente();
            f.setId(resultado.getInt("id"));
            f.setLancamento_id(resultado.getInt("lancamento_id"));
            f.setPeriodo(resultado.getString("periodo"));
            lista.add(f);
        }
        
        return lista;
    }
    
}
