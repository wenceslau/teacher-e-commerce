package com.ada.econmerce.domain.pedido;

import com.ada.econmerce.domain.Identificador;

public class PedidoID extends Identificador<Integer> {

    private static Integer id = 0;

    private Integer valor;

    private PedidoID() {
        id++;
        this.valor = id;
    }

    public static PedidoID criar() {
        return new PedidoID();
    }

    @Override
    public Integer valor() {
        return valor;
    }
}
