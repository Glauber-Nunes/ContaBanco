package domainConta;

import java.io.ObjectInputStream.GetField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entites.subclasses.contas.ContaComercial;
import entites.subclasses.contas.ContaPoupança;
import entites.subclasses.produtos.Computador;
import entites.subclasses.produtos.Iphone;
import entites.superclasses.ComprasRealizadas;
import entites.superclasses.Conta;
import entites.superclasses.Pix;
import entites.superclasses.Produto;
import enums.Mensagens;

public abstract class ContaDomain {

	public static void informarRendaPoupanca(ContaPoupança contaPoupança) {

		double renda = Double.valueOf(JOptionPane.showInputDialog("Informe Sua Renda"));

		if (renda == 0.00) {
			JOptionPane.showMessageDialog(null, "POR FAVOR INFORME UMA RENDA VALIDA");
			informarRendaPoupanca(contaPoupança);
		} else if (renda >= 1212.00) {
			JOptionPane.showMessageDialog(null, "VOÇE NAO SE ENCAIXA NOS CRITERIOS PARA UMA CONTA POUPANÇA");
			informarRendaPoupanca(contaPoupança);
		} else {
			JOptionPane.showMessageDialog(null, "PARABENS VOÇE FOI APROVADO");
			contaPoupança.setRenda(renda);
		}

	}

	public static void abrirContaPoupanca(ContaPoupança contaPoupança, Produto produto,
			ComprasRealizadas comprasRealizadas) throws InterruptedException, ParseException {

		// formatando data com SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder saida = new StringBuilder();

		String cpf = JOptionPane.showInputDialog("Insira Seu Cpf");

		// CONDIÇAO PARA REALIZAR CONSULTA SE O CPF E O TITULAR FOI INFORMADO
		if (cpf.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "CPF Nao informado");
			abrirContaPoupanca(contaPoupança, produto, comprasRealizadas);
		}

		String titular = JOptionPane.showInputDialog("Titular Da conta");

		if (titular.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Titular Nao informado");
			abrirContaPoupanca(contaPoupança, produto, comprasRealizadas);

		}

		contaPoupança.setCpf(cpf);
		contaPoupança.setTitular(titular);

		JOptionPane.showMessageDialog(null, "DATA " + sdf.format(new Date()));

		JOptionPane.showMessageDialog(null, contaPoupança.getTipo() + " " + Mensagens.msgContaAbertaComSucesso);// mensagem

		saida.append(contaPoupança);
		System.out.println(saida);// imprime no console os dados da conta

