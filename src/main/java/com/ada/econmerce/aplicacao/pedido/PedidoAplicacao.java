package com.ada.econmerce.aplicacao.pedido;

import com.ada.econmerce.domain.cliente.Cliente;
import com.ada.econmerce.domain.cliente.ClienteGateway;
import com.ada.econmerce.domain.pedido.ItemPedido;
import com.ada.econmerce.domain.pedido.Pedido;
import com.ada.econmerce.domain.pedido.PedidoGateway;
import com.ada.econmerce.domain.pedido.PedidoID;
import com.ada.econmerce.domain.produto.Produto;
import com.ada.econmerce.domain.produto.ProdutoGateway;
import com.ada.econmerce.domain.produto.ProdutoID;

import java.util.ArrayList;
import java.util.List;

public class PedidoAplicacao {

    private PedidoGateway pedidoGateway;
    private ClienteGateway clienteGateway;
    private ProdutoGateway produtoGateway;

    public PedidoAplicacao(PedidoGateway pedidoGateway, ClienteGateway clienteGateway, ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
        this.pedidoGateway = pedidoGateway;
        this.clienteGateway = clienteGateway;
    }

    public void criar(String clienteId, List<ItemPedidoDTO> itens) {

        Cliente cliente = clienteGateway.buscarPorId(clienteId);

        List<ItemPedido> itensPedido = new ArrayList<>();

        for (ItemPedidoDTO itemPedidoDTO : itens) {

            ProdutoID produtoID = ProdutoID.criar(itemPedidoDTO.getProdutoId());
            Produto produto = produtoGateway.buscarPorId(produtoID.valor());

            ItemPedido itemPedido = ItemPedido.criar(produto, itemPedidoDTO.getQuantidade());

            itensPedido.add(itemPedido);
        }

        Pedido pedido = Pedido.criar(cliente, itensPedido);

        pedidoGateway.salvar(pedido);
    }

    public void adicionarProduto(PedidoID pedidoId, ItemPedidoDTO itemPedidoDTO) {

        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());

        ProdutoID produtoID = ProdutoID.criar(itemPedidoDTO.getProdutoId());
        Produto produto = produtoGateway.buscarPorId(produtoID.valor());

        pedido.adicionarProduto(produto, itemPedidoDTO.getQuantidade());

        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public void removerProduto(PedidoID pedidoId, ProdutoID produtoId) {
        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());
        pedido.removerProduto(produtoId);
        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public void fecharPedido(PedidoID pedidoId) {
        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());
        pedido.fechar();
        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public void cancelarPedido(PedidoID pedidoId) {
        Pedido pedido = pedidoGateway.buscar(pedidoId.valor());
        pedido.cancelar();
        pedidoGateway.atualizar(pedidoId, pedido);
    }

    public Pedido buscar(PedidoID id) {
        return pedidoGateway.buscar(id.valor());
    }

    public List<Pedido> buscarTodos() {
        return pedidoGateway.buscarTodos();
    }

}
