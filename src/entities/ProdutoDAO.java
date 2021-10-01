package entities;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO extends LojaDAO {

    public ProdutoDAO() {
        super();
    }

    public Connection conectarBanco() throws ClassNotFoundException, SQLException {
        // atributos necessários para conexão
        String driver = this.getDriver();
        String url = this.getUrl();
        String usuario = this.getUsuario();
        String senha = this.getSenha();

        Class.forName(driver);
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        System.out.println("Conexão com o Banco de Dados realizada com sucesso");
        return conexao;
    }

    // método para inserir um produto no banco
    public void incluirProduto(Produto produto) throws SQLException, ClassNotFoundException {
        // chamando o método conectarBanco pois preciso da conexão ao realizar os comandos sql
        Connection conexao = this.conectarBanco();

        // trazendo os atributos do produto para serem passados campos de cada produto na tabela produtos
        String nome = produto.getNome();
        String preco = produto.getPreco();
        String quantidade = produto.getQuantidade();

        String insertProduto = "insert into produtos(nome, preco, quantidade)values(?, ?, ?)";

        // aqui preciso da conexão, pois será preparado o comando sql, retorando outro objeto PreparedStatement para que eu possar realizar o statement várias vezes
        PreparedStatement prepStatement = conexao.prepareStatement(insertProduto);

        // settando os atributos aos campos
        prepStatement.setString(1, nome);
        prepStatement.setString(2, preco);
        prepStatement.setString(3, quantidade);
        // executa o DML statement passado
        prepStatement.executeUpdate();
        // mostrando um Pane se o produto for incluido
        JOptionPane.showMessageDialog(null, "Produto incluido com sucesso");
    }
}
