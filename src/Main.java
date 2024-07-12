
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.setNome("Banco do Brasil");

        Cliente maverick = new Cliente();
        maverick.setNome("Maverick");

        banco.adicionarCliente(maverick);

        Conta cc = new ContaCorrente(maverick);
        cc.depositar(100);
        banco.adicionarConta(cc);

        Conta poupanca = new ContaPoupanca(maverick);
        banco.adicionarConta(poupanca);

        cc.transferir(90, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        banco.imprimirClientes();
    }
}
