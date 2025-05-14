public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(double limite) {
        this.limiteChequeEspecial = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            EntradaSaidaDados.saidaDados("Saque realizado usando o limite do cheque especial.");
        } else {
            EntradaSaidaDados.saidaDados("Saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return String.format("Conta Corrente - Saldo: R$ %.2f | Limite Cheque Especial: R$ %.2f", saldo, limiteChequeEspecial);
    }
}
