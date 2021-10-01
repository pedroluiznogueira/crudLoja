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
    private JButton consultarProduto;

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

                // setting o conteúdo do input do frame nos atributos do objeto Produto
                produto.setNome(nomeInput.getText());
                produto.setPreco(precoInput.getText());
                produto.setQuantidade(quantidadeInput.getText());

                // chamando a inserção do produto, logo é aqui que vou tratar as excessões disparadas na classe
                try {
                    produtoDao.incluirProduto(produto);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Remover produto
        excluirButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // a exclusão será feita em relação ao nome que for digitado pelo usuário
                String nomeProduto = nomeInput.getText();

                // chamando a deleção do produto
                try {
                    produtoDao.excluirProduto(nomeProduto);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        consultarProduto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // a consulta será feita em relação ao nome que for digitado pelo usuário
                String nomeProduto = nomeInput.getText();

                try {
                    // retorna os campos do banco de dados nos atributos de um objeto Produto
                    Produto produto = produtoDao.consultarProduto(nomeProduto);

                    // mostrando no frame os dados da consulta
                    nomeInput.setText(produto.getNome());
                    precoInput.setText(produto.getPreco());
                    quantidadeInput.setText(produto.getQuantidade());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
