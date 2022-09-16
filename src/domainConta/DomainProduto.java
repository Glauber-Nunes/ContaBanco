package domainConta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import entites.subclasses.produtos.Computador;
import entites.subclasses.produtos.Iphone;
import entites.superclasses.ComprasRealizadas;
import entites.superclasses.Conta;
import entites.superclasses.Produto;

public abstract class DomainProduto {

	public static void escolherProduto(Conta conta, ComprasRealizadas comprasRealizadas) throws ParseException {

		int op = Integer.valueOf(JOptionPane.showInputDialog("[1]Notebook dell [2]Iphone"));

		switch (op) {

		case 1:
			comprarNotebook(conta, comprasRealizadas);
			break;

		case 2:
			comprarIphone(conta, comprasRealizadas);
			break;
		}
	}

	public static void comprarNotebook(Conta conta, ComprasRealizadas comprasRealizadas) throws ParseException {

		final String nome = "Notebook dell";
		final double preco = 2500;

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());
		// __________________________________________________________________________________

		int opCompra = JOptionPane.showConfirmDialog(null, "Deseja Comprar " + nome + " ?");

		if (opCompra == 0) {
			Computador computador = new Computador(nome, preco); // instanciando objeto

			int opParcelar = JOptionPane.showConfirmDialog(null, "Deseja Parcelar Compra?");

			if (opParcelar == 0) {

				final int VALOR_MAXIMO_PARCELA = 12;

				while (true) {
					int qtdParcelas = Integer.valueOf(JOptionPane.showInputDialog("Digite a quantidade de parcelas"));
					if (qtdParcelas > VALOR_MAXIMO_PARCELA) {
						JOptionPane.showMessageDialog(null, "Valor Maximo de parcelas Sao " + VALOR_MAXIMO_PARCELA);
					} else {
						validarCompra(conta, computador, comprasRealizadas); // chama o metodo de validar a compra
						for (int parcela = 0; parcela < qtdParcelas; parcela++) {
							calendar.add(Calendar.MONTH, 1);
							double valorDaParcela = computador.getPreco() / qtdParcelas;

							System.out.println("Parcela n° " + (parcela + 1) + " Vencimento: "
									+ new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()) + " Valor: "
									+ valorDaParcela);

						}

						JOptionPane.showMessageDialog(null, "Compra Realizada Com Sucesso Em " + qtdParcelas
								+ " Parcelas, Saldo " + conta.getSaldo());
						break;
					}

				}

			} else {
				// caso nao deseje parcelar
				validarCompra(conta, computador, comprasRealizadas); // chama o metodo de validar a compra
				JOptionPane.showMessageDialog(null, "Compra AVISTA Realizada Com Sucesso, Saldo: " + conta.getSaldo());
			}
		} else
			// caso opCompra == NAO volta para MENU
			ContaDomain.menuConta(conta, comprasRealizadas);
		{

		}
	}

	public static void comprarIphone(Conta conta, ComprasRealizadas comprasRealizadas) throws ParseException {

		final String nome = "Iphone X";
		final double preco = 3241.00;

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());

		int opCompra = JOptionPane.showConfirmDialog(null, "Deseja Comprar " + nome + " ?");
		Iphone iphone = new Iphone(nome, preco);
		if (opCompra == 0) {
			final int VALOR_MAXIMO_PARCELA = 12;
			int opParcela = JOptionPane.showConfirmDialog(null, "Deseja Parcela Compra ?");

			if (opParcela == 0) {

				while (true) {
					int qtdParcela = Integer.valueOf(JOptionPane.showInputDialog("Digite a quantidade de parcelas"));
					if (qtdParcela > VALOR_MAXIMO_PARCELA) {
						JOptionPane.showMessageDialog(null, "Valor Maximo de parcelas Sao " + VALOR_MAXIMO_PARCELA);
					} else {
						validarCompra(conta, iphone, comprasRealizadas);
						for (int parcela = 0; parcela < qtdParcela; parcela++) {
							calendar.add(Calendar.MONTH, 1);
							double valorParcela = iphone.getPreco() / qtdParcela;

							System.out.println("Parcela n° " + (parcela + 1) + " Vencimento: "
									+ new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()) + " Valor: "
									+ valorParcela);

						}
						JOptionPane.showMessageDialog(null, "Compra Realizada Com Sucesso Em " + qtdParcela
								+ " Parcelas, Saldo " + conta.getSaldo());
						break;
					}
				}

			} else {
				// caso nao deseje parcelar
				validarCompra(conta, iphone, comprasRealizadas); // chama o metodo de validar a compra
				JOptionPane.showMessageDialog(null, "Compra AVISTA Realizada Com Sucesso, Saldo: " + conta.getSaldo());
			}
		}

	}

	public static void validarCompra(Conta conta, Produto produto, ComprasRealizadas comprasRealizadas)
			throws ParseException {

		if (produto.getPreco() > conta.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
			ContaDomain.menuConta(conta, comprasRealizadas);
		} else {
			produto.comprar(conta, produto.getPreco());
			comprasRealizadas.getListDeProdutos().add(produto);
		}

	}
}