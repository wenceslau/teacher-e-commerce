package com.ada.econmerce.domain.produto;

import com.ada.econmerce.domain.Identificador;

import java.util.UUID;

public class ProdutoID extends Identificador<Integer> {

    private static Integer id = 0;
    private final Integer valor;

    private ProdutoID() {
        this.id++;
        this.valor = id;
    }

    private ProdutoID(Integer valor) {
        this.valor = valor;
    }

    public static ProdutoID criar(Integer valor) {
        return new ProdutoID(valor);
    }

    public static ProdutoID criar() {
        return new ProdutoID();
    }

    @Override
    public Integer valor() {
        return valor;
    }
}
