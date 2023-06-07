package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.br.Calculadora;
import com.br.ConversorDeMoeda;
import com.br.Retangulo;

class TesteCalculadora {
	
	Retangulo r = new Retangulo();
	ConversorDeMoeda moeda = new ConversorDeMoeda();
	
	Calculadora calc =  new Calculadora();
	
	@Test
	public void testSoma() {
		int resultado = calc.soma(5, 6);
		assertEquals(11, resultado);
	}
	@Test 
	public void testSubtrair() {
		int resultado =  calc.subtracao(30, 10);
		assertEquals(20, resultado);
	}
	@Test 
	public void tesDivisao() {
		int resultado =  calc.divisao(20, 5);
		assertEquals(4, resultado);
	}
	@Test 
	public void testMultiplicar() {
		int resultado =  calc.multiplicacao(5, 6);
		assertEquals(30, resultado);
	}
	
	@Test
	public void testRetangulo() {
		double resultado = r.calculaArea(4, 8);
		assertEquals(32, resultado);
	}
	
	@Test
	public void testConverterMoeda() {
		
		double resultado = moeda.converter(100.00, "USD", "BRL");
		assertEquals(534.00, resultado);
	}
	@Test
	public void testConverterMoeda1() {
		
		double resultado = moeda.converter(200.00, "BRL", "USD");
		assertEquals(32.00, resultado);
	}

}
