package teste;

import javax.swing.JOptionPane;

import domainConta.ContaDomain;
import entites.Conta;
import entites.subclasses.ContaComercial;

public class TestProgramming {

	public static void main(String[] args) {

		Conta contaComercial = new ContaComercial();
		Conta contaPoupanca = new ContaComercial();

		String tipo = JOptionPane.showInputDialog("CP OU CC", "Informe O tipo De conta");

		if (tipo.equalsIgnoreCase("CC")) {
			contaComercial.setTipo("CONTA COMERCIAL");
			ContaDomain.abrirConta(contaComercial);
			System.out.println(contaComercial); // imprime na tela
			ContaDomain.menuConta(contaComercial);
			ContaDomain.depositoDados(contaComercial);
			ContaDomain.depositoDados(contaComercial);

		}
	}

}
