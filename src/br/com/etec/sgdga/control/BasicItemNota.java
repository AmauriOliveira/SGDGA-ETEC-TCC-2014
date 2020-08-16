package br.com.etec.sgdga.control;

public class BasicItemNota {

    private int id;
    private int nota;
    private int produto;
    private int quantidade;
    private double valorUni;
    private double subTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUni() {
        return valorUni;
    }


    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
