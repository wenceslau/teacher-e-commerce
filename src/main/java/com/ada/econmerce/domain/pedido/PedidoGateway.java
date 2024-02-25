package com.ada.econmerce.domain.pedido;

import java.util.List;

public interface PedidoGateway {

    void salvar(Pedido pedido);

    void atualizar(PedidoID id, Pedido pedido);

    void remover(PedidoID id);

    Pedido buscar(Integer id);

    List<Pedido> buscarTodos();
}
