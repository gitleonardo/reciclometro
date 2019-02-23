package br.com.reciclometro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.reciclometro.factory.ConnectionFactory;
import br.com.reciclometro.model.Produto;

public class ProdutoDAO {

	private Connection con;

	public ProdutoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public boolean inserir(Produto produto) {
		boolean retorno = false;

		String sql = "insert into Produto " +
				"(formulacao,tipo,descricao,peso)" +
				" values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, produto.getFormulacao());
			stmt.setString(2,produto.getTipo());
			stmt.setString(3,produto.getDescricao());
			stmt.setDouble(4,produto.getPeso());

			// executa
			stmt.execute();
			stmt.close();

			retorno = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}

	public Double obterTotalReciclagem() {

		Double retorno = 0.0;

		String sql = "select sum(peso) from Produto";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			Double total = 0.0;

			while(rs.next()) {
				total = rs.getDouble(1);
			}

			stm.close();
			retorno = total;

		} catch (Exception e) {
			retorno = null;
		}

		return retorno;
	}

	public List<Produto> obterTodosProdutos() {
		List<Produto> listaProdutos = new ArrayList<>();
		String sql = "select id,tipo,formulacao,descricao,peso from Produto";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setTipo(rs.getString("tipo"));
				produto.setFormulacao(rs.getString("formulacao"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPeso(rs.getDouble("peso"));

				listaProdutos.add(produto);
			}

			stm.close();

			return listaProdutos;

		} catch (Exception e) {
			return null;
		}
	}

	public boolean remover(String id) {
		boolean retorno = false;

		String sql = "delete from Produto " +
				"where id=?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, id);

			pstm.execute();

			retorno = true;

			pstm.close();

			return retorno;

		} catch (Exception e) {
			return retorno;
		}
	}
	
	public Produto obterProduto(String id) {
		Produto retorno = new Produto();
		
		String sql = "select id,tipo,formulacao,descricao,peso from Produto "+
					"where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
					
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setTipo(rs.getString("tipo"));
				produto.setFormulacao(rs.getString("formulacao"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPeso(rs.getDouble("peso"));

				retorno = produto;
			}

			ps.close();

			return retorno;

		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean atualizar(Produto produto) {
		boolean retorno = false;

		String sql = "update Produto " +
				"set tipo=?,formulacao=?,descricao=?,peso=? " +
				"where id=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores
			stmt.setString(1,produto.getTipo());
			stmt.setString(2,produto.getFormulacao());
			stmt.setString(3,produto.getDescricao());
			stmt.setDouble(4,produto.getPeso());
			stmt.setInt(5,produto.getId());

			// executa
			stmt.execute();
			stmt.close();

			retorno = true;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}
}
