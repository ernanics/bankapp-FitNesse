package br.ufsc.fit.fixtures;

import java.util.HashMap;
import java.util.Map;

import br.ufsc.domain.ATMApp;
import fit.ActionFixture;

public class WithDrawActionFixtureTest extends ActionFixture {
	public Integer amount;
	public int PIN;
	public String card;
	
	public void valorParaSacar(Integer amount) {
		this.amount = amount;
	}
	
	public void numeroDoCartao(String card) {
		this.card = card;
	}
	
	
	public void OK() {
		
	}
	
	public boolean oValorEValido() {
		Map<Integer,Integer> bills = new HashMap<Integer,Integer>(); 
		try {
			ATMApp.atm.getAvailableBillsByAmount(bills, 100, 100, this.amount, this.amount);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void senha(int PIN) {
		this.PIN = PIN;
		
	}
	
	public String Confirmar() {
		try {
			ATMApp.atm.withDraw(this.card, this.PIN, this.amount);
			return "Operação realizada com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public double SaldoAtual() throws Exception {
		return ATMApp.atm.getBank().getAccountByCardNumber(this.card).getBalance();
	}
	
}
