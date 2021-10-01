package entities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ProdutoForm {
    // referenciando o JPanel
    public JPanel Main;
    // inputs
    private JTextField nomeInput;
    private JTextField precoInput;
    private JTextField quantidadeInput;
    // botoes
    private JButton incluirButton;
    private JButton excluirButton;

    // instanciando um objeto do tipo ProdutoDAO, para que à vez que eu abrir um GUI de Produto, este esteja disponível para fazer a administração dos dados
    ProdutoDAO produtoDao = new ProdutoDAO();

    public static void main(String[] args) {
        // instanciando o JFrame
        JFrame frame = new JFrame("Loja");
        frame.setContentPane(new ProdutoForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ProdutoForm() {
        // Inserindo produto
        incluirButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // para cada vez que eu for incluir um produto, preciso ter um produto criado para relacionar o produto certo a ser inserido no banco
                Produto produto = new Produto();

                // settando o conteúdo do input do frame nos atributos do objeto Produto
                produto.setNome(nomeInput.getText());
                produto.setPreco(precoInput.getText());
                produto.setQuantidade(quantidadeInput.getText());

            }

        });
    }
}
