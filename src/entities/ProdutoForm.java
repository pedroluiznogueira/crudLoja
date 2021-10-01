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

        });
    }
}
