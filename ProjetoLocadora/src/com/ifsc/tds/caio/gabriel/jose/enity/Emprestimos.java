package com.ifsc.tds.caio.gabriel.jose.enity;

import java.sql.Date;

public class Emprestimos {
	
	private long id;
	private Date dataEmpre;
	private Date dataDev;
	private String desc;
	private Clientes clientes;
	private Filmes filmes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataEmpre() {
		return dataEmpre;
	}
	public void setDataEmpre(Date dataEmpre) {
		this.dataEmpre = dataEmpre;
	}
	public Date getDataDev() {
		return dataDev;
	}
	public void setDataDev(Date dataDev) {
		this.dataDev = dataDev;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	public Filmes getFilmes() {
		return filmes;
	}
	public void setFilmes(Filmes filmes) {
		this.filmes = filmes;
	}
	
	

}
