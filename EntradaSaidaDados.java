import javax.swing.*;

public class EntradaSaidaDados {
    public static String entradaDados(String mensagemEntrada) {
        return JOptionPane.showInputDialog(mensagemEntrada);
    }

    public static void saidaDados(String mensagemSaida) {
        JOptionPane.showMessageDialog(null, mensagemSaida);
    }
}
