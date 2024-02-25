package com.ada.econmerce.domain.cliente;

import com.ada.econmerce.domain.cliente.objetos.CEP;

public class Endereco {

    private final CEP cep;
    private final String logradouro;
    private final String bairro;
    private final Cidade cidade;

    private Endereco(CEP cep, String logradouro, String bairro, Cidade cidade) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public static Endereco criar(CEP cep, String logradouro, String bairro, Cidade cidade) {
        return new Endereco(cep, logradouro, bairro, cidade);
    }

    public CEP cep() {
        return cep;
    }

    public String logradouro() {
        return logradouro;
    }

    public String bairro() {
        return bairro;
    }

    public Cidade cidade() {
        return cidade;
    }

    public void validar(){
       if (logradouro == null || logradouro.isBlank()) {
           throw new IllegalArgumentException("O logradouro deve ser informado");
       }
       if (bairro == null || bairro.isBlank()) {
           throw new IllegalArgumentException("O bairro deve ser informado");
       }
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep=" + cep +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
