package com.ada.econmerce.infraestrutura.pedido;

import com.ada.econmerce.domain.pedido.Pedido;
import com.ada.econmerce.domain.pedido.PedidoGateway;
import com.ada.econmerce.domain.pedido.PedidoID;

import java.util.ArrayList;
import java.util.List;

public class PedidoListGateway implements PedidoGateway {

    List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void atualizar(PedidoID id, Pedido pedido) {
        pedidos.remove(pedido);
        pedidos.add(pedido);
    }

    @Override
    public void remover(PedidoID id) {
        pedidos.remove(id);
    }

    @Override
    public Pedido buscar(Integer id) {
        for (Pedido pedido : pedidos) {
            if (pedido.id().valor().equals(id)) {
                return pedido;
            }
        }
        throw new RuntimeException("Pedido não encontrado");
    }

    @Override
    public List<Pedido> buscarTodos() {
        return pedidos;
    }
}
