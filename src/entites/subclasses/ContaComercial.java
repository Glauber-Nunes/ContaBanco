package entites.subclasses;

import DomainExcesoes.ContaException;
import entites.Conta;

public class ContaComercial extends Conta {

	public ContaComercial() {

	}

	public ContaComercial(String cpf, String titular, Double saldo, String tipo) {
		super(cpf, titular, saldo, tipo);
	}

	@Override
	public double deposito(double quantia) {
		return saldo = saldo + quantia;
	}

	@Override
	public double saque(double quantia) {
		saldo = saldo - quantia;
		return saldo = saldo - TAXA_SAQUE_CONTA_COMERCIAL;
	}

	public void validaSaque(double quantia) {
		
		if(quantia > saldo) {
			throw new ContaException("Saque Insuficiente");
		}

	}

	public void validaDeposito(double quantia) {

	}
}
