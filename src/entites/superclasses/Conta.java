package entites.superclasses;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.DOMImplementationSource;

import entites.subclasses.contas.ContaComercial;
import entites.subclasses.contas.ContaPoupança;
import interfacess.InterfaceConta;

public abstract class Conta implements InterfaceConta { // super classe

	// atributos protecteds
	protected String cpf;
	protected String titular;
	protected double saldo;
	protected String tipo;

	protected List<Double> listaDeDepositos = new ArrayList<>();
	protected List<Double> listaDeSaques = new ArrayList<>();
	protected List<Pix> listaDePix = new ArrayList<>();

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

	public List<Double> getListaDeDepositos() {
		return listaDeDepositos;
	}

	public List<Double> getListaDeSaques() {
		return listaDeSaques;
	}
	
	
	public List<Pix> getListaDePix() {
		return listaDePix;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conta [cpf=");
		builder.append(cpf);
		builder.append(", titular=");
		builder.append(titular);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
}
