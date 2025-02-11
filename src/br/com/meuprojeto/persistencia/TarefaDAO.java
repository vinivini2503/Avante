package br.com.meuprojeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import br.com.meuprojeto.model.Tarefa;
import br.com.meuprojeto.model.Usuario;
import br.com.meuprojeto.persistencia.UsuarioDAO;
import br.com.meuprojeto.model.GrauImportancia;
import br.com.meuprojeto.persistencia.GrauImportanciaDAO;
import br.com.meuprojeto.model.ConversaoLocalDate;
import br.com.meuprojeto.model.EquipeChat;
import br.com.meuprojeto.persistencia.EquipeChatDAO;

public class TarefaDAO {

	private ConexaoMysql conexao;
	private UsuarioDAO uDAO;
	private GrauImportanciaDAO giDAO;
	private EquipeChatDAO ecDAO;

	public TarefaDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA,
				BdConfigs.NOME_BD);
		uDAO = new UsuarioDAO();
		giDAO = new GrauImportanciaDAO();
		ecDAO = new EquipeChatDAO();
	}

	public TarefaDAO(ConexaoMysql conexao) {
		this.conexao = conexao;
	}

//ADICIONAR TAREFA
	public void salvar(Tarefa tarefa) {
		this.conexao.abrirConexao();

		String sql = "INSERT INTO tarefa VALUES (null, ?,?,?,?,?, ?, ?, ?);";

		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, tarefa.getNome());
			st.setString(2, tarefa.getDescricao());
			st.setDate(3, ConversaoLocalDate.localDateToDate(tarefa.getData()));
			st.setTimestamp(4, ConversaoLocalDate.localDateTimeToTimestamp(tarefa.getHorario()));
			st.setTimestamp(5, ConversaoLocalDate.localDateTimeToTimestamp(tarefa.getDuracao()));
			st.setLong(6, tarefa.getUsuario().getId());
			st.setLong(7, tarefa.getGrauImportancia().getId());
			st.setLong(8, tarefa.getEquipeChat().getId());

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}
	}

//EDITAR TAREFA
	public void editar(Tarefa tarefa) {
		this.conexao.abrirConexao();

		String sql = "UPDATE tarefa SET nome_tarefa=?, descricao_tarefa=?, data_tarefa=?, horario_tarefa=?, "
				+ "duracao_tarefa=?, id_usuario=?, id_grauimportancia=?, id_chat_equipe=? WHERE id_tarefa=?;";

		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, tarefa.getNome());
			st.setString(2, tarefa.getDescricao());
			st.setDate(3, ConversaoLocalDate.localDateToDate(tarefa.getData()));
			st.setTimestamp(4, ConversaoLocalDate.localDateTimeToTimestamp(tarefa.getHorario()));
			st.setTimestamp(5, ConversaoLocalDate.localDateTimeToTimestamp(tarefa.getDuracao()));
			st.setLong(6, tarefa.getUsuario().getId());
			st.setLong(7, tarefa.getGrauImportancia().getId());
			st.setLong(8, tarefa.getEquipeChat().getId());
			st.setLong(9, tarefa.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}

	}

	// BUSCAR POR ID
	public Tarefa buscarPorId(long id) {
		this.conexao.abrirConexao();
		Tarefa tarefa = null;
		String sql = "SELECT * FROM tarefa WHERE id_tarefa=?;";

		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				tarefa = new Tarefa(id, sql, sql, null, null, null, null, null, null, null);
				tarefa.setId(rs.getLong("id_tarefa"));
				tarefa.setNome(rs.getString("nome_tarefa"));
				tarefa.setDescricao(rs.getString("descricao_tarefa"));
				tarefa.setData(ConversaoLocalDate.dateToLocalDate(rs.getDate("data_tarefa")));
				tarefa.setHorario(ConversaoLocalDate.timestampToLocalDateTime(rs.getTimestamp("horario_tarefa")));
				tarefa.setHorario(ConversaoLocalDate.timestampToLocalDateTime(rs.getTimestamp("duracao_tarefa")));
				tarefa.setUsuario(uDAO.buscarPorId(rs.getLong("id_usuario")));
				tarefa.setGrauImportancia(giDAO.buscarPorId(rs.getLong("id_grauimportancia")));
				tarefa.setEquipeChat(ecDAO.buscarPorId(rs.getLong("id_chat_equipe")));
				st.executeQuery();

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			this.conexao.fecharConexao();
		}
		return tarefa;
	}

	// BUSCAR TODOS
	public List<Tarefa> buscarTodos() {
		List<Tarefa> listaTarefa = new ArrayList<>();
		Tarefa tarefa = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM tarefa";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next() == true) {
				// TEM QUE ENTRAR AQUI QUANDO RETORNAR UM REGISTRO NO RS
				// CONVERTER UM RESULTSET EM UM OBJETO TAREFA
				tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id_tarefa"));
				tarefa.setNome(rs.getString("nome_tarefa"));
				tarefa.setDescricao(rs.getString("descricao_tarefa"));
				tarefa.setData(ConversaoLocalDate.dateToLocalDate(rs.getDate("data_tarefa")));
				tarefa.setHorario(ConversaoLocalDate.timestampToLocalDateTime(rs.getTimestamp("horario_tarefa")));				
				tarefa.setDuracao(ConversaoLocalDate.timestampToLocalDateTime(rs.getTimestamp("duracao_tarefa")));

				UsuarioDAO uDAO = new UsuarioDAO();
				EquipeChatDAO ecDAO = new EquipeChatDAO();
				GrauImportanciaDAO giDAO = new GrauImportanciaDAO();

				Usuario u = uDAO.buscarPorId(rs.getLong("id_usuario"));
				GrauImportancia gi = giDAO.buscarPorId(rs.getLong("id_grauimportancia"));
				EquipeChat ec = ecDAO.buscarPorId(rs.getLong("id_chat_equipe"));
				tarefa.setUsuario(u);
				tarefa.setGrauImportancia(gi);
				tarefa.setEquipeChat(ec);
				listaTarefa.add(tarefa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTarefa;
	}
	
//EXCLUIR TAREFA
	public void excluir(long id) {
		try {
			this.conexao.abrirConexao();
			String sql = "DELETE FROM tarefa WHERE id_tarefa=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
}
