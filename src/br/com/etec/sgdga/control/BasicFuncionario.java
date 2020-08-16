package br.com.etec.sgdga.control;

import java.sql.Date;

public class BasicFuncionario {

    private int id;
    private String nome;//25
    private String cpf;//15
    private String endereco;//45
    private Date admim;
    private String fixo;//12
    private String celular;//13
    private String Funcao;//15


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the admim
     */
    public Date getAdmim() {
        return admim;
    }

    /**
     * @param admim the admim to set
     */
    public void setAdmim(Date admim) {
        this.admim = admim;
    }

    /**
     * @return the fixo
     */
    public String getFixo() {
        return fixo;
    }

    /**
     * @param fixo the fixo to set
     */
    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the Funcao
     */
    public String getFuncao() {
        return Funcao;
    }

    /**
     * @param Funcao the Funcao to set
     */
    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

   
}
