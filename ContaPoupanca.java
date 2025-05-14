public class ContaPoupanca extends Conta {
    @Override
    public void reajustarSaldo() {
        saldo += saldo * 0.10; // reajuste de 10%
        EntradaSaidaDados.saidaDados("Saldo reajustado em 10%.");
    }

    @Override
    public String toString() {
        return String.format("Conta Poupança - Saldo: R$ %.2f", saldo);
    }
}
