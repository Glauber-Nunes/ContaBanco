package entites.subclasses;

import entites.Conta;

public class ContaPoupança extends Conta {

	public ContaPoupança() {

	}

	public ContaPoupança(String cpf, String titular, Double saldo, String tipo) {
		super(cpf, titular, saldo, tipo);
	}

	@Override
	public double deposito(double quantia) {
	
		return saldo = saldo + quantia;
	}

	@Override
	public double saque(double quantia) {
		saldo = saldo - quantia;
		return saldo = saldo - TAXA_SAQUE_CONTA_POUPANÇA;
	}

}
