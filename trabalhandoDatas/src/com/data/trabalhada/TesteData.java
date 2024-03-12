package com.data.trabalhada;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class TesteData {

	public static void main(String[] args) {
		Calendar dataInicio = Calendar.getInstance();
		
		dataInicio.set(2002, Calendar.SEPTEMBER, 12);
		
		Calendar datafinal = Calendar.getInstance();
		
		long diferenca = datafinal.getTimeInMillis() - dataInicio.getTimeInMillis();
		
		int tempoDia = 1000 * 60 *60 *24;
		
		long diasDiferenca = diferenca / tempoDia;
		
		JOptionPane.showMessageDialog(null, "Já se passaram " + diasDiferenca + " dias do nascimento");
		
}

}
