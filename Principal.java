import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Bancário");
        MenuConta menu = new MenuConta();
        Font fontePadrao = new Font("Arial", Font.PLAIN, 16);

        JButton botaoContaCorrente = new JButton("Conta Corrente");
        JButton botaoContaPoupanca = new JButton("Conta Poupança");
        JButton botaoSair = new JButton("Sair");

        botaoContaCorrente.setFont(fontePadrao);
        botaoContaPoupanca.setFont(fontePadrao);
        botaoSair.setFont(fontePadrao);

        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpcoes = new JMenu("Opções");

        JMenu menuCor = new JMenu("Cor");
        JMenuItem corAzul = new JMenuItem("Azul Claro");
        corAzul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(new Color(173, 216, 230));
            }
        });
        JMenuItem corCinza = new JMenuItem("Cinza");
        corCinza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.LIGHT_GRAY);
            }
        });
        JMenuItem corBranco = new JMenuItem("Branco");
        corBranco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.WHITE);
            }
        });
        JMenuItem corVerde = new JMenuItem("Verde Claro");
        corVerde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(new Color(144, 238, 144));
            }
        });
        JMenuItem corAmarelo = new JMenuItem("Amarelo Claro");
        corAmarelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(new Color(255, 255, 153));
            }
        });
        menuCor.add(corAzul);
        menuCor.add(corCinza);
        menuCor.add(corBranco);
        menuCor.add(corVerde);
        menuCor.add(corAmarelo);

        JMenu menuEstilo = new JMenu("Estilo");
        JMenuItem estiloNormal = new JMenuItem("Normal");
        estiloNormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFonte(frame, new Font(fontePadrao.getFontName(), Font.PLAIN, fontePadrao.getSize()));
            }
        });
        JMenuItem estiloNegrito = new JMenuItem("Negrito");
        estiloNegrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFonte(frame, new Font(fontePadrao.getFontName(), Font.BOLD, fontePadrao.getSize()));
            }
        });
        JMenuItem estiloItalico = new JMenuItem("Itálico");
        estiloItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFonte(frame, new Font(fontePadrao.getFontName(), Font.ITALIC, fontePadrao.getSize()));
            }
        });
        JMenuItem estiloNegritoItalico = new JMenuItem("Negrito Itálico");
        estiloNegritoItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFonte(frame, new Font(fontePadrao.getFontName(), Font.BOLD | Font.ITALIC, fontePadrao.getSize()));
            }
        });
        menuEstilo.add(estiloNormal);
        menuEstilo.add(estiloNegrito);
        menuEstilo.add(estiloItalico);
        menuEstilo.add(estiloNegritoItalico);

        JMenu menuTamanho = new JMenu("Tamanho");
        ButtonGroup grupoTamanho = new ButtonGroup();
        int[] tamanhos = {10, 12, 14, 16, 18, 20, 24};
        for (int tamanho : tamanhos) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(String.valueOf(tamanho), tamanho == 16);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    atualizarFonte(frame, new Font(fontePadrao.getFontName(), fontePadrao.getStyle(), tamanho));
                }
            });
            grupoTamanho.add(item);
            menuTamanho.add(item);
        }

        menuOpcoes.add(menuCor);
        menuOpcoes.add(menuEstilo);
        menuOpcoes.add(menuTamanho);
        barraMenu.add(menuOpcoes);

        frame.setJMenuBar(barraMenu);

        frame.setLayout(new GridLayout(3, 1, 5, 5));
        frame.add(botaoContaCorrente);
        frame.add(botaoContaPoupanca);
        frame.add(botaoSair);

        botaoContaCorrente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.operarContaCCGUI(frame, fontePadrao);
            }
        });

        botaoContaPoupanca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.operarContaCPGUI(frame, fontePadrao);
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void atualizarFonte(JFrame frame, Font novaFonte) {
        for (Component comp : frame.getContentPane().getComponents()) {
            comp.setFont(novaFonte);
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
