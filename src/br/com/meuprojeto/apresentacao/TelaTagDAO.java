package br.com.meuprojeto.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.com.meuprojeto.model.Tag;
import br.com.meuprojeto.model.Usuario;
import br.com.meuprojeto.persistencia.TagDAO;
import br.com.meuprojeto.persistencia.UsuarioDAO;

public class TelaTagDAO {

	static Scanner teclado = new Scanner(System.in);
	static UsuarioDAO uDAO = new UsuarioDAO();
	static TagDAO tDAO = new TagDAO();
	
	public static void adicionarTag() {

		System.out.println("Digite o nome da tag: ");
		String nome = teclado.nextLine();

		System.out.println("Informe o id do Usuario que criou a tag:");
		List<Usuario> listaUsuarios =uDAO.buscarTodos();
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		Long idUsuario = teclado.nextLong();

		System.out.println("Tag criado com sucesso!");

		Tag t = new Tag(0, nome, null, null);
		t.setUsuario(uDAO.buscarPorId(idUsuario));
		tDAO.adicionar(t);

	}
	
	public static void editarTag() {

		System.out.println("Digite o id da tag que deseja editar: ");
		List<Tag> listaTag = tDAO.buscarTodos();
		for(Tag t: listaTag) {
			System.out.println(t.toString());
		}
		Long idTag = teclado.nextLong();
		teclado.nextLine();

		System.out.println("Digite o novo nome da tag: ");
		String nome = teclado.nextLine();

		System.out.println("Infome o id do usuario: ");
		List<Usuario> listaUsuarios =uDAO.buscarTodos();
		for(Usuario u:listaUsuarios) {
			System.out.println(u.toString());
		}
		Long idUsuario = teclado.nextLong();

		System.out.println("Tag editada com sucesso!");

		Tag t = new Tag(idTag, nome, null, null);
		t.setUsuario(uDAO.buscarPorId(idUsuario));
		tDAO.editar(t);

	}
	
	public static void buscarTagPorId() {

		System.out.println("Digite o id da Tag que deseja buscar: ");
		Long idTag = teclado.nextLong();

		Tag t = tDAO.buscarPorId(idTag);
		System.out.println(t);

	}
	
	public static void buscarTodasTag() {

		List<Tag> listaTag = tDAO.buscarTodos();
		System.out.println(listaTag);

	}
	
	public static void excluirTag() {

		System.out.println("Digite o id da tag que deseja excluir: ");
		List<Tag> listaTag = tDAO.buscarTodos();
		for(Tag t: listaTag) {
			System.out.println(t.toString());
		}
		Long idTag = teclado.nextLong();
		System.out.println();

		System.out.println("Tag excluida com sucesso!");
		tDAO.excluir(idTag);

	}
}
