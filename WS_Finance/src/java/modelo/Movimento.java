/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guilhermemn
 */
public class Movimento {
    private int id, categoria_id;
    private Boolean tipo_lancamento, conta_fixa;
    private String titulo, descricao;
    private Date vencimento;

    public Boolean getTipo_lancamento() {
        return tipo_lancamento;
    }

    public void setTipo_lancamento(Boolean tipo_lancamento) {
        this.tipo_lancamento = tipo_lancamento;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    private float valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getConta_fixa() {
        return conta_fixa;
    }

    public void setConta_fixa(Boolean conta_fixa) {
        this.conta_fixa = conta_fixa;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the vencimento
     */
    public Date getVencimento() {
        return vencimento;
    }

    /**
     * @return the vencimento
     */
    public String getVencimentoString() {
        String data = new SimpleDateFormat("dd/MM/yyyy").format(this.vencimento);

        return data;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
}
