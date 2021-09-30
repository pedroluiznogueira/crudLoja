import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loja {
    // referenciando o JPanel
    private JPanel Main;
    // inputs
    private JTextField produtoInput;
    private JTextField nomeInput;
    private JTextField precoInput;
    private JTextField quantidadeInput;
    // botoes
    private JButton salvarButton;
    private JButton deletarButton;

    public static void main(String[] args) {
        // instanciando o JFrame
        JFrame frame = new JFrame("Loja");
        frame.setContentPane(new Loja().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Loja() {
        salvarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String produto = produtoInput.getText();
                String preco = precoInput.getText();
                String quantidade = quantidadeInput.getText();

                System.out.println(nome);
            }
        });
    }
}
