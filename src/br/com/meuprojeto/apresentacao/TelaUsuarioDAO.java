package br.com.meuprojeto.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.com.meuprojeto.model.Usuario;
import br.com.meuprojeto.persistencia.UsuarioDAO;

public class TelaUsuarioDAO {

	static Scanner teclado = new Scanner(System.in);
	static UsuarioDAO uDAO = new UsuarioDAO();
	
	public static void salvarUsuario() {

		System.out.println("Insira seu nome: ");
		String nome = teclado.nextLine();
		System.out.println();

		System.out.println("Defina uma senha: ");
		String senha = teclado.nextLine();
		System.out.println();

		System.out.println("Insira um email: ");
		String email = teclado.nextLine();
		System.out.println();

		System.out.println("Conta cadastrada!");

		Usuario u = new Usuario(0, nome, senha, email, null, null, null, null, null);

		uDAO.salvar(u);

		teclado.close();

	}
	
	public static void editarUsuario() {

		System.out.println("Digite o id do usuario que deseja editar:");
		
		List<Usuario> listaUsuarios =uDAO.buscarTodos();
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		
		Long idUsuario = teclado.nextLong();
		teclado.nextLine();
		System.out.println();

		System.out.println("Digite o novo nome: ");
		String nome = teclado.nextLine();
		System.out.println();

		System.out.println("Digite a nova senha:");
		String senha = teclado.next();
		System.out.println();

		System.out.println("Digite o novo email:");
		String email = teclado.next();
		System.out.println();

		System.out.println("Usuario editado com sucesso!");

		Usuario u = new Usuario(idUsuario, nome, senha, email, null, null, null, null, null);
		uDAO.editar(u);
	}
	
	public static void buscarUsuarioPorId() {

		System.out.println("Digite o id do usuário que deseja buscar: ");
		Long idUsuario = teclado.nextLong();

		Usuario u = uDAO.buscarPorId(idUsuario);
		System.out.println(u);
	}
	
	public static void buscarTodosUsuario() {

		List<Usuario> listaUsuarios = uDAO.buscarTodos();
		System.out.println(listaUsuarios);

	}
	
	public static void excluirUsuario() {

		System.out.println("Insira o id do perfil que deseja excluir:");
		
		List<Usuario> listaUsuarios =uDAO.buscarTodos();
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		Long idUsuario = teclado.nextLong();
		uDAO.excluir(idUsuario);
		System.out.println("Perfil excluido com sucesso!");

	}
	
}
