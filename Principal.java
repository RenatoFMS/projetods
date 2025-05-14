import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static Color corDeFundoGlobal = null;
    public static Font fonteGlobal = new Font("Arial", Font.PLAIN, 16);
    private static int espacamentoInternoHorizontal = 5;
    private static List<JFrame> janelasAbertas = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Bancário");
        janelasAbertas.add(frame);
        MenuConta menu = new MenuConta();

        JButton botaoContaCorrente = new JButton("Conta Corrente");
        JButton botaoContaPoupanca = new JButton("Conta Poupança");
        JButton botaoSair = new JButton("Sair");

        atualizarFonteComponente(botaoContaCorrente, fonteGlobal);
        atualizarFonteComponente(botaoContaPoupanca, fonteGlobal);
        atualizarFonteComponente(botaoSair, fonteGlobal);

        botaoContaCorrente.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));
        botaoContaPoupanca.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));
        botaoSair.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));

        JMenuBar barraMenu = criarMenuBarGlobal(frame);

        frame.setJMenuBar(barraMenu);

        frame.setLayout(new GridLayout(3, 1, 5, 5));
        frame.add(botaoContaCorrente);
        frame.add(botaoContaPoupanca);
        frame.add(botaoSair);

        botaoContaCorrente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame contaCCFrame = menu.criarContaCCGUI(frame, fonteGlobal, corDeFundoGlobal);
                janelasAbertas.add(contaCCFrame);
            }
        });

        botaoContaPoupanca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame contaCPFrame = menu.criarContaCPGUI(frame, fonteGlobal, corDeFundoGlobal);
                janelasAbertas.add(contaCPFrame);
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

    public static void atualizarAparenciaGlobal() {
        for (JFrame janela : janelasAbertas) {
            janela.getContentPane().setBackground(corDeFundoGlobal);
            atualizarFonteNaJanela(janela, fonteGlobal);
            SwingUtilities.updateComponentTreeUI(janela);
        }
    }

    private static void atualizarFonteNaJanela(JFrame frame, Font novaFonte) {
        for (Component comp : frame.getContentPane().getComponents()) {
            comp.setFont(novaFonte);
        }
    }

    private static void atualizarFonteComponente(Component comp, Font novaFonte) {
        comp.setFont(novaFonte);
    }

    private static JMenuBar criarMenuBarGlobal(JFrame frame) {
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpcoes = new JMenu("Opções");

        JMenu menuCor = new JMenu("Cor");
        JMenuItem corAzul = new JMenuItem("Azul Claro");
        corAzul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                corDeFundoGlobal = new Color(173, 216, 230);
                atualizarAparenciaGlobal();
            }
        });
        JMenuItem corCinza = new JMenuItem("Cinza");
        corCinza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                corDeFundoGlobal = Color.LIGHT_GRAY;
                atualizarAparenciaGlobal();
            }
        });
        JMenuItem corBranco = new JMenuItem("Branco");
        corBranco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                corDeFundoGlobal = Color.WHITE;
                atualizarAparenciaGlobal();
            }
        });
        JMenuItem corVerde = new JMenuItem("Verde Claro");
        corVerde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                corDeFundoGlobal = new Color(144, 238, 144);
                atualizarAparenciaGlobal();
            }
        });
        JMenuItem corAmarelo = new JMenuItem("Amarelo Claro");
        corAmarelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                corDeFundoGlobal = new Color(255, 255, 153);
                atualizarAparenciaGlobal();
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
                fonteGlobal = new Font(fonteGlobal.getFontName(), Font.PLAIN, fonteGlobal.getSize());
                atualizarAparenciaGlobal();
            }
        });
        JMenuItem estiloNegrito = new JMenuItem("Negrito");
        estiloNegrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fonteGlobal = new Font(fonteGlobal.getFontName(), Font.BOLD, fonteGlobal.getSize());
                atualizarAparenciaGlobal();
            }
        });
        JMenuItem estiloItalico = new JMenuItem("Itálico");
        estiloItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fonteGlobal = new Font(fonteGlobal.getFontName(), Font.ITALIC, fonteGlobal.getSize());
                atualizarAparenciaGlobal();
            }
        });
        JMenuItem estiloNegritoItalico = new JMenuItem("Negrito Itálico");
        estiloNegritoItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fonteGlobal = new Font(fonteGlobal.getFontName(), Font.BOLD | Font.ITALIC, fonteGlobal.getSize());
                atualizarAparenciaGlobal();
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
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(String.valueOf(tamanho), tamanho == fonteGlobal.getSize());
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fonteGlobal = new Font(fonteGlobal.getFontName(), fonteGlobal.getStyle(), tamanho);
                    atualizarAparenciaGlobal();
                }
            });
            grupoTamanho.add(item);
            menuTamanho.add(item);
        }

        menuOpcoes.add(menuCor);
        menuOpcoes.add(menuEstilo);
        menuOpcoes.add(menuTamanho);
        barraMenu.add(menuOpcoes);
        return barraMenu;
    }
}