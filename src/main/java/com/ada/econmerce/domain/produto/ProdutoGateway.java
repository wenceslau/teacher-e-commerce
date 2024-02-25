package com.ada.econmerce.domain.produto;

import com.ada.econmerce.domain.cliente.Cliente;

import java.util.List;

public interface ProdutoGateway {

    void salvar(Produto produto);

    void atualizar(Produto produto);

    Produto buscarPorId(Integer id);

    Produto buscarPorDescricao(String descricao);

    List<Produto> buscarTodos();
}
