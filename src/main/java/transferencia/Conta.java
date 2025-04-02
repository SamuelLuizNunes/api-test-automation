package transferencia;

public class Conta {
    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente;

    public Conta(String agencia, String numeroConta, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void realizarDeposito(double valor){
        saldo += valor;
    }

    public boolean realizarSaque(double valor){
        if (valor > saldo){
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean realizarTransferencia(double valor, Conta destino){
        if (realizarSaque(valor)){
            destino.realizarDeposito(valor);
            return true;
        }
        return false;
    }
}