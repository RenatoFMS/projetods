import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuConta {
    ContaCorrente contaCC = new ContaCorrente(200);
    ContaPoupanca contaCP = new ContaPoupanca();
    private Font fonteAtual = new Font("Arial", Font.PLAIN, 16);

    JMenuBar criarMenuBar(JFrame frame) {
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
                atualizarFonte(frame, new Font(fonteAtual.getFontName(), Font.PLAIN, fonteAtual.getSize()));
            }
        });
        JMenuItem estiloNegrito = new JMenuItem("Negrito");
        estiloNegrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFonte(frame, new Font(fonteAtual.getFontName(), Font.BOLD, fonteAtual.getSize()));
            }
        });
        JMenuItem estiloItalico = new JMenuItem("Itálico");
        estiloItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFonte(frame, new Font(fonteAtual.getFontName(), Font.ITALIC, fonteAtual.getSize()));
            }
        });
        JMenuItem estiloNegritoItalico = new JMenuItem("Negrito Itálico");
        estiloNegritoItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFonte(frame, new Font(fonteAtual.getFontName(), Font.BOLD | Font.ITALIC, fonteAtual.getSize()));
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
                    atualizarFonte(frame, new Font(fonteAtual.getFontName(), fonteAtual.getStyle(), tamanho));
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

    private void atualizarFonte(JFrame frame, Font novaFonte) {
        fonteAtual = novaFonte;
        for (Component comp : frame.getContentPane().getComponents()) {
            comp.setFont(fonteAtual);
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }

    public void operarContaCCGUI(JFrame frameAnterior, Font fonte) {
        fonteAtual = fonte;
        JFrame frame = new JFrame("Conta Corrente");
        JLabel labelSaldo = new JLabel("Saldo: R$ " + ConversorNumeros.doubleToString(contaCC.getSaldo()));
        JTextField campoValor = new JTextField();
        JButton botaoDepositar = new JButton("Depositar");
        JButton botaoSacar = new JButton("Sacar");
        JButton botaoVoltar = new JButton("Voltar");

        labelSaldo.setFont(fonteAtual);
        campoValor.setFont(fonteAtual);
        botaoDepositar.setFont(fonteAtual);
        botaoSacar.setFont(fonteAtual);
        botaoVoltar.setFont(fonteAtual);

        frame.setLayout(new GridLayout(5, 1, 5, 5));
        frame.add(labelSaldo);
        frame.add(campoValor);
        frame.add(botaoDepositar);
        frame.add(botaoSacar);
        frame.add(botaoVoltar);

        botaoDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = ConversorNumeros.stringToDouble(campoValor.getText());
                    contaCC.depositar(valor);
                    JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCC.getSaldo()));
                    campoValor.setText("");
                } catch (Exception ex) {
                    EntradaSaidaDados.saidaDados("Valor inválido.");
                }
            }
        });

        botaoSacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = ConversorNumeros.stringToDouble(campoValor.getText());
                    contaCC.sacar(valor);
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCC.getSaldo()));
                    campoValor.setText("");
                } catch (Exception ex) {
                    EntradaSaidaDados.saidaDados("Erro ao sacar.");
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameAnterior.setVisible(true);
            }
        });

        frame.setJMenuBar(criarMenuBar(frame));
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frameAnterior.setVisible(false);
    }

    public void operarContaCPGUI(JFrame frameAnterior, Font fonte) {
        fonteAtual = fonte;
        JFrame frame = new JFrame("Conta Poupança");
        JLabel labelSaldo = new JLabel("Saldo: R$ " + ConversorNumeros.doubleToString(contaCP.getSaldo()));
        JTextField campoValor = new JTextField();
        JButton botaoDepositar = new JButton("Depositar");
        JButton botaoSacar = new JButton("Sacar");
        JButton botaoReajustar = new JButton("Reajustar");
        JButton botaoVoltar = new JButton("Voltar");

        labelSaldo.setFont(fonteAtual);
        campoValor.setFont(fonteAtual);
        botaoDepositar.setFont(fonteAtual);
        botaoSacar.setFont(fonteAtual);
        botaoReajustar.setFont(fonteAtual);
        botaoVoltar.setFont(fonteAtual);

        frame.setLayout(new GridLayout(6, 1, 5, 5));
        frame.add(labelSaldo);
        frame.add(campoValor);
        frame.add(botaoDepositar);
        frame.add(botaoSacar);
        frame.add(botaoReajustar);
        frame.add(botaoVoltar);

        botaoDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = ConversorNumeros.stringToDouble(campoValor.getText());
                    contaCP.depositar(valor);
                    JOptionPane.showMessageDialog(null, "Depósito realizado!");
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCP.getSaldo()));
                    campoValor.setText("");
                } catch (Exception ex) {
                    EntradaSaidaDados.saidaDados("Valor inválido.");
                }
            }
        });

        botaoSacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = ConversorNumeros.stringToDouble(campoValor.getText());
                    contaCP.sacar(valor);
                    JOptionPane.showMessageDialog(null, "Saque realizado!");
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCP.getSaldo()));
                    campoValor.setText("");
                } catch (Exception ex) {
                    EntradaSaidaDados.saidaDados("Erro ao sacar.");
                }
            }
        });

        botaoReajustar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contaCP.reajustarSaldo();
                EntradaSaidaDados.saidaDados("Reajuste aplicado!");
                labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCP.getSaldo()));
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameAnterior.setVisible(true);
            }
        });

        frame.setJMenuBar(criarMenuBar(frame));
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frameAnterior.setVisible(false);
    }
}
