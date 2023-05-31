package com.ifsc.tds.caio.gabriel.jose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ifsc.tds.caio.gabriel.jose.enity.Contato;
import com.peregrinoti.dao.Conexao;
import com.peregrinoti.entity.Amigo;


public class ContatoDAO implements DAO<Contato> {
	
@Override
 public Contato get (Integer idContato) {
	
	Contato contato = null;
	String sql = "Select * from contato where id = ?";

	// Recupera a conexão com o banco
	Connection conexao = null;

	// Criar uma preparação da consulta
	PreparedStatement stm = null;

	// Criar uma classe que guarde o retorno da operação
	ResultSet rset = null;

	try {

		conexao = new Conexao().getConnection();

		stm = conexao.prepareStatement(sql);
		stm.setInt(1, idContato.intValue());
		rset = stm.executeQuery();

		while (rset.next()) {
			contato = new Contato();

			// atribui campo para atributo
			contato.setIdContato(rset.getInt("id"));
			contato.setNome(rset.getString("Nome"));
			contato.setTelefone(rset.getString("Nome do Responsável"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {

			if (stm != null) {
				stm.close();
			}
			if (conexao != null) {
				conexao.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return contato;
	
}

@Override
public List<Contato> getAll() {
	List<Contato> contatos = new ArrayList<Contato>();

	String sql = "select * from amigo";

	// Recupera a conexão com o banco
	Connection conexao = null;

	// Criar uma preparação da consulta
	PreparedStatement stm = null;

	// Criar uma classe que guarde o retorno da operação
	ResultSet rset = null;

	try {

		conexao = new Conexao().getConnection();

		stm = conexao.prepareStatement(sql);
		rset = stm.executeQuery();

		while (rset.next()) {
			Contato contato = new Contato();

			// atribui campo para atributo
			contato.setIdContato(rset.getInt("id"));
			contato.setNome(rset.getString("Nome"));
			contato.setTelefone(rset.getString("Telefone"));		
			contatos.add(contato);

		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		try {
			if (stm != null) {
				stm.close();
			}

			if (conexao != null) {
				conexao.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return contatos;
}

@Override
public int save(Contato t) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean update(Contato t, String[] params) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(Contato t) {
	// TODO Auto-generated method stub
	return false;
}
	

}
