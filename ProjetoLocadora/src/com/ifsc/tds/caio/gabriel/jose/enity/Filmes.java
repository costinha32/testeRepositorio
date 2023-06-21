package com.ifsc.tds.caio.gabriel.jose.enity;

public class Filmes {
	
	private long id;
	private String nomeFilme;

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.nomeFilme;
	}



}
