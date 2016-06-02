package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimento {

    private int id, id_Categoria, tipo_Lancamento;
    private String titulo, descricao;
    private Date vencimento;
    private Float valor;

    public Movimento() {
    }

    public int getId() {
        return id;
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public int getTipo_Lancamento() {
        return tipo_Lancamento;
    }

    public void setTipo_Lancamento(int tipo_Lancamento) {
        this.tipo_Lancamento = tipo_Lancamento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void setId(int id) {
        this.id = id;
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
}
