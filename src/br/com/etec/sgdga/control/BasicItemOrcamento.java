package br.com.etec.sgdga.control;

public class BasicItemOrcamento {

    private int id;
    private int orcamento;
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
     * @return the valorUni
     */
    public double getValorUni() {
        return valorUni;
    }

    /**
     * @param valorUni the valorUni to set
     */
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

    /**
     * @return the orcamento
     */
    public int getOrcamento() {
        return orcamento;
    }

    /**
     * @param orcamento the orcamento to set
     */
    public void setOrcamento(int orcamento) {
        this.orcamento = orcamento;
    }
}
