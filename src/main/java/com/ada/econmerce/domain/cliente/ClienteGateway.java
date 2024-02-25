package com.ada.econmerce.domain.cliente;

import com.ada.econmerce.domain.Identificador;

import java.util.List;

public interface ClienteGateway {

    void salvar(Cliente cliente);

    void atualizar(Cliente cliente);

    Cliente buscarPorId(String id);

    List<Cliente> buscarTodos();
}
