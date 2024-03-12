package com.zoologico.dois;

import java.util.ArrayList;

public class TesteDoisZoo {

	public static void main(String[] args) {
		ArrayList<Animal> listaAnimais =  new ArrayList<Animal>();
		Cachorro bob =  new Cachorro();
		listaAnimais.add(bob);
		
		Animal huulke = new Cachorro();
		listaAnimais.add(huulke);
		Gato garfiel = new Gato();
		listaAnimais.add(garfiel);
		
		Animal  outroGato = new Gato();
		listaAnimais.add(outroGato);
		
		for (int i = 0; i < listaAnimais.size(); i++) {
			Animal umAnimal = listaAnimais.get(i);
			umAnimal.emitirSom();
			if ( umAnimal instanceof Cachorro)
			{
				System.out.println("É um cachorro");
			} else {
				System.out.println("É  um gato!!");
			}
		}
		
		

	}

}
