package br.com.meuprojeto.persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.meuprojeto.model.EquipeChat;
import br.com.meuprojeto.model.Tag;
import br.com.meuprojeto.model.Usuario;

public class TagDAO {
	
	private ConexaoMysql conexao;
	private UsuarioDAO usuarioDAO;

	public TagDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA,
				BdConfigs.NOME_BD);
	}
	
//ADICIONAR TAG
	public void adicionar(Tag tag) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO tag VALUES (null, ?, ?)";
		
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, tag.getNome());
			st.setLong(2, tag.getUsuario().getId());
			
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
		}
	
//EDITAR TAG
	public void editar (Tag tag) {
		this.conexao.abrirConexao();
		
		String sql = "UPDATE tag SET nome=?, id_usuario=? WHERE id_tag=?;";
				
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, tag.getNome());
			st.setLong(2, tag.getUsuario().getId());
			st.setLong(3, tag.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}		
	}
	
//BUSCAR POR ID
	public Tag buscarPorId (long id) {
		Tag tag = null;
		
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM tag WHERE id_tag=?;";
			PreparedStatement st = this.conexao.getConexao().prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next() == true) {
				tag = new Tag();
				tag.setId(rs.getLong("id_tag"));
				tag.setNome(rs.getString("nome"));
				UsuarioDAO uDAO = new UsuarioDAO();
				Usuario u = uDAO.buscarPorId(rs.getLong("id_usuario"));
				tag.setUsuario(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}
		return tag;
	}
	
//EXCLUIR TAG
	
	public void excluir(long id) {

		this.conexao.abrirConexao();

		String sql = "DELETE FROM tag WHERE id_tag=?;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setLong(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	// BUSCAR TODAS
		public List<Tag> buscarTodos() {
			List<Tag> listaTags = new ArrayList<>();
			Tag tag = null;
			try {
				this.conexao.abrirConexao();
				String sql = "SELECT * FROM tag";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next() == true) {
					// TEM QUE ENTRAR AQUI QUANDO RETORNAR UM REGISTRO NO RS
					// CONVERTER UM RESULTSET EM UM OBJETO TAG
					tag = new Tag();
					tag.setId(rs.getLong("id_tag"));
					tag.setNome(rs.getString("nome"));

					UsuarioDAO uDAO = new UsuarioDAO();

					Usuario u = uDAO.buscarPorId(rs.getLong("id_usuario"));
					tag.setUsuario(u);
					listaTags.add(tag);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listaTags;
		}

}