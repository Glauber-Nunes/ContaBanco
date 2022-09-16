package interfacess;

import entites.superclasses.Conta;
import entites.superclasses.Pix;

public interface InterfaceConta {

	public double deposito(double quantia);

	public double saque(double quantia);

	public boolean validaLogin(String cpf);
	
	public double pix(double quantia);
}
