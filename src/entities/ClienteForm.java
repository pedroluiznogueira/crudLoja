package entities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClienteForm {
    public JPanel ClienteJPanel;
    private JButton atualizarButton;
    private JButton incluirButton;
    private JButton excluirButton;
    private JButton consultarButton;
    private JTextField nomeInput;
    private JTextField cpfInput;
    private JTextField emailInput;
    private JTextField usuarioInput;
    private JTextField senhaInput;

    ClienteDAO clienteDao = new ClienteDAO();

    public ClienteForm() {


        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setNome(nomeInput.getText());
                cliente.setCpf(cpfInput.getText());
                cliente.setEmail(emailInput.getText());
                cliente.setUsuario(usuarioInput.getText());
                cliente.setSenha(senhaInput.getText());

                try {
                    clienteDao.incluirCliente(cliente);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
