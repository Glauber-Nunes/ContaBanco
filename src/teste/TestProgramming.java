package teste;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JOptionPane;

import DomainExcesoes.ContaException;
import domainConta.ContaDomain;
import entites.subclasses.contas.ContaComercial;
import entites.subclasses.contas.ContaPoupança;
import entites.subclasses.produtos.Computador;
import entites.superclasses.ComprasRealizadas;
import entites.superclasses.Produto;
import enums.Mensagens;

public class TestProgramming {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException, ParseException {

		try {

			ComprasRealizadas comprasRealizadas = new ComprasRealizadas();

			int tipo = Integer
					.valueOf(JOptionPane.showInputDialog("Informe O tipo de conta", "[1]COMERCIAL [2]POUPANÇA"));

			// INICIALIZANDO OBJETO CONTACOMERCIAL
			if (tipo == 1) {
				ContaComercial contaComercial = new ContaComercial("Conta Comercial"); // INSTANCIANDO OBJ
				JOptionPane.showMessageDialog(null,
						Mensagens.msgBemVindoAberturaDaConta + " " + contaComercial.getTipo());
				ContaDomain.abrirContaComercial(contaComercial, comprasRealizadas);
			} else if (tipo == 2) {
				ContaPoupança contaPoupança = new ContaPoupança("Conta Poupança"); // INSTANCIANDO OBJ
				JOptionPane.showMessageDialog(null,
						Mensagens.msgBemVindoAberturaDaConta + " " + contaPoupança.getTipo());
				ContaDomain.informarRendaPoupanca(contaPoupança);
				ContaDomain.abrirContaPoupanca(contaPoupança, null, null);
			} else {
				JOptionPane.showMessageDialog(null, "OPÇAO INVALIDA");
			}

		} catch (NumberFormatException e) { // CAPTURANDO EXCESSAO NumberFormatException
			e.printStackTrace(); // IMPRIME ERRO NO CONSOLE
			JOptionPane.showMessageDialog(null, "VALOR INVALIDO"); // IMPRIME MENSAGEN PARA USUARIO
		} catch (ContaException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			JOptionPane.showMessageDialog(null, "Sistema Finalizado");
		}

	}
}
