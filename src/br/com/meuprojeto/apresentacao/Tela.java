package br.com.meuprojeto.apresentacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import br.com.meuprojeto.model.ConversaoLocalDate;
import br.com.meuprojeto.model.EquipeChat;
import br.com.meuprojeto.model.GrauImportancia;
import br.com.meuprojeto.model.Tag;
import br.com.meuprojeto.model.Tarefa;
import br.com.meuprojeto.model.Usuario;
import br.com.meuprojeto.persistencia.EquipeChatDAO;
import br.com.meuprojeto.persistencia.GrauImportanciaDAO;
import br.com.meuprojeto.persistencia.TagDAO;
import br.com.meuprojeto.persistencia.TarefaDAO;
import br.com.meuprojeto.persistencia.UsuarioDAO;

public class Tela {
	static Scanner teclado = new Scanner(System.in);
	Tela telinha = new Tela();
	public static void main(String[] args) {

		Scanner t = new Scanner(System.in);

		System.out.println("Escolha uma opção: ");
		System.out.println("1- Usuario");
		System.out.println("2- Equipe ");
		System.out.println("3- Tag");
		System.out.println("4- Tarefa");
		System.out.println("5- Grau de importância");

		String tecladinho = t.next();

		switch (tecladinho) {

		case "1": {
			System.out.println("Digite o número da opção desejada:");
			System.out.println("1- Adicionar usuario");
			System.out.println("2- Editar usuario");
			System.out.println("3- Buscar usuario por Id");
			System.out.println("4- Buscar todos os usuario");
			System.out.println("5- Excluir usuário");

			String teclado = t.next();

			switch (teclado) {

			case "1": {
				TelaUsuarioDAO.salvarUsuario();
				break;
			}

			case "2": {
				TelaUsuarioDAO.editarUsuario();
				break;

			}

			case "3": {
				TelaUsuarioDAO.buscarUsuarioPorId();
				break;

			}

			case "4": {
				TelaUsuarioDAO.buscarTodosUsuario();
				break;

			}

			case "5": {
				TelaUsuarioDAO.excluirUsuario();
				break;
			}

			default:
				System.out.println("Invalido.");
			}
			t.close();
			break;

		}

		case "2": {
			System.out.println("Digite o número da opção desejada");
			System.out.println("1- Adicionar equipe");
			System.out.println("2- Editar equipe");
			System.out.println("3- Buscar equipe por id");
			System.out.println("4- Buscar todas as equipes");
			System.out.println("5- Excluir equipe");

			String teclado = t.next();

			switch (teclado) {

			case "1": {
				TelaEquipeDAO.criarEquipe();
				break;

			}
			case "2": {
				TelaEquipeDAO.editarEquipe();
				break;
			}
			case "3": {
				TelaEquipeDAO.buscarEquipePorId();
				break;
			}
			case "4": {
				TelaEquipeDAO.buscarTodasEquipe();
				break;
			}
			case "5": {
				TelaEquipeDAO.excluirEquipe();
				break;
			}
			default:
				System.out.println("Invalido.");
			}
			t.close();
			break;
		}

		case "3": {
			System.out.println("Digite o número da opção desejada");
			System.out.println("1- Adicionar tag");
			System.out.println("2- Editar tag");
			System.out.println("3- Buscar tag por id");
			System.out.println("4- Buscar todas as tags");
			System.out.println("5- Excluir tag");

			String teclado = t.next();

			switch (teclado) {

			case "1": {
				TelaTagDAO.adicionarTag();
				break;
			}
			case "2": {
				TelaTagDAO.editarTag();
				break;
			}
			case "3": {
				TelaTagDAO.buscarTagPorId();
				break;
			}
			case "4": {
				TelaTagDAO.buscarTodasTag();
				break;
			}
			case "5": {
				TelaTagDAO.excluirTag();
				break;
			}
			default:
				System.out.println("Invalido.");
			}
			t.close();
			break;
		}
		case "4": {
			System.out.println("Digite o número da opção desejada");
			System.out.println("1- Adicionar tarefa");
			System.out.println("2- Editar tarefa");
			System.out.println("3- Buscar tarefa por id");
			System.out.println("4- Buscar todas as tarefas");
			System.out.println("5- Excluir tarefa");

			String teclado = t.next();

			switch (teclado) {

			case "1": {
				TelaTarefaDAO.adicionarTarefa();
				break;
			}
			case "2": {
				TelaTarefaDAO.editarTerefa();
				break;
			}
			case "3": {
				TelaTarefaDAO.buscarTarefaPorId();
				break;
			}
			case "4": {
				TelaTarefaDAO.buscarTodasTerefas();
				break;
			}
			case "5": {
				TelaTarefaDAO.excluirTarefa();
				break;
			}
			default:
				System.out.println("Invalido.");
			}
			t.close();
			break;
		}
		case "5": {
			System.out.println("Digite o número da opção desejada");
			System.out.println("1- Buscar grau de importância por id");
			System.out.println("2- Buscar todas os graus de importância");

			String teclado = t.next();

			switch (teclado) {

			case "1": {
				TelaGrauImportanciaDAO.buscarGrauPorId();
				break;
			}
			case "2": {
				TelaGrauImportanciaDAO.buscarTodosGrauImportancia();
				break;
			}
			default:
				System.out.println("Invalido.");
			}
			t.close();
			break;
		}
		}
	}
}