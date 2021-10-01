package entities;

import javax.swing.*;
import java.sql.*;

public class ProdutoDAO extends LojaDAO {

    public ProdutoDAO() {
        super();
    }

    public Connection conectarBanco() throws ClassNotFoundException, SQLException {
        Class.forName(this.getDriver());
        Connection conexao = DriverManager.getConnection(this.getUrl(), this.getUsuario(), this.getSenha());
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

    // método para excluir um produto do banco
    public void excluirProduto(String nomeProduto) throws SQLException, ClassNotFoundException {
        // realizando conexao
        Connection conexao = this.conectarBanco();

        String deleteProduto = "delete from produtos where nome = ?";

        // preparando o statement
        PreparedStatement prepStatement = conexao.prepareStatement(deleteProduto);

        // usando o statement para executar comando
        prepStatement.setString(1, nomeProduto);
        prepStatement.executeUpdate();
        // log de que o produto foi deletado
        JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
    }

    public Produto consultarProduto(String nomeProduto) throws SQLException, ClassNotFoundException {
        // preciso armazenar os campos vindos do banco no atributos de um objeto do tipo Produto
        Produto dadosProduto = new Produto();
        Connection conexao = this.conectarBanco();

        // comando dml select
        String consultaProduto = "select * from produtos where nome = ?";
        PreparedStatement prepStatement = conexao.prepareStatement(consultaProduto);

        // executando comando dml
        prepStatement.setString(1, nomeProduto);
        // preciso chamar executeQuery, pois vai retornar um Set com os campos do banco resultantes da query
        ResultSet dadosConsultados =  prepStatement.executeQuery();

        // percorrendo o ResultSet
        while (dadosConsultados.next()) {
            dadosProduto.setNome(dadosConsultados.getString("nome"));
            dadosProduto.setPreco(dadosConsultados.getString("preco"));
            dadosProduto.setQuantidade(dadosConsultados.getString("quantidade"));
        }

        // loggando que a consulta foi bem sucedida
        JOptionPane.showMessageDialog(null, "Produto consultado com sucesso");
        return dadosProduto;
    }

    public void atualizarProduto(Produto produto) throws SQLException, ClassNotFoundException {
        // realizando conexao com banco
        Connection conexao = this.conectarBanco();

        // acesando os atributos do objeto que serão passados como campos para o banco de dados
        String nome = produto.getNome();
        String preco = produto.getPreco();
        String quantidade = produto.getQuantidade();

        // comando dml
        String alterProduto = "update produtos set preco = ?, quantidade = ? where nome = ?";
        PreparedStatement prepStatement = conexao.prepareStatement(alterProduto);

        // realizando comando
        prepStatement.setString(1, preco);
        prepStatement.setString(2, quantidade);
        prepStatement.setString(3, nome);
        prepStatement.executeUpdate();

        // loggando que a alteração foi bem sucedida
        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

    }
}
