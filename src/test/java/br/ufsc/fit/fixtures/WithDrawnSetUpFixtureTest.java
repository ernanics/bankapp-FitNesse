package br.ufsc.fit.fixtures;

import java.util.Date;

import br.ufsc.domain.ATMApp;
import br.ufsc.model.ATM;
import fitlibrary.SetUpFixture;

public class WithDrawnSetUpFixtureTest extends SetUpFixture {
	
	private ATM atm;
	
	public WithDrawnSetUpFixtureTest() {
		super();
	}
	
	private ATM getATM() {
		if (this.atm == null) {
			if(ATMApp.atm != null) {
				this.atm = ATMApp.atm; 
			} else {
				this.atm = new ATM();
			}
		}
		return this.atm;
	}
	
	public void idUsuarioContaCorrenteSaldoNumeroDoCartaoSenhaNumeroDeNotasDe5Comma10Comma20Comma50E100CommaDisponiveisNoCaixaEletronicoCommaSeparadosPorVirgula(long id, String fullName, String accountNumber, double balance, String cardNumber, int pin,  int[] bills) {
		//atm = new ATM();
		ATMApp.atm = null;
		this.getATM().getBank().createBankCustomer(id, fullName, cardNumber, pin, accountNumber, balance);
		this.getATM().chargeBills(bills[0], bills[1], bills[2], bills[3], bills[4]);
		this.getATM().chargeBills(0, 200, 0, 150, 100);
		ATMApp.atm = this.getATM();
	}
	
	public void numeroDoCartaoSenhaCorretaNumeroHoraAtras(String numeroDoCartao, boolean senhaCorreta, Integer numeroHoraAtras) throws Exception { 
		this.getATM().getBank().getCardByNumber(numeroDoCartao).insertPinHistory(senhaCorreta, new Date(new Date().getTime()-(numeroHoraAtras*3600000)));
		
	}
	

	
}
