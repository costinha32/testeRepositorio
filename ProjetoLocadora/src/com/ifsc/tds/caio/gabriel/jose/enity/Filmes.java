package com.ifsc.tds.caio.gabriel.jose.enity;

public class Filmes {

	
	private Long id;

	private String nomeFilme;

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.nomeFilme;
	}

}
