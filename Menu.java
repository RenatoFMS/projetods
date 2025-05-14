public class Menu {
    private int opcao;
    private String mensagemMenu;

    public Menu() {
        mensagemMenu = "Menu Principal:\n" +
                "1 - Conta Corrente\n" +
                "2 - Conta Poupança\n" +
                "0 - Sair";
    }

    public void executar() {
        String entrada = EntradaSaidaDados.entradaDados(mensagemMenu);
        opcao = ConversorNumeros.stringToInt(entrada);
    }

    public void executarMenu() {
        executar();
    }

    public int avaliarOpcaoEscolhida() {
        return opcao;
    }
}