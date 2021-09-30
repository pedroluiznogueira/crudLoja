import javax.swing.*;

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
}
