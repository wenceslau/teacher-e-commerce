package com.ada.econmerce.aplicacao.product;

import com.ada.econmerce.domain.produto.Produto;
import com.ada.econmerce.domain.produto.ProdutoGateway;
import com.ada.econmerce.domain.produto.ProdutoID;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoAplicacao {

    private final ProdutoGateway gateway;

    public ProdutoAplicacao(ProdutoGateway gateway) {
        this.gateway = gateway;
    }

    public void incluir(
            String descricao,
            BigDecimal preco,
            Integer estoque
    ) {

        ProdutoID idValido = ProdutoID.criar();

        Produto novoProduto = Produto
                .criar(idValido, descricao, preco, estoque);

        novoProduto.validar();

        gateway.salvar(novoProduto);

    }

    public void atualizarProduto(Integer produtoID, String descricao, BigDecimal preco) {

        Produto produto = gateway.buscarPorId(produtoID);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }

        produto.atualizarDescricao(descricao);
        produto.atualizarPreco(preco);
        gateway.atualizar(produto);

    }

    public void diminuirEstoque(Integer produtoID, Integer quantidade) {
        Produto produto = gateway.buscarPorId(produtoID);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }
        produto.diminuirEstoque(quantidade);
        gateway.atualizar(produto);
    }

    public void aumentarEstoque(Integer produtoID, Integer quantidade) {
        Produto produto = gateway.buscarPorId(produtoID);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }
        produto.aumentarEstoque(quantidade);
        gateway.atualizar(produto);
    }

    public void decrementarEstoque(Integer produtoID) {
        Produto produto = gateway.buscarPorId(produtoID);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }
        produto.decrementarEstoque();
        gateway.atualizar(produto);
    }

    public Produto buscar(Integer produtoID) {
        return gateway.buscarPorId(produtoID);
    }

    public List<Produto> buscarTodos() {
        return gateway.buscarTodos();
    }

}
