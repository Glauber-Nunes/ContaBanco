package entites.subclasses.contas;

import java.util.List;

import javax.swing.JOptionPane;

import DomainExcesoes.ContaException;
import domainConta.ContaDomain;
import entites.superclasses.Conta;
import entites.superclasses.Pix;

public class ContaComercial extends Conta {

	public ContaComercial() {

	}

	public ContaComercial(String tipo) {
		this.tipo = tipo;
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
		return saldo = saldo - quantia;
	}

	// retorna true || false
	@Override
	public boolean validaLogin(String cpf) {
		return this.cpf.equals(cpf);
	}

	@Override
	public double pix(double quantia) {
		
		return saque(quantia);
	}

	
}
