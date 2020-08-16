package br.com.etec.sgdga.control;

import java.sql.Date;

public class BasiConta {

    private int id;
    private String nome;//25
    private double valor;
    private Date data;
    private int status;
    private String discr;//45

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDiscr() {
        return discr;
    }

    public void setDiscr(String discr) {
        this.discr = discr;
    }
}