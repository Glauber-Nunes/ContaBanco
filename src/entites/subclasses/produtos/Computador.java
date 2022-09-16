package entites.subclasses.produtos;

import javax.swing.JOptionPane;

import entites.superclasses.Conta;
import entites.superclasses.Produto;

public class Computador extends Produto {

	public Computador() {

	}

	public Computador(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public double comprar(Conta conta, double preco) {
		return super.comprar(conta, preco);
	}

	@Override
	public void apresentarProduto() {
		// TODO Auto-generated method stub
		super.apresentarProduto();
	}

}
