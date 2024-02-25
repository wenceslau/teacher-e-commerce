package com.ada.econmerce.domain.pedido;

import com.ada.econmerce.domain.produto.Produto;

import java.math.BigDecimal;

public class ItemPedido {

    private Produto produto;
    private Integer quantidade;
    private BigDecimal valor;

    private ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = produto.preco().multiply(new BigDecimal(quantidade));
        validar();
    }

    public static ItemPedido criar(Produto produto, Integer quantidade) {
        return new ItemPedido(produto, quantidade);
    }

    public Produto produto() {
        return produto;
    }

    public Integer quantidade() {
        return quantidade;
    }

    public BigDecimal valor() {
        return valor;
    }

    public void validar() {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não informado");
        }
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
