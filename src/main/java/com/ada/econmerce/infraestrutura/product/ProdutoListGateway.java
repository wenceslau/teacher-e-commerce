package com.ada.econmerce.infraestrutura.product;

import com.ada.econmerce.domain.cliente.Cliente;
import com.ada.econmerce.domain.cliente.ClienteGateway;
import com.ada.econmerce.domain.produto.Produto;
import com.ada.econmerce.domain.produto.ProdutoGateway;

import java.util.ArrayList;
import java.util.List;

public class ProdutoListGateway implements ProdutoGateway {

    List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvar(Produto cliente) {
        produtos.add(cliente);
    }

    @Override
    public void atualizar(Produto cliente) {
        produtos.remove(cliente);
        produtos.add(cliente);
    }

    @Override
    public Produto buscarPorId(Integer id) {

        for (Produto produto : produtos) {
            if (produto.id().valor().equals(id)) {
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    @Override
    public Produto buscarPorDescricao(String descricao) {
        return produtos.stream()
                .filter(cliente -> cliente.descricao().equals(descricao))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtos;
    }
}
