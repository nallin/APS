package modelo;

import controlador.FabricaConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MovimentoDAO {

    Connection banco;
    boolean debugar = true;

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
                + "id_categoria, tipo_lancamento, periodo) VALUES(?, ?, ?, ?, ?, ?, ?)");
        java.util.Date data = m.getVencimento();
        java.sql.Date databanco = new java.sql.Date(data.getTime());

        stmt.setString(1, m.getTitulo());
        stmt.setString(2, m.getDescricao());
        stmt.setDate(3, databanco);
        stmt.setFloat(4, m.getValor());
        stmt.setInt(5, m.getId_Categoria());
        stmt.setInt(6, m.getTipo_Lancamento());
        stmt.setString(7, m.getPeriodo());

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
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET descricao=? WHERE descricao LIKE ?");
        stmt.setString(1, descricao);
        stmt.setString(2, "%" + m.getDescricao() + "%");
        return stmt.executeUpdate();
    }

    public int atualizarVencimento(Movimento m, String vencimento) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET vencimento=? WHERE vencimento LIKE ?");
        stmt.setString(1, vencimento);
        stmt.setString(2, "%" + m.getVencimento() + "%");
        return stmt.executeUpdate();
    }

    public int atualizarValor(Movimento m, float valor) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET valor=? WHERE valor LIKE ?");
        stmt.setFloat(1, valor);
        stmt.setString(2, "%" + m.getValor() + "%");
        return stmt.executeUpdate();
    }

    public int atualizarTipo(Movimento m, String tipo_lancamento) throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET tipo_lancamento=? WHERE tipo_lancamento LIKE ?");
        stmt.setString(1, tipo_lancamento);
        stmt.setString(2, "%" + m.getTipo_Lancamento() + "%");
        return stmt.executeUpdate();
    }
    
    public int atualizarPeriodo(Movimento m, String periodo) throws SQLException {
        
        PreparedStatement stmt = banco.prepareStatement("UPDATE movimentos SET periodo=? WHERE id_movimento = ?");
        stmt.setString(1, periodo);
        stmt.setString(2, "%" + m.getId() + "%");
        
        return stmt.executeUpdate();
    }
    
    // FIM ATUALIZAÇÃO NO BANCO  
    
    // LISTAR O BANCO 
    public ArrayList listarTituloMovimento() throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("SELECT TITULO FROM movimentos");
        ArrayList<Movimento> lista_titulo = new ArrayList<Movimento>();
        
        ResultSet resultado = stmt.executeQuery();
        Movimento t_m;
        while (resultado.next()) {
            t_m = new Movimento();
            t_m.setTitulo(resultado.getString("titulo"));
            lista_titulo.add(t_m);
            if(debugar) System.out.println(lista_titulo);//teste no servidor
        }
        return lista_titulo;
    }
    
    public ArrayList listarDescricaoMovimento() throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("SELECT DESCRICAO FROM movimentos");
        ArrayList<Movimento> lista_descricao = new ArrayList<Movimento>();
        
        ResultSet resultado = stmt.executeQuery();
        Movimento t_d;
        while (resultado.next()) {
            t_d = new Movimento();
            t_d.setTitulo(resultado.getString("Descricao"));
            lista_descricao.add(t_d);
            if(debugar) System.out.println(lista_descricao);//teste no servidor
        }
        return lista_descricao;
    }
    
    public ArrayList listarVencimentoMovimento() throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("SELECT VENCIMENTO FROM movimentos");
        ArrayList<Movimento> lista_vencimento = new ArrayList<Movimento>();
        
        ResultSet resultado = stmt.executeQuery();
        Movimento t_ve;
        while (resultado.next()) {
            t_ve = new Movimento();
            t_ve.setTitulo(resultado.getString("Vencimento"));
            lista_vencimento.add(t_ve);
            if(debugar) System.out.println(lista_vencimento);//teste no servidor
        }
        return lista_vencimento;
    }
    
    public ArrayList listarValorMovimento() throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("SELECT VALOR FROM movimentos");
        ArrayList<Movimento> lista_valor = new ArrayList<Movimento>();
        
        ResultSet resultado = stmt.executeQuery();
        Movimento t_va;
        while (resultado.next()) {
            t_va = new Movimento();
            t_va.setTitulo(resultado.getString("Valor"));
            lista_valor.add(t_va);
            if(debugar) System.out.println(lista_valor);//teste no servidor
        }
        return lista_valor;
    }
    
    public float listarSaldo() throws SQLException {
        PreparedStatement stmt = banco.prepareStatement("SELECT (( SELECT sum(valor) as Disponivel from movimentos WHERE tipo_lancamento=1)\n"
                + "-(SELECT sum(valor) as Disponivel from movimentos WHERE tipo_lancamento=0)) as DISPONIVEL FROM movimentos GROUP BY DISPONIVEL;");

        ResultSet resultado = stmt.executeQuery();
        Movimento m;
        m = new Movimento();
        resultado.next();
        m.setValor(resultado.getFloat("Disponivel"));
        return (m.getValor());
    }
    // FIM DO LISTAR O BANCO
    
    //PERIODO
    public String Periodo(Movimento m) throws SQLException, ClassNotFoundException {
        /*PreparedStatement stmt = banco.prepareStatement("SELECT * FROM movimentos WHERE periodo > 0");
        ResultSet resultado = stmt.executeQuery();
        
        Movimento m;
        resultado.next();
        m = new Movimento();
        m.setId(resultado.getInt("id_movimento"));
        m.setTitulo(resultado.getString("titulo"));
        m.setDescricao(resultado.getString("descricao"));
        m.setVencimento(resultado.getDate("vencimento"));
        m.setValor(resultado.getFloat("valor"));
        m.setId_Categoria(resultado.getInt("id_categoria"));
        m.setTipo_Lancamento(resultado.getInt("tipo_lancamento"));*/
        
        int x = 0;
        x = Integer.parseInt(m.getPeriodo());
            
            m.getVencimento();
            Date d = new Date();
            Calendar c = Calendar.getInstance();
            d = m.getVencimento();
            c.setTime(d);
            c.add(Calendar.DAY_OF_YEAR, x);
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
             d = c.getTime();
             x = x - 1;
             //x = Integer.toString(x);
             m.setVencimento(d);
             m.setPeriodo(null);
             inserir(m);
             //x = x+1;
          
           
            /*Date d= new Date();
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_YEAR,5 );//adicionamos 5 dias a data aual
            , c.add(Calendar.MONTH,3 );//adicionamos 3 mêses a data atual
            c.add(Calendar.YEAR,1 );//adicionamos 1 ano a data atual*/
            if(debugar) System.out.println(d + "ooooooooooo");//teste no servidor
            
        
        /* stmt = banco.prepareStatement("SELECT vencimento FROM movimentos WHERE periodo > 0");
        
        resultado = stmt.executeQuery();
        while (resultado.next()){
        m = new Movimento();
        m.setVencimento(resultado.getDate("vencimento"));
        m.getDate();
        }*/
           // Date d = new Date();
            //Calendar c = Calendar.getInstance();
           // c.setTime(d);
            //c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)+ p);
           // c.set(Calendar.MONTH, c.get(Calendar.MONTH));
            //c.set(Calendar.YEAR, c.get(Calendar.YEAR));
           // System.out.print(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
         
        return ("inserido periodo");
    }
    
    public float SaldoInicial(Movimento m) throws SQLException{
         PreparedStatement stmt = banco.prepareStatement("INSERT INTO movimentos(titulo, descricao, vencimento, valor, "
                + "id_categoria, tipo_lancamento, periodo) VALUES(?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, "Saldo Inicial");
        stmt.setString(2, null);
        stmt.setDate(3, null);
        stmt.setFloat(4, m.getValor());
        stmt.setInt(5, 1);
        stmt.setInt(6, 0);
        stmt.setString(7, null);

        return stmt.executeUpdate();
    }
}
