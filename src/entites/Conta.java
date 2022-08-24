package entites;

import java.util.ArrayList;
import java.util.List;

import interfacess.InterfaceConta;

public abstract class Conta implements InterfaceConta{

	// atributos protecteds
	protected String cpf;
	protected String titular;
	protected double saldo;
	protected String tipo;

	protected final static double TAXA_SAQUE_CONTA_COMERCIAL = 5;
	protected final static double TAXA_SAQUE_CONTA_POUPANÇA = 2;

	protected List<Double> listaDeDepositos = new ArrayList<>();

	public Conta() {

	}

	public Conta(String cpf, String titular, Double saldo, String tipo) {
		this.cpf = cpf;
		this.titular = titular;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public static double getTaxaSaqueContaComercial() {
		return TAXA_SAQUE_CONTA_COMERCIAL;
	}

	public static double getTaxaSaqueContaPoupança() {
		return TAXA_SAQUE_CONTA_POUPANÇA;
	}

	public List<Double> getListaDeDepositos() {
		return listaDeDepositos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conta [cpf=");
		builder.append(cpf);
		builder.append(", titular=");
		builder.append(titular);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}

	
	
}
