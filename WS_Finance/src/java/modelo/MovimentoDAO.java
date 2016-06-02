package modelo;

import controlador.FabricaConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MovimentoDAO {

    Connection banco;

    public MovimentoDAO() throws ClassNotFoundException, SQLException {
        FabricaConexoes fabrica = new FabricaConexoes();
        banco = fabrica.Conexao();
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

    public int inserir(Movimento m) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = banco.prepareStatement("INSERT INTO movimentos(titulo, descricao, vencimento, valor, "
                + "id_categoria, tipo_lancamento) VALUES(?, ?, ?, ?, ?, ?)");

        java.util.Date data = m.getVencimento();
        java.sql.Date databanco = new java.sql.Date(data.getTime());

        stmt.setString(1, m.getTitulo());
        stmt.setString(2, m.getDescricao());
        stmt.setDate(3, databanco);
        stmt.setFloat(4, m.getValor());
        stmt.setInt(5, m.getId_Categoria());
        stmt.setInt(6, m.getTipo_Lancamento());


        return stmt.executeUpdate();
    }

    public int apagarPeloTitulo(Movimento m) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("DELETE FROM movimentos WHERE titulo LIKE ?");
        stmt.setString(1, "%" + m.getTitulo() + "%");
        return stmt.executeUpdate();
    }

    // ATUALZAÇÃO NO BANCO
    public int atualizarTitulo(Movimento m, String titulo) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET titulo=? WHERE titulo LIKE ?");
        stmt.setString(1, titulo);
        stmt.setString(2, "%" + m.getTitulo() + "%");
        return stmt.executeUpdate();
    }

    public int atualizarDescricao(Movimento m, String descricao) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET descricao=? WHERE titulo LIKE ?");
        stmt.setString(1, descricao);
        stmt.setString(2, "%" + m.getTitulo() + "%");
        return stmt.executeUpdate();
    }

    public int atualizarVencimento(Movimento m, String vencimento) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET vencimento=? WHERE titulo LIKE ?");
        stmt.setString(1, vencimento);
        stmt.setString(2, "%" + m.getTitulo() + "%");
        return stmt.executeUpdate();
    }

    public int atualizarTValor(Movimento m, String valor) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET valor=? WHERE titulo LIKE ?");
        stmt.setString(1, valor);
        stmt.setString(2, "%" + m.getTitulo() + "%");
        return stmt.executeUpdate();
    }

    public int atualizarTipo(Movimento m, String tipo_lancamento) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET tipo_lancamento=? WHERE titulo LIKE ?");
        stmt.setString(1, tipo_lancamento);
        stmt.setString(2, "%" + m.getTitulo() + "%");
        return stmt.executeUpdate();
    }

    // FIM ATUALZAÇÃO NO BANCO    
    public ArrayList listar() throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("SELECT * FROM movimentos");
        ArrayList<Movimento> lista = new ArrayList<Movimento>();

        ResultSet resultado = stmt.executeQuery();
        Movimento m;
        while (resultado.next()) {
            m = new Movimento();
            m.setId(resultado.getInt("id"));
            m.setTitulo(resultado.getString("titulo"));
            m.setDescricao(resultado.getString("descricao"));
            m.setVencimento(resultado.getDate("vencimento"));
            m.setValor(resultado.getFloat("valor"));
            m.setId_Categoria(resultado.getInt("id_categoria"));
            m.setTipo_Lancamento(resultado.getInt("tipo_lancamento"));
            lista.add(m);
        }

        return lista;
    }
}
