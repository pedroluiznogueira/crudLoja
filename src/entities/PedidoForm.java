package entities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PedidoForm {
    public JPanel PedidoJPanel;
    private JTextField formaPagamentoInput;
    private JButton incluirButton;
    private JTextField produtoInput;
    private JButton excluirButton;
    private JButton consultarButton;
    private JButton atualizarButton;
    private JTextField cpfInput;

    PedidoDAO pedidoDao = new PedidoDAO();

    public PedidoForm() {
        // Incluir pedido
        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedido pedido = new Pedido();
                pedido.setFormaPagamento(formaPagamentoInput.getText());

                Cliente cliente = new Cliente();
                cliente.setCpf(cpfInput.getText());

                try {
                    pedidoDao.incluirPedido(pedido, cliente);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        // Excluir pedido

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setCpf(cpfInput.getText());

                try {
                    pedidoDao.excluirPedido(cliente);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
