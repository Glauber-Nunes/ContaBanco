package domainConta;

import javax.swing.JOptionPane;

import entites.Conta;

public abstract class ContaDomain {

	public static void menuConta(Conta conta) {

		int op = Integer
				.valueOf(JOptionPane.showInputDialog("O que voçe deseja Fazer?", "[1]DEPOSITO [2]SAQUE [3]SALDO"));

		switch (op) {
		case 1:
			depositoDados(conta);
			menuConta(conta);
			break;
		case 2:
			if (conta.getSaldo() <= 0) {
				JOptionPane.showMessageDialog(null, "Voçe Nao Tem saldo para sacar :( ");
				menuConta(conta);
			} else {
				saqueDados(conta);
				menuConta(conta);
			}
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Seu saldo " + conta.getSaldo() + " R$");
			menuConta(conta);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opçao Invalida");
			menuConta(conta);
			break;
		}

	}

	public static void abrirConta(Conta conta) {

		JOptionPane.showMessageDialog(null, "BEM VINDO A ABERTURA DA SUA CONTA " + conta.getTipo());

		String cpf = JOptionPane.showInputDialog("Insira Seu Cpf");
		String titular = JOptionPane.showInputDialog("Titular Da conta");

		conta.setCpf(cpf);
		conta.setTitular(titular);

		JOptionPane.showMessageDialog(null, "Sua Conta foi Aberta Com Sucesso");

	}

	public static void depositoDados(Conta conta) {

		int opDeposito = JOptionPane.showConfirmDialog(null, "Deseja Depositar em sua Conta?");

		if (opDeposito == 0) {
			double quantia = Double.valueOf(JOptionPane.showInputDialog("Digite A quantia"));
			conta.deposito(quantia);
			conta.getListaDeDepositos().add(quantia);
			JOptionPane.showMessageDialog(null, "DEPOSITO Realizado Com Sucesso");
			menuConta(conta);
		} else {
			menuConta(conta);
		}
	}

	public static void saqueDados(Conta conta) {

		int opSaque = JOptionPane.showConfirmDialog(null, "Deseja Sacar da sua Conta?");

		if (opSaque == 0) {
			double quantia = Double.valueOf(JOptionPane.showInputDialog("Digite A quantia Para Saque"));
			conta.saque(quantia);
			if (conta.getTipo().equalsIgnoreCase("CONTA COMERCIAL")) {
				System.out.println("(_SAQUE_)Saldo Atualizado com desconto de " + conta.getTaxaSaqueContaComercial()
						+ " " + conta.getSaldo() + " R$");
				menuConta(conta);
			} else {
				System.out.println("(_SAQUE_)Saldo Atualizado com desconto de " + conta.getTaxaSaqueContaPoupança()
						+ " " + conta.getSaldo() + " R$");
				menuConta(conta);
			}

		} else {
			// opSaque == 1
			menuConta(conta);

		}

	}

	public void pecorreListaDeposito(Conta conta) {

		for (Double deposito : conta.getListaDeDepositos()) {
			System.out.println("Deposito: " + deposito);
		}

	}
}
