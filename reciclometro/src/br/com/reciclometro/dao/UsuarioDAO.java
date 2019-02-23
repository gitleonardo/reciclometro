package br.com.reciclometro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.reciclometro.factory.ConnectionFactory;
import br.com.reciclometro.model.Usuario;

public class UsuarioDAO {
	private Connection con;

	public UsuarioDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public boolean autenticar(Usuario usuario) {
		boolean retorno = false;

		String sql = "select username,senha from Usuario " +
				"where username=? " +
				"and senha=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getUsername());
			ps.setString(2, usuario.getSenha());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				usuario.setValid(true);

				if(usuario.getUsername().equalsIgnoreCase("admin")) {
					usuario.setAdmin(true);
				}
			}

			ps.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}

	public boolean inserir(Usuario usuario) {
		boolean retorno = false;

		String sql = "insert into Usuario " +
				"(username,senha)" +
				" values (?,?)";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getUsername());
			pstm.setString(2, usuario.getSenha());

			pstm.execute();
			pstm.close();

			retorno = true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return retorno;
	}

	public List<Usuario> obterTodosUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		String sql = "select id,username,senha from Usuario";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));

				listaUsuarios.add(usuario);
			}

			stm.close();

			return listaUsuarios;

		} catch (Exception e) {
			return null;
		}
	}

	public Usuario obterUsuario(String username) {

		Usuario usuario = null;

		String sql = "select username from Usuario " + 
				"where username=?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, username);
			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
			}

			pstm.close();

			return usuario;

		} catch (Exception e) {
			return usuario;
		}
	}

	public boolean remover(String id) {
		boolean retorno = false;

		String sql = "delete from Usuario " +
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

	public Usuario obterUsuarioPorId(String id) {
		Usuario usuario = null;

		String sql = "select id,username,senha from Usuario " + 
				"where id=?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
			}

			pstm.close();

			return usuario;

		} catch (Exception e) {
			return usuario;
		}
	}

	public boolean atualizar(Usuario usuario) {
		boolean retorno = false;

		String sql = "update Usuario " +
				"set username=?,senha=? " +
				"where id=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores
			stmt.setString(1,usuario.getUsername());
			stmt.setString(2,usuario.getSenha());
			stmt.setInt(3,usuario.getId());

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
