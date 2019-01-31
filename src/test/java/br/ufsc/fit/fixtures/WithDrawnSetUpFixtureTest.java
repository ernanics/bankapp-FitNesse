package br.ufsc.fit.fixtures;

import java.util.Date;

import br.ufsc.domain.ATMApp;
import fitlibrary.SetUpFixture;

public class WithDrawnSetUpFixtureTest extends SetUpFixture {

	public void idUsuarioContaCorrenteSaldoNumeroDoCartaoSenhaNumeroDeNotasDe5Comma10Comma20Comma50E100CommaDisponiveisNoCaixaEletronicoCommaSeparadosPorVirgula(
			long id, String usuario, String contaCorrente, double saldo, String numeroDoCartao, int senha, 
			String txtNotas) {
		ATMApp.atm.getBank().createBankCustomer(id, usuario, numeroDoCartao, senha, contaCorrente, saldo);

		String[] notas = txtNotas.split(",");

		int numOf5Bills = Integer.parseInt(notas[0]);
		int numOf10Bills = Integer.parseInt(notas[1]);
		int numOf20Bills = Integer.parseInt(notas[2]);
		int numOf50Bills = Integer.parseInt(notas[3]);
		int numOf100Bills = Integer.parseInt(notas[4]);
		ATMApp.atm.chargeBills(numOf5Bills, numOf10Bills, numOf20Bills, numOf50Bills, numOf100Bills);
	}

	public String numeroDoCartaoSenhaCorretaNumeroHoraAtras(String numeroDoCartao, boolean senhaCorreta, int numeroHoraAtras) { 

		Date dataTentativa = new Date(new Date().getTime()-(numeroHoraAtras*3600000));

		try {
			ATMApp.atm.getBank().getCardByNumber(numeroDoCartao).insertPinHistory(senhaCorreta, dataTentativa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numeroDoCartao;

	}
}