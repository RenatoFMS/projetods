public class Conta {
    protected double saldo;

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            EntradaSaidaDados.saidaDados("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            EntradaSaidaDados.saidaDados("Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        EntradaSaidaDados.saidaDados("Saldo atual: R$ " + ConversorNumeros.doubleToString(saldo));
    }

    public void reajustarSaldo() {
        saldo += saldo * 0.05;
        EntradaSaidaDados.saidaDados("Saldo reajustado em 5%.");
    }

    public double getSaldo() {
        return saldo;
    }
}
