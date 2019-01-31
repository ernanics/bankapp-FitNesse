package br.ufsc.fit.fixtures;

import br.ufsc.model.Loan;
import fit.ColumnFixture;

public class CalculateEMIColumnFixture extends ColumnFixture {
	
	public double valorAFinanciar;
	public double taxaDeJuros;
	public long numeroDeParcelas;
	
	
	public double valorDasParcelasMensais(){
		Loan emp = new Loan(valorAFinanciar, taxaDeJuros, numeroDeParcelas);
		return emp.getValueOfMontlhyInstalments().doubleValue(); 
	}
	
	public double valorTotalAPagarComJuros(){
		Loan emp = new Loan(valorAFinanciar, taxaDeJuros, numeroDeParcelas);
		return emp.getLoanAmountWithInterests().doubleValue(); 
	}
}