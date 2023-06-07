package com.ifsc.tds.caio.gabriel.jose.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ifsc.tds.caio.gabriel.jose.enity.Clientes;
import java.sql.PreparedStatement;
import java.sql.Connection;;

public class ClientesDAO implements DAO<Clientes> {

	@Override
	public Clientes get(Long id) {
		Clientes clientes = null;
		String sql = "select * from cliente where id=?";
		
		Connection conexao = null;
		
		PreparedStatement stm = null;
		ResultSet rset = null;
		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setInt(1, id.intValue());
			rset = stm.executeQuery();
			
			while(rset.next()) {
				clientes = new Clientes();
				
				clientes.setId(rset.getLong("id"));
				clientes.setNome(rset.getNString("nome"));
				clientes.setEmail(rset.getNString("email"));
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
			return clientes;
		}

	@Override
	public List<Clientes> getAll() {
		List<Clientes> clientes = new ArrayList<Clientes>();

		String sql = "select * from clientes";

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
				Clientes clientes = new Clientes();

				// atribui campo para atributo
				clientes.setId(rset.getLong("id"));
				clientes.setNome(rset.getString("nome"));
				clientes.setEmail(rset.getString("email"));
			
				clientes.add(clientes);
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
		return cli;
	
	}

	@Override
	public int save(Clientes t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Clientes t, String[] params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Clientes t) {
		// TODO Auto-generated method stub
		return false;
	}

}
