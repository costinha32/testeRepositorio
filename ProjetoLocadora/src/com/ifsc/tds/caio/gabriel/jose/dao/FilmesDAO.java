package com.ifsc.tds.caio.gabriel.jose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ifsc.tds.caio.gabriel.jose.enity.Filmes;

public class FilmesDAO implements DAO<Filmes> {
		
		public Filmes get(Long id) {
			Filmes filmes = null;
			String sql = "select * from filmes where id = ?";
			
			Connection conexao = null;
			
			PreparedStatement stm = null;
			ResultSet rset = null;
			try {
				conexao = new Conexao().getConnection();

				stm = conexao.prepareStatement(sql);
				stm.setInt(1, id.intValue());
				rset = stm.executeQuery();
				
				while(rset.next()) {
					filmes = new Filmes();
					
					filmes.setId(rset.getLong("id"));
					filmes.setNomeFilme(rset.getNString("nomeFilme"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
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
			return filmes;
		}

		@Override
		public List<Filmes> getAll() {
			List<Filmes> filmesS = new ArrayList<Filmes>();
			String sql ="select * from filmes";
					
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
					Filmes filmes = new Filmes();

					// atribui campo para atributo
					filmes.setId(rset.getLong("id"));
					filmes.setNomeFilme(rset.getString("nomeFilme"));
					
				filmesS.add(filmes);
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
			return filmesS;

		}

		@Override
		public int save(Filmes filmes) {
			String sql = "insert into filmes (nomeFilme) "+ "values(?)";
			 
			// Recupera a conexão com o banco
			Connection conexao = null;

			// Criar uma preparação da consulta
			PreparedStatement stm = null;

			try {

				conexao = new Conexao().getConnection();

				stm = conexao.prepareStatement(sql);
				stm.setString(1, filmes.getNomeFilme());
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
		public boolean update(Filmes filmes, String[] params) {
			String sql = "update filmes set nomeFilme = ? where id = ?";

			// Recupera a conexão com o banco
			Connection conexao = null;

			// Criar uma preparação da consulta
			PreparedStatement stm = null;

			try {

				conexao = new Conexao().getConnection();

				stm = conexao.prepareStatement(sql);
				stm.setString(1, filmes.getNomeFilme());
				stm.setLong(2, filmes.getId());

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
		public boolean delete(Filmes filmes) {
			
			String sql = "delete from filmes where id = ?";
			// Recupera a conexão com o banco
			Connection conexao = null;

			// Criar uma preparação da consulta
			PreparedStatement stm = null;

			try {

				conexao = new Conexao().getConnection();

				stm = conexao.prepareStatement(sql);
				stm.setLong(1, filmes.getId());
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

		
			