		login(contaPoupança, comprasRealizadas);

	}

	public static void abrirContaComercial(ContaComercial contaComercial, ComprasRealizadas comprasRealizadas)
			throws InterruptedException, ParseException {

		StringBuilder saida = new StringBuilder();

		String cpf = JOptionPane.showInputDialog("Insira Seu Cpf");

		if (cpf.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "CPF Nao Informado");
			abrirContaComercial(contaComercial, comprasRealizadas);
		}

		String titular = JOptionPane.showInputDialog("Titular Da conta");

		if (titular.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Titular Nao informado");
			abrirContaComercial(contaComercial, comprasRealizadas);
		}

		contaComercial.setCpf(cpf);
		contaComercial.setTitular(titular);

		JOptionPane.showMessageDialog(null, contaComercial.getTipo() + " " + Mensagens.msgContaAbertaComSucesso);// mensagem

		saida.append(contaComercial);

		Thread.sleep(1000); // thread para dar um tempo ao inicar proxima classe de login
		System.out.println(saida); // IMPRIME NO CONSOLE OS DADOS DA CONTA

		login(contaComercial, comprasRealizadas);

	}

	public static void login(Conta conta, ComprasRealizadas comprasRealizadas) throws ParseException {

		for (int tentativas = 3; tentativas >= 0; tentativas--) {

			String cpf = JOptionPane.showInputDialog("TELA DE LOGIN", "informe Seu Cpf Cadastrado");

			if (conta.validaLogin(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagens.msgSEJABEMVINDO + " " + conta.getTitular());
				menuConta(conta, comprasRealizadas);
				break;
			} else {
				JOptionPane.showMessageDialog(null, Mensagens.msgCPFINVALIDO + " " + tentativas + "° Tentativas");

				if (tentativas == 0) {
					JOptionPane.showMessageDialog(null, "Cadastro Bloqueado Faça Um Novo Cadastro");
					break;
				}

			}

		}

	}

	public static void menuConta(Conta conta, ComprasRealizadas comprasRealizadas) throws ParseException {

		int op = Integer.valueOf(JOptionPane
				.showInputDialog("[1]DEPOSITO [2]SAQUE [3]SALDO [4]Lista De Depositos [5]Lista De Saques [6]Shopping"
						+ " Banco [7]Compras Feitas [8]PIX [9] lIsta De Pix [10]Sair"));

		switch (op) {
		case 1:
			depositoDados(conta, comprasRealizadas);
			menuConta(conta, comprasRealizadas);
			break;
		case 2: // FAZER SAQUE
			if (conta.getSaldo() <= 0) { // SO CHAMA O METODO SAQUE CASO AJA SALDO MAIOR QUE ZERO
				JOptionPane.showMessageDialog(null, Mensagens.msgSEMSALDO);
				menuConta(conta, comprasRealizadas);
			} else {
				saqueDados(conta, comprasRealizadas);
				menuConta(conta, comprasRealizadas);
			}
			break;
		case 3:
			JOptionPane.showMessageDialog(null, Mensagens.msgSEUSALDO + " " + conta.getSaldo() + "R$");
			menuConta(conta, comprasRealizadas);
			break;

		case 4:
			pecorreListaDeposito(conta);// chama metodo de ver lista de depositos
			menuConta(conta, comprasRealizadas); // volta para o menu
			break;

		case 5:
			listaDeSaques(conta);
			menuConta(conta, comprasRealizadas);
			break;

		case 6:
			DomainProduto.escolherProduto(conta, comprasRealizadas);
			menuConta(conta, comprasRealizadas);
			break;

		case 7:
			listaDeCompras(comprasRealizadas);
			menuConta(conta, comprasRealizadas);
			break;

		case 8:
			fazerPix(conta);
			menuConta(conta, comprasRealizadas);
			break;

		case 9:
			pecorreListaPix(conta);
			menuConta(conta, comprasRealizadas);
			break;
		default:
			JOptionPane.showMessageDialog(null, Mensagens.msgOPCAOINVALIDA);
			menuConta(conta, comprasRealizadas);
			break;
		}

	}

	// INSERIR OS DADOS PARA DEPOSITO EM CONTA
	public static void depositoDados(Conta conta, ComprasRealizadas comprasRealizadas) throws ParseException {

		int opDeposito = JOptionPane.showConfirmDialog(null, "Deseja Depositar em sua Conta?");

		if (opDeposito == 0) {
			double quantia = Double.valueOf(JOptionPane.showInputDialog("Digite A quantia"));
			validaDeposito(conta, quantia);

		} else {
			menuConta(conta, comprasRealizadas);
		}
	}

	public static void saqueDados(Conta conta, ComprasRealizadas comprasRealizadas) throws ParseException {

		int opSaque = JOptionPane.showConfirmDialog(null, "Deseja Sacar da sua Conta?");

		if (opSaque == 0) {
			double quantia = Double.valueOf(JOptionPane.showInputDialog("Digite A quantia Para Saque"));
			validaSaque(conta, quantia, comprasRealizadas);

		} else {
			// opSaque == 1
			menuConta(conta, comprasRealizadas);

		}

	}

	public static void pecorreListaDeposito(Conta conta) {

		if (conta.getListaDeDepositos().size() == 0) {
			JOptionPane.showMessageDialog(null, "Voçe Ainda nao efetuou Nenhum Deposito");
		}

		// IMPRIME LISTA DE DEPOSITOS APENAS UMA VEZ NA TELA
		for (Double depositos : conta.getListaDeDepositos()) {

			JOptionPane.showMessageDialog(null, "Depositos: " + conta.getListaDeDepositos());
			break;
		}
	}

	public static void listaDeSaques(Conta conta) {

		if (conta.getListaDeSaques().size() == 0) {
			JOptionPane.showMessageDialog(null, "Voçe Ainda nao efetuou Nenhum Saque..");
		}

		// IMPRIME LISTA DE SAQUES APENAS UMA VEZ NA TELA
		for (Double saque : conta.getListaDeSaques()) {
			JOptionPane.showMessageDialog(null, "Saques: " + conta.getListaDeSaques());
			break;
		}

	}

	public static void validaSaque(Conta conta, double quantia, ComprasRealizadas comprasRealizadas) throws ParseException {

		if (quantia > conta.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
			menuConta(conta, comprasRealizadas);

		} else if (quantia == 0.00) {
			JOptionPane.showMessageDialog(null, "Informe um valor Valido Para Saque");
			menuConta(conta, comprasRealizadas);

		} else {
			conta.saque(quantia);
			JOptionPane.showMessageDialog(null, "SAQUE REALIZADO COM SUCESSO..");
			if (quantia > 0) { // ADCIONA NA LISTA DE SAQUES APENAS VALORES MAIOR QUE ZERO
				conta.getListaDeSaques().add(quantia);
			}
		}

	}

	public static void validaDeposito(Conta conta, double quantia) {

		if (quantia <= 0) {
			JOptionPane.showMessageDialog(null, Mensagens.msgQUANTIAINVALIDAPARADEPOSITO);

		} else {
			conta.deposito(quantia);

			if (quantia > 0) {
				conta.getListaDeDepositos().add(quantia); // ADCIONA NA LISTA DE DEPOSITOS APENAS VALORES MAIOR QUE ZERO
			}

			JOptionPane.showMessageDialog(null,
					Mensagens.msgDEPOSITOREALIZADOCOMSUCESSO + " SALDO: " + conta.getSaldo() + "R$");

		}

	}

	

	public static void listaDeCompras(ComprasRealizadas comprasRealizadas) {

		if (comprasRealizadas.getListDeProdutos().size() == 0) {
			JOptionPane.showMessageDialog(null, "Voçe Ainda nao efetuou nenhuma Compra");
		}

		for (Produto compras : comprasRealizadas.getListDeProdutos()) {
			JOptionPane.showMessageDialog(null, comprasRealizadas.getListDeProdutos().toString());
			break;
		}

	}

	public static void fazerPix(Conta conta) throws ParseException {

		int op = JOptionPane.showConfirmDialog(null, "Deseja Fazer PIX?");

		if (op == 0) {
			validarPix(conta);
		} else {
			menuConta(conta, null);
		}

	}

	public static void validarPix(Conta conta) {
		String chavePix = JOptionPane.showInputDialog("Digite a Chave Pix");
		Pix pixx = new Pix(chavePix);

		double quantia = Double.valueOf(JOptionPane.showInputDialog("Valor do Pix"));

		if (quantia > conta.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Voçe nao tem Saldo Suficiente Para fazer esse Pix");

		} else if (quantia <= 0) {
			JOptionPane.showMessageDialog(null, "Valor Invalido Para Pix");
		} else {
			conta.pix(quantia);
			conta.getListaDePix().add(pixx);
			JOptionPane.showMessageDialog(null, "Pix Realizado Com Sucesso");
		}

	}

	public static void pecorreListaPix(Conta conta) {

		if (conta.getListaDePix().size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum PIX Feito");
		}

		for (Pix pix : conta.getListaDePix()) {
			JOptionPane.showMessageDialog(null, "Destinatario pix" + conta.getListaDePix());
			break;
		}

	}
}
