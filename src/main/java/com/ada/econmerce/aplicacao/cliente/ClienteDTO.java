package com.ada.econmerce.aplicacao.cliente;

import com.ada.econmerce.domain.cliente.objetos.Tipo;

public class ClienteDTO {

    private Tipo tipo;
    private String id;
    private String nome;
    private String email;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public ClienteDTO(Tipo tipo,
                      String id,
                      String nome,
                      String email,
                      String logradouro,
                      String bairro,
                      String cep,
                      String cidade,
                      String estado) {
        this.tipo = tipo;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "ClienteInput{" +
                "tipo=" + tipo +
                ", id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
