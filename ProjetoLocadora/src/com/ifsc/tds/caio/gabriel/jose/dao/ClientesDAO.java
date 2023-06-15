package com.ifsc.tds.caio.gabriel.jose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ifsc.tds.caio.gabriel.jose.enity.Clientes;;

public class ClientesDAO implements DAO<Clientes> {

	@Override
	public Clientes get(Long id) {
		Clientes clientes = null;
		String sql = "select * from clientes where id = ?";

		Connection conexao = null;

		PreparedStatement stm = null;
		ResultSet rset = null;
		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setInt(1, id.intValue());
			rset = stm.executeQuery();

			while (rset.next()) {
				clientes = new Clientes();

				clientes.setId(rset.getLong("id"));
				clientes.setNome(rset.getString("Nome"));
				clientes.setTelefone(rset.getString("Telefone"));
				clientes.setEmail(rset.getString("Email"));
				

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
				clientes.setNome(rset.getString("Nome"));
				clientes.setTelefone(rset.getString("Telefone"));
				clientes.setEmail(rset.getString("Email"));
				

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
		String sql = "insert into clientes (nome, telefone, email)" + " values (?, ?, ?)";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setString(1, clientes.getNome());
			stm.setString(2, clientes.getTelefone());
			stm.setString(3, clientes.getEmail());

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
		String sql = "update clientes set nome = ?, telefone = ?, email = ? where id = ?";
		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setString(1, clientes.getNome());
			stm.setString(2, clientes.getTelefone());
			stm.setString(3, clientes.getEmail());
			stm.setLong(4, clientes.getId());

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
		String sql = "delete from clientes where id = ?";
		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setLong(1, clientes.getId());
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
