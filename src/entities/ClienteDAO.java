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
}
