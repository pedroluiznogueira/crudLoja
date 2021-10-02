package entities;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import javax.swing.*;
import java.sql.*;

public class PedidoDAO extends LojaDAO {

    public PedidoDAO() {
        super();
    }

    public Connection conectarBanco() throws SQLException, ClassNotFoundException {
        Class.forName(getDriver());
        Connection conexao = DriverManager.getConnection(this.getUrl(), this.getUsuario(), this.getSenha());
        System.out.println("Conexão com o Banco de Dados realizada com sucesso");

        return conexao;
    }

    public void incluirPedido(Pedido pedido, Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = this.conectarBanco();

        // procura no banco de dados pelo id do cliente que fez o pedido
        PreparedStatement prepStatementId = conexao.prepareStatement("select id from cliente where cpf = ?");
        prepStatementId.setString(1, cliente.getCpf());
        ResultSet dadosId = prepStatementId.executeQuery();

        while (dadosId.next()) {
            cliente.setId(dadosId.getString("id"));
        }

        JOptionPane.showMessageDialog(null, "Cliente encontrado no banco de dados");

        // insere o pedido e o id do cliente que fez o pedido no banco de dados
        PreparedStatement prepStatement = conexao.prepareStatement("insert into pedido(id_cliente, forma_pagamento)values(?, ?)");
        prepStatement.setString(1, cliente.getId());
        prepStatement.setString(2, pedido.getFormaPagamento());
        prepStatement.executeUpdate();

        JOptionPane.showMessageDialog(null, "Pedido incluído com sucesso");
    }
}
