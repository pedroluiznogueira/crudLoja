import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Loja {
    // referenciando o JPanel
    private JPanel Main;
    // inputs
    private JTextField nomeInput;
    private JTextField precoInput;
    private JTextField quantidadeInput;
    // botoes
    private JButton salvarButton;
    private JButton deletarButton;

    // conexao com banco
    Connection conexao;
    // variavel para tratar comandos sql
    PreparedStatement prepStatement;

    public static void main(String[] args) {
        // instanciando o JFrame
        JFrame frame = new JFrame("Loja");
        frame.setContentPane(new Loja().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Loja() {
        // realizando a conexão com o banco
        ConexaoBanco();

        // addActionListener implementa actionPerformed e vai executar seu escopo quando o botão for clicado
        salvarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // recebendo os input do usuário
                String nome = nomeInput.getText();
                String preco = precoInput.getText();
                String quantidade = quantidadeInput.getText();

                try {
                    // realizando comandos sql repetidamente em cima do prepared statement sql
                    prepStatement = conexao.prepareStatement("insert into produtos(nome, preco, quantidade)values(?,?,?)");
                    // setando cada input
                    prepStatement.setString(1, nome);
                    prepStatement.setString(2, preco);
                    prepStatement.setString(3, quantidade);
                    prepStatement.executeUpdate();
                    // informando um painel com um log informando que o procedimento foi realizado
                    JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void ConexaoBanco() {
        // tratando as excessões necessárias
        try {
            // relacionando o driver, 8.0.22 precisou explicitar a timezone
            Class.forName("com.mysql.cj.jdbc.Driver");
            // essa conexão fará a ponte para que sejam executados os comandos sql nessa variável
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojinha", "root", "root");
            System.out.println("A conexão foi bem sucedida");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
