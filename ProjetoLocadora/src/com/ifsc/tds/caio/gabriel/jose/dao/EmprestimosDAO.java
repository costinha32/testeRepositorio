package com.ifsc.tds.caio.gabriel.jose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ifsc.tds.caio.gabriel.jose.enity.Emprestimos;


public class EmprestimosDAO  implements DAO<Emprestimos>{
	
	private ClientesDAO clientesDAO;
	
	private FilmesDAO filmesDAO;
	
	public EmprestimosDAO() {
		this.clientesDAO = new ClientesDAO();
		this.filmesDAO = new FilmesDAO();
	}


	@Override
	public Object get(Long id) {
		Emprestimos emprestimos = null;
		String sql = "select * from emprestimos where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		// Criar uma classe que guarde o retorno da operação
		ResultSet rset = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setInt(1, id.intValue());
			rset = stm.executeQuery();

			while (rset.next()) {
				emprestimos = new Emprestimos();

				// atribui campo para atributo
				emprestimos.setId(rset.getLong("id"));
				emprestimos.setDataEmpre(rset.getDate("dataEmpre"));
				emprestimos.setDataDev(rset.getDate("dataDev"));
				emprestimos.setDesc(rset.getString("desc"));
	
				// buscando as chaves estrangeiras
				emprestimos.setClientes(this.clientesDAO.get(rset.getLong("clientes_id")));
				emprestimos.setFilmes(this.filmesDAO.get(rset.getLong("filmes_id")));
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
		return emprestimos;
	}

	@Override
	public List<Emprestimos> getAll() {
		List<Emprestimos> emprestimo = new ArrayList<Emprestimos>();

		String sql = "select * from emprestimos";

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
				Emprestimos emprestimos = new Emprestimos();

				// atribui campo para atributo
				emprestimos.setId(rset.getLong("id"));
				emprestimos.setDataEmpre(rset.getDate("dataEmpre"));
				emprestimos.setDataDev(rset.getDate("dataDev"));

				// buscando as chaves estrangeiras
				emprestimos.setClientes(this.clientesDAO.get(rset.getLong("clientes_id")));
				emprestimos.setFilmes(this.filmesDAO.get(rset.getLong("filmes_id")));

				emprestimo.add(emprestimos);
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
		return emprestimo;
	}

	@Override
	public int save(Emprestimos emprestimos) {
		String sql = "insert into emprestimos (nome, dataEmpre, dataDev, desc, clientes_id, filmes_id)" + " values (?, ?, ?, ?, ?, ?)";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setDate(1, emprestimos.getDataEmpre());
			stm.setDate(2, emprestimos.getDataDev());
			stm.setString(3, emprestimos.getDesc());
			stm.setLong(4, emprestimos.getClientes().getId());
			stm.setLong(5, emprestimos.getFilmes().getId());

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
	public boolean update(Emprestimos emprestimos, String[] params) {
		String sql = "update emprestimos set nome = ?, dataEmpre = ?, dataDev = ?, desc = ?, clientes_id = ?, filmes_id = ? where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setDate(1, emprestimos.getDataEmpre());
			stm.setDate(2, emprestimos.getDataDev());
			stm.setString(3, emprestimos.getDesc());
			stm.setLong(4, emprestimos.getClientes().getId());
			stm.setLong(5, emprestimos.getFilmes().getId());
			stm.setLong(6, emprestimos.getFilmes().getId());


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
	public boolean delete(Emprestimos emprestimos) {
		String sql = "delete from emprestimos where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setLong(1, emprestimos.getId());
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
