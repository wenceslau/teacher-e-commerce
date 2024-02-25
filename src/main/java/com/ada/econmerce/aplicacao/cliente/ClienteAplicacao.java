package com.ada.econmerce.aplicacao.cliente;

import com.ada.econmerce.domain.Identificador;
import com.ada.econmerce.domain.cliente.Cidade;
import com.ada.econmerce.domain.cliente.Cliente;
import com.ada.econmerce.domain.cliente.ClienteGateway;
import com.ada.econmerce.domain.cliente.Endereco;
import com.ada.econmerce.domain.cliente.objetos.CEP;
import com.ada.econmerce.domain.cliente.objetos.CNPJ;
import com.ada.econmerce.domain.cliente.objetos.CPF;
import com.ada.econmerce.domain.cliente.objetos.Tipo;

public class ClienteAplicacao {

    private final ClienteGateway gateway;

    public ClienteAplicacao(ClienteGateway gateway) {
        this.gateway = gateway;
    }

    public void incluir(ClienteDTO clienteDTO){

        String id = clienteDTO.getId();
        String nome = clienteDTO.getNome();
        String email = clienteDTO.getEmail();
        String logradouro = clienteDTO.getLogradouro();
        String bairro = clienteDTO.getBairro();
        String cep = clienteDTO.getCep();
        String cidade = clienteDTO.getCidade();
        String estado = clienteDTO.getEstado();
        Tipo tipo = clienteDTO.getTipo();

        Identificador idValido;

        if (tipo == Tipo.FISICA) {
            idValido = CPF.criar(id);
        } else {
            idValido = CNPJ.criar(id);
        }

        CEP cepValido = CEP.criar(cep);
        Cidade cidadeValida = Cidade.criar(cidade, estado);
        Endereco endereco = Endereco.criar(cepValido, logradouro, bairro, cidadeValida);

        Cliente cliente = Cliente.criar(idValido, nome, email, endereco);


        gateway.salvar(cliente);

    }

    public void atualizar(String clienteID, String nome, String email) {

        Cliente cliente = gateway.buscarPorId(clienteID);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        cliente.altearNome(nome);
        cliente.alterarEmail(email);

        gateway.atualizar(cliente);
    }

    public void atualizarEndereco(String clienteID, ClienteDTO clienteDTO) {

        String logradouro = clienteDTO.getLogradouro();
        String bairro = clienteDTO.getBairro();
        String cep = clienteDTO.getCep();
        String cidade = clienteDTO.getCidade();
        String estado = clienteDTO.getEstado();

        CEP cepValido = CEP.criar(cep);
        Cidade cidadeValida = Cidade.criar(cidade, estado);
        Endereco novoEndereco = Endereco.criar(cepValido, logradouro, bairro, cidadeValida);

        Cliente cliente = gateway.buscarPorId(clienteID);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        cliente.atualizarEndereco(novoEndereco);

        gateway.atualizar(cliente);
    }

}
