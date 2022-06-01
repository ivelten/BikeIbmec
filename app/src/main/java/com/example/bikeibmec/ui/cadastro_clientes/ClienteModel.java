package com.example.bikeibmec.ui.cadastro_clientes;

import java.util.List;

public class ClienteModel {

    private String matricula;
    private String nome;
    private String sobrenome;
    private String sexo;
    private List<String> cursos;
    private String celular;
    private String email;
    private String cartaoBandeira;
    private String cartaoNumero;
    private String cartaoTitular;
    private String cartaoValidade;
    private String cartaoCv;

    public ClienteModel() {
    }

    public ClienteModel(
            String matricula,
            String nome,
            String sobrenome,
            String sexo,
            List<String> cursos,
            String celular,
            String email,
            String cartaoBandeira,
            String cartaoNumero,
            String cartaoTitular,
            String cartaoValidade,
            String cartaoCv
    ) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.cursos = cursos;
        this.celular = celular;
        this.email = email;
        this.cartaoBandeira = cartaoBandeira;
        this.cartaoNumero = cartaoNumero;
        this.cartaoTitular = cartaoTitular;
        this.cartaoValidade = cartaoValidade;
        this.cartaoCv = cartaoCv;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCartaoBandeira() {
        return cartaoBandeira;
    }

    public void setCartaoBandeira(String cartaoBandeira) {
        this.cartaoBandeira = cartaoBandeira;
    }

    public String getCartaoNumero() {
        return cartaoNumero;
    }

    public void setCartaoNumero(String cartaoNumero) {
        this.cartaoNumero = cartaoNumero;
    }

    public String getCartaoTitular() {
        return cartaoTitular;
    }

    public void setCartaoTitular(String cartaoTitular) {
        this.cartaoTitular = cartaoTitular;
    }

    public String getCartaoValidade() {
        return cartaoValidade;
    }

    public void setCartaoValidade(String cartaoValidade) {
        this.cartaoValidade = cartaoValidade;
    }

    public String getCartaoCv() {
        return cartaoCv;
    }

    public void setCartaoCv(String cartaoCv) {
        this.cartaoCv = cartaoCv;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cursos=" + cursos +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", cartaoBandeira='" + cartaoBandeira + '\'' +
                ", cartaoNumero='" + cartaoNumero + '\'' +
                ", cartaoTitular='" + cartaoTitular + '\'' +
                ", cartaoValidade='" + cartaoValidade + '\'' +
                ", cartaoCv='" + cartaoCv + '\'' +
                '}';
    }
}
