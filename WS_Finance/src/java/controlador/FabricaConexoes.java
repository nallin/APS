package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guilhermemn
 */
public class FabricaConexoes {
    private String servidor, porta, base, login, senha;
    
    public FabricaConexoes(){
        this.servidor = "localhost";
        this.porta = "3306";
        this.base = "dbFinance";
        this.login = "root";
        this.senha = "root";
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection Conexao() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection("jdbc:mysql://" +this.getServidor()+ ":" + 
                this.getPorta() + "/" + this.getBase(), this.getLogin(), this.getSenha());
    }


}



