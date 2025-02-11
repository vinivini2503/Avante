package br.com.meuprojeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.meuprojeto.model.EquipeChat;
import br.com.meuprojeto.model.Usuario;

public class EquipeChatDAO {

	private ConexaoMysql conexao;
	private UsuarioDAO usuarioDAO;

	public EquipeChatDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA, BdConfigs.NOME_BD);
	}

   //ADICIONAR EQUIPE
	public void adicionar(EquipeChat equipe) {
		this.conexao.abrirConexao();

		String sql = "INSERT INTO equipe_chat VALUES(null, ?, ?)";

		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, equipe.getNome());
			st.setLong(2, equipe.getUsuario().getId());

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}
	}
    //EDITAR EQUIPE
	public void editar(EquipeChat equipe) {
		this.conexao.abrirConexao();

		String sql = "UPDATE equipe_chat SET nome_equipe=?, id_usuario=? WHERE id_chat_equipe=?;";

		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, equipe.getNome());
			st.setLong(2, equipe.getUsuario().getId());
			st.setLong(3, equipe.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}

	}
	//BUSCAR POR ID
	public EquipeChat buscarPorId (long id) {
		EquipeChat equipe = null;
		
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM equipe_chat WHERE id_chat_equipe=?;";
			PreparedStatement st = this.conexao.getConexao().prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next() == true) {
				equipe = new EquipeChat();
				equipe.setId(rs.getLong("id_chat_equipe"));
				equipe.setNome(rs.getString("nome_equipe"));
				UsuarioDAO uDAO = new UsuarioDAO();
				Usuario u = uDAO.buscarPorId(rs.getLong("id_usuario"));
				equipe.setUsuario(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}
		return equipe;
	}
	
	//BUSCAR TODOS
	public List<EquipeChat> buscarTodos() {
		this.conexao.abrirConexao();
		List<EquipeChat> listEquipeChat = new ArrayList<EquipeChat>();

		String sql = "SELECT * FROM equipe_chat;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				EquipeChat equipe = new EquipeChat();
				equipe.setId(rs.getLong("id_chat_equipe"));
				equipe.setNome(rs.getString("nome_equipe"));
				UsuarioDAO uDAO = new UsuarioDAO();
				Usuario u = uDAO.buscarPorId(rs.getLong("id_usuario"));
				equipe.setUsuario(u);
				listEquipeChat.add(equipe);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			this.conexao.fecharConexao();
		}
		return listEquipeChat;
	}
	
	//EXCLUIR
	public void excluir(long id) {

		this.conexao.abrirConexao();

		String sql = "DELETE FROM equipe_chat WHERE id_chat_equipe=?;";
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
}

