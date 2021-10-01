package application;

import entities.ClienteForm;
import entities.ProdutoForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JButton clienteButton;
    private JPanel MainJPanel;
    private JButton produtosButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lojinha");
        frame.setContentPane(new MainForm().MainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public MainForm() {
        // chamando o frame do produto
        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // instanciando o JFrame
                JFrame frame = new JFrame("Produto");
                frame.setContentPane(new ProdutoForm().ProdutoJPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        // chamando o frame do cliente
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // instanciando o JFrame
                JFrame frame = new JFrame("Cliente");
                frame.setContentPane(new ClienteForm().ClienteJPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
