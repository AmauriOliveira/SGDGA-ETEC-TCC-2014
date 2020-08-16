package br.com.etec.sgdga.control;

public class BasicFornecedor {

    private int id;
    private String nome;//25
    private String disc;//50 
    private String cnpj;//18
    private String endereco;//60
    private int cidade;
    private String cep;//9
    private String email;//25
    private String telefone;//13
    private String site;//30

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the disc
     */
    public String getDisc() {
        return disc;
    }

    /**
     * @param disc the disc to set
     */
    public void setDisc(String disc) {
        this.disc = disc;
    }
}
