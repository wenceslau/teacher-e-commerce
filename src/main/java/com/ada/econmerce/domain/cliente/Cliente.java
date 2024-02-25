package com.ada.econmerce.domain.cliente;


import com.ada.econmerce.domain.Identificador;
import com.ada.econmerce.domain.cliente.objetos.CPF;
import com.ada.econmerce.domain.cliente.objetos.Tipo;

public class Cliente {

    private final Identificador id;
    private final Tipo tipo;
    private String nome;
    private String email;
    private Endereco endereco;

    private Cliente(Identificador id, String nome, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;

        if (id instanceof CPF){
            this.tipo = Tipo.FISICA;
        }else{
            this.tipo = Tipo.JURIDICA;
        }
        validar();
    }

    public static Cliente criar(Identificador id, String nome, String email, Endereco endereco) {
        return new Cliente(id, nome, email, endereco);
    }

    public void atualizarEndereco(Endereco novoEndereco){
        this.endereco = novoEndereco;
    }

    public void altearNome(String novoNome) {
        this.nome = novoNome;
    }

    public void alterarEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public Identificador id() {
        return id;
    }

    public Tipo tipo() {
        return tipo;
    }

    public String nome() {
        return nome;
    }

    public String email() {
        return email;
    }

    public Endereco endereco() {
        return endereco;
    }

    private void validar() {
        if (id == null) {
            throw new RuntimeException("ID não pode ser nulo");
        }

        if (nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("Nome não pode ser nulo");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new RuntimeException("Email não pode ser nulo");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
