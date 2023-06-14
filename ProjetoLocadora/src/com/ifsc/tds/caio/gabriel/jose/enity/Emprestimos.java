package com.ifsc.tds.caio.gabriel.jose.enity;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Emprestimos {
	
	private long id;
	private Date dataEmpre;
	private Date dataDev;
	private String descr;
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
	public String getDescr() {
		return descr;
	}
	public void setDesc(String desc) {
		this.descr = desc;
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
	public String getDataEmpreFormatada() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.dataEmpre.toLocalDate().format(formato).toString();
	}
	public String getDataDevFormatada() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.dataDev.toLocalDate().format(formato).toString();
	}
	
	

}
