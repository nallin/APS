/* 
*  Autor - Adriano
*  Java - 2016-05-01 09:11:00
*  
*  MODEL CLASSES FOR dbFinance DATABASE
*/ 



/* Movimentos.java -------------------------------------*/
package com.package.dbFinance.model; 

import java.util.*;
import java.sql.*;
import java.text.*;

/* 
*  Java - Model Class - dbFinance.movimentos
*  2016-04-26 07:52:15
*/ 
public class Movimentos {

    // private members 
    private int m_id;
    private String m_titulo;
    private String m_descricao;
    private java.sql.Date m_vencimento;
    private double m_valor;
    private int m_categoria_id;
    private boolean m_tipo_lancamento;
    private boolean m_conta_fixa;


    /**
    * Constructor
    * 
    * Example: 
    * Movimentos myMovimentos = new Movimentos();
    */
    public Movimentos() {
        //--
    }

    /**
    * Constructor
    * 
    * Example: 
    * Movimentos myMovimentos = new Movimentos( val1, val2,.. );
    */
    public Movimentos(int id, String titulo, String descricao, java.sql.Date vencimento, double valor, int categoria_id, boolean tipo_lancamento, boolean conta_fixa) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setVencimento(vencimento);
        this.setValor(valor);
        this.setCategoria_id(categoria_id);
        this.setTipo_lancamento(tipo_lancamento);
        this.setConta_fixa(conta_fixa);
    }


    /**
    * Getters and Setters
    */

    public int getId() {
        return this.m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public String getTitulo() {
        return this.m_titulo;
    }

    public void setTitulo(String titulo) {
        this.m_titulo = titulo;
    }

    public String getDescricao() {
        return this.m_descricao;
    }

    public void setDescricao(String descricao) {
        this.m_descricao = descricao;
    }

    public java.sql.Date getVencimento() {
        return this.m_vencimento;
    }

    public void setVencimento(java.sql.Date vencimento) {
        this.m_vencimento = vencimento;
    }

    public double getValor() {
        return this.m_valor;
    }

    public void setValor(double valor) {
        this.m_valor = valor;
    }

    public int getCategoria_id() {
        return this.m_categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.m_categoria_id = categoria_id;
    }

    public boolean getTipo_lancamento() {
        return this.m_tipo_lancamento;
    }

    public void setTipo_lancamento(boolean tipo_lancamento) {
        this.m_tipo_lancamento = tipo_lancamento;
    }

    public boolean getConta_fixa() {
        return this.m_conta_fixa;
    }

    public void setConta_fixa(boolean conta_fixa) {
        this.m_conta_fixa = conta_fixa;
    }



    /**
    * Methods
    */

    @Override
    public String toString() {
        return "";
    }

}



/* Categoria.java -------------------------------------*/
package com.package.dbFinance.model; 

import java.util.*;
import java.sql.*;
import java.text.*;

/* 
*  Java - Model Class - dbFinance.categoria
*  2016-04-26 07:52:27
*/ 
public class Categoria {

    // private members 
    private int m_id;
    private String m_name;


    /**
    * Constructor
    * 
    * Example: 
    * Categoria myCategoria = new Categoria();
    */
    public Categoria() {
        //--
    }

    /**
    * Constructor
    * 
    * Example: 
    * Categoria myCategoria = new Categoria( val1, val2,.. );
    */
    public Categoria(int id, String name) {
        this.setId(id);
        this.setName(name);
    }


    /**
    * Getters and Setters
    */

    public int getId() {
        return this.m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public String getName() {
        return this.m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }



    /**
    * Methods
    */

    @Override
    public String toString() {
        return "";
    }

}



/* Lanc_freq.java -------------------------------------*/
package com.package.dbFinance.model; 

import java.util.*;
import java.sql.*;
import java.text.*;

/* 
*  Java - Model Class - dbFinance.lanc_freq
*  2016-04-26 08:04:35
*/ 
public class Lanc_freq {

    // private members 
    private int m_id;
    private int m_lancamento_id;
    private String m_periodo;


    /**
    * Constructor
    * 
    * Example: 
    * Lanc_freq myLanc_freq = new Lanc_freq();
    */
    public Lanc_freq() {
        //--
    }

    /**
    * Constructor
    * 
    * Example: 
    * Lanc_freq myLanc_freq = new Lanc_freq( val1, val2,.. );
    */
    public Lanc_freq(int id, int lancamento_id, String periodo) {
        this.setId(id);
        this.setLancamento_id(lancamento_id);
        this.setPeriodo(periodo);
    }


    /**
    * Getters and Setters
    */

    public int getId() {
        return this.m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public int getLancamento_id() {
        return this.m_lancamento_id;
    }

    public void setLancamento_id(int lancamento_id) {
        this.m_lancamento_id = lancamento_id;
    }

    public String getPeriodo() {
        return this.m_periodo;
    }

    public void setPeriodo(String periodo) {
        this.m_periodo = periodo;
    }



    /**
    * Methods
    */

    @Override
    public String toString() {
        return "";
    }

}