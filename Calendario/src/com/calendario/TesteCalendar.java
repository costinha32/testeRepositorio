package com.calendario;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class TesteCalendar {

	public static void main(String[] args) {
		Calendar calendario = Calendar.getInstance();
		JOptionPane.showMessageDialog(null, calendario.getTime());

	}

}
