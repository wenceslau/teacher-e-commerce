package com.ada.econmerce.infraestrutura.cliente;

import com.ada.econmerce.domain.Identificador;
import com.ada.econmerce.domain.cliente.Cliente;
import com.ada.econmerce.domain.cliente.ClienteGateway;

import java.util.ArrayList;
import java.util.List;

public class ClienteListGateway implements ClienteGateway {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clientes.remove(cliente);
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorId(String id) {

        for (Cliente cliente : clientes) {
            if (cliente.id().toString().equals(id)) {
                return cliente;
            }
        }

        throw new RuntimeException("Cliente não encontrado");
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clientes;
    }
}
