package br.ufsc.fit.fixtures;

import java.util.HashMap;
import java.util.Map;

import br.ufsc.domain.ATMApp;
import fit.ActionFixture;

public class WithDrawActionFixtureTest extends ActionFixture {
	
	private String numeroDoCartao;
	private Integer valorParaSacar;
	private Integer senha;
		
	public void numeroDoCartao(String numero){
		this.numeroDoCartao = numero;
	}
	
	public void valorParaSacar(Integer valor){
		this.valorParaSacar = valor;
	}
	
	public void OK(){
		
	}
	
	public void senha(int senhaDigitada){
		this.senha = senhaDigitada;
	}
	
	public boolean oValorEValido(){
		Map<Integer,Integer> bills = new HashMap<Integer,Integer>(); 
		try {
			ATMApp.atm.getAvailableBillsByAmount(bills, 100, 100, this.valorParaSacar, this.valorParaSacar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String Confirmar(){
		
		String mensagem = "";
		
		try {
			ATMApp.atm.withDraw(numeroDoCartao, senha, valorParaSacar);
			mensagem = "Operação realizada com sucesso!"; 
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		return mensagem;
	}
	
	public double SaldoAtual() throws Exception{
		double saldo = ATMApp.atm.getBank().getAccountByCardNumber(numeroDoCartao).getBalance();
		
		return saldo;
	}
	
}
