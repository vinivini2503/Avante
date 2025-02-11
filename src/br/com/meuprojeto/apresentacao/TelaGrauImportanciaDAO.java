package br.com.meuprojeto.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.com.meuprojeto.model.GrauImportancia;
import br.com.meuprojeto.persistencia.GrauImportanciaDAO;

public class TelaGrauImportanciaDAO {
	
	static Scanner teclado = new Scanner(System.in);
	static GrauImportanciaDAO giDAO = new GrauImportanciaDAO();
	
	public static void buscarGrauPorId() {

		System.out.println("Digite o id do grau de importância que deseja buscar: ");
		Long idImportancia = teclado.nextLong();
		System.out.println();

		GrauImportancia gi = giDAO.buscarPorId(idImportancia);
		System.out.println(gi);

	}
	
	public static void buscarTodosGrauImportancia() {

		GrauImportanciaDAO giDAO = new GrauImportanciaDAO();
		List<GrauImportancia> listaGrauImportancia = giDAO.buscarTodos();
		System.out.println(listaGrauImportancia);

	}
}
