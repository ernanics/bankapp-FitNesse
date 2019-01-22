package br.ufsc.fit.fixtures;

import br.ufsc.model.Loan;
import fit.ColumnFixture;

public class CalculateEMIColumnFixture extends ColumnFixture {
	public Double valorAFinanciar;
	public Double taxaDeJuros;
	public Long numeroDeParcelas;
	
	public CalculateEMIColumnFixture() {
		super();
	}
	
	public Double valorDasParcelasMensais(){
		Loan loan = new Loan(valorAFinanciar, taxaDeJuros, numeroDeParcelas);
		return loan.getValueOfMontlhyInstalments().doubleValue();
		
	}
	
	public Double valorTotalAPagarComJuros() {
		Loan loan = new Loan(valorAFinanciar, taxaDeJuros, numeroDeParcelas);
		return loan.getLoanAmountWithInterests().doubleValue();
	}
	
}
