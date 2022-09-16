package entites.superclasses;

import javax.swing.JOptionPane;

import interfacess.InterfaceConta;
import interfacess.InterfaceProduto;

// SUPER CLASSE PRODUTO
public abstract class Produto implements InterfaceProduto {

	protected String nome;
	protected double preco;

	public Produto() {

	}

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public double comprar(Conta conta, double preco) {

		return conta.saque(preco);
	}

	@Override
	public void apresentarProduto() {
		JOptionPane.showMessageDialog(null, "VOÇE COMPROU UM: " + nome + " " + " Preço: " + preco);

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [Nome=");
		builder.append(nome);
		builder.append(", Preco=");
		builder.append(preco);
		builder.append("]");
		return builder.toString();
	}

}
