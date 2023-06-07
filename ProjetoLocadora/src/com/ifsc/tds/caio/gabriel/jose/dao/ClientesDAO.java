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
		List<Clientes> clientesS = new ArrayList<Clientes>();

		String sql = "select * from clientes";

		// Recupera a conex�o com o banco
		Connection conexao = null;

		// Criar uma prepara��o da consulta
		PreparedStatement stm = null;

		// Criar uma classe que guarde o retorno da opera��o
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
			
				clientesS.add(clientes);
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
		return clientesS;
	
	}

	@Override
	public int save(Clientes clientes) {
		String sql = "insert into clientes nome, email)" + " values (?, ?)";

		// Recupera a conex�o com o banco
		Connection conexao = null;

		// Criar uma prepara��o da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setString(1, clientes.getNome());
			stm.setString(2, clientes.getEmail());

			stm.execute();

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
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}


	@Override
	public boolean update(Clientes clientes, String[] params) {
		String sql = "update clientes set nome = ?, email = ? where id = ";
		// Recupera a conex�o com o banco
		Connection conexao = null;

		// Criar uma prepara��o da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setString(1, clientes.getNome());
			stm.setString(2, clientes.getEmail());
			stm.setLong(3, clientes.getId());
			
			stm.execute();

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
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return false;
	}

	@Override
	public boolean delete(Clientes clientes) {
		String sql ="delete from clientes where id = ?";
		// Recupera a conex�o com o banco
		Connection conexao = null;

		// Criar uma prepara��o da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setLong(3, clientes.getId());
			
			stm.execute();

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
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
		return false;
	}

}
