package br.com.meuprojeto.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.com.meuprojeto.model.EquipeChat;
import br.com.meuprojeto.model.Usuario;
import br.com.meuprojeto.persistencia.EquipeChatDAO;
import br.com.meuprojeto.persistencia.UsuarioDAO;

public class TelaEquipeDAO {

	static Scanner teclado = new Scanner(System.in);
	
	static UsuarioDAO uDAO = new UsuarioDAO();
	static EquipeChatDAO ecDAO = new EquipeChatDAO();
	
	public static void criarEquipe() {

		System.out.println("Digite o nome da equipe: ");
		String nome = teclado.nextLine();
		System.out.println();

		System.out.println("Informe o id do usuario que pertence a equipe: ");
		List<Usuario> listaUsuarios =uDAO.buscarTodos();
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		Long idUsuario = teclado.nextLong();

		System.out.println("Equipe criada com sucesso!");

		EquipeChat ec = new EquipeChat(0, nome, null, null, null, null);
		ec.setUsuario(uDAO.buscarPorId(idUsuario));
		ecDAO.adicionar(ec);
	}
	
	public static void editarEquipe() {

		System.out.println("Digite o id da equipe que deseja editar:");
		List<EquipeChat> listaEquipeChat = ecDAO.buscarTodos();
		for(EquipeChat ec:listaEquipeChat) {
			System.out.println(ec.toString());
		}
		Long idEquipe = teclado.nextLong();
		teclado.nextLine();
		System.out.println();

		System.out.println("Digite o novo nome: ");
		String nome = teclado.nextLine();
		System.out.println();

		System.out.println("Informe o id do usuario:");
		Long idUsuario = teclado.nextLong();
		System.out.println();

		System.out.println("Equipe editada com sucesso!");

		EquipeChat ec = new EquipeChat(idEquipe, nome, null, null, null, null);
		ec.setUsuario(uDAO.buscarPorId(idUsuario));
		ecDAO.editar(ec);
	}
	
	public static void buscarEquipePorId() {

		System.out.println("Digite o id da Equipe que deseja procurar: ");
		Long idEquipe = teclado.nextLong();

		EquipeChatDAO ecDAO = new EquipeChatDAO();
		EquipeChat ec = ecDAO.buscarPorId(idEquipe);
		System.out.println(ec);

	}
	
	public static void buscarTodasEquipe() {

		EquipeChatDAO ecDAO = new EquipeChatDAO();
		List<EquipeChat> listaEquipeChat = ecDAO.buscarTodos();
		System.out.println(listaEquipeChat);

	}
	
	public static void excluirEquipe() {

		System.out.println("Digite o id da equipe que deseja excluir: ");
		List<EquipeChat> listaEquipeChat = ecDAO.buscarTodos();
		for(EquipeChat ec:listaEquipeChat) {
			System.out.println(ec.toString());
		}
		Long idEquipe = teclado.nextLong();

		EquipeChatDAO ecDAO = new EquipeChatDAO();
		ecDAO.excluir(idEquipe);

		System.out.println("Equipe excluida sucesso!");

	}
	
}
