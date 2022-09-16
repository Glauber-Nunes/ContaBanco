package entites.superclasses;

import java.util.ArrayList;
import java.util.List;

public class ComprasRealizadas extends Produto {

	private List<Produto> listDeProdutos = new ArrayList<>(); // lista de produtos

	public List<Produto> getListDeProdutos() {
		return listDeProdutos;
	}

	public void setListDeProdutos(List<Produto> listDeProdutos) {
		this.listDeProdutos = listDeProdutos;
	}

	@Override
	public double comprar(Conta conta, double preco) {
		// TODO Auto-generated method stub
		return 0;
	}
}
