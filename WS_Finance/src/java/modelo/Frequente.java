/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Frequente {
    private int id, id_movimento;
    private String periodo;

    
    public Frequente() {
    }
    
    public int getId() {
        return id;
    }

    public int getId_movimento() {
        return id_movimento;
    }

    public void setId_movimento(int id_movimento) {
        this.id_movimento = id_movimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    
    
}
