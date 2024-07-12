# Sistema Bancário

Este projeto é um sistema bancário simples implementado em Java. Ele inclui classes para um banco, clientes e diferentes tipos de contas bancárias. O sistema permite operações como depósito, saque e transferência de dinheiro entre contas, além de imprimir extratos de contas e informações de clientes.

## Classes

### Banco

A classe `Banco` representa um banco e contém métodos para gerenciar clientes e contas.

- **Campos:**
  - `nome`: O nome do banco.
  - `contas`: Uma lista de contas no banco.
  - `clientes`: Uma lista de clientes no banco.

- **Métodos:**
  - `getNome()`: Retorna o nome do banco.
  - `setNome(String nome)`: Define o nome do banco.
  - `adicionarCliente(Cliente cliente)`: Adiciona um cliente ao banco.
  - `adicionarConta(Conta conta)`: Adiciona uma conta ao banco.
  - `getContas()`: Retorna a lista de contas no banco.
  - `getClientes()`: Retorna a lista de clientes no banco.
  - `imprimirClientes()`: Imprime a lista de clientes no banco.

### Cliente

A classe `Cliente` representa um cliente do banco.

- **Campos:**
  - `nome`: O nome do cliente.

- **Métodos:**
  - `getNome()`: Retorna o nome do cliente.
  - `setNome(String nome)`: Define o nome do cliente.

### Conta

A classe `Conta` é uma classe abstrata que representa uma conta bancária. Ela implementa a interface `IConta`.

- **Campos:**
  - `AGENCIA_PADRAO`: O número padrão da agência.
  - `agencia`: O número da agência da conta.
  - `numero`: O número da conta.
  - `saldo`: O saldo da conta.
  - `cliente`: O cliente que possui a conta.

- **Métodos:**
  - `Conta(Cliente cliente)`: Construtor que inicializa a conta com um cliente.
  - `depositar(double valor)`: Deposita um valor na conta.
  - `sacar(double valor)`: Saca um valor da conta.
  - `transferir(double valor, Conta contaDestino)`: Transfere um valor para outra conta.
  - `getAgencia()`: Retorna o número da agência da conta.
  - `getNumero()`: Retorna o número da conta.
  - `getSaldo()`: Retorna o saldo da conta.
  - `imprimirInfosComuns()`: Imprime informações comuns da conta.

### ContaCorrente

A classe `ContaCorrente` representa uma conta corrente e estende a classe `Conta`.

- **Métodos:**
  - `ContaCorrente(Cliente cliente)`: Construtor que inicializa a conta com um cliente.
  - `imprimirExtrato()`: Imprime o extrato da conta.

### ContaPoupanca

A classe `ContaPoupanca` representa uma conta poupança e estende a classe `Conta`.

- **Métodos:**
  - `ContaPoupanca(Cliente cliente)`: Construtor que inicializa a conta com um cliente.
  - `imprimirExtrato()`: Imprime o extrato da conta.

### IConta

A interface `IConta` define os métodos que uma conta bancária deve implementar.

- **Métodos:**
  - `sacar(double valor)`: Saca um valor da conta.
  - `depositar(double valor)`: Deposita um valor na conta.
  - `transferir(double valor, Conta contaDestino)`: Transfere um valor para outra conta.
  - `imprimirExtrato()`: Imprime o extrato da conta.

## Classe Principal

A classe `Main` demonstra o uso do sistema bancário.

- **Métodos:**
  - `main(String[] args)`: O método principal que executa a aplicação.

## Uso

Para usar este sistema bancário, siga estes passos:

1. Crie uma instância de `Banco`.
2. Crie instâncias de `Cliente` e defina seus nomes.
3. Adicione os clientes ao banco usando o método `adicionarCliente`.
4. Crie instâncias de `ContaCorrente` e `ContaPoupanca` para os clientes.
5. Adicione as contas ao banco usando o método `adicionarConta`.
6. Realize operações como depósito, saque e transferência de dinheiro.
7. Imprima extratos de contas e informações de clientes.

## Exemplo

```java
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
