package br.com.meuprojeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.meuprojeto.model.Usuario;

public class UsuarioDAO {
	private ConexaoMysql conexao;

	public UsuarioDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA, BdConfigs.NOME_BD);
	}

	//ADICIONAR USUARIO
	public void salvar(Usuario usuario) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO usuario VALUES(null, ?, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getEmail());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void editar(Usuario usuario) {
		
		try {
			this.conexao.abrirConexao();
			String sql = "UPDATE usuario SET nome=?, senha=?, email=? WHERE id_usuario=?;";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getEmail());
			statement.setLong(4, usuario.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	// DELETAR USUARIO
	public void excluir(long id) {
		try {
			this.conexao.abrirConexao();
			String sql = "DELETE FROM usuario WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	// BUSCAR POR ID
	public Usuario buscarPorId(long id) {
		Usuario usuario = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM usuario WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();

			if (rs.next() == true) {
				// TEM QUE ENTRAR AQUI QUANDO RETORNAR UM REGISTRO NO RS
				// CONVERTER UM RESULTSET EM UM OBJETO USUARIO
				usuario = new Usuario(id, sql, sql, sql, null, null, null, null, null);
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	// BUSCAR TODOS OS  USUÁRIOS
	public List<Usuario> buscarTodos() {
		Usuario usuario = null;
		List<Usuario> listaUsuarios = new ArrayList<>();
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM usuario";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next() == true) {
				// TEM QUE ENTRAR AQUI QUANDO RETORNAR UM REGISTRO NO RS
				// CONVERTER UM RESULTSET EM UM OBJETO USUARIO
				usuario = new Usuario(0, sql, sql, sql, null, null, null, null, null);
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

}
