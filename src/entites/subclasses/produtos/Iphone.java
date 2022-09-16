package entites.subclasses.produtos;

import entites.superclasses.Conta;
import entites.superclasses.Produto;

public class Iphone extends Produto {

	public Iphone(String nome, double preco) {
		super(nome, preco);
	}

	@Override
	public double comprar(Conta conta, double preco) {
		// TODO Auto-generated method stub
		return super.comprar(conta, preco);
	}

	@Override
	public void apresentarProduto() {
		// TODO Auto-generated method stub
		super.apresentarProduto();
	}
}
