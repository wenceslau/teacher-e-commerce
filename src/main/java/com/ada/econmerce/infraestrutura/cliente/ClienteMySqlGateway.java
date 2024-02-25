package com.ada.econmerce.infraestrutura.cliente;

import com.ada.econmerce.domain.cliente.Cliente;
import com.ada.econmerce.domain.cliente.ClienteGateway;

import java.util.List;

public class ClienteMySqlGateway implements ClienteGateway {


    @Override
    public void salvar(Cliente cliente) {

    }

    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public Cliente buscarPorId(String id) {
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return null;
    }
}
