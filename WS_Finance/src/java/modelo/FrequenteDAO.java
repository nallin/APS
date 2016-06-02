package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FrequenteDAO {
    
    Connection banco;
  
    public int inserir(Frequente f) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = banco.prepareStatement("INSERT INTO categoria (id, id_movimento, periodo) VALUES (null, ?, ?)");
        stmt.setInt(1, f.getId_movimento());
        stmt.setString(2, f.getPeriodo());
        return stmt.executeUpdate();
    }
    
    public int apagarPeloPeriodo(Frequente f) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("DELETE FROM id_movimento WHERE periodo LIKE ?");
        stmt.setString(1, "%"+f.getPeriodo()+"%");
        return stmt.executeUpdate();
    }
    
    public int atualizarPeriodo(Frequente f, String periodo) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("UPDATE id_movimento SET periodo=? WHERE periodo LIKE ?");
        stmt.setString(1, periodo);
        stmt.setString(2, "%"+f.getPeriodo()+"%");
        return stmt.executeUpdate();        
    }
    
    public ArrayList listar() throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("SELECT * FROM id_movimento");
        ArrayList<Frequente> lista = new ArrayList<Frequente>();
        
        ResultSet resultado = stmt.executeQuery();
        Frequente f;
        while(resultado.next()){
            f = new Frequente();
            f.setId(resultado.getInt("id"));
            f.setId_movimento(resultado.getInt("id_movimento"));
            f.setPeriodo(resultado.getString("periodo"));
            lista.add(f);
        }
        
        return lista;
    }
    
}
