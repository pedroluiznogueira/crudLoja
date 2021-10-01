package entities;

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
}
