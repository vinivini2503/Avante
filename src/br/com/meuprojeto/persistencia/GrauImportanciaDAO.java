package br.com.meuprojeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.meuprojeto.model.GrauImportancia;

public class GrauImportanciaDAO{
	
	private ConexaoMysql conexao;
	
	public GrauImportanciaDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA, BdConfigs.NOME_BD);
	}
	
	//BUSCAR POR ID
		public GrauImportancia buscarPorId (long id) {
			this.conexao.abrirConexao();
			GrauImportancia grau = null;
			String sql = "SELECT * FROM grauimportancia WHERE id_grauimportancia=?;";
			
			try {
				PreparedStatement st = conexao.getConexao().prepareStatement(sql);
				st.setLong(1, id);
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					grau = new GrauImportancia (id, sql, null);
					grau.setId(rs.getLong("id_grauimportancia"));
					grau.setPrioridade(rs.getString("prioridade"));
					st.executeQuery();
				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				this.conexao.fecharConexao();
			}
			return grau;
		}
	//BUSCAR TODOS
		public List<GrauImportancia> buscarTodos() {
			List<GrauImportancia> listaGrauImportancia = new ArrayList<>();
			GrauImportancia grau = null;
			try {
				this.conexao.abrirConexao();
				String sql = "SELECT * FROM grauimportancia";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next() == true) {
					// TEM QUE ENTRAR AQUI QUANDO RETORNAR UM REGISTRO NO RS
					// CONVERTER UM RESULTSET EM UM OBJETO USUARIO
					grau = new GrauImportancia(0, sql, null);
					grau.setId(rs.getLong("id_grauimportancia"));
					grau.setPrioridade(rs.getString("prioridade"));
			
					listaGrauImportancia.add(grau);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listaGrauImportancia;
		}
}
