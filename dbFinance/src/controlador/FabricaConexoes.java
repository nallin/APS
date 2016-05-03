/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        this.servidor = "127.0.0.1";
        this.porta = "3306";
        this.base = "dbFinance";
        this.login = "root";
        this.senha = "root";
    }
    
    public Connection Conexao() throws ClassNotFoundException, SQLException
    {
        return (Connection) DriverManager.getConnection("jdbc:mysql://" +getServidor()+ ":"+ 
                getPorta() +"/" + getBase(), getLogin(), getSenha());
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




}



