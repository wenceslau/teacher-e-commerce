package com.ada.econmerce.domain.produto;

import java.math.BigDecimal;

public class Produto {

    private final ProdutoID id;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;

    private Produto(ProdutoID id, String descricao, BigDecimal preco, Integer estoque) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public static Produto criar(ProdutoID id, String descricao, BigDecimal preco, Integer estoque) {
        return new Produto(id, descricao, preco, estoque);
    }

    public void atualizarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public void atualizarPreco(BigDecimal novoPreco) {
        if (novoPreco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Preço inválido");
        }
        this.preco = novoPreco;
    }

    public void diminuirEstoque(Integer quantidade) {
        if (this.estoque < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }
        this.estoque = this.estoque - quantidade;
    }

    public void aumentarEstoque(Integer quantidade) {
        if (quantidade < 0) {
            throw new RuntimeException("Quantidade inválida");
        }
        this.estoque = this.estoque + quantidade;
    }

    public void decrementarEstoque(){
        if (this.estoque < 1) {
            throw new RuntimeException("Estoque insuficiente");
        }
        this.estoque = this.estoque - 1;
    }

    public ProdutoID id() {
        return id;
    }

    public String descricao() {
        return descricao;
    }

    public BigDecimal preco() {
        return preco;
    }

    public Integer estoque() {
        return estoque;
    }

    public void validar(){
        if (this.estoque == null) {
            throw new RuntimeException("Estoque não deve ser nulo");
        }
        if (this.preco == null || this.preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Preço deve ser maior que 0");
        }
        if (this.descricao == null || this.descricao.isEmpty()) {
            throw new RuntimeException("Descrição não de deve nula ou vazia");
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
