package br.com.meuprojeto.apresentacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import br.com.meuprojeto.model.Usuario;
import br.com.meuprojeto.persistencia.UsuarioDAO;
import br.com.meuprojeto.model.EquipeChat;
import br.com.meuprojeto.model.GrauImportancia;
import br.com.meuprojeto.persistencia.EquipeChatDAO;
import br.com.meuprojeto.persistencia.GrauImportanciaDAO;
import br.com.meuprojeto.model.Tag;
import br.com.meuprojeto.persistencia.TagDAO;
import br.com.meuprojeto.model.Tarefa;
import br.com.meuprojeto.persistencia.TarefaDAO;

public class TesteTelas {

	public static void main(String[] args) {
	
			//USUARIODAO
//TESTE SALVAR
//	    Usuario u = new Usuario(0, "Carlos", "1234", "vinivini@gmail.com", null, null, null, null, null);
//		UsuarioDAO uDAO = new UsuarioDAO();
//		uDAO.salvar(u);
//		
//TESTE EDITAR 
//		Usuario u = new Usuario(1, "FYTASFy", "123131231", "asdasdasd@gmail.com", null, null, null, null, null);
//		UsuarioDAO uDAO = new UsuarioDAO();
//		uDAO.editar(u);
//TESTE EXCLUIR
//		UsuarioDAO uDAO= new UsuarioDAO();
//		uDAO.excluir(4);
		
//TESTE BUSCARID
//		UsuarioDAO uDAO= new UsuarioDAO();
//		Usuario usuario = uDAO.buscarPorId(1);
//		System.out.println(usuario.toString());
		
//TESTE BUSCAR TODOS
//		UsuarioDAO uDAO = new UsuarioDAO();
//		List<Usuario> listaUsuarios = uDAO.buscarTodos();
//		for(Usuario u:listaUsuarios) {
//			System.out.println(u.toString());
//		}
		
		//EQUIPECHATDAO
//ADICIONAR 
//		UsuarioDAO uDAO = new UsuarioDAO();
//		EquipeChatDAO ecDAO = new EquipeChatDAO();
//		EquipeChat equipe = new EquipeChat();
//		equipe.setNome("Projeto");
//		Usuario usuario = uDAO.buscarPorId(1);
//		equipe.setUsuario(usuario);
//		ecDAO.adicionar(equipe);
		
//EDITAR
//		EquipeChatDAO equipe = new EquipeChatDAO();
//		EquipeChat ec = new EquipeChat();
//		ec.setId(1);
//		ec.setNome("Teste");
//		Usuario usuario = uDAO.buscarPorId(1);
//		ec.setUsuario(usuario);
//		equipe.editar(ec);
		
//BUSCAR POR ID 
//		EquipeChat ec = ecDAO.buscarPorId(1);
//		System.out.println(ec.toString());
		
//BUSCAR TODOS
//		List<EquipeChat> listaEquipeChat = ecDAO.buscarTodos();
//		for(EquipeChat e:listaEquipeChat) {
//			System.out.println(e.toString());
//		}
		
//EXCLUIR
//		ecDAO.excluir(1);
		
//		
	 //TAG
//ADIOCIONAR
//		UsuarioDAO uDAO = new UsuarioDAO();
//		TagDAO tDAO = new TagDAO();
//		Tag tag = new Tag();
//		tag.setNome("ESTUDAR");
//		Usuario usuario = uDAO.buscarPorId(1);
//		tag.setUsuario(usuario);
//		tDAO.adicionar(tag);
		
//EDITAR
//		Tag tag = new Tag();
//		tag.setId(1);
//		tag.setNome("PROJETO");
//		Usuario usuario = uDAO.buscarPorId(1);
//		tag.setUsuario(usuario);
//		tDAO.editar(tag);
		
//BUSCAR POR ID 
//		Tag tag = tDAO.buscarPorId(2);
//		System.out.println(tag.toString());
		
//BUSCAR POR TODOS
//		List<Tag> listaTags = tDAO.buscarTodos();
//		for(Tag t:listaTags) {
//			System.out.println(t.toString());
//		}
		
	//TAREFA
//ADICIONAR
//		UsuarioDAO uDAO = new UsuarioDAO();
//		TarefaDAO tDAO = new TarefaDAO();
//		GrauImportanciaDAO giDAO = new GrauImportanciaDAO();
//		EquipeChatDAO ecDAO = new EquipeChatDAO();
//		
//		LocalDate data = LocalDate.of(2023, Month.NOVEMBER, 20);
//		LocalDateTime time = data.atTime(10, 30);
//		LocalDateTime time2 = data.atTime(00,20);
//		//(0, "Projeto", "Fazer telas", data, time, time2, null, null, null, null);
//		
//		
//		
//		Tarefa t = new Tarefa(0, "Projeto", "Fazer telas", data, time, time2, null, null, null, null);
//		Usuario usuario = uDAO.buscarPorId(1);
//		GrauImportancia gi = giDAO.buscarPorId(1);
//		EquipeChat ec = ecDAO.buscarPorId(2);
//		
//		t.setEquipeChat(ec);
//		t.setGrauImportancia(gi);
//		t.setUsuario(usuario);
//		tDAO.salvar(t);
		
//EDITAR
//		LocalDate data = LocalDate.of(2023, Month.JANUARY, 20);
//		LocalDateTime time = data.atTime(10, 30);
//		LocalDateTime time2 = data.atTime(00,20);
//		Tarefa t = new Tarefa(1, "Teste deu certo", "Editar agora", data, time, time2, null, null, null, null );
//		Usuario usuario = uDAO.buscarPorId(1);
//		GrauImportancia gi = giDAO.buscarPorId(1);
//		EquipeChat ec = ecDAO.buscarPorId(2);
//		t.setEquipeChat(ec);
//		t.setGrauImportancia(gi);
//		t.setUsuario(usuario);
//		tDAO.editar(t);
		
//BUSCAR POR ID -- localtime imprimindo como null
//		Tarefa tarefa = tDAO.buscarPorId(1);
//		System.out.println(tarefa.toString());
		
//BUSCAR TODOS -- dois ultimos imprimindo como null
//		List<Tarefa> listaTarefas =tDAO.buscarTodos();
//		for (Tarefa t:listaTarefas) {
//			System.out.println(t.toString());
//		}
		
//EXCLUIR
//		tDAO.excluir(2);
		
		
		//GRAU DE IMPORTÂNCIA
//BUSCAR POR ID
//		GrauImportanciaDAO giDAO = new GrauImportanciaDAO();
//		TarefaDAO tDAO = new TarefaDAO();
//		GrauImportancia gi = giDAO.buscarPorId(1);
//		System.out.println(gi.toString());
		
//BUSCAR TODOS
//		List<GrauImportancia> listaGrauImportancia = giDAO.buscarTodos();
//		for(GrauImportancia gi:listaGrauImportancia) {
//			System.out.println(gi.toString());
//		}
//		
	}
	}