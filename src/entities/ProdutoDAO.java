package entities;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public ProdutoDAO() {

    }

    // método para inserir um produto no banco
    public void incluirProduto() {
        // realizar a conexão como banco de dados
        Connection conexao = this.conectarBanco();
    }

    // método para realizar a conexão com o banco de dados para cada vez que eu queira incluir um produto
    public Connection conectarBanco() {
        Connection conexao;
        return conexao;
    }
}
