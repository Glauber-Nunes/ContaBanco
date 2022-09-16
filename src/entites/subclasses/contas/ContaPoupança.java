package entites.subclasses.contas;

import javax.management.remote.SubjectDelegationPermission;

import DomainExcesoes.ContaException;
import entites.superclasses.Conta;
import entites.superclasses.Pix;
import interfacess.InterfaceConta;

public class ContaPoupança extends Conta {

	private double renda; // ATRIBUTO PROPRIO DA CLASSE CONTA POUPANÇA

	public ContaPoupança() {

	}

	public ContaPoupança(String tipo) {
		this.tipo = tipo;
	}

	public ContaPoupança(String cpf, String titular, Double saldo, String tipo, double renda) {
		super(cpf, titular, saldo, tipo);
		this.renda = renda;
	}

	@Override
	public double deposito(double quantia) {

		return saldo = saldo + quantia;
	}

	@Override
	public double saque(double quantia) {
		return saldo = saldo - quantia;
	}

	@Override
	public boolean validaLogin(String cpf) {
		return this.cpf.equals(cpf);
	}

	

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CPF:");
		builder.append(cpf);
		builder.append(", Titular:");
		builder.append(titular);
		builder.append(tipo);
		builder.append(", Renda Mensal:");
		builder.append(renda);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public double pix(double quantia) {
		// TODO Auto-generated method stub
		return saque(quantia);
	}
}
