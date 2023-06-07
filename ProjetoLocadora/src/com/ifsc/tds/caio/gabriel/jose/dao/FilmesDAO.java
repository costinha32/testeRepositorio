package com.ifsc.tds.caio.gabriel.jose.dao;

import java.sql.ResultSet;
import java.util.List;

import com.ifsc.tds.caio.gabriel.jose.enity.Filmes;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class FilmesDAO {
		
		public Filmes get(Long id) {
			Filmes filmes = null;
			String sql = "select * from filmes where id=?";
			
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
					filmes.setNomeFilme(rset.getNString("nome"));
					
				}
				
			} catch (Exception e) {
				
			}
			return null;
		}

		@Override
		public List<Clientes> getAll() {
			// TODO Auto-generated method stub
			return null;
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


}
