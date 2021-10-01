package entities;

import javax.swing.*;
import java.sql.*;

public class ClienteDAO extends LojaDAO {

    public ClienteDAO() {
        super();
    }

    public Connection conectarBanco() throws ClassNotFoundException, SQLException {
        Class.forName(this.getDriver());
        Connection conexao = DriverManager.getConnection(this.getUrl(), this.getUsuario(), this.getSenha());
        System.out.println("Conexão com o Banco de Dados realizada com sucesso");

        return conexao;
    }

    public void incluirCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = conectarBanco();

        PreparedStatement prepStatement = conexao.prepareStatement("insert into cliente(nome, cpf, email, usuario, senha)values(?,?,?,?,?)");
        prepStatement.setString(1, cliente.getNome());
        prepStatement.setString(2, cliente.getCpf());
        prepStatement.setString(3, cliente.getEmail());
        prepStatement.setString(4, cliente.getUsuario());
        prepStatement.setString(5, cliente.getSenha());
        prepStatement.executeUpdate();

        JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso");

    }

    public void excluirCliente(String nomeCliente) throws SQLException, ClassNotFoundException {
        Connection conexao = conectarBanco();

        PreparedStatement prepStatement = conexao.prepareStatement("delete from cliente where nome = ?");
        prepStatement.setString(1, nomeCliente);
        prepStatement.executeUpdate();

        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
    }

    public Cliente consultarCliente(String nomeCliente) throws SQLException, ClassNotFoundException {
        Connection conexao = conectarBanco();
        Cliente cliente = new Cliente();

        PreparedStatement prepStatement = conexao.prepareStatement("select cpf, email, usuario, senha from cliente where nome = ?");
        prepStatement.setString(1, nomeCliente);
        ResultSet dadosCliente = prepStatement.executeQuery();

        while (dadosCliente.next()) {
            cliente.setCpf(dadosCliente.getString("cpf"));
            cliente.setEmail(dadosCliente.getString("email"));
            cliente.setUsuario(dadosCliente.getString("usuario"));
            cliente.setSenha(dadosCliente.getString("senha"));
        }
        JOptionPane.showMessageDialog(null, "Cliente consultado com sucesso");

        return cliente;
    }

    public void atualizarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = this.conectarBanco();

        PreparedStatement prepStatement = conexao.prepareStatement("update cliente set email = ?, usuario = ?, senha  = ? where nome = ?");
        prepStatement.setString(1, cliente.getEmail());
        prepStatement.setString(2, cliente.getUsuario());
        prepStatement.setString(3, cliente.getSenha());
        prepStatement.setString(4, cliente.getNome());
        prepStatement.executeUpdate();

        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
    }
}
