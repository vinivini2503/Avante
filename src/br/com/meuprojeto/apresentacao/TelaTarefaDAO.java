package br.com.meuprojeto.apresentacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import br.com.meuprojeto.model.ConversaoLocalDate;
import br.com.meuprojeto.model.EquipeChat;
import br.com.meuprojeto.model.GrauImportancia;
import br.com.meuprojeto.model.Tarefa;
import br.com.meuprojeto.model.Usuario;
import br.com.meuprojeto.persistencia.EquipeChatDAO;
import br.com.meuprojeto.persistencia.GrauImportanciaDAO;
import br.com.meuprojeto.persistencia.TarefaDAO;
import br.com.meuprojeto.persistencia.UsuarioDAO;

public class TelaTarefaDAO {

	static Scanner teclado = new Scanner(System.in);
	static UsuarioDAO uDAO = new UsuarioDAO();
	static EquipeChatDAO ecDAO = new EquipeChatDAO();
	static GrauImportanciaDAO giDAO = new GrauImportanciaDAO();
	static TarefaDAO tDAO = new TarefaDAO();
	
	public static void adicionarTarefa() {

		System.out.println("digite o nome da tarefa:");
		String nome = teclado.nextLine();
		System.out.println();
		System.out.println("Adicione descrição da tarefa: ");
		String descricao = teclado.nextLine();
		System.out.println();

		System.out.println("Informe a data da tarefa (2023-11-25):");
		LocalDate data = ConversaoLocalDate.addDate(teclado.next());
		System.out.println();

		System.out.println("Defina o horário para realizar a terefa (hh:mm): ");
		LocalDateTime horario = ConversaoLocalDate.stringToLocalDateTime(teclado.next());
		System.out.println();

		System.out.println("Defina a duração da terfa (hh:mm): ");
		LocalDateTime duracao = ConversaoLocalDate.stringToLocalDateTime(teclado.next());
		System.out.println();

		System.out.println("Informe o id do grau de importância: ");
		List<GrauImportancia> listaGrauImportancia = giDAO.buscarTodos();
		for(GrauImportancia gi: listaGrauImportancia) {
			System.out.println(gi.toString());
		}
		Long idImportancia = teclado.nextLong();
		System.out.println();

		System.out.println("Informe o id do usuario: ");
		List<Usuario> listaUsuarios =uDAO.buscarTodos();
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		Long idUsuario = teclado.nextLong();
		System.out.println();

		System.out.println("Informe o id da Equipe: ");
		List<EquipeChat> listaEquipeChat = ecDAO.buscarTodos();
		for(EquipeChat ec:listaEquipeChat) {
			System.out.println(ec.toString());
		}
		Long idEquipe = teclado.nextLong();
		System.out.println();

		System.out.println("Tarefa adicionada com sucesso!");

		Tarefa t = new Tarefa(0, nome, descricao, data, horario, duracao, null, null, null, null);
		t.setUsuario(uDAO.buscarPorId(idUsuario));
		t.setEquipeChat(ecDAO.buscarPorId(idEquipe));
		t.setGrauImportancia(giDAO.buscarPorId(idImportancia));
		tDAO.salvar(t);
	}
	
	public static void editarTerefa() {

		System.out.println("Digite o id da tarefa que deseja editar: ");
		List<Tarefa> listaTarefa = tDAO.buscarTodos();
		for(Tarefa t:listaTarefa) {
			System.out.println(t.toString());
		}
		Long idTarefa = teclado.nextLong();
		teclado.nextLine();
		System.out.println();

		System.out.println("Digite o novo nome: ");
		String nome = teclado.nextLine();
		System.out.println();

		System.out.println("Digite a nova descrição: ");
		String descricao = teclado.nextLine();
		System.out.println();

		System.out.println("Defina a nova data (2023-11-25)");
		LocalDate data = ConversaoLocalDate.addDate(teclado.next());
		System.out.println();

		System.out.println("Defina o novo horário da tarefa (hh:mm): ");
		LocalDateTime horario = ConversaoLocalDate.stringToLocalDateTime(teclado.next());
		System.out.println();

		System.out.println("Defina o novo tempo de duração da tarefa (hh:mm): ");
		LocalDateTime duracao = ConversaoLocalDate.stringToLocalDateTime(teclado.next());
		System.out.println();

		System.out.println("Digite o id do grau de importância: ");
		List<GrauImportancia> listaGrauImportancia = giDAO.buscarTodos();
		for(GrauImportancia gi: listaGrauImportancia) {
			System.out.println(gi.toString());
		}
		Long idImportancia = teclado.nextLong();
		System.out.println();

		System.out.println("Digite o id do usuario: ");
		List<Usuario> listaUsuarios =uDAO.buscarTodos();
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		Long idUsuario = teclado.nextLong();
		System.out.println();

		System.out.println("Digite o id da equipe: ");
		List<EquipeChat> listaEquipeChat = ecDAO.buscarTodos();
		for(EquipeChat ec:listaEquipeChat) {
			System.out.println(ec.toString());
		}
		Long idEquipe = teclado.nextLong();
		System.out.println();

		System.out.println("Tarefa editada com sucesso!");

		Tarefa t = new Tarefa(idTarefa, nome, descricao, data, horario, duracao, null, null, null, null);
		t.setUsuario(uDAO.buscarPorId(idUsuario));
		t.setEquipeChat(ecDAO.buscarPorId(idEquipe));
		t.setGrauImportancia(giDAO.buscarPorId(idImportancia));
		tDAO.editar(t);
	}
	
	public static void buscarTarefaPorId() {

		System.out.println("Digite o id da tarefa que deseja buscar: ");
		Long idTarefa = teclado.nextLong();
		System.out.println();

		Tarefa t = tDAO.buscarPorId(idTarefa);
		System.out.println(t);

	}
	
	public static void buscarTodasTerefas() {

		List<Tarefa> listaTarefa = tDAO.buscarTodos();
		System.out.println(listaTarefa);

	}
	
	public static void excluirTarefa() {

		System.out.println("Digite o id da tarefa que deseja excluir: ");
		List<Tarefa> listaTarefa = tDAO.buscarTodos();
		for(Tarefa t:listaTarefa) {
			System.out.println(t.toString());
		}
		Long idTarefa = teclado.nextLong();
		System.out.println();

		System.out.println("Tarefa excluida com sucesso!");

		tDAO.excluir(idTarefa);

	}

}
