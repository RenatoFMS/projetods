import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class MenuConta {
    ContaCorrente contaCC = new ContaCorrente(200);
    ContaPoupanca contaCP = new ContaPoupanca();
    private static int espacamentoInternoHorizontal = 5;

    private JMenuBar criarMenuBar(JFrame frame) {
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpcoes = new JMenu("Opções");

        JMenu menuCor = new JMenu("Cor");
        JMenuItem corAzul = new JMenuItem("Azul Claro");
        corAzul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.corDeFundoGlobal = new Color(173, 216, 230);
                Principal.atualizarAparenciaGlobal();
            }
        });
        JMenuItem corCinza = new JMenuItem("Cinza");
        corCinza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.corDeFundoGlobal = Color.LIGHT_GRAY;
                Principal.atualizarAparenciaGlobal();
            }
        });
        JMenuItem corBranco = new JMenuItem("Branco");
        corBranco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.corDeFundoGlobal = Color.WHITE;
                Principal.atualizarAparenciaGlobal();
            }
        });
        JMenuItem corVerde = new JMenuItem("Verde Claro");
        corVerde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.corDeFundoGlobal = new Color(144, 238, 144);
                Principal.atualizarAparenciaGlobal();
            }
        });
        JMenuItem corAmarelo = new JMenuItem("Amarelo Claro");
        corAmarelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.corDeFundoGlobal = new Color(255, 255, 153);
                Principal.atualizarAparenciaGlobal();
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
                Principal.fonteGlobal = new Font(Principal.fonteGlobal.getFontName(), Font.PLAIN, Principal.fonteGlobal.getSize());
                Principal.atualizarAparenciaGlobal();
            }
        });
        JMenuItem estiloNegrito = new JMenuItem("Negrito");
        estiloNegrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.fonteGlobal = new Font(Principal.fonteGlobal.getFontName(), Font.BOLD, Principal.fonteGlobal.getSize());
                Principal.atualizarAparenciaGlobal();
            }
        });
        JMenuItem estiloItalico = new JMenuItem("Itálico");
        estiloItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.fonteGlobal = new Font(Principal.fonteGlobal.getFontName(), Font.ITALIC, Principal.fonteGlobal.getSize());
                Principal.atualizarAparenciaGlobal();
            }
        });
        JMenuItem estiloNegritoItalico = new JMenuItem("Negrito Itálico");
        estiloNegritoItalico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.fonteGlobal = new Font(Principal.fonteGlobal.getFontName(), Font.BOLD | Font.ITALIC, Principal.fonteGlobal.getSize());
                Principal.atualizarAparenciaGlobal();
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
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(String.valueOf(tamanho), tamanho == Principal.fonteGlobal.getSize());
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Principal.fonteGlobal = new Font(Principal.fonteGlobal.getFontName(), Principal.fonteGlobal.getStyle(), tamanho);
                    Principal.atualizarAparenciaGlobal();
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

    private void atualizarFonteComponente(Component comp, Font novaFonte) {
        comp.setFont(novaFonte);
    }

    public JFrame criarContaCCGUI(JFrame frameAnterior, Font fonteInicial, Color corDeFundoInicial) {
        JFrame frame = new JFrame("Conta Corrente");
        if (corDeFundoInicial != null) {
            frame.getContentPane().setBackground(corDeFundoInicial);
        } else if (Principal.corDeFundoGlobal != null) {
            frame.getContentPane().setBackground(Principal.corDeFundoGlobal);
        }
        frame.setFont(fonteInicial != null ? fonteInicial : Principal.fonteGlobal);
        JLabel labelSaldo = new JLabel("Saldo: R$ " + ConversorNumeros.doubleToString(contaCC.getSaldo()));
        JTextField campoValor = new JTextField();
        JButton botaoDepositar = new JButton("Depositar");
        JButton botaoSacar = new JButton("Sacar");
        JButton botaoVoltar = new JButton("Voltar");

        atualizarFonteComponente(labelSaldo, frame.getFont());
        atualizarFonteComponente(campoValor, frame.getFont());
        atualizarFonteComponente(botaoDepositar, frame.getFont());
        atualizarFonteComponente(botaoSacar, frame.getFont());
        atualizarFonteComponente(botaoVoltar, frame.getFont());

        botaoDepositar.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));
        botaoSacar.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));
        botaoVoltar.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));

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
                    JOptionPane.showMessageDialog(frame, "Depósito realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCC.getSaldo()));
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botaoSacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = ConversorNumeros.stringToDouble(campoValor.getText());
                    contaCC.sacar(valor);
                    JOptionPane.showMessageDialog(frame, "Saque realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCC.getSaldo()));
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
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
        return frame;
    }

    public JFrame criarContaCPGUI(JFrame frameAnterior, Font fonteInicial, Color corDeFundoInicial) {
        JFrame frame = new JFrame("Conta Poupança");
        if (corDeFundoInicial != null) {
            frame.getContentPane().setBackground(corDeFundoInicial);
        } else if (Principal.corDeFundoGlobal != null) {
            frame.getContentPane().setBackground(Principal.corDeFundoGlobal);
        }
        frame.setFont(fonteInicial != null ? fonteInicial : Principal.fonteGlobal);
        JLabel labelSaldo = new JLabel("Saldo: R$ " + ConversorNumeros.doubleToString(contaCP.getSaldo()));
        JTextField campoValor = new JTextField();
        JButton botaoDepositar = new JButton("Depositar");
        JButton botaoSacar = new JButton("Sacar");
        JButton botaoReajustar = new JButton("Reajustar");
        JButton botaoVoltar = new JButton("Voltar");

        atualizarFonteComponente(labelSaldo, frame.getFont());
        atualizarFonteComponente(campoValor, frame.getFont());
        atualizarFonteComponente(botaoDepositar, frame.getFont());
        atualizarFonteComponente(botaoSacar, frame.getFont());
        atualizarFonteComponente(botaoReajustar, frame.getFont());
        atualizarFonteComponente(botaoVoltar, frame.getFont());

        botaoDepositar.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));
        botaoSacar.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));
        botaoReajustar.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));
        botaoVoltar.setBorder(new EmptyBorder(0, espacamentoInternoHorizontal, 0, espacamentoInternoHorizontal));

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
                    JOptionPane.showMessageDialog(frame, "Depósito realizado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCP.getSaldo()));
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botaoSacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = ConversorNumeros.stringToDouble(campoValor.getText());
                    contaCP.sacar(valor);
                    JOptionPane.showMessageDialog(frame, "Saque realizado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    labelSaldo.setText("Saldo: R$ " + ConversorNumeros.doubleToString(contaCP.getSaldo()));
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botaoReajustar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contaCP.reajustarSaldo();
                JOptionPane.showMessageDialog(frame, "Reajuste aplicado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
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
        return frame;
    }
}