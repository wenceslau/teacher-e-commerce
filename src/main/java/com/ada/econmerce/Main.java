package com.ada.econmerce;

import com.ada.econmerce.aplicacao.cliente.ClienteAplicacao;
import com.ada.econmerce.aplicacao.cliente.ClienteDTO;
import com.ada.econmerce.aplicacao.pedido.ItemPedidoDTO;
import com.ada.econmerce.aplicacao.pedido.PedidoAplicacao;
import com.ada.econmerce.aplicacao.product.ProdutoAplicacao;
import com.ada.econmerce.domain.cliente.Cliente;
import com.ada.econmerce.domain.cliente.ClienteGateway;
import com.ada.econmerce.domain.cliente.objetos.Tipo;
import com.ada.econmerce.domain.pedido.Pedido;
import com.ada.econmerce.domain.pedido.PedidoGateway;
import com.ada.econmerce.domain.produto.Produto;
import com.ada.econmerce.domain.produto.ProdutoGateway;
import com.ada.econmerce.infraestrutura.cliente.ClienteListGateway;
import com.ada.econmerce.infraestrutura.pedido.PedidoListGateway;
import com.ada.econmerce.infraestrutura.product.ProdutoListGateway;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Produto
        // Instancia do Produto Gateway
        // Instalncia d Produto Aplicação injetando o Gateway
        ProdutoGateway produtoGateway = new ProdutoListGateway();
        ProdutoAplicacao produtoAplicacao = new ProdutoAplicacao(produtoGateway);

        //Criando o produto
        String nome = "Coca-cola";
        BigDecimal preco = BigDecimal.valueOf(4.50);
        Integer estoque = 10;
        produtoAplicacao.incluir(nome, preco, estoque);
        produtoAplicacao.incluir("Pepsi", BigDecimal.valueOf(4.10), 5);

        //Listando os produto
        List<Produto> listProduto = produtoGateway.buscarTodos();
        listProduto.forEach(System.out::println);

        // Cliente
        // Instancia do Cliente Gateway
        // Instalncia do Cliente Aplicação injetando o Gateway
        ClienteGateway clienteGateway = new ClienteListGateway();
        ClienteAplicacao clienteAplicacao = new ClienteAplicacao(clienteGateway);

        //Criando o cliente
        ClienteDTO clienteDTO = new ClienteDTO(
                Tipo.FISICA,
                "12345678900",
                "João da Silva",
                "wKqgR@example.com",
                "Rua das Flores",
                "Vila A",
                "12345678",
                "São Paulo",
                "SP");
        clienteAplicacao.incluir(clienteDTO);

        //Listando os cliente
        List<Cliente> listCliente = clienteGateway.buscarTodos();
        listCliente.forEach(System.out::println);

        //Pedido
        //Instanciando o Pedido Gateway
        //Instanciando o Pedido Aplicação injetando o Gateway
        PedidoGateway pedidoGateway = new PedidoListGateway();
        PedidoAplicacao pedidoAplicacao = new PedidoAplicacao(pedidoGateway, clienteGateway, produtoGateway);

        //Criando o pedido
        List<ItemPedidoDTO> itens = new ArrayList<>();
        itens.add(new ItemPedidoDTO(1, 1));
        itens.add(new ItemPedidoDTO(2, 2));
        pedidoAplicacao.criar("12345678900", itens);

        //Listando os pedidos
        List<Pedido> listPedido = pedidoGateway.buscarTodos();
        listPedido.forEach(System.out::println);

    }

}