
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionFactory.ConnectionFactory;
import model.Pais;

public class PaisDAO {

	public void inserir(Pais p) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getPopulacao());
			stm.setDouble(3, p.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					p.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Pais p) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getPopulacao());
			stm.setDouble(3, p.getArea());
			stm.setInt(4, p.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Pais p) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, p.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pais carregar(Pais p) {
		Pais pais = new Pais();
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, p.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
				} else {
					p.setId(-1);
					p.setNome(null);
					p.setPopulacao(0);
					p.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return pais;
	}

	public String maiorPopulacao(Pais p) {
		String sqlSelect = "select id, nome, populacao, area from pais order by populacao desc limit 1";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setId(rs.getInt("id"));
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p.getNome();
	}

	public String menorArea(Pais p) {
		String sqlSelect = "select id, nome, populacao, area from pais order by area asc limit 1;";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setId(rs.getInt("id"));
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p.getNome();
	}

	public Pais[] vetorTresPaises(Pais p) {
		String sqlSelect = "select * from pais limit 3;";
		ArrayList<Pais> lista = new ArrayList<>();
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					p.setId(rs.getInt("id"));
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
					Pais pais = new Pais(p.getId(), p.getNome(), p.getPopulacao(), p.getArea());
					lista.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		Pais[] paises = new Pais[lista.size()];
		for (int i = 0; i < paises.length; i++) {
			paises[i] = lista.get(i);
		}
		return paises;
	}

}
