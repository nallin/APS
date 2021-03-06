/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.FabricaConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guilhermemn
 */
public class CategoriaDAO {
    
    Connection banco;
    
    public CategoriaDAO() throws ClassNotFoundException, SQLException {
        FabricaConexoes fabrica = new FabricaConexoes();
        banco = fabrica.Conexao();
    }
    
    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws SQLException, Throwable
    {
        try {
            banco.close();
        } finally {
            super.finalize();
        }
    }

    public int inserir(Categoria c) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = banco.prepareStatement("INSERT INTO categoria (id, name) VALUES (?, ?)");

        stmt.setInt(1, c.getId());
        stmt.setString(2, c.getName());
        return stmt.executeUpdate();
    }
    
    public int apagarPeloNome(Categoria c) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("DELETE FROM categoria WHERE name LIKE ?");
        stmt.setString(1, "%"+c.getName()+"%");
        return stmt.executeUpdate();
    }
    
    public int atualizarCategoria(Categoria c, String name) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("UPDATE categoria SET name=? WHERE name LIKE ?");
        stmt.setString(1, name);
        stmt.setString(2, "%"+c.getName()+"%");
        return stmt.executeUpdate();        
    }
    
    public ArrayList listar() throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("SELECT * FROM categoria");
        ArrayList<Categoria> lista = new ArrayList<Categoria>();
        
        ResultSet resultado = stmt.executeQuery();
        Categoria c;
        while(resultado.next()){
            c = new Categoria();
            c.setId(resultado.getInt("id"));
            c.setName(resultado.getString("nome"));
            lista.add(c);
        }
        
        return lista;
    }
}
