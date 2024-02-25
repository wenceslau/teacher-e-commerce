package com.ada.econmerce.domain.cliente;

public class Cidade {

    private String nome;
    private String uf;

    private Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
        validar();
    }

    public static Cidade criar(String nome, String uf) {
        return new Cidade(nome, uf);
    }

    public String nome() {
        return nome;
    }

    public String uf() {
        return uf;
    }

    private void validar(){
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (uf == null || uf.isEmpty() || uf.length() != 2) {
            throw new IllegalArgumentException("UF inválido");
        }
    }
}
