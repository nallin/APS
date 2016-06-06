package modelo;

import controlador.FabricaConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {
    
    public boolean debugar;
    
    public Connection banco;
    
    public CategoriaDAO() throws ClassNotFoundException, SQLException {
        FabricaConexoes fabrica = new FabricaConexoes();
        banco = fabrica.Conexao();
        debugar = true;
    }
    
    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws SQLException, Throwable {
        try {
            banco.close();
        } finally {
            super.finalize();
        }
    }

    public boolean inserir(Categoria c) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = banco.prepareStatement("INSERT INTO categoria (id_categoria, nome_categoria) VALUES (NULL, ?);");
        stmt.setString(1, c.getName());
        if(debugar) System.out.println("chamado: inserir");
        return stmt.execute();
    }
    
    public int apagarPeloNome(Categoria c) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("DELETE FROM categoria WHERE nome_categoria LIKE ?;");
        stmt.setString(1, "%"+c.getName()+"%");
        return stmt.executeUpdate();
    }
    
    public int atualizar(Categoria c, String name) throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("UPDATE categoria SET nome_categoria=? WHERE nome_categoria LIKE ?;");
        stmt.setString(1, name);
        stmt.setString(2, "%"+c.getName()+"%");
        return stmt.executeUpdate();        
    }
    
    public ArrayList listar() throws SQLException{
        PreparedStatement stmt = banco.prepareStatement("SELECT * FROM categoria;");
        ArrayList<Categoria> lista = new ArrayList<Categoria>();
        
        ResultSet resultado = stmt.executeQuery();
        Categoria p;
        while(resultado.next()){
            p = new Categoria();
            p.setName(resultado.getString("nome_categoria"));
            lista.add(p);
            if(debugar) System.out.println(lista);
        }
        return lista;
    }
}
